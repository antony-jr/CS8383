package PaySlip;

import PaySlip.Employee;
import PaySlip.PayGenerator;
import java.util.Scanner;

public class AssistantProfessor extends Employee {
	private PayGenerator gen;
	public AssistantProfessor(){
		super("\n\n:: ASSISTANT PROFESSOR DETAILS ::" ,
		      "\n:: ASSISTANT PROFESSOR PAY SLIP ::");
		gen = new PayGenerator();	
	}

	public String toString(){
		return super.toString() + gen;	
	}
}
