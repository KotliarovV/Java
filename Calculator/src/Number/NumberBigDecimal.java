package Number;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Vitaly on 01.02.2017.
 */

 class NumberBigDecimal {

    BigDecimal Rp;
    BigDecimal Ip;

    private NumberBigDecimal(Number a) {
        this.Rp = new BigDecimal(Double.toString(a.realPart));
        this.Ip = new BigDecimal(Double.toString(a.imaginaryPart));
    }

    private NumberBigDecimal(BigDecimal a, BigDecimal b) {
        this.Rp = a;
        this.Ip = b;
    }

    private static NumberBigDecimal mult(NumberBigDecimal a, NumberBigDecimal b) {
        BigDecimal answRP = a.Rp.multiply(b.Rp).subtract( a.Ip.multiply(b.Ip));
        BigDecimal answIP = a.Rp.multiply(b.Ip).add(a.Ip.multiply(b.Rp));
        return new NumberBigDecimal(answRP, answIP);
    }

    static NumberBigDecimal mult(Number a, Number b) {
       return NumberBigDecimal.mult(new NumberBigDecimal(a),new NumberBigDecimal(b));
    }

    private static NumberBigDecimal sum (NumberBigDecimal a, NumberBigDecimal b) {
        return new NumberBigDecimal(a.Rp.add(b.Rp),a.Ip.add(b.Ip));
    }

    static NumberBigDecimal sum (Number a, Number b) {
        return NumberBigDecimal.sum(new NumberBigDecimal(a),new NumberBigDecimal(b));
    }

    private static NumberBigDecimal diff (NumberBigDecimal a, NumberBigDecimal b) {
        return new NumberBigDecimal(a.Rp.subtract(b.Rp),a.Ip.subtract(b.Ip));
    }

    static NumberBigDecimal diff (Number a, Number b){
        return NumberBigDecimal.diff(new NumberBigDecimal(a),new NumberBigDecimal(b));
    }

    private static NumberBigDecimal divide (NumberBigDecimal a, NumberBigDecimal b) {
        BigDecimal answRP1 = a.Rp.multiply(b.Rp).add(a.Ip.multiply(b.Ip));
        BigDecimal answRP2 = b.Rp.multiply(b.Rp).add(b.Ip.multiply(b.Ip));
        BigDecimal answRP = answRP1.divide(answRP2, 9 , RoundingMode.CEILING);
        BigDecimal answIP1 = b.Rp.multiply(a.Ip).subtract(a.Rp.multiply(b.Ip));
        BigDecimal answIP2 = b.Rp.multiply(b.Rp).add(b.Ip.multiply(b.Ip));
        BigDecimal answIP = answIP1.divide(answIP2, 9 , RoundingMode.CEILING);
        return new NumberBigDecimal(answRP, answIP);
    }

    static NumberBigDecimal divide (Number a, Number b) {
        return NumberBigDecimal.divide(new NumberBigDecimal(a), new NumberBigDecimal(b));
    }
}
