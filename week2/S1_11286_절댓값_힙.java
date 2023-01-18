package week2;
import java.util.*;
import java.io.*;
public class S1_11286_절댓값_힙 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                //절대값 기준으로 앞 값이 더 크다면 자리를 바꿔준다.
//                if(Math.abs(o1) > Math.abs(o2)) {
//                    return Math.abs(o1) - Math.abs(o2);
//                    //절대값 기준으로 두 값이 같다면 음수를 앞으로 보내준다.
//                }else if(Math.abs(o1) == Math.abs(o2)) {
//                    return o1 - o2;
//                }else {
//                    return -1;
//                }
//            }
//        });
        // 밑에는 람다식 사용, 위에서는 intellij가 자동완성시켜준 Comparator 익명 클래스 구현
        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer o1, Integer o2)->{
            if(Math.abs(o1) > Math.abs(o2)){
                return Math.abs(o1) - Math.abs(o2);
            }
            else if(Math.abs(o1) == Math.abs(o2)){ // 절대값이 같으면 작은수를 앞으로 보냄
                return o1 - o2;
            }
            else{
                return -1;
            }

//            return  o1 - o2; // Comparatordml compare 메소드는
            // 음수일 경우 두원소의 위치를 교환 안함, 양수일 경우 두 원소의 위치를 교환함
            // 내림차순으로 정렬하고 싶다면 반환값에 음수를 붙이던가 o2 - o1으로 return

        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i ++){
            int input = Integer.parseInt(br.readLine());
            if(input == 0){
                if(pq.isEmpty()){
                    sb.append("0\n");
                }
                else{
                    sb.append(pq.poll() + "\n");
                }
            }
            else{
                pq.add(input);
            }
        }
        br.close();
        System.out.println(sb);

    }
}
