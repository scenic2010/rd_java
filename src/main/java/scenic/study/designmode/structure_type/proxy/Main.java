package scenic.study.designmode.structure_type.proxy;

import org.junit.Test;

import scenic.study.designmode.structure_type.proxy.abstract_core.Proxy;
import scenic.study.designmode.structure_type.proxy.abstract_core.Subject;

/**
 * Created by scenic on 16/8/10.
 *
 * 主要使用地方:
 * 1. 安全代理,控制对真实对象的访问权限.
 * 2. 智能指引,调用真实对象的时候,代理处理另外一些事情.
 *
 * 代理于外观的主要区别:
 * 代理对象代表一个单一的对象,外观对象代表一个子系统;
 * 代理的客户对象无法直接访问目标对象,由代理提供对单独的目标对象的访问控制,而外观的客户对象可以直接访问子系统中的各个对象,
 * 但通常由外观对象提供对子系统各元件功能的简化的共同层次的接口调用.
 *
 * 代理和适配器的区别
 * 适配器不需要虚构出一个代表者,只需要为应付特定使用目的,将原来的类进行一些组合.
 *
 */
public class Main {
    @Test
    public void testSimpleProxy(){

        Subject.RealSubject realSubject = new Subject.RealSubject("小明");
        Subject proxy = new Proxy(realSubject);
        proxy.request();

    }
}
