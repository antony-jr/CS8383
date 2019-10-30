import java.util.Scanner;
import Converters.*;

class Converter {
	public static void main(String [] args){
		Scanner s = new Scanner(System.in);
		String raw;
		System.out.println("Enter the value you want to convert " +
		"along with the amount and units in format( X [From Unit] to [To Unit] )\n" +
		"Units:\n"+
		"      M = Meters\n" +
		"      KM = Kilo Meters\n"+
		"      Miles = Miles\n" +
		"      Sec = Seconds\n" +
		"      Min = Minutes\n" +
		"      Hour = Hours\n" +
		"      Inr = Indian rupees\n" +
		"      Dollar = Ameraican Dollars\n" +
		"      Euro = Euros\n" +
		"      Yen = Japanese Yen\n" + 
		"Example:\n" +
		"        20 M to KM\n" +
		"        1 Hours to Sec\n" +
		"        256 INR to Dollars\n" +
		"Or Enter 'exit' to exit");
		while(true){
			System.out.print(">>> ");
			raw = s.nextLine();
			if(raw.toLowerCase().contains("exit")){
				return;
			}
			System.out.println(new UnitParser(raw));
		}
	}
}
