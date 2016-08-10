package scenic.study.designmode.structure_type.proxy.abstract_core;

/**
 * Created by scenic on 16/8/10.
 * 主角类
 */
public interface Subject {
    void request();


    /**
     * 具体的主角
     */
    class RealSubject implements Subject{

        String name;

        public RealSubject(String name){
            this.name = name;
        }
        @Override
        public void request() {
            System.out.println("主角1 " + name + " 要送给MM 礼物");
        }
    }

}
