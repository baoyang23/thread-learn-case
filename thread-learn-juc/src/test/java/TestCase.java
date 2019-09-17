import java.util.Arrays;

/**
 * @Author: Mu_Yi
 * @Date: 2019/9/17 16:46
 * @Version 1.0
 * @qq: 1411091515
 */
public class TestCase {

    public static void main(String[] args) {

        char [] chars = {'1','1','1','1','1','1','1','1'};

        String s = new String(chars);
        System.out.println("s : " + s);
        int i1 = Integer.parseInt(s, 2);

        int parseInt = Integer.parseInt("1", 2);
        int i = Integer.parseInt("0", 2);

        System.out.println(parseInt);
        System.out.println(i);
        System.out.println(i1);

    }

}
