package Java;
interface animal{
    public abstract String wal();
    public abstract int werl();
}
abstract class animal1 implements animal{
    public String wal(){
        return "hello";
    }
}
@FunctionalInterface // 애너테이션을 붙이면 컴파일러가 올바르게 작성했는지 확인해줌
interface myInterface{

    public abstract int max(int a, int b);
}
class animal2 extends animal1 {
    public String wal(){
        return "hi";
    }
    public int werl(){
        return 0;
    }
}
class test1 {
    int size = 100;
    static int size2 = 200;

    static void printSize() {
//        System.out.println(size);
        System.out.println(size2);
    }

    class test2 {
        void getTest1() {
            System.out.println(size2);
        }
    }

    class test4 {

    }

    static class test3 {
        static int test3size = 30;
        int level = 3;

        static void getsize() {
//            System.out.println(size);
            System.out.println(size2);
        }
    }

    public static void main(String[] args) {

        animal1 ani1 = new animal2();
        System.out.println(ani1.wal());
    }
//        test1.test2 test = new test1().new test2();
//        test.getTest1();
//        test1.test3.getsize();
//        System.out.println(test3.test3size);
//        test1.test3 t3 = new test1.test3();
//        System.out.println(t3.level);

//        animal a = new animal(){
//
//            @Override
//            public String wal() {
//                return "wal";
//            }
//
//
//        };
//        animal a2 = new animal(){
//            public String wal() {
//                return "walwal";
//            }
//            public int werl(){
//                return 200;
//            }
//        };
//
//        System.out.println(a.wal());
//        System.out.println(a.werl());
//        System.out.println(a2.wal());
//        System.out.println(a2.werl());
//    }
//}
}
