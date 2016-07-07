package scenic.study.thinkinjava.exception;//: c10:StormyInning.java
// From 'Thinking in Java, 2nd ed.' by Bruce Eckel
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
// Overridden methods may throw only the 
// exceptions specified in their base-class 
// versions, or exceptions derived from the 
// base-class exceptions.

import org.junit.Test;

class BaseballException extends Exception {

}

class Foul extends BaseballException {

}

class Strike extends BaseballException {

}

class StormException extends Exception {

}

class RainedOut extends StormException {

}

class PopFoul extends Foul {

}

interface Storm {
  void event() throws RainedOut;

  void rainHard() throws RainedOut;
}

abstract class Inning {
  Inning() throws BaseballException {
  }

  void event() throws BaseballException {
    // Doesn't actually have to throw anything
  }

  void event2() throws Strike {

  }

  abstract void atBat() throws Strike, Foul;

  void walk() {
  } // Throws nothing
}


/**
 * 自己总结: java变成思想之异常
 *      1. 如果构造函数抛出了异常,子类必须也抛出这个异常.
 *            原因: 如果要创建子类的一个对象,那么必须的也要创建父类的对象(再子类构造函数里面调用super),父类的构造函数需要抛出异常,
 *                 并且super必须是子类构造函数里面的在第一行代码,而不能是try,所以只能也同样的抛异常出去
 *
 *      2. 如果重写了父类的抛异常的方法
 *          a. 可以不用声明抛出异常
 *              原因: 1. 因为子类抛出的异常要小于基类的异常,所以没有异常也是符合这个规定
 *                   2. 如果使用基类的引用的话,完全可以提示到客户端要捕获异常
 *                   3. 子类的方法里面的内容完全可以和基类的不同,可能子类的方法根本不会抛出异常. 如果要涉及到super调用基类的方法,完全可以在子类里面记性try catch
 *                      当然如果子类不重写基类的方法. 及时使用子类对象引用,是需要强制客户端捕获这个异常的
 *
 *          b. 如果要抛异常,必须是范围小于基类的异常.
 *              原因: 1. 基类声明的是接口规范, 子类只能声明比父类范围更小的规范(就好像地方法规要小于宪法的约束范围一样)
 *                   2. 如果子类声明了超出基类的异常,此时如果使用基类的引用执行子类对象的操作的时候,基类就无法控制子类的异常了
 */
public class StormyInning extends Inning
        implements Storm {
  // OK to add new exceptions for
  // constructors, but you must deal
  // with the base constructor exceptions:
  public StormyInning() throws RainedOut , BaseballException  {

  }

  StormyInning(String s) throws Foul, BaseballException {
    super();
  }

  // Regular methods must conform to base class:
//    void walk() throws PopFoul {} //Compile error
  // Interface CANNOT add exceptions to existing
  // methods from the base class:
//     public void event() throws RainedOut {}
  // If the method doesn't already exist in the
  // base class, the exception is OK:
  public void rainHard() throws RainedOut {
  }

  // You can choose to not throw any exceptions,
  // even if base version does:
  public void event() {
    try {
      super.event();
    } catch (BaseballException e) {
      e.printStackTrace();
    }
  }


//    public void event2(){
//
//    }



  // Overridden methods can throw
  // inherited exceptions:
  void atBat() {

  }




  @Test
  public void scenicTestClient(){
    {

      StormyInning stormyInning = null;
      try {
        stormyInning= new StormyInning();
      } catch (RainedOut rainedOut) {
        rainedOut.printStackTrace();
      } catch (BaseballException e) {
        e.printStackTrace();
      }

      ////////////////////////

      stormyInning.event();

//            stormyInning.event2();

      stormyInning.atBat();

      ////////////////////////
      try {
        stormyInning.rainHard();
      } catch (RainedOut rainedOut) {
        rainedOut.printStackTrace();
      }


    }
    {
      Inning inning = null;
      try {
        inning = new StormyInning();
      } catch (RainedOut rainedOut) {
        rainedOut.printStackTrace();
      } catch (BaseballException e) {
        e.printStackTrace();
      }

      try {
        inning.event();
      } catch (BaseballException e) {
        e.printStackTrace();
      }

      try {
        inning.atBat();
      } catch (Strike strike) {
        strike.printStackTrace();
      } catch (Foul foul) {
        foul.printStackTrace();
      }

    }


    {
      Storm storm = null;
      try {
        storm = new StormyInning();
      } catch (RainedOut rainedOut) {
        rainedOut.printStackTrace();
      } catch (BaseballException e) {
        e.printStackTrace();
      }

      try {
        storm.event();
      } catch (RainedOut rainedOut) {
        rainedOut.printStackTrace();
      }

      try {
        storm.rainHard();
      } catch (RainedOut rainedOut) {
        rainedOut.printStackTrace();
      }

    }

  }

  public static void main(String[] args) {
    try {
      StormyInning si = new StormyInning();
      si.atBat();
    } catch (PopFoul e) {
      System.err.println("Pop foul");
    } catch (RainedOut e) {
      System.err.println("Rained out");
    } catch (BaseballException e) {
      System.err.println("Generic error");
    }
    // Strike not thrown in derived version.
    try {
      // What happens if you upcast?
      Inning i = new StormyInning();
      i.atBat();
      // You must catch the exceptions from the
      // base-class version of the method:
    } catch (Strike e) {
      System.err.println("Strike");
    } catch (Foul e) {
      System.err.println("Foul");
    } catch (RainedOut e) {
      System.err.println("Rained out");
    } catch (BaseballException e) {
      System.err.println(
              "Generic baseball exception");
    }
  }



} ///:~
