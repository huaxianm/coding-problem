import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MultiplyExceptSelf {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String res = br.readLine();
        int N = Integer.parseInt(res);
        long[] data = new long[N];
        long[] product = new long[N];
        ArrayList<Integer> zeros = new ArrayList<Integer>();
        long midRes = 1;
        for (int i = 0; i < N; i++){
            res = br.readLine();
            long ires = Long.parseLong(res);
            data[i] = ires;
            if (ires != 0){
                if (i != 0) {
                    midRes *= ires;
                }
            } else {
                zeros.add(i);
            }
        }
        if (zeros.isEmpty()) {
            product[0] = midRes;
            for (int i = 1; i < N; i++){
                product[i] = (midRes / data[i]) * data[0];
            }
        }
        if (zeros.size() >= 1){
            for (int i = 0; i < N; i++){
                product[i] = 0;
            }
        }
        if (zeros.size() == 1){
            if (zeros.get(0) == 0) {
                product[0] = midRes;
            }
            else {
                product[zeros.get(0)] = midRes * data[0];
            }
        }
        for (int i = 0; i < N; i++){
            System.out.println(product[i]);
        }
    }
}
