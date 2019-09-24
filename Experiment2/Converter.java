import java.util.Scanner;
import Converters.*;

class Converter {
	public static int printMainMenu(){
		System.out.println(
		":: MAIN MENU ::\n" +
		"   1. Currency Converter\n" +
		"   2. Distance Converter\n" +
		"   3. Time Converter\n" + 
		"   4. Exit");

		System.out.print("Enter you choice: ");
		return (new Scanner(System.in)).nextInt();
	}
	public static void runDistanceConverter(){
		System.out.print("\n\n");
		Scanner s = new Scanner(System.in);
		int choice = 0;
		double amount = 0;
		while(choice != 7){
		System.out.println(
		":: DISTANCE CONVERTER ::\n" +
		"   1. Meter to KiloMeter\n" +
		"   2. Meter to Miles\n" +
		"   3. Miles to Meter\n" + 
	        "   4. Miles to KiloMeter\n" +
	        "   5. KiloMeter to Miles\n" +
	        "   6. KiloMeter to Meter\n" +
	        "   7. Exit");
		System.out.print("Enter your choice: ");
		choice = s.nextInt();

		if(choice != 7){
		System.out.print("Enter a amount: ");
		amount = s.nextDouble();
		}
		switch(choice){
			case 1:
				System.out.println(new DistanceConverter(
							DistanceConverter.DistanceType.M,
							DistanceConverter.DistanceType.KM,
							amount));
				break;
			case 2:
				System.out.println(new DistanceConverter(
							DistanceConverter.DistanceType.M,
							DistanceConverter.DistanceType.MILES,
							amount));
				break;
			case 3:
				System.out.println(new DistanceConverter(
							DistanceConverter.DistanceType.MILES,
							DistanceConverter.DistanceType.M,
							amount));
				break;
			case 4:
				System.out.println(new DistanceConverter(
							DistanceConverter.DistanceType.MILES,
							DistanceConverter.DistanceType.KM,
							amount));
				break;
			case 5:
				System.out.println(new DistanceConverter(
							DistanceConverter.DistanceType.KM,
							DistanceConverter.DistanceType.MILES,
							amount));
				break;
			case 6:
				System.out.println(new DistanceConverter(
							DistanceConverter.DistanceType.KM,
							DistanceConverter.DistanceType.M,
							amount));
				break;
			default:
				choice = 7;
				break;	
		}
		}
	}
	public static void main(String [] args){
		int choice = 0;
		while(choice != 4){
			choice = printMainMenu();
			switch(choice){
				case 1:
					break;
				case 2:
					runDistanceConverter();
					break;
				case 3:
					break;
				default:
					choice = 4;
					break;
			}
		}
		return;
	}
}
