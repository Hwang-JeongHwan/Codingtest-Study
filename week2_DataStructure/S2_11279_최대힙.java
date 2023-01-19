package week2_DataStructure;
import java.io.*;
import java.util.*;
public class S2_11279_최대힙 {
    public static void main(String[] args) throws IOException{
        // 최대힙을 구하는 문제
        // 최대힙 : 부모 노드의 값(키값) >= 자식노드의 값(키값)

        // 파이썬에서는 heap이 min heap으로 구현되어있어서
        // 힙에 집어 넣을때 -를 붙이고 뺄때 다시 - 를 붙여서 빼서 max heap을 구현

        // 자바에서는 우선순위큐가 오름차순으로 정렬 되어있기때문에
        // Collections.reverseOrder()로 생성하면 max heap 구현 가능
        // 일단 이 문제는 0이 들어오면 pop else push

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        // 문제에서 입 력되는 자연수는 2^31 보다 작다 했으니 int 사용 가능
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for(int i = 0; i < n; i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(pq.isEmpty()){
                    sb.append("0\n");
                }
                else{
                    sb.append(pq.poll() + "\n");
                }
            }
            else{
                pq.add(x);
            }
        }
        br.close();
        System.out.println(sb);


    }
}
