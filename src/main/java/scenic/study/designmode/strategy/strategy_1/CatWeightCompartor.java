package scenic.study.designmode.strategy.strategy_1;

/**
 * Created by liuzd2 on 2014/11/23.
 */
public class CatWeightCompartor implements  Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Cat c1 = (Cat) o1;
        Cat c2 = (Cat) o2;

        if(c1.getHeight() > c2.getHeight()) return 1;
        else if (c1.getHeight()<c2.getHeight()) return -1;

        return 0;
    }
}
