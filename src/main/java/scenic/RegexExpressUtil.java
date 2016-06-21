package scenic;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexExpressUtil {

	
	public static final String CHECK_IP =
     "^((\\d|\\d\\d|[0-1]\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|\\d\\d|[0-1]\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|\\d\\d|[0-1]\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|\\d\\d|[0-1]\\d\\d|2[0-4]\\d|25[0-5]))$";
	
	
	
	public static void main(String[] args) {
//		//一个点代表一个字母,一个字符
//		System.out.println("abc".matches("..."));
		
		
		
//		//所有的数字换成一条横线.  	\d 代表的是一位数字
//		System.out.println("a887298a".replaceAll("\\d", "-"));
		
		
		
		//匹配一位字母
//		Pattern p = Pattern.compile("[a-z]");
	
//		//匹配三个字符，并且这三个字符的任何一个是 a 到 z 之间的字母
//		Pattern p = Pattern.compile("[a-z]{3}");
//		Matcher m = p.matcher("fgh");
//		System.out.println(m.matches());
//		
		
		
//		System.out.println("fgha".matches("[a-z]{3}"));
		
		
		
//		//初步认识 . * + 
		System.out.println("a".matches("."));
//		System.out.println("aa".matches("aa"));
//		System.out.println("aaaa".matches("a*")); //* 代表0个或多个
//		System.out.println("aaaa".matches("a+")); //+     1个或多个
//		System.out.println("".matches("a?")); //?     1个或0 个
//		System.out.println("a".matches("a?")); 
//		System.out.println("".matches("a*")); 
//		System.out.println("aaa".matches("a+")); 
//		System.out.println("a".matches("a*"));
//		//一个数字，至少三次，不超过一百次
//		System.out.println("1232156165465546".matches("\\d{3,100}")); //{n},{n,}{n,m}
//		System.out.println("192.168.0.aaa".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")); //{n},{n,}{n,m}
//		System.out.println("192".matches("[0-2][0-9][0-9]"));//[]代表一个范围
		
		
		
//		//范围
//		System.out.println("a".matches("[abc]")); //[abc]代表了 取这么多中的一个  []代表的一个字符
//		System.out.println("a".matches("[^abc]")); //[^abc]代表了 取除了 abc 之外的其他字母都可以
//		System.out.println("a".matches("[a-zA-Z]")); //[a-zA-Z]代表了 取小写的a-z之间的或者是大写的A-Z之间的
//		System.out.println("a".matches("[a-z]|[A-Z]")); //同上
//		System.out.println("a".matches("[a-z[A-Z]]")); //同上
//		System.out.println("R".matches("[A-Z&&[RFG]]")); //A到Z之中的，并且是RFG三者之一的
		
		
//		// \d  [0-9]
//		// \D  [^0-9]
//		// \s  	一个空格字符，\t\n\x0B\f\r			(r是回车)
//		// \w [a-zA-Z_0-9]
//		System.out.println(" \n\r\t".matches("\\s{4}"));//四个空白字符
//		System.out.println(" ".matches("\\S"));// \\S 非空白字符
//		System.out.println("a_8".matches("\\w{3}"));// \\w 构成单词的字符
//		System.out.println("abc888&^%".matches("[a-z]{1,3}\\d+[&^#%]+"));
//		System.out.println("abc888&^%".matches("[a-z]{1,3}\\d+[&^#%]+"));
//		System.out.println("\\".matches("\\\\"));
		
		
//		//边界
//		System.out.println("hello sir".matches("^h.*"));// ^在中括号外面代表 输入的开始
//		System.out.println("hello sir".matches(".*ir$"));// $输入的结尾
//		System.out.println("hello sir".matches("^h[a-z]{1,3}o\\b.*"));// \\b单词的边界
//		System.out.println("hellosir".matches("^h[a-z]{1,3}o\\b.*"));// \\b单词的边界

		
		
//		//读取文章，文章里有很多的空白行，统计有多少空白行
//		//找空白行
//		System.out.println(" \n".matches("^[\\s&&[^\\n]]*\\n$"));//开头的是空白符号，并且这个空白符不是换行符,中间0个或者字符字符，结束的是换行符

		
//		//邮件地址
//		System.out.println("dflsdkjfsdklfjsdkf@dfdfsd.com".matches("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+"));
		
		
		
		
		
		
//		//maches   find找子串   lookingAt在头上看
//		Pattern p = Pattern.compile("\\d{3,5}");
//		String s = "123-123-123-00";
//		Matcher m = p.matcher(s);
//		System.out.println(m.matches());
//		m.reset();
//		System.out.println(m.find()); //找个匹配的字串  字符串引擎不会回退
//		System.out.println(m.start() +"  " + m.end());
//		
//		System.out.println(m.find()); //找个匹配的字串
//		System.out.println(m.start() +"  " + m.end());
//
//		System.out.println(m.find()); //找个匹配的字串
//		System.out.println(m.start() +"  " + m.end());
//		
//		
//		System.out.println(m.lookingAt());
//		System.out.println(m.lookingAt());
//		System.out.println(m.lookingAt());
//		System.out.println(m.lookingAt());
//		System.out.println(m.lookingAt());
		
		
//		
//		Pattern p = Pattern.compile("java");
//		Matcher m = p.matcher("Java JAVA java I love javfa  you hate java");
//		while(m.find()){
//			System.out.println(m.group());
//		}
//		
		
		
//		Pattern p = Pattern.compile("java",Pattern.CASE_INSENSITIVE);
//		Matcher m = p.matcher("Java JAVA java I love javfa  you hate java");
//		System.out.println(m.replaceAll("JAVA"));
		
		
		
		
		//分组 小括号分组
		Pattern p = Pattern.compile("(\\d{3,5})[a-z]{2}");
		String s = "123aa-23234bb-3445-00";
		Matcher m = p.matcher(s);
//		System.out.println(m.lookingAt());
		while(m.find()){
			System.out.println(m.group());
		}
//		
//		String str = "./out/target/product/msm8660_surf/obj/SHARED_LIBRARIES/libchromium_net_intermediates/webkit";
		String str = 
			"./cts/tests/tests/webkit"
			;
//		System.out.println(str.matches(".*[^e]+"));
//		System.out.println(str.matches("\\./[^o].+"));
//		System.out.println("./out".matches("\\./.*"));
		
//		String re = "\\./[^o].*/([^t]).*/.*";
//						//"\./[^o].*/[^t].*/"
//
//		System.out.println(str.matches(re));
//									  //^\./[^o].*/[^t].*
//		Pattern p = Pattern.compile(re);
//		Matcher m = p.matcher(str);
//		System.out.println(m.lookingAt());
//		while(m.find()){
//			System.out.println(m.group(1));
//		}


		System.out.println("手机号====");
		String phone="17080151610";
		System.out.println(phone.matches("^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8]))\\d{8}$"));


	}

	@Test
	public void testGetHTTPCode() {

		System.out.println("200".matches("\\d{3}"));

		String str = "[HTTP/1.1 200 OK]";
		Pattern pattern = Pattern.compile(".+HTTP/.+(\\d{3}).+");
		Matcher result = pattern.matcher(str);
		if(result.matches()){
			System.out.println("ok " +  result.group(1));

		}else {
			System.out.println("not matches");
		}
	}
}
