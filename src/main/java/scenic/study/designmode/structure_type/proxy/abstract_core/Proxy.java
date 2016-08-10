package scenic.study.designmode.structure_type.proxy.abstract_core;

/**
 * Created by scenic on 16/8/10.
 */
public class Proxy implements Subject{

    Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        if(subject != null){
            subject.request();
        }
    }
}
