package scenic.study.basic_knowledge;

import org.junit.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import scenic.MyLogger;

/**
 * Created by scenic on 2016/8/27.
 */
public class SystemApiTest extends MyLogger.TestWithLogger {
    @Test
    public void testEvn(){
        Map<String, String> evn = System.getenv();
        Set<Map.Entry<String, String>> set = evn.entrySet();

        for ( Map.Entry<String ,String> entry : set) {
            logger.info( entry.getKey() + "\t" + entry.getValue() );
        }
    }

    @Test
    public void testProperties(){
        Properties properties = System.getProperties();
        Set<Object> set = properties.keySet();

        for ( Object key : set) {
            logger.info( key + "\t" + properties.get(key));
        }
    }
}
