package scenic.study.datastructure.math;

import org.junit.Test;

/**
 * Created by scenic on 16/7/3.
 * mathematical
 * 经典的数学问题
 */
public class MathModel {

    /**
     *  获取最大公约数<br>
     *  根据欧几里得定律
     *  计算两个非负整数的最大公约数,p, q
     *  如 q == 0, 则 最大公约数为p
     *  若 r = p % q (将p 除以 q 得到余数 r , 则 p q 的最大公约数是 q和r的最大公约数)
     * @param p
     * @param q
     * @return
     */
    public static int gcd(int p , int q){

        if(q == 0){
            return p;
        }

        int r = p % q;

        return gcd(q,r);
    }

    @Test
    public void testGcd(){

        int gcd = gcd(240,18);
        System.out.println(gcd);
//        Assert.assertThat(gcd,is(2));
    }
}
