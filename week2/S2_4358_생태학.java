package week2;
import java.util.*;
import java.io.*;

public class S2_4358_생태학 {
    public static void main(String[] args) throws IOException{
        // 이 문제는 key와 value형태로 출력하면 되므로
        // HashMap 사용
        // 입력받는 문자열이 존재하면 value + 1
        // 없으면 0 저장
        // HashMap의 getOrDefalut메소드를 이용하면 get이 null 이 아닌경우 원하는 값을 지정해서 반환할 수 있음

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        double count = 0;
        while(input != null){
//            System.out.println(input);
            map.put(input, map.getOrDefault(input, 0) + 1);
            count ++;
            input = br.readLine();
        }
//        String[] result = map.keySet().toArray(new String[map.size()]); // 맵의 모든키를 Set으로 반환한 결과를 Array로 반환
//        Arrays.sort(result);
//
//        for (int i = 0; i < result.length; i ++){
//            sb.append(result[i] + " " + String.format("%.4f", (map.get(result[i])/ count) * 100) + "\n");
//        }
//        System.out.println(sb);
//
//
        // 최상위 객체 Object를 사용하면 모든 객체를 배열로 담을 수 있음 ->
        // String[] 문자열 배열로 받으려면 map의 길이를 알아야함

        Object[] result = map.keySet().toArray();
        Arrays.sort(result);
        for(Object key : result){
            sb.append((String)key + " " + String.format("%.4f", (map.get((String)key)/ count) * 100) + "\n");

        }
        System.out.println(sb);
        // ArrayList로도 keySet을 받을 수 있음
//        ArrayList<String> keys = new ArrayList<String>(map.keySet());
//        Collections.sort(keys);
//        for(String key : keys){
//
//            sb.append(key + " " + String.format("%.4f", (map.get(key)/ count) * 100) + "\n");
//        }
//        System.out.println(sb);

    }
}
