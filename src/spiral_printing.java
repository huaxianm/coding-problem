import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class spiral_printing {
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
					int row=Integer.parseInt(inputs[0]);
					int col=Integer.parseInt(inputs[1]);
					String[] arr=inputs[2].split(" ");
					int[][] array=new int[row][col];
					for(int i=0;i<row;i++){
						for(int j=0;j<col;j++){
							array[i][j]=Integer.parseInt(arr[3*i+j]);
						}
					}
					spiral(array,row,col,0);
				}
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
}
	public static void spiral(int[][] matrix, int m,int n, int level){
        if(m<=0||n<=0) return;
        if(m==1){
            for(int i=0;i<n;i++){
                System.out.print(matrix[level][level+i]+" ");
            }
            return;
        }
        if(n==1){
            for(int i=0;i<m;i++){
            	System.out.print(matrix[level+i][level]+" ");
                
            }
            return;
        }
        for(int i=0;i<n-1;i++){
        	System.out.print(matrix[level][i+level]+" ");
        }
        for(int i=0;i<m-1;i++){
        	System.out.print(matrix[i+level][n-1+level]+" ");
        }
        for(int i=0;i<n-1;i++){
        	System.out.print(matrix[m-1+level][n+level-1-i]+" ");
        }
        for (int i = 0; i < m - 1; i++)
        	System.out.print(matrix[level+m-1-i][level]+" ");
 
            spiral(matrix, m-2, n-2, level+1);
}

}
