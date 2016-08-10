package scenic.study.designmode.create_type.prototype;

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
