import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class FrequentTerm {
	  static class MyComparator<K extends Comparable<? super K>, V extends Comparable<? super V>> implements Comparator<Map.Entry<K, V>>{
		  public int compare(Map.Entry<K, V> b, Map.Entry<K, V> a) {
				int cmp1 = a.getValue().compareTo(b.getValue());
				if (cmp1 != 0) {
					return cmp1;
				} else {
					return b.getKey().compareTo(a.getKey());
				}
			}
	  }
	  static HashMap<String,Integer> hash=new HashMap<String,Integer>();
	  public static void main(String[] args) throws IOException{
		try {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String s = br.readLine();
	        int number = Integer.parseInt(s);
	        int count=0;
	        while(count<number){
	        	String str=br.readLine();
	        	if(hash.containsKey(str)){
	        		int fre=hash.get(str);
	        		fre++;
	        		hash.put(str, fre);
	        	}else{
	        		hash.put(str, 1);
	        	}
	        	count++;
	        }
	        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(
					hash.entrySet());
	        Collections.sort(list,new MyComparator<String,Integer>());
	        int k=Integer.parseInt(br.readLine());
	        Iterator<Map.Entry<String, Integer>> iter=list.iterator();
	        while(k>0 && iter.hasNext())
			{
				System.out.println(iter.next().getKey());
				k--;
			}
	        } catch (Exception e) {
	        System.err.println("Error:" + e.getMessage());
	    }
			
		} 
}
