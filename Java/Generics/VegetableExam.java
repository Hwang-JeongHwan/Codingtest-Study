package book_study;
import java.util.*;
interface Eatable{}
class Juice{
    String name;
    Juice(String name){this.name = name + "Juice";}
    public String toString(){return this.name;}

}
class Juicer{
    static Juice makeJuice(VegetableBox<? extends Vegetable> box){ // 함수의 매개변수로 와일드 카드 타입 사용
        // Vegetable과 그 자손들이 타입 변수로 들어올 수 있다
        String temp = "";
        for(Vegetable v : box.getList()){ // 부모타입인 Vegetable의 레퍼런스 v는 자신의 인스턴스를 참조할 수 있으므로
            // 에러가 발생하지 않는다.
            temp += v + " ";
        }
        return new Juice(temp);
    }
//    static <T extends Vegetable> Juice makeJuice(VegetableBox<T> box){ // 함수의 매개변수로 와일드 카드 타입 사용
//        // Vegetable과 그 자손들이 타입 변수로 들어올 수 있다
//        String temp = "";
//        for(Vegetable v : box.getList()){ // 부모타입인 Vegetable의 레퍼런스 v는 자신의 인스턴스를 참조할 수 있으므로
//            // 에러가 발생하지 않는다.
//            temp += v + " ";
//        }
//        return new Juice(temp);
//    }
}
class Vegetable implements Eatable{ // 아무 내용이 없는 Eatable을 구현하는 Vegetable클래스
    public String toString(){return "Vegetable";}

}
class Carrot extends Vegetable{public String toString() {return "Carrot";}}
class Tomato extends Vegetable{public String toString(){return "Tomato";}}
class Toy {public String toString(){return "Car";}}

class VegetableBox<T extends Vegetable & Eatable> extends Box<T> {} // Box<T>를 상속받는데
// Type변수는 Fruit의 자식이면서 Eatable 인터페이스를 구현하는 클래스만 들어올수 있음
// interface를 같이 쓸때는 (,)콤마가 아니라 &로 선언, Vegetable이 이미 Eatable인터페이스를 구현하고 있으므로 Vegetable만
// 써도 됨, 인터페이스를 같이 쓸때는 콤마가 아니라 &로 쓴다는것을 기억하기 위해 썻음

class Box<T>{
    ArrayList<T>list = new ArrayList<T>(); // 아이템을 저장할 리스트
    void add(T item){this.list.add(item);} // 박스에 아이템을 추가
    T get(int i) {return this.list.get(i);} // 박스에서 아이템을 꺼낼때
    ArrayList<T> getList(){return this.list;}
    int size(){ return this.list.size();}
    public String toString(){return this.list.toString();}

}
public class VegetableExam {

