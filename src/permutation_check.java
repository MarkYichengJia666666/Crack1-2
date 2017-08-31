/**
 * Created by jiayicheng on 17/6/13.
 */
public class permutation_check {

    //目的：给两个字符串，判断其中一个是否为另一个的置换（换顺序以后相等）
    //解读：即为判断两个字符串里面的东西相等与否
    //注意：想问题要全面，大小写，空格是否要在考虑范围内。
    //一般方法：将字符串重新排列，比较是否相同。TC：N＊LOGN，SC：N
    public static void main(String[] args) {
        String str1 = "12345";
        String str2 = "12345";
        if (permutation1(str1, str2) == false)
            System.out.print("false");
        else
            System.out.print("true");
        return;
    }


    static boolean permutation(String str1, String str2) {
     if(sort(str1).equals(str2))     //字符串可以直接比大小
         return true;
        else
            return false;
    }
    static String sort(String str) {
        char[] content1 = str.toCharArray();
        java.util.Arrays.sort(content1);     //可以直接调用排序函数
        String str1=new String(content1);    //转化
        return str1;
    }


    static boolean permutation1(String str1, String str2)
    {
        if(str1.length()!=str2.length())
            return false;
        int[] letters = new int[128];
        for (int i=0;i<str1.length();i++)
        {
            letters[str1.charAt(i)]++;
        }
        for (int i=0;i<str2.length();i++)      //创建一个跟ASCII码对照的数组，每遇到一个字母加一次
        {
            letters[str2.charAt(i)]--;         //再用另一个字符串，每遇到一个字母就减一，并同时判断数组内是否会出现负数
            if(letters[str2.charAt(i)]<0)      //TC：N   SC：常数
            {      return false;
            }
        }
               return true;
    }


}