package scenic.study.thinkinjava.initandclear;//: c04:Garbage.java
// Demonstration of the garbage
// collector and finalization

public class Garbage {
    public static void main(String[] args) throws InterruptedException {
        // As long as the flag hasn't been set,
        // make Chairs and Strings:
        while (!Chair.f) {

            new Chair();

//            System.out.println("create one chair " + chair.i);
            Thread.sleep(1);
        }
        System.out.println(
                "After all Chairs have been created:\n" +
                        "total created = " + Chair.created +
                        ", total finalized = " + Chair.finalized);
        // Optional arguments force garbage
        // collection & finalization:

        int debugFlag = 0;
        switch (debugFlag){
            case 1:
                System.gc();
                break;
            case 2:
                System.runFinalization();
                break;
            case 3:
                System.gc();
                System.runFinalization();
                break;
        }

        System.out.println("bye!");
    }
} ///:~


class Chair {
    static boolean gcrun = false;
    static boolean f = false;
    static int created = 0;
    static int finalized = 0;
    int i;

    Chair() {
        byte[] bytes = new byte[1024*1024];
        i = ++created;
        if (created == 47)
            System.out.println("Created 47");
    }

    public void finalize() {
        if (!gcrun) {
            // The first time finalize() is called:
            gcrun = true;
            System.out.println(
                    "Beginning to finalize after " +
                            created + " Chairs have been created");
        }
        if (i == 47) {
            System.out.println(
                    "Finalizing Chair #47, " +
                            "Setting flag to stop Chair creation");
            f = true;
        }
        finalized++;
        if (finalized >= created)
            System.out.println(
                    "All " + finalized + " finalized");

        System.out.println("finalize " + i);
    }
}

