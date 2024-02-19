import java.util.Scanner;

/** Exe6
 *
 * Escrever um programa que leia um inteiro n e imprima todos os números primos inferiores
 * a n. Utilize um método auxiliar para determinar de um número é ou não primo.
 * No fim da execução o utilizador deverá ter a possibilidade de jogar novamente.
 */
public class Exe6 {

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Insira um número: ");
        int n = sc.nextInt();

        for (int i = 2; i < n; i++)
            if (isPrime(i)) System.out.println(i);

        System.out.print("Jogar novamente? (s/n) ");
        String playAgain = sc.next();
        if (playAgain.equals("s")) main(args);

        sc.close();
    }
}
