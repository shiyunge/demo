import java.math.BigDecimal;

/**
 * @Author syg
 * @Date ${Date}
 * @Description **
 */
public class aa {


    public  static void main(String[]args){
        double f = 111231.5485;
        BigDecimal b = new BigDecimal(f);
        double f1 = b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.print(f1);
    }
}
