package scenic.study.designmode.prototype.addNewTrash2;

import scenic.study.designmode.prototype.Paper;

/**
 * Created by scenic on 16/7/25.
 */
public class Cardboard extends Paper{
    public Cardboard(double wt) {
        super(wt);
    }

    @Override
    public int value() {
        return 5;
    }
}
