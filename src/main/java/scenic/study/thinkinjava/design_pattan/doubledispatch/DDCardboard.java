//: DDCardboard.java
// Cardboard for double dispatching
package scenic.study.thinkinjava.design_pattan.doubledispatch;
import scenic.study.thinkinjava.design_pattan.trash.*;

public class DDCardboard extends Cardboard 
    implements TypedBinMember {
  public DDCardboard(double wt) { super(wt); }
  public boolean addToBin(TypedBin[] tb) {
    for(int i = 0; i < tb.length; i++)
      if(tb[i].add(this))
        return true;
    return false;
  }
} ///:~