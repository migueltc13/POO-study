import java.util.Scanner;
import java.time.LocalDateTime;

/** Exe7
 *
 * Escrever um programa que leia o ano, mês e dia de nascimento de uma pessoa e calcule
 * a sua idade actual em horas, assim como a data e hora em que esse cálculo foi efectuado.
 */
public class Exe7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Insira a data de nascimento (dia mês ano): ");
        int dia = sc.nextInt();
        int mes = sc.nextInt();
        int ano = sc.nextInt();

        int curMes  = LocalDateTime.now().getMonthValue();
        int curDia  = LocalDateTime.now().getDayOfMonth();
        int curAno  = LocalDateTime.now().getYear();
        int curHora = LocalDateTime.now().getHour();

        int idade =
            (curAno - ano) * 365 * 24 +
            (curMes - mes) * 30 * 24 +
            (curDia - dia) * 24 +
            curHora;

        System.out.println("Idade: " + idade + " horas");
        System.out.println("Data e hora do calculo (dd/mm/yyyy HH): " +
            curDia + "/" + curMes + "/" + curAno + " " + curHora);

        sc.close();
    }
}
