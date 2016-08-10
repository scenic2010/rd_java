package scenic.study.designmode.create_type.prototype;

/**
 * Created by scenic on 16/7/22.
 * @since resolution2
 */
public class Peel extends Trash {

    public Peel(double wt) {
        super(wt);
    }

    @Override
    public int value() {
        return 5;
    }
}
