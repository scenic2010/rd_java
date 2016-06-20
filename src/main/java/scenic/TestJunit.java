package scenic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasValue;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertThat;


/**
 * Created by scenic on 16/6/9.
 */
public class TestJunit {
    private String testString = "scenic_mandy_home";


    @Before
    public void before() {

        System.out.println("before");
        System.out.println();
    }

    @After
    public void after() {
        System.out.println("after");
        System.out.println();
    }


    @BeforeClass
    public static void beforeClass() {

        System.out.println("beforeClass");
        System.out.println();
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass");
    }

    @Test
    public void testAdd() {
        int z = 9;
        assertThat(z, is(9));
        assertThat(z, anything());
        assertThat(z, allOf(greaterThan(8), lessThan(10)));
    }

    @Test
    public void testString() {
        String str = testString;

        assertThat(str, is("scenic_mandy_home"));

        assertThat(str, is(not("test")));
        assertThat(str, not("test"));

        assertThat(str, containsString("d"));
        assertThat(str, endsWith("d"));
        assertThat(str, startsWith("d"));
        assertThat(str, equalTo("d"));

        assertThat(str, equalToIgnoringCase("d"));
        //忽略空白字符
        assertThat(str, equalToIgnoringWhiteSpace("d"));
    }

    @Test
    public void testFloatValue() {
        double n = 3.1;

        //接近3.0 误差不超过0.3
        assertThat(n, closeTo(3.0, 0.3));

        assertThat(n, lessThan(3.0));
        assertThat(n, greaterThan(3.0));
        assertThat(n, lessThanOrEqualTo(3.0));
        assertThat(n, greaterThanOrEqualTo(3.0));
    }


    @Test
    public void testMap() {
        Map<String, String> map = new HashMap<>();


        assertThat(map, hasEntry("key", "value"));
        assertThat(map, hasKey("key"));
        assertThat(map, hasValue("value"));


    }

    @Test
    public void testList() {
        List<String> list = new ArrayList<>();
        assertThat(list, hasItem("value"));
    }

    @Ignore
    @Test(expected = java.lang.ArithmeticException.class)
    public void testAnnotation() {
        int a = 8 / 0;
    }

    @Test(timeout = 100)
    public void testTimeOut() throws InterruptedException {
        Thread.sleep(6);
    }
}
