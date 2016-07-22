//: Visitor.java
// The base interface for visitors
package scenic.study.thinkinjava.design_pattan.trashvisitor;
interface Visitor {
  void visit(VAluminum a);
  void visit(VPaper p);
  void visit(VGlass g);
  void visit(VCardboard c);
} ///:~