package book_study;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(5);
        arr.add(5);
        System.out.println(arr.toString());
        for(int i : arr){
            System.out.println(i);
        }
    }
}
