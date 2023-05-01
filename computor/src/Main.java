import java.io.BufferedReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static double x1, x2, a, b, c, d, degree;

    public static void main(String[] args) throws WrongArgumentException {
        if (args.length != 1) {
            throw new WrongArgumentException();
        }
//        "5 * X^0 + 4 * X^1 - 9.3 * X^2 = 1 * X^0"
//        ax2 + bx + c = 0
//        System.out.println("Hello world!");
        pars(args[0].split(" "));
//        Reduced form: 5 + 4 * X = 0
//        Polynomial degree: 1

        System.out.println("a = " + a + " b = " + b + " c = " + c + " d = " + d);
        d = Math.pow(b, 2) - 4 * a * c;
        System.out.println(" d = " + d);
        if (d > 0) {
            x1 = (-b + Math.sqrt(d)) / (2 * a);
            x2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println(x2);
            System.out.printf("x1 = %.4f, x2 = %.4f%n", x1, x2);
        }


//        (\+|\-)?\s*\d+\.?\d*  Числа со знаком
        String text = "Егор Ал ла Александр";
        Pattern pattern = Pattern.compile("А.+а");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }

    }


    private static boolean checkIP(String input) {
        return input.matches("((0|1\\d{0,2}|2([0-4][0-9]|5[0-5]))\\.){3}(0|1\\d{0,2}|2([0-4][0-9]|5[0-5]))");
    }


    public static Pattern compile (String literal, int flags) {

        return null;
    }




    static void pars(String[] mas) {
        int l = mas.length;
        System.out.println(l);
        int i = 0;
        do {
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

    }
}