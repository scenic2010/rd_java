package scenic.study.designmode.create_type.prototype.solution3;

import java.util.Vector;

import scenic.study.designmode.create_type.prototype.Trash;

/**
 * Created by scenic on 16/7/25.
 */
public class VectorFillable implements Fillable {

    final Vector vector ;

    public VectorFillable(Vector vector){
        this.vector = vector;
    }

    @Override
    public void addTrash(Trash t) {
       vector.add(t);
    }
}
