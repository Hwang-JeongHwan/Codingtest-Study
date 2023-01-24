package week3_Tree;

import java.io.*;
import java.util.*;
public class None_6416_트리인가 {
    // 트리 판별 -> 루트는 하나, 루트는 들어오는 간선이 하나도 없는 노드
    // 루트를 제외한 모든 노드는 반드시 단 하나의 들어오는 간선이 존재 -> 집입차수가 1
    // 루트에서 다른 노드로 가는 경로는 반드시 가능하며, 유일하다, 이는 루트를 제외한 모든 노드에 성립해야 한다.

    // 루트는 하나여야하고 , 루트를 제외한 모든 노들들의 진입 간선은 한개, 정점의 개수 - 1 == 간선의 개수

    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 한줄씩 입력받는게 아니라 0 0 or -1 -1 이 입력될때 까지 입력받는거라 readLine으로 받으면 안되고
        // Scanner사용해야함
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map;
        int tc = 1;
        while(true){
            map = new HashMap<>();
            int edge = 0;
            while(true){
//                StringTokenizer st = new StringTokenizer(br.readLine());
//                int s = Integer.parseInt(st.nextToken());
//                int e = Integer.parseInt(st.nextToken());
                int s = sc.nextInt();
                int e = sc.nextInt();
                if (s == 0 && e == 0){
                    break;
                }
                else if (s == -1 && e == -1){
                    return;
                }
                map.put(s, map.getOrDefault(s, 0)); // 출발 지점 저장 map.get(key) == 0이면 루트,
                // 처음에 0, s였던 노드가 e로 들어온적이 없다면 계속 0, 아니면 0보다 큰수
                map.put(e, map.getOrDefault(e, 0) + 1); // 진입차수를 나타내기 위해
                // 처음엔 1, e가 겹치면 e + 1
                edge++; // 간선의 개수 ++
            }
            int root = 0;
            boolean tree = true;
            boolean onlyOne = true;
            Iterator<Integer> key = map.keySet().iterator();// map에 저장된 키 정보를 Iterator에 저장
            while(key.hasNext()){
                int now = key.next();
                if(map.get(now) == 0){ // 진입차수가 0이면 루트
                    root ++;
                }
                if(root > 1){ // 루트가 2개 이상이면 트리가 아님
                    tree = false;
                    break;
                }
                if(map.get(now) > 1){ // 진입차수가 1보다 크면 트리가 아님
                    onlyOne = false;
                    break;
                }

            }
            if(map.isEmpty()){ // 노드의 개수가 0인경우 tree
                System.out.println("Case " + tc + " is a tree.");
            }
            else if (tree && onlyOne && map.size() - 1 == edge){ // 간선의 개수 = node - 1
                System.out.println("Case " + tc + " is a tree.");
            }
            else{
                System.out.println("Case " + tc + " is not a tree.");
            }
            tc++;



        }

    }
}
