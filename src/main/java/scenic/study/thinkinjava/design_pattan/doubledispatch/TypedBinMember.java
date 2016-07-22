//: TypedBinMember.java
// An interface for adding the double dispatching
// method to the trash hierarchy without 
// modifying the original hierarchy.
package scenic.study.thinkinjava.design_pattan.doubledispatch;

interface TypedBinMember {
  // The new method:
  boolean addToBin(TypedBin[] tb);
} ///:~