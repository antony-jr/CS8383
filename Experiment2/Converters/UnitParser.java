package Converters;

import Converters.DistanceConverter;
import Converters.TimeConverter;
import Converters.CurrencyConverter;

public class UnitParser {
	private int m_From = 0, m_To = 0;
	public static enum UnitType{
		None,
		Distance,
		Currency,
		Time
	}
	private UnitType m_Type = UnitType.None;
	private double amount = 0.0; 
	private String result;

	private void parseFromTo(String s, boolean isFrom){
		int d = 0;
		s = s.toLowerCase();
		if(s.contains("km")){
			d = DistanceConverter.DistanceType.KM.ordinal();
		}else if(s.contains("miles")){
			d = DistanceConverter.DistanceType.MILES.ordinal();
		}else if(s.contains("sec")){
			d = TimeConverter.TimeType.SEC.ordinal();
		}else if(s.contains("min")){
			d = TimeConverter.TimeType.MIN.ordinal();
		}else if(s.contains("hour")){
			d = TimeConverter.TimeType.HOURS.ordinal();
		}else if(s.contains("euro")){
			d = CurrencyConverter.CurrencyType.EURO.ordinal();
		}else if(s.contains("dollar")){
			d = CurrencyConverter.CurrencyType.DOLLAR.ordinal();
		}else if(s.contains("inr")){
			d = CurrencyConverter.CurrencyType.INR.ordinal();
		}else if(s.contains("yen")){
			d = CurrencyConverter.CurrencyType.YEN.ordinal();
		}else if(s.contains("m")){
			d = DistanceConverter.DistanceType.M.ordinal();
		}else{
			throw new RuntimeException("Invalid Units!");
		}

		if(isFrom){
			m_From = d;
		}else{
			m_To = d;
		}
	}

	public UnitParser(String raw) throws RuntimeException {
		String x = new String(),
		       from = new String(),
		       to = new String();
		String [] raws;
		result = new String();
		raw = raw.toLowerCase();

		raws = raw.split("to");
		if(raws.length < 2){
			throw new RuntimeException("Malformed String!");
		}
		
		for(int iter = 0; iter < raws[0].length(); ++iter){
			char c = (raws[0]).charAt(iter);
			if(Character.isDigit(c) || c == '.'){
				x += c;
			}else if(Character.isLetter(c)){
				from += c;
			}
		}
		
		for(int iter = 0; iter < raws[1].length(); ++iter){	
			char c = (raws[1]).charAt(iter);
			if(Character.isLetter(c)){
				to += c;
			}
		}

		if(x.split(".").length > 2){
			throw new RuntimeException("Malformed amount!");
		}

		String f = from.toLowerCase();
		String t = to.toLowerCase();
		if((f.contains("m") || f.contains("km") || f.contains("miles")) &&
		   (t.contains("m") || t.contains("km") || f.contains("miles"))){
			m_Type = UnitType.Distance;
		}else if((f.contains("sec") || f.contains("min") || f.contains("hour")) &&
			 (t.contains("sec") || t.contains("min") || t.contains("hour"))){
			m_Type = UnitType.Time;
		}else if((f.contains("euro") || f.contains("dollar") || f.contains("inr") || f.contains("yen")) &&
			 (t.contains("euro") || t.contains("dollar") || t.contains("inr") || t.contains("yen"))){
			m_Type = UnitType.Currency;
		}else{
			throw new RuntimeException("Invalid conversion units!");
		}

		parseFromTo(from, true);
		parseFromTo(to, false);
		amount = Double.parseDouble(x);
		result = x + " " + from + " in " + to + " is ";
	}

	public String toString(){
		if(m_Type == UnitType.Distance){
			return (result += (new DistanceConverter(DistanceConverter.DistanceType.values()[m_From], 
							         DistanceConverter.DistanceType.values()[m_To], amount)).toString());
		}else if(m_Type == UnitType.Time){
			return (result += (new TimeConverter(TimeConverter.TimeType.values()[m_From], 
							     TimeConverter.TimeType.values()[m_To], amount)).toString());	
		}
		else if(m_Type == UnitType.Currency){
			return (result += (new CurrencyConverter(CurrencyConverter.CurrencyType.values()[m_From], 
							     CurrencyConverter.CurrencyType.values()[m_To], amount)).toString());	
		
		}else{
			return new String();
		}
	}
}
