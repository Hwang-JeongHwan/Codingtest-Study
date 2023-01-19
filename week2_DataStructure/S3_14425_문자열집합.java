package week2_DataStructure;

import java.io.*;
import java.util.*;
public class S3_14425_문자열집합 {
    public static void main(String[] args)throws IOException {
        // N개의 문자열로 집합을 만들고 M 개의 문자열을 입력받아
        // M개의 문자열중 몇개가 집합에 포함되어있는지 출력하는 문제이다.
        // 일단 파이썬에서의 집합 set()자료형은 중복을 허용하지 않고 인덱싱을 하는것이 아니라
        // 해시에서의 key롤 값을 찾는것 같이 if x in set -> O(1)의 시간복잡도를 갖는다
        // if x in array (배열로 만들시 O(n))
        // 값이 있는지 없는지 검사하여 true, false를 return 하는구조
        // 자바에서의 set자료구조의 사용법을 알아보고 문제를 풀어보려고한다.

        // 자바에서 저장 순서를 유지하고 싶으면 LinkedHashSet클래스 사용
        // HashSet은 순서를 유지하지 않음, 내부적으로 HashMap을사용
        // TreeSet은 HashSet과 달리 이진탐색트리 구조로 이루어져 있음
        // 추가와 삭제에는 시간이 조금더 걸리지만 정려르 검색에 높은 성능을 보이는 자료구조
        // Comparator객체를 매개변수로 받아 정렬방법을 임의로 저장해줄 수도 있음

        /* Class Name       Add     Contains     Next
        *   HashSet         O(1)      O(1)         O(h/n) // h는 해시 테이블 용량
        *   LinkedHashSet   O(1)      O(1)         O(1)
        *   EnumSet         O(1)      O(1)         O(1)
        *   TreeSet         O(log n)  O(log n)     O(log n)
        *   HashSet이 가장 빠르다고함
        *
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0; // 몇개가 포함되어있는지 셀 변수
        for(int i = 0; i < n; i++){
            set.add(br.readLine()); //n 번 입력받아 set에 저장
        }

        for(int i = 0; i < m; i ++){
            if(set.contains(br.readLine())){
                count++;
            }
        }
        br.close();
        System.out.println(count);
    }
}
