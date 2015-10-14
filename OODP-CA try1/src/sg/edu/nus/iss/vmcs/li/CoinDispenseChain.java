package sg.edu.nus.iss.vmcs.li;

import sg.edu.nus.iss.vmcs.store.StoreController;

public class CoinDispenseChain {

	private DispenseChain c1;
	private DispenseChain c2;
	private DispenseChain c3;
	private DispenseChain c4;
	private DispenseChain c5;

	public CoinDispenseChain(StoreController storeCtrl,int chainLength) {
		
		this.c1 = new Coin100Dispenser(storeCtrl,chainLength);
        this.c2 = new Coin50Dispenser(storeCtrl,chainLength);
        this.c3 = new Coin20Dispenser(storeCtrl,chainLength);
        this.c4 = new Coin10Dispenser(storeCtrl,chainLength);
        this.c5 = new Coin5Dispenser(storeCtrl,chainLength);
        
 
        // set the chain of responsibility
        
        c1.setNextChain(c2);
        c2.setNextChain(c3);
        c3.setNextChain(c4);
        c4.setNextChain(c5);
	}

	public DispenseChain getC1() {
		return c1;
	}
	
}
