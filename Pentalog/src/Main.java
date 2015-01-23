import java.io.IOException;


public class Main
{

	 public static void main(String[] args) throws IOException 
	 {
		 Maxim m=new Maxim();
	     String fileName = "filename";

	    // read the file
	    m.readFile(fileName);
	    
		m.printArray(fileName);
		
	
		System.out.println(m.maxProduct());
	
		
	 }
	 

}





