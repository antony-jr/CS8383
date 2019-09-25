package Converters;

public class DistanceConverter {
		public static enum DistanceType{
			None,
			M,
			KM,
			MILES
		}

		private String m_Result;

		private double toM(DistanceType from, double amount){
			double r = 0;
			switch(from){
				case KM:
					r = amount * 1000;
					break;
				case MILES:
					r = (amount / 0.62) * 1000;
					break;
				default:
					r = amount;
					break;
				
			}
			return r;
		}

		private double toKM(DistanceType from, double amount){
			double r = 0;
			switch(from){
				case M:
					r = amount/1000;
					break;
				case MILES:
					r = amount/0.62;
					break;
				default:
					r = amount;
					break;
			}
			return r;
		}

		private double toMILES(DistanceType from, double amount){
			double r = 0;
			switch(from){
				case M:
					r = (amount/1000) * 0.62;
					break;
				case KM:
					r = amount * 0.62;
					break;
				default:
					r = amount;
					break;
			}
			return r;
		}

		public DistanceConverter(
				DistanceType from,
				DistanceType to,
				double amount){

			m_Result = new String();
			switch(to){
				case M:
					m_Result += toM(from, amount);
					break;
				case KM:
					m_Result += toKM(from, amount);
					break;
				case MILES:
					m_Result += toMILES(from, amount);
					break;
				default:
					m_Result += amount;
					break;
			}
		}

		public String toString(){
			return m_Result;
		}
}
