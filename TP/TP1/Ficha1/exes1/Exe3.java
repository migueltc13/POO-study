import java.util.Scanner;

/** Exe3
*
* Escrever um programa que aceite n classificações (números reais) de uma UC, e indique o
* número de classificações em cada um dos intervalos: [0, 5[, [5, 10[, [10, 15[ e [15, 20].
*
*/
public class Exe3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        System.out.print("Quantas classificações? ");
        n = sc.nextInt();

        double[] classificacoes = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Classificação " + (i+1) + ": ");
            double c = sc.nextDouble();
            if (c < 0 || c > 20) {
                System.out.println("Classificação inválida");
                i--;
                continue;
            }
            classificacoes[i] = c;
        }

        int[] intervalos = new int[4];
        int r, index;
        for (int i = 0; i < n; i++) {
            r = (int) classificacoes[i] / 5;
            index = r == 4 ? 3 : r;
            intervalos[index]++;
        }

        System.out.println("Intervalo [ 0,  5[: " + intervalos[0]);
        System.out.println("Intervalo [ 5, 10[: " + intervalos[1]);
        System.out.println("Intervalo [10, 15[: " + intervalos[2]);
        System.out.println("Intervalo [15, 20]: " + intervalos[3]);

        sc.close();
    }
}
