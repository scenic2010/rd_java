package scenic.study.basic_knowledge;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import scenic.MyLogger;


public class RegexExpressTest {

    static Logger logger = MyLogger.get(RegexExpressTest.class);


    public static final String CHECK_IP =
            "^((\\d|\\d\\d|[0-1]\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|\\d\\d|[0-1]\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|\\d\\d|[0-1]\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|\\d\\d|[0-1]\\d\\d|2[0-4]\\d|25[0-5]))$";


    @Test
    public void testDot() {
        //一个点代表一个字母,一个字符
        logger.debug("abc".matches("..."));

        //所有的数字换成一条横线.  	\d 代表的是一位数字
        logger.debug("a887298a".replaceAll("\\d", "-"));


        //初步认识 . * +
        logger.debug("aaaa".matches("a*"));   //  * 代表0个或多个
        logger.debug("aaaa".matches("a+"));   //  + 代表1个或多个
        logger.debug("".matches("a?"));       //  ? 代表1个或0 个

        logger.debug("a".matches("."));
        logger.debug("aa".matches("aa"));
        logger.debug("a".matches("a?"));
        logger.debug("".matches("a*"));
        logger.debug("aaa".matches("a+"));
        logger.debug("a".matches("a*"));
    }


    @Test
    public void testRange() {
        //一个数字，至少三次，不超过一百次
        logger.debug("1232156165465546".matches("\\d{3,100}")); //{n},{n,}{n,m}
        logger.debug("192.168.0.aaa".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")); //{n},{n,}{n,m}
        logger.debug("192".matches("[0-2][0-9][0-9]"));//[]代表一个范围

        //范围
        logger.debug("a".matches("[abc]"));           //[abc]代表了 取这么多中的一个  []代表的一个字符
        logger.debug("a".matches("[^abc]"));          //[^abc]代表了 取除了 abc 之外的其他字母都可以
        logger.debug("a".matches("[a-zA-Z]"));        //[a-zA-Z]代表了 取小写的a-z之间的或者是大写的A-Z之间的
        logger.debug("a".matches("[a-z]|[A-Z]"));     //同上
        logger.debug("a".matches("[a-z[A-Z]]"));      //同上
        logger.debug("R".matches("[A-Z&&[RFG]]"));    //A到Z之中的，并且是RFG三者之一的


        //边界
        logger.debug("hello sir".matches("^h.*"));              // ^在中括号外面代表 输入的开始
        logger.debug("hello sir".matches(".*ir$"));             // $输入的结尾
        logger.debug("hello sir".matches("^h[a-z]{1,3}o\\b.*"));// \\b单词的边界
        logger.debug("hellosir".matches("^h[a-z]{1,3}o\\b.*")); // \\b单词的边界
    }

    @Test
    public void testSpaceChar() {
        // \d  [0-9]
        // \D  [^0-9]
        // \s  	一个空格字符，\t\n\x0B\f\r			(r是回车)
        // \w [a-zA-Z_0-9]
        logger.debug(" \n\r\t".matches("\\s{4}"));    //  四个空白字符
        logger.debug(" ".matches("\\S"));             //  \\S 非空白字符
        logger.debug("a_8".matches("\\w{3}"));        //  \\w 构成单词的字符
        logger.debug("abc888&^%".matches("[a-z]{1,3}\\d+[&^#%]+"));
        logger.debug("abc888&^%".matches("[a-z]{1,3}\\d+[&^#%]+"));
        logger.debug("\\".matches("\\\\"));

        //读取文章，文章里有很多的空白行，统计有多少空白行
        //找空白行
        logger.debug(" \n".matches("^[\\s&&[^\\n]]*\\n$"));//开头的是空白符号，并且这个空白符不是换行符,中间0个或者字符字符，结束的是换行符

    }

    public static void main(String[] args) {


        //匹配一位字母
//		Pattern p = Pattern.compile("[a-z]");

//		//匹配三个字符，并且这三个字符的任何一个是 a 到 z 之间的字母
//		Pattern p = Pattern.compile("[a-z]{3}");
//		Matcher m = p.matcher("fgh");
//		logger.debug(m.matches());
//		logger.debug("fgha".matches("[a-z]{3}"));
//		//邮件地址
//		logger.debug("dflsdkjfsdklfjsdkf@dfdfsd.com".matches("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+"));
//		String str = "./out/target/product/msm8660_surf/obj/SHARED_LIBRARIES/libchromium_net_intermediates/webkit";
        String str =
                "./cts/tests/tests/webkit";
//		logger.debug(str.matches(".*[^e]+"));
//		logger.debug(str.matches("\\./[^o].+"));
//		logger.debug("./out".matches("\\./.*"));

//		String re = "\\./[^o].*/([^t]).*/.*";
//						//"\./[^o].*/[^t].*/"
//
//		logger.debug(str.matches(re));
//									  //^\./[^o].*/[^t].*
//		Pattern p = Pattern.compile(re);
//		Matcher m = p.matcher(str);
//		logger.debug(m.lookingAt());
//		while(m.find()){
//			logger.debug(m.group(1));
//		}


        logger.debug("手机号====");
        String phone = "17080151610";
        logger.debug(phone.matches("^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8]))\\d{8}$"));
    }

    @Test
    public void testReplace() {
        {
            Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher("Java JAVA java I love java  you hate java");
            logger.debug(m.replaceAll("JAVA"));
        }

        {
            String logPatten = "%t %c%20 %l %c";

            StringBuffer buffer = new StringBuffer();
            Pattern pattern = Pattern.compile("%[a-z](%\\d{1,2})?", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(logPatten);

            logger.debug(matcher.lookingAt());
            matcher.reset();
            while (matcher.find()) {
                String value = matcher.group();
                if (value.equals("%t")) {

                }
                if (value.equals("%c")) {

                }
                if (value.equals("%l")) {

                }
                logger.debug("value " + value);
                matcher.appendReplacement(buffer, "ttt");

            }


            logger.debug("buffer is " + buffer.toString());
        }

    }


    @Test
    public void testGroup1() {
        //分组 小括号分组
        Pattern p = Pattern.compile("(\\d{3,5})[a-z]{2}");
        String s = "123aa-23234bb-3445-00";
        Matcher m = p.matcher(s);
        logger.debug(m.lookingAt());
        while (m.find()) {
            logger.debug(m.group());
        }
    }

    @Test
    public void testGroup2() {
        //maches   find找子串   lookingAt在头上看
        Pattern p = Pattern.compile("\\d{3,5}");
        String s = "123-123-123-00";
        Matcher m = p.matcher(s);
        logger.debug(m.matches());
        m.reset();
        logger.debug(m.find()); //找个匹配的字串  字符串引擎不会回退
        logger.debug(m.start() + "  " + m.end());

        logger.debug(m.find()); //找个匹配的字串
        logger.debug(m.start() + "  " + m.end());

        logger.debug(m.find()); //找个匹配的字串
        logger.debug(m.start() + "  " + m.end());


        logger.debug(m.lookingAt());
        logger.debug(m.lookingAt());
        logger.debug(m.lookingAt());
        logger.debug(m.lookingAt());
        logger.debug(m.lookingAt());
    }

    @Test
    public void testGetHTTPCode() {

        logger.debug("200".matches("\\d{3}"));

        String str = "[HTTP/1.1 200 OK]";
        Pattern pattern = Pattern.compile(".+HTTP/.+(\\d{3}).+");
        Matcher result = pattern.matcher(str);
        if (result.matches()) {
            logger.debug("ok " + result.group(1));

        } else {
            logger.debug("not matches");
        }
    }

    @Test
    public void testReplaceStr() {
        String str = "%t %c %20 %l %c";
        Pattern pattern = Pattern.compile(".+(%c).+");
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            int groupCount = matcher.groupCount();
            for (int i = 0; i <= groupCount; i++) {
                logger.debug("group is " + matcher.group(i));
            }
//			String replace = matcher.
//			logger.debug("replace is " + replace);
        }

    }
}
