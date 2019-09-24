package Converters;

public class CurrencyConverter {
	public static enum CurrencyType {
		None,
		DOLLAR,
		INR,
		EURO,
		YEN
	}
	private String m_Result;
	
	public CurrencyConverter(CurrencyType from,
			         CurrencyType to,
				 int amount){
		
	}

	public String toString(){
		return m_Result;
	}
}
