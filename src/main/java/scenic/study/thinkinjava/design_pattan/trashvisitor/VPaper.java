//: VPaper.java
// Paper for the visitor pattern
package scenic.study.thinkinjava.design_pattan.trashvisitor;

import scenic.study.thinkinjava.design_pattan.trash.Paper;

//import scenic.study.thinkinjava.design_pattan.trash.*;
public class VPaper extends Paper
    implements Visitable {
  public VPaper(double wt) { super(wt); }
  public void accept(Visitor v) {
    v.visit(this);
  }
} ///:~