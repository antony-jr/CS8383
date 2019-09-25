import java.util.Scanner;

abstract class Shape {
	int x,y;
	public abstract int Area();
}

class Rectangle extends Shape {
	Rectangle(int length, int breadth){
		x = length;
		y = breadth;
	}

	public int Area(){
		return x*y;
	}
}

class Triangle extends Shape {
	Triangle(int base, int height){
		x = base;
		y = height;
	}

	public int Area(){
		return (x * y)/2;
	}
}

class Circle extends Shape {
	Circle(int radius){
		x = radius;
		y = 3;
	}

	public int Area(){
		return x*x*y;
	}
}

public class FindArea {
	public static int printMenu(){
		System.out.println(
		":: MAIN MENU ::\n" +
		"   1. Area of Rectangle\n" +
		"   2. Area of Triangle\n" + 
		"   3. Area of Circle\n" + 
		"   4. Exit");
		System.out.print("Enter your choice: ");
		return (new Scanner(System.in)).nextInt();
	}

	public static void main(String [] args){
		int choice = 0;
		int x = 0,
		    y = 0;
		Scanner s = new Scanner(System.in);
		while(choice != 4){
			choice = printMenu();
			switch(choice){
				case 1:
					System.out.print("Enter Length: ");
					x = s.nextInt();
					System.out.print("Enter Breadth: ");
					y = s.nextInt();
					System.out.println("Area of Rectangle(" + x + "," + y + "): " + (new Rectangle(x,y)).Area());
					break;
				case 2:
					System.out.print("Enter Base: ");
					x = s.nextInt();
					System.out.print("Enter Height: ");
					y = s.nextInt();
					System.out.println("Area of Triangle(" + x + "," + y + "): " + (new Triangle(x,y)).Area());
					break;
				case 3:
					System.out.print("Enter Radius: ");
					x = s.nextInt();
					System.out.println("Area of Circle(" + x + "): " + (new Circle(x)).Area());
					break;
				default:
					choice = 4;
			}
		}	
	}
}

