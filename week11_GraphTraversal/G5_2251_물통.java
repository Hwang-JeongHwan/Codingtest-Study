package week11_GraphTraversal;
import java.io.*;
import java.util.*;



// 물통의 현재 상태와 물을 붓는 행위를 관리하는 클래스
class State{
    int[] X;
    State(int[] X){
        this.X = new int[3];
        for(int i = 0; i < 3; i++){
            this.X[i] = X[i];
        }
    }

    State move(int from,int to,int[] Limit){
        // from 물통에서 to 물통으로 물을 옮긴다.
        int[] nX = new int[]{X[0], X[1], X[2]};
        if (X[from] + X[to] <= Limit[to]){  // 만약 from 을 전부 부을 수 있다면
            nX[to] = nX[from] + nX[to];
            nX[from] = 0;
        }else{  // from 의 일부만 옮길 수 있는 경우
            nX[from] -= Limit[to] - nX[to];
            nX[to] = Limit[to];
        }
        return new State(nX);
    }
    State move2(int from, int to, int[] limit){
        // from 물통에서 to 물통으로 물을 옮긴다.
        int[] nX = new int[]{X[0], X[1], X[2]};

        // from의 물의양과 to의 물의양을 더했을때 to의 용량을 넘어서면
        if(X[from] + X[to] >= limit[to]){
            // 현재 from의 물의양에, to의 용량에 원래 to에 있던 물의 양을 뺴주면됨
            // ex 7, 10, 8 이면 nX[from] = 7 - (10 - 8) = 5
            nX[from] -= limit[to] - X[to];
            nX[to] = limit[to];
        }
        // from이 먼저 바닥나는경우
        else{
            nX[to] += nX[from];
            nX[from] = 0;
        }

        return new State(nX);
    }
};
public class G5_2251_물통 {
    static FastReader scan = new FastReader();
    static StringBuilder sb;
    static int[] limit;
    static boolean[] possible;
    static boolean[][][] visited;

    static void input(){
        limit = new int[3];
        sb = new StringBuilder();
        for(int i = 0; i < 3; i++){
            limit[i] = scan.nextInt();
        }
        visited = new boolean[205][205][205];
        possible = new boolean[205];
    }
    static void bfs(int x1, int x2, int x3){
        Queue<State> queue = new LinkedList<>();
        visited[x1][x2][x3] = true;
        queue.add(new State(new int[]{x1, x2, x3}));

        while(!queue.isEmpty()){
            State st = queue.poll();
            // A번째 물통이 비어있으면 C에 있는값을 확인
            if(st.X[0] == 0){
                possible[st.X[2]] = true;
            }
            for(int from = 0; from < 3; from++){
                for(int to = 0; to < 3; to++){
                    if(from == to){ // 같은 물통의 경우 고려할 필요 없음
                        continue;
                    }
                    State next = st.move(from, to, limit);
                    // 옮기고 난 후의 결과를 아직 방문하지 않았으면 방문처리
                    if(!visited[next.X[0]][next.X[1]][next.X[2]]){
                        visited[next.X[0]][next.X[1]][next.X[2]] = true;
                        queue.add(next);
                    }
                }
            }
        }
    }
    static void solution(){
        bfs(0, 0, limit[2]);
        for(int i = 0; i <= 200; i++){
            if(possible[i]){
                sb.append(i + " ");
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) {
        input();
        solution();
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
