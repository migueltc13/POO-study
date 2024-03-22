import java.util.Scanner;

/** Exe2
 *
 * Escrever um programa que determine a soma de duas datas em dias, horas, minutos e
 * segundos, utilizando um método auxiliar para o efeito. O método deverá aceitar as duas
 * datas e devolver uma string no formato “ddD hhH mmM ssS”.
 */
public class Exe2 {

    private static String somaDatas(
        int d1, int h1, int m1, int s1,
        int d2, int h2, int m2, int s2) {

        int s = s1 + s2;
        int m = m1 + m2;
        int h = h1 + h2;
        int d = d1 + d2;

        if (s >= 60) {
            s -= 60;
            m++;
        }
        if (m >= 60) {
            m -= 60;
            h++;
        }
        if (h >= 24) {
            h -= 24;
            d++;
        }

        return d + "D " + h + "H " + m + "M " + s + "S";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Insira a primeira data (dd hh mm ss): ");
        int d1 = sc.nextInt();
        int h1 = sc.nextInt();
        int m1 = sc.nextInt();
        int s1 = sc.nextInt();

        System.out.print("Insira a segunda data (dd hh mm ss): ");
        int d2 = sc.nextInt();
        int h2 = sc.nextInt();
        int m2 = sc.nextInt();
        int s2 = sc.nextInt();

        String result = somaDatas(d1, h1, m1, s1, d2, h2, m2, s2);
        System.out.println(result);

        sc.close();
    }
}
