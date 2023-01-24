package week3_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_1068_트리 {
    static int parent[];
    static boolean visited[];
    static ArrayList<Integer>[] arr;
    static int bfs(int start, int removeNum){
        int count = 0;
        if(start == removeNum) { // 루트노드를 제거하는경우 0리턴
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
//        if(start == removeNum)
//            return 0;
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            if(arr[now].size() == 0){ // 자식이 없는 노드인경우 ++
                count ++;
            }
            for(int i : arr[now]){
                if(i == removeNum && arr[now].size() == 1){
                    count++;
                    continue;
                    //78퍼에서 안되서 질문게시판 찾아보니 반례
                    //2
                    //-1 0
                    //1 일때 루트노드만 남아서 리프노드가 1개인경우라 1이출력되어야하는데
                    // 이부분을 추가안해줘서 틀림 -> 추가해줌
                    // i가 삭제된 노드고 i의 부모가 i만 자식으로 가지고 있으면 리프노드가됨
                }
                if(!visited[i] && i != removeNum){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }

        return count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        parent = new int[n];
        arr = new ArrayList[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            parent[i] = Integer.parseInt(st.nextToken());
            arr[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        int removeNum = Integer.parseInt(st.nextToken());

        br.close();
        int start = 0;
        for(int i = 0; i < n; i++){
            if(parent[i] == -1){
                start = i;

            }
            else{
                int s = parent[i];
                int e = i;
                arr[s].add(e);
                // 부모 기준으로 연결리스트 만들기



            }

        }
        visited = new boolean[n];
        System.out.println(bfs(start, removeNum));

    }
}
