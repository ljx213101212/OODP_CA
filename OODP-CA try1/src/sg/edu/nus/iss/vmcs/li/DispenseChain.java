package sg.edu.nus.iss.vmcs.li;

import sg.edu.nus.iss.vmcs.customer.TransactionController;
import sg.edu.nus.iss.vmcs.store.Coin;
import sg.edu.nus.iss.vmcs.store.Store;
import sg.edu.nus.iss.vmcs.store.StoreController;
import sg.edu.nus.iss.vmcs.store.StoreItem;
import sg.edu.nus.iss.vmcs.util.VMCSException;

public abstract class DispenseChain {
  
	protected DispenseChain chain;
	protected int offerValue;
	protected int storeItemIndex;
	protected int quantity;
	protected StoreController storeCtrl;
	protected int chainLength;
	
	
	public DispenseChain(StoreController storeCtrl, int chainLength) {
		super();
		this.storeCtrl = storeCtrl;
		this.chainLength = chainLength;
	}
	
	public int initializeStoreItemIndex(int gap){
		return this.storeItemIndex = chainLength - gap;
	}
	
	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;		
	}
	public int dispense(Currency cur, TransactionController txcl) {
		int remainder = 0;	
		
			if (cur.getValue() < this.offerValue){
				if (null != this.chain)
					this.chain.dispense(cur,txcl);
			}else{
				int num = cur.getValue() / this.offerValue;
				remainder = cur.getValue() % this.offerValue;
				
					if (this.quantity < num){
						if (null != this.chain && remainder != 0 )
							this.chain.dispense(cur,txcl);
						else
							return remainder;
					}else{
						
						try {
					    	txcl.getMainController().getMachineryController().giveChange(storeItemIndex,num);
					    } catch (VMCSException e) {
						// TODO Auto-generated catch block
					    	e.printStackTrace();
					    }	
						
						if (null != this.chain &&  remainder != 0 )
						    this.chain.dispense(new Currency(remainder),txcl);
						else
							return remainder;
						
					}
				
			}
			return remainder;
	}
}
