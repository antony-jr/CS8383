import java.util.Scanner;

interface Stack {
	public boolean push(Object v);
	public boolean pop();
	public boolean peek();
}

class IntegerStack implements Stack {
	int [] data = {0};
	int top = -1;
	public IntegerStack(int size){
		data = new int[size];
	}

	public boolean push(Object v){
		try{
			data[++top] = (Integer)v;
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Stack is Full!");
			return false;
		}
		return true;
	}

	public boolean pop(){
		try{
			System.out.println("Poped: " + data[top--]);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Stack is Empty!");
			return false;
		}
		return true;
	}

	public boolean peek(){
		try{
			System.out.println("Element at Top: " + data[top]);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Stack is Empty!");
			return false;
		}
		return true;
	}

	public String toString(){
		String r = new String();
		r += ":: STACK ::\n";
		for(int iter = top; iter > -1; --iter){
			r += data[iter] + "\n";
		}
		r += "::=========::\n";
		return r;
	}
}

public class ADTStack {
	public static int printMenu(){
		System.out.println(
		":: MAIN MENU::\n" + 
		"   1. Push\n" +
		"   2. Pop\n" +
		"   3. Print\n" +
		"   4. Peek\n" + 
		"   5. Exit");
		System.out.print("Enter your choice: ");
		return (new Scanner(System.in)).nextInt();
	}
	public static void main(String [] args){
		IntegerStack stack = new IntegerStack(250);
		int choice = 0;
		while(choice != 5){
			choice = printMenu();
			switch(choice){
				case 1:
					System.out.print("Enter a value: ");
					stack.push((new Scanner(System.in)).nextInt());
					break;
				case 2:
					stack.pop();
					break;
				case 3:
					System.out.println(stack);
					break;
				case 4:
					stack.peek();
					break;
				default:
					choice = 5;
					break;
			}
		}
	}
}	
