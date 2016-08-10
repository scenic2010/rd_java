package scenic.study.designmode.structure_type.flyweight;

import org.junit.Test;

import scenic.study.designmode.structure_type.flyweight.abstract_core.User;
import scenic.study.designmode.structure_type.flyweight.abstract_core.WebSite;

public class Main {

    /**
     * 享元模式
     * 运用共享技术,有效的支持大量细粒度的对象[DP]
     * <p/>
     * 享元模式的主要目的是实现对象的共享，即共享池，当系统中对象多的时候可以减少内存的开销，通常与工厂模式一起使用。
     * 如果一个应用使用了大量的对象，而这些大量的对象造成了很大的内存开销的时候，应该考虑享元模式；
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    @Test
    public void testString() {
        String a = "你好";
        String b = "你好";
        //此处打印是一样的，应为使用了享元模式
        System.out.println(a.equals(b));
    }

    @Test
    public void testWeb() {
        WebSite fx = new WebSite.OneTestClass("产品展示");
        fx.use();
        WebSite fy = new WebSite.OneTestClass("产品展示");
        fy.use();
        WebSite fz = new WebSite.OneTestClass("产品展示");
        fz.use();


        WebSite f1 = new WebSite.OneTestClass("博客");
        f1.use();
        WebSite fm = new WebSite.OneTestClass("博客");
        fm.use();
        WebSite fn = new WebSite.OneTestClass("博客");
        fn.use();
    }

    @Test
    public void testWebSiteByFlyWeight() {
        ConcreteImpl.WebSiteFactory factory = new ConcreteImpl.WebSiteFactory();
        WebSite fx = factory.getWebSiteCategory("产品展示");
        fx.abUse(new User("大鸟"));

        WebSite fy = factory.getWebSiteCategory("产品展示");
        fy.abUse(new User("小菜"));

        WebSite fz = factory.getWebSiteCategory("产品展示");
        fz.abUse(new User("mandy"));


        WebSite f1 = factory.getWebSiteCategory("博客");
        f1.abUse(new User("scenic"));
        WebSite fm = factory.getWebSiteCategory("博客");
        fm.abUse(new User("Elijah"));
        WebSite fn = factory.getWebSiteCategory("博客");
        fn.abUse(new User("Klaus"));
    }
}
