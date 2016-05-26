package scenic.study.designmode.strategy.strategy_1;

import java.lang.*;

/**
 * Created by liuzd2 on 2014/11/23.
 */
public class Dog implements java.lang.Comparable {
    private int height ;

    private Comparator comparator = new CatHeightCompartor();

    public Comparator getComparator() {
        return comparator;
    }

    public void setComparator(Comparator comparator) {
        this.comparator = comparator;
    }

    @Override
    public int compareTo(Object o) {
        return comparator.compare(this,o);
    }

    private int weight ;

    public Dog(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }
}
