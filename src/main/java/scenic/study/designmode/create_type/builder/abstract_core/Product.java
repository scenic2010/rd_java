package scenic.study.designmode.create_type.builder.abstract_core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scenic on 16/8/8.
 */
public class Product {
    private List<String> part = new ArrayList<>();

    public void addPart(String str) {
        part.add(str);
    }

    public void show() {
        System.out.println("产品: " + part);
    }
}
