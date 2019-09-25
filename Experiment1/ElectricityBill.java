package Experiment1;

import java.util.Scanner;

public class ElectricityBill {
	private String m_CustomerNo;
	private String m_CustomerName;
	private int m_PreviousMonthReading,
		    m_CurrentMonthReading;
	private String m_Bill;
	private void print(String s){
		System.out.print(s);
	}

	public ElectricityBill(){
		/* Read in values from user. */
		int units = 0;
		float payable = 0,
		      case1 = 1,
		      case2 = 2.5F,
		      case3 = 4,
		      case4 = 6;
		boolean isDomestic = false;
		Scanner s = new Scanner(System.in);
		m_Bill = ":: Electricity Bill ::\n";
		print("Enter Customer No. : ");
		m_Bill += "Customer No. : ";
		m_CustomerNo = s.nextLine();
		m_Bill += m_CustomerNo + "\n";
		print("Enter Customer Name: ");
		m_Bill += "Customer Name: ";
		m_CustomerName = s.nextLine();
		m_Bill += m_CustomerName + "\n";
		m_Bill += "Previous Month Reading: ";
		print("Enter Previous month reading: ");
		m_PreviousMonthReading = s.nextInt();
		m_Bill += m_PreviousMonthReading + "\n";
		m_Bill += "Current Month Reading: ";
		print("Enter Current Month Reading: ");
		m_CurrentMonthReading = s.nextInt();
		m_Bill += m_CurrentMonthReading + "\n";
		m_Bill += "EB Connection Type: ";
		print("What is your EB Connection Type" +
		      "(Domestic/Commercial)?: ");
	        s.nextLine();	
		String type = s.nextLine();
		if(type.toLowerCase().contains("domestic")){
			isDomestic = true;
		}else{
			case1 += 1;
			case2 = 4.5F;
			case3 = 6;
			case4 = 7;
		}

		m_Bill += isDomestic ? "Domestic\n" : "Commercial\n";
		
		
		units = m_CurrentMonthReading - m_PreviousMonthReading;

		m_Bill += "Units consumed: " + units + "\n";
		m_Bill += "Amount Payable: Rs. ";
	
		print("\n\n");


		if(units <= 100){
			payable = units * case1;
			m_Bill += payable + "\n";
		}else if(units <= 200){
			payable = (100 * case1) + 
				  ((units - 100) * case2);
			m_Bill += payable + "\n";
		}else if(units <= 500){
			payable = (100 * case1) + 
				  (100 * case2) +
				  ((units - 200) * case3);
			m_Bill += payable + "\n";
		}else{
			payable = (100 * case1) + 
				  (100 * case2) +
				  (300 * case3) +
				  ((units - 500) * case4);
			m_Bill += payable + "\n";
		}

		m_Bill += "-*-*-*-\n";

	}

	public String toString(){
		return m_Bill;
	}

	// Program Entry
	public static void main(String [] args){
		System.out.println((new ElectricityBill()));
		return;
	}
}
