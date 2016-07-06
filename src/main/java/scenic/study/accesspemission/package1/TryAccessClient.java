package scenic.study.accesspemission.package1;

import scenic.study.accesspemission.package2.TestAccessPermission;

/**
 * Created by scenic on 16/7/4.
 */
public class TryAccessClient {

    class TestClient extends TestAccessPermission {

    }
    {

        TestClient client = new TestClient() {
            @Override
            protected void testProtected() {
                super.testProtected();
            }

            @Override
            public void testPublic() {
                super.testPublic();
            }
        };

        client.testPublic();
    }


}
