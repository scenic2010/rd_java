package scenic.study.designmode.prototype;

/**
 * Created by scenic on 16/7/22.
 */
public class Glass extends Trash {

    public Glass(double wt) {
        super(wt);
    }

    @Override
    public int value() {
        return 1;
    }
}
