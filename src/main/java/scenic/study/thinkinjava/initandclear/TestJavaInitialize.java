package scenic.study.thinkinjava.initandclear;

/**
 * Created by scenic on 16/7/4.
 */
public class TestJavaInitialize {

    public int i;



    public TestJavaInitialize(int i) {
        this.i = i;
    }

    {
        System.out.println(i);
    }
    public static void main(String args[]){
        System.out.println( new TestJavaInitialize(2).i);
    }
}
