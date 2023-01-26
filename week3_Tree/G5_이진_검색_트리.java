package week3_Tree;
import java.util.*;
import java.io.*;
public class G5_이진_검색_트리 {
    static StringBuilder sb;
    static class Node{
        int num;
        Node left, right;
        Node(int num){
            this.num = num;
        }

        void addNum(int num){
            if(this.num > num){
                if(this.left == null){ // 왼쪽이 비어있으면
                    this.left = new Node(num); // 왼쪽에 새로운 노드를만들고 num을 추가
                }
                else{
                    this.left.addNum(num);//현재 Node의 인스턴스를 참조하는 레퍼런스에서
                    // 계속해서 재귀적으로 addNum(num)을 호출해Node left를 만들고 num을 추가
                }
            }
            else{
                if(this.right == null){
                    this.right = new Node(num);
                }
                else{
                    this.right.addNum(num);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        Node tree = new Node(Integer.parseInt(br.readLine()));
        String input;
        while(true){
            input = br.readLine();
//            System.out.println(input);
            if(input == null || input.equals("")){
                break;
            }
            tree.addNum(Integer.parseInt(input));

        }
//        System.out.println(tree.left);
        postOrder(tree);
        System.out.print(sb);


    }
    static void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.num + "\n");
    }
}
