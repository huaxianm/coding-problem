import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class email_regex {
	public static void main(String[] args) throws IOException{
		if(args.length<1){
			System.out.println("Please provide filepath for input");
			System.exit(0); 
		}
		String filepath=args[0];
		BufferedReader in = new BufferedReader(new FileReader(filepath));
		try{
			String readline="";
			while((readline=in.readLine())!=null){
				if(readline.equals(""))
					continue;
				else
				{
					checkValidation(readline);
				}
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		}
	static void checkValidation(String str){
		String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(str);
		boolean isMatched = matcher.matches();
		System.out.println(isMatched);

}
}
