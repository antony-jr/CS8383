package PaySlip;

import PaySlip.Employee;
import PaySlip.PayGenerator;
import java.util.Scanner;

public class Professor extends Employee {
	private PayGenerator gen;
	public Professor(){
		super("\n\n:: PROFESSOR DETAILS ::",
		      "\n:: PROFESSOR PAY SLIP ::");
		gen = new PayGenerator();	
	}

	public String toString(){
		return super.toString() + gen;	
	}
}
