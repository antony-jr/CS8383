import java.util.Scanner;

class UserIsNotHuman extends Exception {
	public UserIsNotHuman(String msg){
		super(msg);
	}
}

public class UserDefException {
	public static void testHuman() throws UserIsNotHuman {
		String opt;
		System.out.print("Are you a Human(yes/no)?: ");
		opt = (new Scanner(System.in)).next();
		if(opt.toLowerCase().contains("yes")){
			System.out.println("Welcome to International Space Station!");
		}else{
			throw new UserIsNotHuman("Something Answered No!");
		}

	}
	public static void main(String [] args) {
		try{
			testHuman();
		}catch(UserIsNotHuman e){
			System.out.println("Sorry only Humans allowed here!");
			System.out.println(e);
		}
	}
}
