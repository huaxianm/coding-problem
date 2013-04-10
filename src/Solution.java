import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Solution {
	static long[] data=null;
	static long[] product=null;
	public static void main(String[] args) throws IOException{
		try {
			readInput();
			productBesideItself();
			printall();
	        } catch (Exception e) {
	        System.err.println("Error:" + e.getMessage());
	    }	
		}
	public static void readInput() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
        int count = Integer.parseInt(s);
        data=new long[count];
        product=new long[count];
        int i=0;
        while(i<count){
        	data[i]=Long.parseLong(br.readLine());
        	i++;
        	}
        br.close();
	}
	public static void printall() throws IOException{
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(
				System.out));
		int i = 0;
		while (i < product.length) {
			output.write(product[i] + "\n");
			i++;
		}
		output.flush();
		output.close();
	}
	public static void productBesideItself(){
		long p =1;
		for (int i = 0; i < data.length; i++) {
			product[i] = p;
			p *= data[i];
		}

		p=1;
		for(int i=data.length-1;i>=0;i--)
		{
		  product[i]*=p;
		  p*=data[i];
		}
	}
}

