package com.logistics.manage.util;



import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**

 * @Create 2020-01-11 4:29
 */
public class HouseUtils {

    private static SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyyMMddhhmmss");

    /**
     * 验证集合是否有效
     * @param c		待验证集合
     * @return		验证结果（true：有效，false：无效）
     * @author 封捷
     */
    public static <E> boolean collectionEffectiveCheck(Collection<E> c) {
        return (c != null) && (c.size() > 0);
    }

    /**
     * 验证字符串是否有效
     * @param source	待验证字符串
     * @return			验证结果（true：有效，false：无效）
     * @author 封捷
     */
    public static boolean strEffectiveCheck(String source) {
        return (source != null) && (source.length() > 0);
    }


    public static String getSharingFileConnectedActicleId(){
        String dateString = dateTimeFormatter.format(new Date());
        return UUID.randomUUID().toString().replace("-", "").substring(0, 6) + dateString;
    }


    /**
     * 字符串转int集合
     * @return
     */
    public static List<Integer> strToIntList(String target){
        List<String> stringList = Arrays.asList(target.split(","));
        return stringList.stream().map(Integer::valueOf).collect(Collectors.toList());
    }


    /**
     * 获取20位数订单号
     * @return
     */
    public static String getOrderNumber(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "").substring(0, 20);
    }

    /**
     * 判断字符串是否为整数
     * @param str 传入的字符串
     * @return 是整数返回true,否则返回false
     */
    public static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    public static void main(String[] args) {
        System.out.println(getOrderNumber());
    }
}