package week2;
import java.util.*;
import java.io.*;

public class S2_2075_N번쨰_큰_수 {
    /*
    * N 번째로 작은 수를 구하는 문제
    * 리스트에 다 집어넣고 인덱싱해서 찾기 add = O(1), indexing O(1) N = 1500이니까
    * 1500 * 1500 = 2,250,000 // 파이썬의 경우 1초에 2백만 정도면 괜찮음
    * 자바도 그러한지 확인해 보려고 리스트에 다 집어넣고 인덱싱 해서 찾아봄
    *
    * 통과후 다른사람들의 코드를 확인해보니 우선순위 큐를이용해서 큐의 원소가 항상 n개가 되도록
    * 유지하면서 == 우선순위큐의 peek를 하면 새로 입력받은 수가 최상단 원소보다 크면 pop후
    * 그 수를 다시 우선순위코드에 입력
    *
    *  n * n 번 반복수행후 pop 하면 N번째로 큰수를 구하도록 구현함
    *  -> 코드는 N번째_큰_수2에 있음
    * */
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
//        ArrayList<Integer> data = new ArrayList<>(); //ArratyList로 구현
//        for (int i = 0; i < n; i ++){
//            st = new StringTokenizer(br.readLine());
//            for(int j = 0; j <n; j ++)
//            {
//                data.add(Integer.parseInt(st.nextToken()));
//            }
//        }
//        Collections.sort(data,Collections.reverseOrder());
//        System.out.println(data.get(n - 1));
//
        int[] array = new int[n * n]; // 배열로도 구현
        int index = 0;

        for(int i = 0; i <n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                array[index++] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(array);

        System.out.println(array[n * n - n]);
    }
}
