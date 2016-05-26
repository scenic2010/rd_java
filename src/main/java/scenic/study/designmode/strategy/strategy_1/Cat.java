package scenic.study.designmode.strategy.strategy_1;

/**
 * Created by liuzd2 on 2014/11/23.
 */
public class Cat implements  Comparable{
    private int height ;
    private int weight ;
    private Comparator comparator = new CatHeightCompartor();
    @Override
    public int compareTo(Object o) {
//        if(o instanceof  Cat){
//            Cat c  = (Cat) o;
//            if(this.getHeight() > c.getHeight()){
//                return 1;
//            }else if(this.getHeight() < c.getHeight()){
//                return -1;
//            }else {
//                return 0;
//            }
//        }
        return comparator.compare(this,o);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Comparator getComparator() {
        return comparator;
    }

    public void setComparator(Comparator comparator) {
        this.comparator = comparator;
    }

    public Cat(int weight, int height) {
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
