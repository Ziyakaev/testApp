import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    String string;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Test(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }

    public static void main(String[] args) {
        A aB = new B();
        A aC = new C();
        B bB = new B();
        B bC = new C();
        C cC = new C();
        System.out.println(aC.sum(1,1));
        System.out.println(bB.diff(1,2));
        System.out.println(bC.diff(1,2));



        List<Test> stringList = new ArrayList<>();
        stringList.add(new Test("one"));
        stringList.add(new Test("two"));
        stringList.add(new Test("three"));
        stringList.add(new Test("four"));
        stringList.add(new Test("five"));

        List<Test> first = stringList;
        List<Test> second = new ArrayList<>(stringList);
        List<Test> third = stringList.subList(0, 4);

//        Collections.reverse(stringList);
 //       stringList.remove(0);
        third.get(0).setString("saadas");
// Артур
        System.out.println(first); // "one", "two", "three", "four", "five"
        System.out.println(second);//"one", "two", "three", "four", "five"
        System.out.println(third);//"one", "two", "three" // error
// Ваня
//        System.out.println(first); // "one", "two", "three", "four", "five" - наоборот
//        System.out.println(second);// "one", "two", "three", "four", "five"
//        System.out.println(third);// "one", "two", "three"
    }

}
