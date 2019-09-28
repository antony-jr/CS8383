import java.awt.*;
import java.awt.event.*;
import java.util.*;

class StringEvaluate {
	String result;
	private int priority(char c){
		return (c == '-') ? 1 : (c == '+') ? 2 :
		       (c == '*') ? 3 : (c == '/') ? 4 : -1;
	}
	private String doOp(String a, String b, String op){
		String r;
		double na = Double.parseDouble(a),
		       nb = Double.parseDouble(b);
		switch(op.charAt(0)){
			case '+':
				r = "" + (na + nb);
				break;
			case '-':
				r = "" + (na - nb);
				break;
			case '*':
				r = "" + (na * nb);
				break;
			case '/':
				r = "" + (na / nb);
				break;
			default:
				r ="";
				break;
		}
		return r;
	}
	StringEvaluate(String s){
		Stack<String> S = new Stack<String>();
		ArrayList<String> Postfix = new ArrayList<String>();
		for(int iter = 0; iter < s.length(); ++iter){
			char c = s.charAt(iter);
			if(priority(c) == -1){
			String operand = new String();
			while(iter < s.length()){
				c = s.charAt(iter);
				if(priority(c) != -1){
					break;
				}
				operand += c;
				++iter;
			}
			iter -= 1;
			Postfix.add(operand);
			}else{
				try{
				if(priority(S.peek().charAt(0)) > priority(c)){
					Postfix.add(S.pop());
				}
				}catch(EmptyStackException e){
				}
				S.push(c + "");
			}
		}
		while(!S.empty()){
			Postfix.add(S.pop());
		}

		S = new Stack<String>();
		for(int iter =0; iter < Postfix.size(); ++iter){
			String opr = Postfix.get(iter);
			if(priority(opr.charAt(0)) == -1){
				S.push(opr);
			}else{
				try{
					String b = S.pop();
					String a = S.pop();
					S.push(doOp(a,b,opr));		
				}catch(EmptyStackException e){
					result = "ERROR";
					return;
				}
			}
		}
		if(S.size() != 1){
			result = "ERROR";
			return;
		}
		result = S.pop();
	}
	public String toString(){
		return result;
	}
}

public class Calculator extends Frame implements ActionListener {
	Button [] numberBtns;
	Button [] basicOpt;
	Button [] advOpt;
	Button modeBtn, clearBtn;	
	boolean scific = false;
	Panel p;
	TextField display;
	String data;

	int opt = -1;
	String oper1, oper2;
	private String toBasicOpt(int n){
		if(n == 0){
			return "-";
		}else if(n == 1){
			return "+";
		}else if(n == 2){
			return "*";
		}else if(n == 3){
			return "/";
		}else if(n == 4){
			return "=";
		}else if(n == 5){
			return ".";
		}
		return "NONE";
	}

	private String toAdvOpt(int n){
		if(n == 0){
			return "Sin";
		}else if(n == 1){
			return "Cos";
		}else if(n == 2){
			return "Tan";
		}
		return "NONE";
	}



	public Calculator(){
		super("Calculator");
		setSize(500,500);
		setLayout(new BorderLayout());

		oper1 = new String();
		oper2 = new String();

		p = new Panel();
		p.setLayout(new GridLayout(0,4));
		display = new TextField(500);
		data = new String();

		add(display, BorderLayout.NORTH);

		numberBtns = new Button[10];

		for(int iter = 0; iter < 10; ++iter){
			numberBtns[iter] = new Button("" + iter);
			numberBtns[iter].setActionCommand("n" + iter);
			numberBtns[iter].addActionListener(this);
			p.add(numberBtns[iter]);
		}

		basicOpt = new Button[6];
		for(int iter = 0; iter < 6; ++iter){
			basicOpt[iter] = new Button(toBasicOpt(iter));
			basicOpt[iter].setActionCommand("bo" + iter);
			basicOpt[iter].addActionListener(this);	
			p.add(basicOpt[iter]);
		}

		advOpt = new Button[3];
		for(int iter = 0; iter < 3; ++iter){
			advOpt[iter] = new Button(toAdvOpt(iter));
			advOpt[iter].setActionCommand("ao" + iter);
			advOpt[iter].addActionListener(this);
			// p.add(advOpt[iter]);
		}

		modeBtn = new Button("Scientific");
		modeBtn.setActionCommand("modeChange");
		modeBtn.addActionListener(this);
		p.add(modeBtn);
		clearBtn = new Button("C");
		clearBtn.setActionCommand("clear");
		clearBtn.addActionListener(this);
		p.add(clearBtn);

		add(p, BorderLayout.CENTER);
		
		/* Show window and handle closing. */	
		setVisible(true);	
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				dispose();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
		
		if(cmd.charAt(0) == 'n'){
			data += cmd.charAt(1);
			if(opt == -1){
			oper1 += cmd.charAt(1);
			}else{
			oper2 += cmd.charAt(1);
			}
			display.setText(data);
		}else if(cmd.charAt(0) == 'b' && cmd.charAt(1) == 'o'){
			int opt = Character.getNumericValue(cmd.charAt(2));
			if(opt == 4){
				data = "" + (new StringEvaluate(data));
				display.setText(data);
				return;
			}
			data += toBasicOpt(opt);;
			this.opt = opt;
			display.setText(data);
		}else if(cmd.charAt(0) == 'a' && cmd.charAt(1) == 'o'){
			int opt = Character.getNumericValue(cmd.charAt(2)); 
			data = "" + (new StringEvaluate(data));
			double value = Double.parseDouble(data);
			if(opt == 0){
				data = "" + Math.sin(value);
			}else if(opt == 1){
				data = "" + Math.cos(value);
			}else{
				data = "" + Math.tan(value);
			
			}
			display.setText(data);	
		}else if(cmd.equals("clear")){
			data = "";
			display.setText(data);
		}else if(cmd.equals("modeChange")){
			if(!scific){
				modeBtn.setLabel("Decimal");
				scific = true;
				/* Add adv opt. */
				for(int iter = 0; iter < 3; ++iter){
					p.add(advOpt[iter]);
				}
			}else{
				modeBtn.setLabel("Scientific");
				scific = false;

				/* Remove adv opt. */
				for(int iter = 0; iter < 3; ++iter){
					p.remove(advOpt[iter]);
				}
	
			}
			setSize(500,550);
			setSize(500,500);
		}
	}

	public static void main(String [] args){
		new Calculator();
	}
}