    public static void main(String[] args) {
        Box box = null;
        Box b = new Box<String>();
        Box b1 = (Box)new Box<String>();
        b.add(new Integer(100));// 가능, 제네릭 안썻을때와 같음


        Box<String>bstr = null;
        box = (Box)bstr;
        bstr = (Box<String>)box;

//        Box<Object> objBox = (Box<Object>)new Box<String>(); // 에러, 형변환 불가능
        Box<? extends Object> wBox = (Box<? extends Object>) new Box<String>();// OK
        Box<? extends Object> wBox1 = new Box<String>();// OK

        VegetableBox<? extends  Vegetable> vbox = (VegetableBox<? extends Vegetable>) new VegetableBox<Vegetable>();
        // VegetableBox<Carrot> -> VegetableBox<? extends Vegetable>
        VegetableBox<? extends Vegetable> cbox = new VegetableBox<Carrot>();

        //VegetableBox<? extends Vegetable> -> VegetableBox<Carrot> 가능?
        VegetableBox<Carrot> carrotbox = (VegetableBox<Carrot>)cbox; //OK. 경고발생



        VegetableBox<Vegetable> vegetableBox = new VegetableBox<Vegetable>();
        vegetableBox.add(new Carrot());
        vegetableBox.add(new Tomato());
//        Vegetable과 그 자손들 Carrot, Tomato가 올 수 있다.
        VegetableBox<Tomato> tomatoBox = new VegetableBox<Tomato>();
        tomatoBox.add(new Tomato());
//        tomatoBox.add(new Carrot()); 타입변수가 일치하지 않으므로 add 에러
        VegetableBox<? extends Vegetable> carrotBox = new VegetableBox<Carrot>();
//        carrotBox.add(new Carrot()) // 에러, 왜 에러가 발생할까? Vegetable의 자손인 Carrot을 add
        // 하는건데...

//        Answer : add T 를 Carrot으로 변경시 가능, add를 <?extends Vegetable> 여서
//        Carrot을 넣는것을 허용해 주면 carroxBox = new VegetableBox<Tomato>로 변경했을때
//        Tomato를 꺼내려 했지만 실제로 넣은 값은 Carrot인 상황이 발생
//        Tomato는 Carrot을 참조할 수 없기때문에 에러 발생

        carrotBox = new VegetableBox<Vegetable>(); // 가능
        carrotBox = new VegetableBox<Tomato>(); // 가능
        // 와일드 카드를 적용하면 하나의 참조변수로 대입된 제네릭 타입이 다 다른 객체들을 다룰 수 있음


        System.out.println(Juicer.makeJuice(vegetableBox)); //Carrot Tomato Juice 출력
        System.out.println(Juicer.makeJuice(tomatoBox)); // Tomato Juice 출력
        // 매개변수로 VegetableBox<? extends Vegetable> 을 받는 static Juice makeJuice 메서드안에서
        // 부모타입인 Vegetable v 로 box.getList()의 리턴을 받으므로 오류가 발생하지 않는다.
//        System.out.println(VegetableExam.<Vegetable>make(vegetableBox));

    }

}


//        VegetableBox<Vegetable> vegetableBox = new VegetableBox<Vegetable>();
//        // extends Vegetable ==> Vegetable을 상속받는 클래스들만 올 수 있는데 자기 자신도 가능
//        VegetableBox<Carrot> carrotBox = new VegetableBox<Carrot>();
//        VegetableBox<Tomato> tomatoBox = new VegetableBox<Tomato>();
////        VegetableBox<Tomato> tomatoBox1 = new VegetableBox<Carrot>(); // 에러, 타입 불일치
//        // 참조변수에 대입된 타입하고 생성자에 대입된 타입이 다르기 때문에 에러
//
////        VegetableBox<Toy> toyBox = new VegetableBox<Toy>(); // 에러, Toy는 Vegetable을 상속받지 않음
//        Box<Toy> toyBox = new Box<Toy>(); // 가능, 타입 T면 무조건 가능
//        // VegetableBox는 Vegetable을 상속받고 Eatable인터페이스를 구현하는 클래스 여야함
//        vegetableBox.add(new Vegetable()); // add(T item)이 add(Vegetable item)으로 바뀜
//        vegetableBox.add(new Carrot()); // 다형성에 의해 자손이니까 됨 부모타입의 레퍼런스는 자식의 인스턴스를 가리킬 수 있다
//        vegetableBox.add(new Tomato()); // ''
//        carrotBox.add(new Carrot());
////        carrotBox.add(new Tomato()) // 에러, 토마토는 캐럿의 자식이 아니므로
//        tomatoBox.add(new Tomato());
//        Eatable eatable = new Vegetable(); // 인터페이스의 레퍼런스는 인터페이스를 구현하는 클래스의 인스턴스를 참조할 수 있다
//        System.out.println(eatable);
//        System.out.println("vegetableBox - " + vegetableBox);
//        System.out.println("carrotBox - " + carrotBox);
//        System.out.println("tomatoBox - " + tomatoBox);
//    }
//}
