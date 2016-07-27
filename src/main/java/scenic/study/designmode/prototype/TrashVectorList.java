package scenic.study.designmode.prototype;


import java.util.Vector;

/**
 * Created by scenic on 16/7/25.
 */
public class TrashVectorList extends Vector<TrashVector> {
    public void sortBin(TrashVector allTrashVector){
        for(int i = 0; i < this.size() ; i++){
            TrashVector tv = this.get(i);
            allTrashVector.forEach(tv::grab);
        }
    }
}
