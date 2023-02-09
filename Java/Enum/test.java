package Java.Enum;

//class Unit{
//    int x, y;
//    Direction dir;
//    void int(){
//        dir = Direction.EAST;
//    }
//}
enum Direction{
    EAST("동쪽",3), WEST("서쪽",5),
    SOUTH("남쪽",-1), NORTH("북쪽",7); // 끝에 세미콜론 추가
    // EAST()는 생성자 호출임
    private static final Direction[] DIR = Direction.values();
    // name, value를 배열에 저장
    private final String Symbol; // 문자열을 저장할 필드(인스턴스 변수) 추가
    private final int value; // 정수를 저장할 필드(인스턴스 변수) 추가

        Direction(String symbol, int value){
        this.Symbol = symbol;
        this.value = value;
    } // 생성자를 추가
    // 생성자를 추가하기 전에는 위의 코드들이 전부 오류였음, 생성자는 항상 private, 생략된거임

    public int getValue(){return this.value;}
    public String getSymbol(){return this.Symbol;}
    public String toString(){
            return name() + " " + getSymbol() + " " + getValue();
    }
    public static Direction of(int dir) {
        return DIR[dir - 1];
    }
}
class Trump{
//    enum Kind {DIAMOND, CLOVER, HEART, SPADE} // 열거형 Kind를 정의
//    //             0       1      2     3
//    enum Value {ZERO,ONE, TWO, THREE}
//    final Kind kind; // 타입이 int가 아니라 Kind
//    final Value value;
    static final int DIAMOND = 0;
    static final int CLOVER = 1;
    static final int HEART = 2;
    static final int SPADE = 3;

    static final int  ONE = 1;
    static final int TWO = 2;

//    final int kind;
//    final int num;

}
public class test {
    public static void main(String[] args) {
        System.out.println(Trump.HEART == Trump.TWO);

//        if(dir == Direction.EAST){ // OK
//            x++;
//        }
//
//        else if(dir > Direction.WEST){ //   에러, 열거형 상수에 비교연산자 사용 불가
//
//        }
//        else if (dir.compareTo(Direction.WEST > 0)){ // compareTo()는 가능
//    }
//        Direction d = new Direction('WEST',10); // 생성자가 private
        // 여서 외부에서 호출할 수 없음

        Direction d1 = Direction.of(2);
        System.out.println(d1);
        System.out.println(Direction.EAST);

        switch (d1){
            case EAST: // Direction.EAST라고 쓸 수 없다
                System.out.println("Direction is EAST");break;
            case WEST:
                System.out.println("Direction is WEST");break;
            case SOUTH:
                System.out.println("Direction is SOUTH");break;
            case NORTH:
                System.out.println("Direction is NORTH");break;
        }
    }

}
