package PaySlip;

import java.util.Scanner;

class PayGenerator {
	private int BP = 0; 
	private String m_Result;
	public PayGenerator(){
		double da,hra,pf,cf,gs;
		Scanner s = new Scanner(System.in);
		m_Result = new String();

		m_Result += "Employee Basic Pay: ";
		System.out.print("Enter Basic Pay: ");
		BP = s.nextInt();
		m_Result += BP + "\n";
		m_Result += "DA: " + (da = BP * 0.97) + "\n";
		m_Result += "HRA: " + (hra = BP * 0.10) + "\n";
		m_Result += "PF: " + (pf = BP * 0.12) + "\n";
		m_Result += "Club Fund: " + (cf = BP * 0.1) + "\n";
		m_Result += "Gross Salary: " + (gs = BP + da + hra + pf + cf) + "\n";
		m_Result += "Net Salary: " + (gs - pf - cf) + "\n";
		m_Result += "-x-x-x-x-x-x-x-x-x-\n\n";
	}

	public String toString(){
		return m_Result;	
	}
}
