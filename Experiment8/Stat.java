import java.io.*;
import java.util.*;
import java.nio.file.Files;

public class Stat {
	public static void printYesNo(boolean b){
		if(b){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
		
	}

	public static void main(String [] args){
		if(args.length < 1){
			System.out.println("Usage: java Stat [FILE PATH]");
			return;
		}
		File f = new File(args[0]);

		System.out.println(":: FILE INFORMATION ::");
		System.out.print("File Exists: ");
		printYesNo(f.exists());

		System.out.print("File Readable: ");
		printYesNo(Files.isReadable(f.toPath()));

		System.out.print("File Writable: ");
		printYesNo(Files.isWritable(f.toPath()));

		System.out.println("Byte Length: " + f.length());

		System.out.print("File Type: ");
		try{
			System.out.println(Files.probeContentType(f.toPath()));
		}catch (IOException e){
			System.out.println("Unable to determine file type for " + f
					+ " due to exception " + e);
		}
	}
}
