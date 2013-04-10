import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/*
 * author:Huaxiang Man
 */

public class str_substitution {
	//use a map to record whether current index has been substituted
	static Map<Integer,Integer> map=new HashMap<Integer,Integer>();
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
				else{
					String[] inputs=readline.split(";");
					String string=inputs[0];
					String[] source=inputs[1].split(",");
					for(int i=0;i<=source.length-2;i=i+2){
						string=getSubstitution(string,source[i],source[i+1]);
					}
					System.out.println(string);
				}
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
}
		public static String getSubstitution(String str, String target, String sub){
			int len=target.length();
			String output="";
			int count=0;
			while(count<=str.length()-len){
				if(map.containsKey(count)){
					int newlen=map.get(count);
					count+=newlen;
				}else{
					String cur=str.substring(count,count+len);
					if(cur.equals(target)){
						map.put(count, sub.length());
						output= str.substring(0, count)+sub+str.substring(count+len);
						break;
				}
					count++;
			}
			
		}
			return output==""?str:output;
}
}
