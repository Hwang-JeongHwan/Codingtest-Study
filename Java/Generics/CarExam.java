package Java.Generics;

class Suv extends Car {
    Suv(){
//        super("페라리", 100, 100);
    }
}
class CarBox<T extends Car> extends Box<T> { }
interface Ride{}

class Car implements Ride {
    public String toString(){return "Car";}
}
public class CarExam{


        public static void main(String[] args) {
            CarBox<? extends Car> carBox = new CarBox<Car>(); // Ok
//            carBox.add(new Car());
//        list = new ArrayList<Suv>(); // Ok
//        list = new ArrayList<Suv>();
//
//        System.out.println(list.toString());
//        ArrayList<Car> list3 = new ArrayList<Vegetable>(); // 에러, 대입된 타입 불일치
        }

//        HashMap<String, Car> map = new HashMap<String, Car>();
//
//        map.put("페라리", new Car("페라리", 100, 100));
//        Car car = map.get("페라리");
//        Car car1 = (Car)map.get("페라리");// 예전에는 이렇게 사용 지금은 형변환 생략 가능, 타입이 지정되어 있으니까
//        System.out.println(map.get("페라리").company); // 이렇게도 사용하능, 페라리 출력
    }


