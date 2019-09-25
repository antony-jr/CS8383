import java.util.*;
public class FindMax{
	public static <T extends Comparable<T>> void Max(T [] elements){
		T largest = elements[0];
		for(T value : elements){
			if(value.compareTo(largest) > 0){
				largest = value;
			}
		}

		System.out.println(largest);
		return ;
	}
	public static void main(String [] args){
		int n = 0;
		Scanner s = new Scanner(System.in);
		System.out.print("Enter upper limit: ");
		n = s.nextInt();	
	        Integer [] integers = new Integer[n];
		String [] strings = new String[n];
		Double [] doubles = new Double[n];

		for(int iter =0; iter < n; ++iter){
			System.out.print("Enter a Integer: ");
			integers[iter] = s.nextInt();

			System.out.print("Enter a String: ");
			s.nextLine();
			strings[iter] = s.nextLine();

			System.out.print("Enter a double: ");
			doubles[iter] = s.nextDouble();
		}

		
		System.out.print("\n\nMax in Integers: ");
		Max(integers);

		System.out.print("Max in Strings: ");
		Max(strings);
		
		System.out.print("Max in Doubles: ");
		Max(doubles);
	}
}
