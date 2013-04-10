import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TopFour {
	static int[] heap=new int[4];
	  public static void main(String[] args) throws IOException{
		try {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String s = br.readLine();
	        int number = Integer.parseInt(s);
	        int count=0;
	        while(count<number){
	        	int temp=Integer.parseInt(br.readLine());
	        	if(count<4){
	        		heap[count]=temp;
	        	}else{
	        		buildHeap(heap);
	        		if(temp>heap[0]){
	        			heap[0]=temp;
	        		}
	        	}
	        	count++;
	        }
	        heapSort(heap);
	        for(int i=0;i<4;i++){
	        	System.out.println(heap[i]);
	        }
	        } catch (Exception e) {
	        System.err.println("Error:" + e.getMessage());
	    }
			
		} 
	  private static void buildHeap(int[] array){
		  for (int i=(int)((array.length-1)/2); i>=0; i--)
				minHeapify(array,i,array.length-1);
	  }
	  private static void minHeapify(int[] A,int i,int j){
		  int left = 2*i+1; //l ← LEFT(i)
			int right = 2*i+2; //r ← RIGHT(i)
			int smallest = Integer.MAX_VALUE;
			if ( left <= j && A[left] < A[i] ) { //if l ≤ heap-size[A] and A[l] > A[i]
				smallest = left; //   then largest ←l
			} else { //else 
				smallest = i; //largest ←i
			}
			if (right <= j && A[right] < A[smallest]) { //if r ≤ heap-size[A] and A[r] > A[largest]
				smallest = right;	//   then largest ←r
			}
			if (smallest != i) {		//if largest <> i
				//   then exchange A[i] ↔ A[largest]
				int temp = A[i];
				A[i] = A[smallest];
				A[smallest] = temp;

				minHeapify(A,smallest, j);	//MAX-HEAPIFY(A, largest)
			}

	  }
	  public static void heapSort(int[] a) {
			 
			buildHeap(a);
			for (int i = a.length - 1; i >= 1; i--) {
				int temp = a[i];
				a[i] = a[0];
				a[0] = temp;
				minHeapify(a,0, i-1);
			}
	    }

}
