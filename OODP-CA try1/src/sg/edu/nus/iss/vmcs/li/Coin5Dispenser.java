package sg.edu.nus.iss.vmcs.li;

import sg.edu.nus.iss.vmcs.customer.TransactionController;
import sg.edu.nus.iss.vmcs.store.Coin;
import sg.edu.nus.iss.vmcs.store.Store;
import sg.edu.nus.iss.vmcs.store.StoreController;
import sg.edu.nus.iss.vmcs.store.StoreItem;
import sg.edu.nus.iss.vmcs.util.VMCSException;

public class Coin5Dispenser extends DispenseChain{
	
	
	private int indexGap = 5;
	public Coin5Dispenser(StoreController storeCtrl,int chainLength) {
		super(storeCtrl,chainLength);
		
		if (chainLength - 1 < 0){
			storeItemIndex = 0;
		}else{
			storeItemIndex = this.initializeStoreItemIndex(indexGap);
		}		
		StoreItem cashStoreItem=storeCtrl.getStore(Store.CASH).getStoreItem(storeItemIndex);
		Coin coin=(Coin)cashStoreItem.getContent();
		quantity = cashStoreItem.getQuantity();
		offerValue = coin.getValue();
	}
}
