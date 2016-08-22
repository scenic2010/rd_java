package scenic.study.designmode.create_type.singleton;

import java.util.ArrayList;
import java.util.List;

public enum EasySingleton {

    aaa(4),
    bbb(7);

    private String aa;
    private List<String> lis;


     EasySingleton(int a){
        System.out.println("====   "  + a);
        lis = new ArrayList<>();
        aa = null;
    }

}