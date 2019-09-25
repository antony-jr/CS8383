import java.awt.*;
import java.awt.event.*;
import java.util.*;

class BasicCalculate {
	double result = 0.0;
	public static double doOpt(double a, double b, char c){
		return (c == '-') ? a-b : (c == '+') ? a+b :
		       (c == '*') ? a*b : (c == '/') ? a/b : 0.0;
	
	}
	public static int priority(char c){
		return (c == '-') ? 1 : (c == '+') ? 2 :
		       (c == '*') ? 3 : (c == '/') ? 4 : -1;
	}
	BasicCalculate(String s){
		Stack<Double> postfix = new Stack<Double>();
		Stack<Character> opt = new Stack<Character>();
		String n = new String();
		for(int iter = 0; iter < s.length(); ++iter){
			if(Character.isDigit(s.charAt(iter)) || s.charAt(iter) == '.'){
				n += s.charAt(iter);
			}else{
				postfix.push(Double.parseDouble(n));
				n = new String();
				try{	
					char c = opt.peek();
					if(priority(c) > priority(s.charAt(iter))){
						c = opt.pop();
						double b = postfix.pop();
						double a = postfix.pop();
						postfix.push(doOpt(a,b,c));
					}else{
						opt.push(s.charAt(iter));
					}
				}catch(EmptyStackException e){
					opt.push(s.charAt(iter));	
				}
			}	
		}
		while(!opt.empty()){
			try{
			char c = opt.pop();
			double b = postfix.pop();
			double a = postfix.pop();
			postfix.push(doOpt(a,b,c));
			}catch(EmptyStackException e){
				return;
			}
			
		}
		try{
			result = postfix.pop();
		}catch(EmptyStackException e){
			result = 0.0;
		}
	}

	public String toString() {
		String r = new String();
		r += result;
		return r;
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
			display.setText(data);
		}else if(cmd.charAt(0) == 'b' && cmd.charAt(1) == 'o'){
			int opt = Character.getNumericValue(cmd.charAt(2));
			if(opt == 4){
			        data = "" + (new BasicCalculate(data));
				display.setText(data);
				return;
			}
			data += toBasicOpt(opt);;
			display.setText(data);
		}else if(cmd.charAt(0) == 'a' && cmd.charAt(1) == 'o'){
			int opt = Character.getNumericValue(cmd.charAt(2)); 
			double value = Double.parseDouble("" + (new BasicCalculate(data)));
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
