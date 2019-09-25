package PaySlip;

import PaySlip.Employee;
import PaySlip.PayGenerator;
import java.util.Scanner;

public class Programmer extends Employee {
	private PayGenerator gen;
	public Programmer(){
		super("\n\n:: PROGRAMMER DETAILS ::",
		      "\n:: PROGRAMMER PAY SLIP ::");
		gen = new PayGenerator();	
	}

	public String toString(){
		return super.toString() + gen;	
	}
}
