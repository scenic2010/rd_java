package com.example;

/**
 * Created by scenic on 15/9/10.
 */
public interface interfaceBase64 {



/**
 *根据传进来的字符的字节码，查询base64码表的索引，并返回所查到的索引
 *
 *@paramb一个编码后的字节码
 *@return返回base64码表的索引
 */
        public abstract byte baseIndex(byte b);
/**
 *解码的方法
 *传进来的是编码后的base64字符的字节码
 *解析时是4个一组进行解析
 *@paramb编码后的字符的字节码数组
 *@return返回原来的字符串
 */
        public abstract String backEncode(byte[]b);
/**
 *解码
 *将4个字节码中的第1个的后6位（00xxxxxx）和第2个
 *字节的前4位的后2位（00yy0000）
 *还原为原来的字节码（xxxxxxyy）
 *
 *@paramfirst4个字节码中的第1个
 *@paramsecond4个字节码中的第2个
 *@return原来的字符的字节码
 */public abstract byte backFirst(byte  first,byte  second);
/**
 *解码
 *将4个字节码中的第2个的后4位（0000xxxx）和第3个
 *字节的前6位的后4位（00yyyy00）
 *还原为原来的字节码（xxxxyyyy）
 *@paramsecond4个字节码中的第2个
 *@paramthird4个字节码中的第3个
 *@return原来的字符的字节码
 */
        public abstract byte  backSecond(byte  second,byte  third);
/**
 *解码
 *将4个字节码中的第3个的后2位（000000xx）和第4个
 *字节的后6位（00yyyyyy）
 *还原为原来的字节码（xxyyyyyy）
 *@paramthird传进来的第3个字符
 *@paramfourth传进来的第4个字符
 *@return原来的字符的字节码
 */public abstract byte  backThird(byte  third,byte  fourth);
/**
 *解码
 *将编码后的字符串数组的最后2个字节码还原为原来的字节码
 *假如数组末尾剩下2个字节：
 *将倒数第2个字节的前后6位(00xxxxxx)
 *和倒数第一个字节的后2位(000000yy)
 *还原为原来的编码（xxxxxxyy）
 *假如数组末尾剩下3个字节：
 *将倒数第2个字节的前后4位(0000xxxx)
 *和倒数第一个字节的后4位(0000yyyy)
 *还原为原来的编码（xxxxyyyy）
 *@paramlast_b倒数第2个字节
 *@paramnext_b倒数第1个字节
 *@parammove_l倒数第2个字节移动位数的参数
 *@parammove_b倒数第1个字节移动位数的参数
 *@return原来的字符的字节码
 */
        public byte  backLastOne(byte  last_b,byte  next_b,int move_l,int move_b);
/**
 *编码
 *将传进来的字符编码为base64，返回一个base64的字符串
 *编码时3个字节一组进行编码，传进来的是要进行编码的字符串数组
 *@paramb要进行编码的字符串数组
 *@return编码后的字符串
 */
        public abstract String encode(byte[]b);
/**
 *假如字符长度%3！=0，使用此方法编码末尾字符
 *假如b=xxxxyyyy
 *假如末尾字节个数等于1：
 *将这个字节的前6位作为一个字节(00xxxxyy)
 *将这个字节的后6位作为一个字节(00xxyyyy)
 *假如末尾字节个数等于2：
 *将这个字节的后6位作为一个字节(00xxyyyy)
 *@paramb末尾的字符的字节码
 *@parammove末尾的字符的字节码要移动的位数的参数
 *@return编码后的字节码
 */
        public abstract byte  lastOneByte(byte  b,int move);
/**
 *编码
 *假如b=xxxxyyyy
 *将第1个字节的前6位编码为base64
 *将3个字节中的第1个子节码转为（00xxxxyy）
 *@paramb3个字节中的第1个字节
 *@return编码后的字节码
 */
        public abstract byte  firstByte(byte  b);
/**
 *编码
 *假如last_b=xxxxyyyynext_b=kkkkffff
 *将3个字节中的第1个字节的最后2位（000000yy）
 *和第2个字节的前4位（kkkk0000）编码为（00yykkkk）
 *
 *@paramlast_b3个字节中的第1个字节
 *@paramnext_b3个字节中的第2个字节
 *@return编码后的字节码
 */
        public abstract byte  secondByte(byte  last_b,byte  next_b);
/**
 *编码
 *假如last_b=xxxxyyyynext_b=kkkkffff
 *将3个字节中的第2个字节的最后4位（0000yyyy）
 *和第4个字节的前2位（kk000000）编码为（00yyyykk）
 *
 *
 *@paramlast_b3个字节中的第2个字节
 *@paramnext_b3个字节中的第3个字节
 *@return编码后的字节码
 */
        public abstract byte  thirdByte(byte  last_b,byte  next_b);
/**
 *编码
 *假如b=xxxxyyyy
 *将3个字节中的第3个字节的最后6位（00xxyyyy）
 *转码为（00xxyyyy）
 *@paramb3个字节中的第3个字节
 *@return编码后的字节码
 */
        public abstract byte  fourthByte(byte  b);


}
