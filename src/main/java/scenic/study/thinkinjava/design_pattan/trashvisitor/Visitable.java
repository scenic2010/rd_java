//: Visitable.java
// An interface to add visitor functionality to 
// the Trash hierarchy without modifying the 
// base class.
package scenic.study.thinkinjava.design_pattan.trashvisitor;
import scenic.study.thinkinjava.design_pattan.trash.*;

interface Visitable {
  // The new method:
  void accept(Visitor v);
} ///:~