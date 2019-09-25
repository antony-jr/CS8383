package PaySlip;

import PaySlip.Employee;
import PaySlip.PayGenerator;
import java.util.Scanner;

public class AssociateProfessor extends Employee {
	private PayGenerator gen;
	public AssociateProfessor(){
		super("\n\n:: ASSOCIATE PROFESSOR DETAILS ::",
		      "\n:: ASSOCIATE PROFESSOR PAY SLIP ::");
		gen = new PayGenerator();	
	}

	public String toString(){
		return super.toString() + gen;	
	}
}
