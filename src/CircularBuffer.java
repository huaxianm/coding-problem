import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class CircularBuffer {
	  static Queue<String> queue=new LinkedList<String>();
	  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  public static void main(String[] args) throws IOException{
		try {
			String s = br.readLine();
	        int buffersize = Integer.parseInt(s);
	        while(true){
	        	String dosomething=br.readLine();
	        	if(dosomething.startsWith("A")){
	        		append(dosomething,buffersize);
	        	}else if(dosomething.startsWith("R")){
	        		remove(dosomething);
	        	}else if(dosomething.startsWith("L")){
	        		list(dosomething);
	        	}else if(dosomething.startsWith("Q")){
	        		return;
	        	}
	        	}
	        } catch (Exception e) {
	        System.err.println("Error:" + e.getMessage());
	    }	
		}
	  private static void append(String str,int size) throws IOException{
		  String[] temp=str.split(" ");
		  int ntoappend=Integer.parseInt(temp[1]);
		  while(ntoappend>0){
			  if(queue.size()<size){
				  queue.add(br.readLine());
				  ntoappend--;
			  }else{
				  queue.remove();
				  queue.add(br.readLine());
				  ntoappend--;
			  }
		  }
	  }
	  private static void remove(String str){
		  String[] temp=str.split(" ");
		  int ntoremove=Integer.parseInt(temp[1]);
		  while(ntoremove>0){
			 queue.remove();
			 ntoremove--;
		  }
	  }
	  private static void list(String str){
		  Iterator<String> iter=queue.iterator();
		  while(iter.hasNext()){
			  System.out.println(iter.next());
		  }
	  }
}
