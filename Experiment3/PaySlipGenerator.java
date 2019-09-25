import PaySlip.*;
import java.util.Scanner;

class PaySlipGenerator {
	public static int printMainMenu(){
		System.out.println(
			":: MAIN MENU ::\n" +
			"   1. Programmer Pay Slip\n" +
			"   2. Assistant Professor Pay Slip\n" +
			"   3. Associate Professor Pay Slip\n" + 
			"   4. Professor Pay Slip\n" + 
			"   5. Exit");
		System.out.print("Enter your choice: ");
		return (new Scanner(System.in)).nextInt();
	}
	public static void main(String [] args){
		int choice = 0;
		while(choice != 5){
			choice = printMainMenu();
			switch(choice){
				case 1:
					System.out.println(new Programmer());
					break;
				case 2:
					System.out.println(new AssistantProfessor());
					break;
				case 3:
					System.out.println(new AssociateProfessor());
					break;
				case 4:
					System.out.println(new Professor());
					break;
				default:
					choice = 5;
					break;
			}
		}
	}
}
