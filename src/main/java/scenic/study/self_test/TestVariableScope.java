package scenic.study.self_test;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * Created by scenic on 16/7/4.
 * 测试不同类型变量的作用域
 */
public class TestVariableScope {


    @Test
    public void testIntScope() {
        //32 位
        System.out.println((int) Math.pow(2, 31) + "\t\t" + "2^31");
        System.out.println((int) Math.pow(2, 31) - 1 + "\t\t" + "2^31 -1");

        int max = 2147483645;
        System.out.println(max + "\t\t" + Integer.toBinaryString(max));

        max++;
        System.out.println(max + "\t\t" + Integer.toBinaryString(max));

        max++;
        System.out.println(max + "\t\t" + Integer.toBinaryString(max));

        max++;
        System.out.println(max + "\t\t" + Integer.toBinaryString(max));

    }

    @Test
    public void testLongScope() {
        //64位
        System.out.println((long) Math.pow(2, 63) + "\t\t" + "2^63");
        System.out.println((long) Math.pow(2, 63) - 1 + "\t\t" + "2^63 -1");

        long max = 9223372036854775806l;
        System.out.println(max + "\t\t");

        max++;
        System.out.println(max + "\t\t");

        max++;
        System.out.println(max + "\t\t");

        max++;
        System.out.println(max + "\t\t");
    }

    @Test
    public void testFloatScope() {
        Float max = Float.MAX_VALUE;
        System.out.println(max);
    }

    @Test
    public void test() {
        System.out.println(isInteger(new Integer(3)));
    }

    public boolean isInteger(Object value) {
        int flag = 0;
        switch (flag) {
            case 0:
                try {
                    Integer.parseInt(value.toString());
                } catch (NumberFormatException e) {
                    return false;
                }
                return true;
            case 1:
                Pattern pattern = Pattern.compile("\\d+");
                return pattern.matcher(value.toString()).matches();
            case 2:


                break;
        }
        throw new RuntimeException("need switch the flag");
    }
}
