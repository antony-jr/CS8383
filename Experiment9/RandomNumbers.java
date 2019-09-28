import java.io.*;
import java.util.*;

class RandomGen {
	private Random rnd;
	int n = 0;

	RandomGen(){
		rnd = new Random();
	}

	synchronized void generate(){
		n = rnd.nextInt(1000);
		System.out.println("Generated Number: " + n);
		notifyAll();
	}

	synchronized int getRnd(){
		try{
			wait();
		}catch(InterruptedException e){

		}
		return n;
	}
}

public class RandomNumbers {
	public static void main(String [] args){
		RandomGen r = new RandomGen();

		/* first thread generates randome number every one sec. */
		new Thread(){
			public void run(){
				try{
				while(true){
					r.generate();
					sleep(1000);
				}
				}catch(InterruptedException e){

				}
			}
		}.start();

		/* Second thread prints the square of the random if even. */
		new Thread(){
			public void run(){
				while(true){
					int v = r.getRnd();
					if(v % 2 == 0){
						System.out.println("Square of Random No. : " + (v*v));
					}
				}
			}
		}.start();

		/* Third thread prints the cube of the random if odd. */
		new Thread(){
			public void run(){
				while(true){
					int v = r.getRnd();
					if(v % 2 != 0){
						System.out.println("Cube of Random No. : " + (v*v*v));
					}
				}
			}
		}.start();

	}
}
