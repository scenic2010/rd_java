//: VCardboard.java
// Cardboard for the visitor pattern
package scenic.study.thinkinjava.design_pattan.trashvisitor;
import scenic.study.thinkinjava.design_pattan.trash.*;

public class VCardboard extends Cardboard 
    implements Visitable {
  public VCardboard(double wt) { super(wt); }
  public void accept(Visitor v) {
    v.visit(this);
  }
} ///:~