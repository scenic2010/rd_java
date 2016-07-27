package scenic.study.designmode.prototype;

/**
 * Created by scenic on 16/7/22.
 */
public class Paper extends Trash {

    public Paper(double wt) {
        super(wt);
    }

    @Override
    public int value() {
        return 2;
    }
}
