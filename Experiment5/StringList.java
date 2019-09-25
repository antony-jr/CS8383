import java.util.Scanner;
import java.util.ArrayList;

public class StringList {
	ArrayList<String> m_Data;

	StringList(){
		m_Data = new ArrayList<String>();
	}

	public boolean append(String s){
		return m_Data.add(s);
	}

	public boolean insert(int pos, String s){
		boolean flag = false;
		ArrayList<String> t = new ArrayList<String>();
		for(int iter = 0; iter <= m_Data.size() ; ++iter){
			if(iter == pos){
				t.add(s);
				flag = true;
				continue;
			}
			t.add(m_Data.get(iter));

		}
		m_Data = t;
		return flag;
	}

	public int search(String s){
		int iter = 0;
		for(String r : m_Data){
			if(r.equals(s)){
				return iter; 
			}
			++iter;
		}
		return -1;
	}

	public void listStringsWithStartingLetter(char c){
		for(String r : m_Data){
			if(r.charAt(0) == c){
				System.out.println(r);
			}
		}
	}

	public static int printMenu(){
		System.out.println(
		":: MAIN MENU ::\n" +
		"   1. Append\n"+
		"   2. Insert\n"+
		"   3. Search\n"+
		"   4. List All Strings starting with the given Letter\n" +
		"   5. Exit");
		System.out.print("Enter your choice: ");
		return (new Scanner(System.in)).nextInt();
	}
	public static void main(String [] args){
		StringList obj = new StringList();
		int choice = 0;
		int pos = 0;
		while(choice != 5){
			choice = printMenu();
			switch(choice){
				case 1:
					System.out.print("Enter a String to Append: ");
					obj.append((new Scanner(System.in)).nextLine());
					break;
				case 2:
					System.out.print("Enter a String to Insert: ");
					String s = (new Scanner(System.in)).nextLine();
					System.out.print("Enter a position to place the string: ");
					pos = (new Scanner(System.in)).nextInt();
					obj.insert(pos,s);
					break;
				case 3:
					System.out.print("Enter the string to search: ");
					pos = obj.search((new Scanner(System.in)).nextLine());
					if(pos >= 0){
					System.out.println("String fount at position " + pos);
					}else{
					System.out.println("String not found!\n");
					}
					break;
				case 4:
					System.out.print("Enter the Letter: ");
					obj.listStringsWithStartingLetter((new Scanner(System.in)).next(".").charAt(0));
					break;
				default:
					choice = 5;

			}
		}
	}
}
