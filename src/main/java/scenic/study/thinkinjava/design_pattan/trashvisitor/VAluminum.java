//: VAluminum.java
// Aluminum for the visitor pattern
package scenic.study.thinkinjava.design_pattan.trashvisitor;

import scenic.study.thinkinjava.design_pattan.trash.Aluminum;

public class VAluminum extends Aluminum
    implements Visitable {
  public VAluminum(double wt) { super(wt); }
  public void accept(Visitor v) {
    v.visit(this);
  }
} ///:~