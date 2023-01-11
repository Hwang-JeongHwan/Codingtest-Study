package week1;
// 조마다 티셔츠를 맞추는 비용 = 조에서 가장 큰 원생 키 - 가장 작은 원생 키
// 최소 비용합
import java.util.*;
import java.io.*;
public class G5_13164_행복유치원 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Integer[] data = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i ++){
            data[i] = Integer.parseInt(st.nextToken());
            
        }
        Arrays.sort(data);
//        System.out.println("Arrays.toString(data = " + Arrays.toString(data));
        ArrayList<Integer> sumData = new ArrayList<>();

        for (int i = 0; i < n - 1; i ++){
            sumData.add(data[i + 1] - data[i]);

//            System.out.println(sumData.get(i));
        }
        Collections.sort(sumData); // ArrayList sort
        long result = 0;
        for (int i = 0; i < n - k; i ++){
            result += sumData.get(i); //ArrayList indexing

        }
        System.out.println(result);

        
    }
}
//7 3
//1 4 2 5 6 10 3
