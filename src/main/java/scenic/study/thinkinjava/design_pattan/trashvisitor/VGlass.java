//: VGlass.java
// Glass for the visitor pattern
package scenic.study.thinkinjava.design_pattan.trashvisitor;
import scenic.study.thinkinjava.design_pattan.trash.*;

public class VGlass extends Glass 
    implements Visitable {
  public VGlass(double wt) { super(wt); }
  public void accept(Visitor v) {
    v.visit(this);
  }
} ///:~