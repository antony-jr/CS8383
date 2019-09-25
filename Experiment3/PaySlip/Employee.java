package PaySlip;
import java.util.Scanner;

public class Employee {
	private String Emp_name,
		Mail_id,
		Mobile_no,
		Address,
		Emp_id;
	private String m_Result;

	public Employee(String title , String slipName){
		Scanner s = new Scanner(System.in);
		m_Result = new String();

		m_Result += slipName;
		System.out.println(title);
		
		m_Result += "\nEmployee Name: ";
		System.out.print("Enter Employee Name: ");
		Emp_name = s.nextLine();
		m_Result += Emp_name + "\n";

		m_Result += "Employee Mail id: ";
		System.out.print("Enter Employee Mail id: ");
		Mail_id = s.nextLine();
		m_Result += Mail_id + "\n";

		m_Result += "Employee Mobile no: ";
		System.out.print("Enter Employee Mobile no.: ");
		Mobile_no = s.nextLine();
		m_Result += Mobile_no + "\n";

		m_Result += "Employee Address: ";
		System.out.print("Enter Employee Address: ");
		Address = s.nextLine();
		m_Result += Address + "\n";

		m_Result += "Employee Id: ";
		System.out.print("Enter Employee id: ");
		Emp_id = s.nextLine();
		m_Result += Emp_id + "\n";
	}

	public String toString(){
		return m_Result;
	}

}
