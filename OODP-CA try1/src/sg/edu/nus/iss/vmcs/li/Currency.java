package sg.edu.nus.iss.vmcs.li;

public class Currency {

	
	private int value;
	private String currencyValue;
	
	
	public Currency(int value) {
		super();
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getCurrencyValue() {
		return currencyValue;
	}
	public void setCurrencyValue(String currencyValue) {
		this.currencyValue = currencyValue;
	}
	
	
}
