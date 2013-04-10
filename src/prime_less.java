import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class prime_less {
	public static void main(String[] args) throws IOException{
		if(args.length<1){
			System.out.println("Please provide filepath for input");
            return; 
		}
		String filepath=args[0];
		BufferedReader in = new BufferedReader(new FileReader(filepath));
		try{
			String readline="";
			while((readline=in.readLine())!=null){
				if(readline.equals(""))
					continue;
				else{
					printPrime(Integer.parseInt(readline));
				}
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	public static void printPrime(int n){
		String output="";
		for(long i=2;i<n;i++){
			if(isPrime(i)){
				output+=i+",";
			}
		}
		System.out.println(output.substring(0, output.length()-1));
	}
	public static boolean isPrime(long n){
		for(long i=2;i*i<=n;i++){
			if(n%i==0)
				return false;
		}
		return true;
		
	}
}
