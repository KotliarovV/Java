package Readers;
import Token.Token;
import Number.Number;
/**
 * Created by Vitaly on 29.01.2017.
 */

public class ConstReader implements Reader {

    public Token tryReadToken (String input) {
        if (input.startsWith("Pi"))
            return new Token(new Number(StrictMath.PI,0), "n", input.substring(0, 2));
        else return null;
    }
}
