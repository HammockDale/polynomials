import java.io.BufferedReader;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {



    static double[] rezult = new double[1000];


    static void print(double x) {
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        String secondResult = decimalFormat.format(x);
        System.out.print((secondResult));
    }

    static void parsMas(String str, int flag) {
        int ind = 0;
        String[] mas_dig = str.split("\\*");
        if (mas_dig.length == 1) {
            ind = 0;
        } else if (mas_dig.length == 2) {
            String[] mas_x = mas_dig[1].split("\\^");
            if (mas_x[0].equals("X")) {
                if (mas_x.length == 1) {
                    ind = 1;
                } else if (mas_x.length == 2) {
                    ind = Integer.parseInt(mas_x[1]) * flag;
                } else {
                    new WrongArgumentException();
                }
            }
            else {
                new WrongArgumentException();
            }
        } else {
            new WrongArgumentException();
        }
        double num = Double.parseDouble(mas_dig[0]);
        rezult[ind] = num;
    }


    public static void main(String[] args) throws WrongArgumentException {
        int degree = 0;

        if (args.length != 1) {
            throw new WrongArgumentException();
        }
//        "5 * X^0 + 4 * X^1 - 9.3 * X^2 = 1 * X^0"
//        ax2 + bx + c = 0

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
            parsMas(until.substring(matcher.start(), matcher.end()), 1);
        }

        matcher = pattern.matcher(past);
        while (matcher.find()) {
            System.out.println(past.substring(matcher.start(), matcher.end()));
            parsMas(past.substring(matcher.start(), matcher.end()), (-1));
        }

        double x1, x2, a, b, c;
        a = rezult[0];
        b = rezult[1];
        c = rezult[2];

        System.out.print("Reduced form: ");
        boolean flag = false;
        for (int i = 0; i < 1000; i++) {
            if (rezult[i] != 0) {
                if (flag) {
                    if (rezult[i] >= 0 ) {
                        System.out.print(" + ");
                    }
                    else {
                        System.out.print(" - ");
                        rezult[i] *= -1;
                    }
                }
                flag = true;
                degree = i;
                print(rezult[i]);
                System.out.print("*X^" + i);
            }
        }
        System.out.println(" = 0");

        System.out.println("Polynomial degree: " + degree);
        if (degree > 2) {
            System.out.println("The polynomial degree is strictly greater than 2, I can't solve.");
        } else if (degree == 2) {

            run(a, b, c);
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


    static void run(double a, double b, double c) {

        //        args[0].find(reg);
//        pars(args[0].split(reg));
//        Reduced form: 5 + 4 * X = 0
//        Polynomial degree: 1

        double d;
        double x1, x2;


        d = Math.pow(b, 2) - 4 * a * c;
//        System.out.println("a = " + a + " b = " + b + " c = " + c + " d = " + d);
        System.out.println("Discriminant: " + d);
        if (Math.abs(d) < 0.0001) {
            System.out.println("Discriminant is zero, the one solutions is:");
            x1 = - b / (2 * a);
            print(x1);
            System.out.println();
//            System.out.printf("%.4f\n", x1);
        }
        else if (d > 0) {
            System.out.println("Discriminant is strictly positive, the two solutions are:");
            x1 = (-b + Math.sqrt(d)) / (2 * a);
            x2 = (-b - Math.sqrt(d)) / (2 * a);
            print(x1);
            System.out.println();
            print(x2);
            System.out.println();
//            System.out.printf("%.4f\n", x1);
//            System.out.printf("%.4f\n", x2);
        } else {
            System.out.println("Discriminant is strictly negative and has no solutions.");

        }


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
