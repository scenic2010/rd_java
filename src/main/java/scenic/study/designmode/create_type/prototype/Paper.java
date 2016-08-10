package scenic.study.designmode.create_type.prototype;

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
