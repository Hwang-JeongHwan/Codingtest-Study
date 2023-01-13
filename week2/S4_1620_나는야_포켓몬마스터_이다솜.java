package week2;
import java.util.*;
import java.io.*;
public class S4_1620_나는야_포켓몬마스터_이다솜 {
    public static void main(String[] args) throws IOException {

        // 예전에 파이썬의 dictionary를 이용해서 풀어봣던 기억이 있는 문제
        // 자바에서는 어떻게 해야할까 찾아보니 HashMap이라는 자료구조가 있었음 key:value 형식으로
        // 저장하고 기존의 키와 동일한 키로 값을 저장하면 기존의 값은 없어지고 새로운 값으로 대치
        // Hashing을사용, 기억 공간에 저장된 정보를 보다 빠르게 검색하기 위해 절대주소나 상대주소가
        // 아닌 해시 테이블을 생성하는 방식
        // key로 값을 찾는 구조여서 많은 양의 데이터를 검색하는데 뛰어난 성능을 가짐
        // 연관배열 구조를 사용 키1개와 값1개가 1:1로 연관되어있는 자료구조

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String name = "";
        HashMap<String, String> data = new HashMap<>();
        for(int i = 1; i < n + 1; i ++){ // Bulbasaur => 1 이니까
            name = br.readLine();
            data.put(name, Integer.toString(i));
            data.put(Integer.toString(i), name);
            // 이름으로 검색하면 숫자가 나오고 숫자로 검색하면 이름이 나오게
            // 해시맵에 저장


        }
        for(int i = 0; i < m; i ++){
            sb.append(data.get(br.readLine()) + '\n');
            //sb.append(data.get(br.readLine()) + "\n"); 위아래 둘다됨
            // 해시에서 key값으로 값을 얻으려면 HashMap을 참조하는 변수명.get(key)형태로 사용


        }
        System.out.println(sb);
    }
}
