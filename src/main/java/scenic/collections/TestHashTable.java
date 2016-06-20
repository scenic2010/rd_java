package scenic.collections;

import org.junit.Test;

import java.util.HashSet;
import java.util.Hashtable;

/**
 * Created by scenic on 16/6/12.
 */
public class TestHashTable {
    class EntityForHashTableKey {

        private final int name;

        EntityForHashTableKey(int name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "key: " + name;
        }

        @Override
        public boolean equals(Object obj) {
            System.out.println("call the key equals param obj " + obj + " this obj " + this);
            if (obj instanceof EntityForHashTableKey) {
                return this.name == ((EntityForHashTableKey) obj).name;
            }
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
//            int code = name;
            int code = 30000;
            System.out.println("call key hashCode " + code);
            return code;
        }
    }

    class EntityForHashTableValue {

        private final int name;

        EntityForHashTableValue(int name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "value:" + name;
        }


        @Override
        public boolean equals(Object obj) {
            System.out.println("call the value equals param obj " + obj + " this obj " + this);

            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            int code = super.hashCode();
            System.out.println("call value hashCode " + code);
            return code;
        }
    }


    @Test
    public void testHashList() {
        HashSet hashSet = new HashSet();
//        List hashSet = new ArrayList<>();

        System.out.println("begin HashSet add=============");
        hashSet.add(new EntityForHashTableKey(1));
        hashSet.add(new EntityForHashTableKey(2));
        hashSet.add(new EntityForHashTableKey(3));
        hashSet.add(new EntityForHashTableKey(3));


        System.out.println("collection size is " + hashSet.size());

        System.out.println("begin HashSet remove============= \n");
        System.out.println("get value " + hashSet.remove(new EntityForHashTableKey(2)));
    }

    @Test
    public void testHashTable() {


        Hashtable hashtable = new Hashtable();
        System.out.println("begin put=============");
        hashtable.put(new EntityForHashTableKey(1), new EntityForHashTableValue(1));
        hashtable.put(new EntityForHashTableKey(2), new EntityForHashTableValue(1));
        hashtable.put(new EntityForHashTableKey(3), new EntityForHashTableValue(1));
        hashtable.put(new EntityForHashTableKey(3), new EntityForHashTableValue(1));
        hashtable.put(new EntityForHashTableKey(3), new EntityForHashTableValue(1));
        hashtable.put(new EntityForHashTableKey(3), new EntityForHashTableValue(1));
        hashtable.put(new EntityForHashTableKey(3), new EntityForHashTableValue(1));


        System.out.println("begin get=============\n");
        System.out.println("get value " + hashtable.get(new EntityForHashTableKey(3)));
    }


}
