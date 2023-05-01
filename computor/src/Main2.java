import java.io.BufferedReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {

    static double x1, x2, a, b, c, d, degree;

    public static void main(String[] args) throws WrongArgumentException {
        if (args.length != 1) {
            throw new WrongArgumentException();
        }
//        "5 * X^0 + 4 * X^1 - 9.3 * X^2 = 1 * X^0"
//        ax2 + bx + c = 0
//        System.out.println("Hello world!");

//        String text = "Егор Алла Александр";
        String until, past;
        until = args[0].replaceAll(" ", "");
        String[] mas = until.split("=");
        until = mas[0];
        past = mas[1];

        String reg = "(\\+|\\-)?\\d+\\.?\\d*(\\*X(\\^\\d)?)?";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(until);
        while (matcher.find()) {
            System.out.println(until.substring(matcher.start(), matcher.end()));
        }
//        args[0].find(reg);
//        pars(args[0].split(reg));
/*//        Reduced form: 5 + 4 * X = 0
//        Polynomial degree: 1

        System.out.println("a = " + a + " b = " + b + " c = " + c + " d = " + d);
        d = Math.pow(b, 2) - 4 * a * c;
        System.out.println(" d = " + d);
        if (d > 0) {
            x1 = (-b + Math.sqrt(d)) / (2 * a);
            x2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println(x2);
            System.out.printf("x1 = %.4f, x2 = %.4f%n", x1, x2);
        }*/


//        (\+|\-)?\s*\d+\.?\d*  Числа со знаком
//        (\+|\-)?\s*\d+\.?\d*\s*(\*\s*X(\^\d)?)?      - 9009.9* X^7  Числа со знаком и Х в степени

    }


    static void pars(String[] mas) {
        int l = mas.length;
        System.out.println(l);
        int i = 0;
        for (String m : mas) {
            System.out.println(m);
        }
       /* do {
            if ("*".equals(mas[i + 1]) && (i==0 || ("+".equals(mas[i -1 ])))) {
                switch (mas[i + 2]) {
                    case "X^2": a += Double.parseDouble(mas[i]); break;
                    case "X^1": b += Double.parseDouble(mas[i]); break;
                    case "X^0": c += Double.parseDouble(mas[i]); break;
                }
                i += 4;
            }
            else if ("*".equals(mas[i + 1]) && ("-".equals(mas[i -1 ]))) {
                switch (mas[i + 2]) {
                    case "X^2": a -= Double.parseDouble(mas[i]); break;
                    case "X^1": b -= Double.parseDouble(mas[i]); break;
                    case "X^0": c -= Double.parseDouble(mas[i]); break;
                }
                i += 4;
            }
            else {


            }
        } while ("+".equals(mas[i -1 ]) || "-".equals(mas[i -1 ]));
        if ("=".equals(mas[i - 1])) {
            if (i == l - 1 && "0".equals(mas[i])) {
                return;
            } else {
                if ("*".equals(mas[i + 1])) {
                    switch (mas[i + 2]) {
                        case "X^2": a -= Double.parseDouble(mas[i]); break;
                        case "X^1": b -= Double.parseDouble(mas[i]); break;
                        case "X^0": c -= Double.parseDouble(mas[i]); break;
                    }
                    i += 4;


                }
            }

        }
*/
    }
}
