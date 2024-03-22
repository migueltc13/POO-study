import java.util.Scanner;

/** Exe4
*
* Escrever um programa que aceite n temperaturas inteiras (pelo menos duas) e determine
* a média das temperaturas, o dia (2,3, ...) em que se registou a maior variação em valor
* absoluto relativamente ao dia anterior e qual o valor efectivo (positivo ou negativo) dessa
* variação. Os resultados devem ser apresentados sob a forma:
*
* A média das _n_ temperaturas foi de ____ graus.
* A maior variação registou-se entre os dias __ e __, tendo a temperatura subido/descido(*4) ___
* graus.
*
* (*4) - Utilizar a expressão apropriada.
*/
public class Exe4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;
        System.out.print("Quantas temperaturas? ");
        n = sc.nextInt();

        if (n < 2) {
            System.out.println("Tem de inserir pelo menos duas temperaturas");
            sc.close();
            return;
        }

        int[] temperaturas = new int[n];

        System.out.print("Temperatura 1: ");
        temperaturas[0] = sc.nextInt();
        int sum = temperaturas[0];
        int min = temperaturas[0], min_index = 0;
        int max = temperaturas[0], max_index = 0;

        for (int i = 1; i < n; i++) {
            System.out.print("Temperatura " + (i+1) + ": ");
            temperaturas[i] = sc.nextInt();
            sum += temperaturas[i];
            if (temperaturas[i] < min) {
                min = temperaturas[i];
                min_index = i;
            }
            if (temperaturas[i] > max) {
                max = temperaturas[i];
                max_index = i;
            }
        }

        System.out.println("A média das " + n + " temperaturas foi de " + (sum / n) + " graus.");

        String expression;
        int first_day, second_day;
        if (min_index < max_index) {
            expression = "subido";
            first_day = min_index;
            second_day = max_index;
        } else {
            expression = "descido";
            first_day = max_index;
            second_day = min_index;
        }
        first_day++; second_day++;

        System.out.println("A maior variação registou-se entre os dias " +
            first_day + " e " + second_day +
            ", tendo a temperatura " + expression + " " + Math.abs(max - min) + " graus.");

        sc.close();
    }
}
