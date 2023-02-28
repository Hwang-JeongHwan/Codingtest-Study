package week7_BinarySearch;
import java.util.*;
import java.io.*;
public class S3_19637_IF문_좀_대신_써줘 {
    static class stat{
        String name;
        int value;
        stat(String name, int value){
            this.name = name;
            this.value = value;
        }
    }
    static ArrayList<stat> stats;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        stats = new ArrayList<stat>();

        for(int i = 0; i < n; i ++){
            st = new StringTokenizer(br.readLine());
            stats.add(new stat(st.nextToken(), Integer.parseInt(st.nextToken())));
        }
        for(int i = 0; i < m; i++){
            sb.append(binarySearch(0, n - 1, Integer.parseInt(br.readLine())) + "\n");
        }
        System.out.print(sb);
    }
    static String binarySearch(int start, int end, int target){
        int mid = 0;
        while(start <= end){
            mid = (start + end) / 2;
            if(target <= stats.get(mid).value){
                end = mid - 1; // 같은 value를 갖는 stat들이 있을수 있고, 가장 먼저 나온
                // 가장 먼저 입력된 칭호 하나만 출력해야함
            }
            else{
                start = mid + 1;
            }
        }
        return stats.get(start).name; //  start <= end 반복문 탈출시 start가 end보다 큼 위의 if문에서
        // target <= 인경우 end의 범위를 줄이므로
    }
}
