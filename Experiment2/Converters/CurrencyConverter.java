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

	private double toInr(CurrencyType from,
			     double amount){
		double r = 0;
		switch(from){
			case DOLLAR:
				r = amount * 70.4;
				break;
			case EURO:
				r = amount * 77.83;
				break;
			case YEN:
				r = amount * 0.66;
				break;
			default:
				r = amount;
				break;
		}
		return r;
	}

	private double toDollar(CurrencyType from,
			     double amount){
		double r = 0;
		switch(from){
			case INR:
				r = amount / 70.4;
				break;
			case EURO:
				r =  (amount * 77.83) / 70.4;
				break;
			case YEN:
				r = (amount * 0.66) / 70.4;
				break;
			default:
				r = amount;
				break;
		}
		return r;
	}

	private double toEuro(CurrencyType from,
			     double amount){
		double r = 0;
		switch(from){
			case DOLLAR:
				r = (amount * 70.4)  / 77.83;
				break;
			case INR:
				r =  amount / 77.83;
				break;
			case YEN:
				r = (amount * 0.66) / 77.83;
				break;
			default:
				r = amount;
				break;
		}
		return r;
	}


	private double toYen(CurrencyType from,
			     double amount){
		double r = 0;
		switch(from){
			case INR:
				r = amount / 0.66;
				break;
			case EURO:
				r =  (amount * 78.4) / 0.66;
				break;
			case DOLLAR:
				r = (amount * 70.4) / 0.66;
				break;
			default:
				r = amount;
				break;
		}
		return r;
	}

	public CurrencyConverter(CurrencyType from,
			         CurrencyType to,
				 double amount){
		m_Result = new String();

		switch(to){
			case DOLLAR:
				m_Result += toDollar(from, amount);
				break;
			case INR:
				m_Result += toInr(from, amount);
				break;
			case EURO:
				m_Result += toEuro(from, amount);
				break;
			case YEN:
				m_Result += toYen(from, amount);
				break;
			default:
				m_Result = "";
				break;
		}
	}

	public String toString(){
		return m_Result;
	}
}
