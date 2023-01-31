package week3_Tree;
import java.util.*;
import java.io.*;
public class S1_14675_단절점과_단절선 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] tree = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            tree[s].add(e);
            tree[e].add(s);
            // 정점이나 간선을 제거후 남은 사이즈를 봐야하기 때문에 s,e번째에 e,s를 저장


        }
        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if(t == 2){ // 모든 간선은 제거시 트리가 2개 만들어짐
                sb.append("yes\n");
            }
            else{
                if(tree[k].size() >= 2){
                    sb.append("yes\n");
                }
                else{
                    sb.append("no\n");
                }
            }
        }
        System.out.println(sb);


    }
}
