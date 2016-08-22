package scenic.study.designmode.create_type.singleton;

/**
 * Created by scenic on 16/8/9.
 */
public class Singleton {
    private Singleton() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        System.out.println( EasySingleton.aaa);
    }



    private static Singleton singleton;

    public static Singleton getInstance() {

        if(false){
            createNoSync();
        }else {
            createWithSync();
        }
        return singleton;
    }

    private static void createNoSync(){
        if (singleton == null) {
            singleton = new Singleton();
        }
    }

    private static void createWithSync() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
    }

}
