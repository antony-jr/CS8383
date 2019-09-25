package Converters;

public class TimeConverter {
	public static enum TimeType{
		None,
		SEC,
		MIN,
		HOURS
	}

	private String m_Result;

	private double toHours(TimeType from, double amount){
		double r = 0;
		switch(from){
			case SEC:
				r = amount/3600;
				break;
			case MIN:
				r = amount/60;
				break;
			default:
				r = amount;
				break;
		}
		return r;
	}

	private double toMin(TimeType from, double amount){
		double r = 0;
		switch(from){
			case SEC:
				r = amount/60;
				break;
			case HOURS:
				r = amount * 60;
				break;
			default:
				r = amount;
				break;
		}
		return r;
	}

	private double toSec(TimeType from, double amount){
		double r = 0;
		switch(from){
			case MIN:
				r = amount * 60;
				break;
			case HOURS:
				r = amount * 3600;
				break;
			default:
				r = amount;
				break;
		}
		return r;
	}

	public TimeConverter(TimeType from, 
			     TimeType to,
			     double amount){

		m_Result = new String();
		switch(to){
			case SEC:
				m_Result += toSec(from, amount);
				break;
			case MIN:
				m_Result += toMin(from, amount);
				break;
			case HOURS:
				m_Result += toHours(from, amount);
				break;
			default:
				break;
		}
	}

	public String toString(){
		return m_Result;
	}


}
