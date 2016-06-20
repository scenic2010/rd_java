package scenic.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by scenic on 16/6/8.
 */
public class TestCollections {

    String[] content = {
            "1",
            "2",
            "3",

            "1",
            "2",
            "3"
    };

    @Test
    public void testHashSet() {
        Set<String> collection = new HashSet<>();
        for (String str : content) {
            collection.add(str);
        }
        System.out.println("HashSet result is " + collection);
    }

    @Test
    public void testTreeSet() {
        Set<String> collection = new TreeSet<>();
        for (String str : content) {
            collection.add(str);
        }
        System.out.println("TreeSet result is " + collection);
    }


    @Test
    public void testList() {
        List<String> collection = new ArrayList<>();
        for (String str : content) {
            collection.add(str);
        }
        System.out.println("ArrayList result is " + collection);
    }
}
