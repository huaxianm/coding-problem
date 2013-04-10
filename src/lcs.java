import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/*
 * author:James Man
 */
public class lcs {
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
					String[] words=readline.split(";");
					String s=words[0];
					String t=words[1];
					findLCS(s.toCharArray(),t.toCharArray());
				}
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		
	}
	public static void findLCS(char[] string ,char[] string2) {
		int m = string.length;
		int n = string2.length;
		int[][] c = new int[m+1][n+1];
		int[][] b = new int[m+1][n+1];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				// the character "\\" means the current subsequence is derived from upleft character 
				if(string[i]==string2[j]) {
					c[i+1][j+1]=c[i][j]+1;
					b[i+1][j+1]= '\\';
				} else {
				// the character "|" means the current subsequence is derived from upper character 
					if(c[i][j+1] >= c[i+1][j]) {
						c[i+1][j+1] = c[i][j+1];
						b[i+1][j+1]= '|';
					} else {
				// the character "\\" means the current subsequence is derived from left character 
						c[i+1][j+1] = c[i+1][j];
						b[i+1][j+1]= '-';

					}
				}
			}
		}
		printLCS(b,string,m,n);
		System.out.println();
	}
	private static void printLCS(int[][] b, char[] string, int i, int j) {
		if(i==0 || j==0) {
			return ;
		}
		if(b[i][j]=='\\') {
			printLCS(b, string, i-1, j-1);
			System.out.print(string[i-1]);
		} else if(b[i][j]=='|'){
			printLCS(b, string, i-1, j);
		} else {
			printLCS(b, string, i, j-1);
		}
		 
	}
}

	

