package scenic.study.accesspemission.package2;

/**
 * Created by scenic on 16/7/4.
 */
public class TryAccessClient {

    {
        TestAccessPermission permission = new TestAccessPermission();

        permission.testProtected();
        permission.testDefault();
        permission.testPublic();
    }


}
