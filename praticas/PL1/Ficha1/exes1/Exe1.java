import java.util.Scanner;

/**
 * Exe1
 * Dado um dia (1..31), mes (1..12) e ano (1900..2100), retorna o dia da semana.
 *
 * 1. Subraia 1900 do ano e multiplique por 365.
 * 2. Adicione (ano - 1900) / 4 (os anos bissextos).
 * 3. Se o ano for bissexto e o mês for janeiro ou fevereiro, subtraia 1.
 * 4. Adicione os dias já passados no corrente ano (considere 28 dias para Fevereiro)
 */
public class Exe1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int dia, mes, ano;
        System.out.print("Digite o dia: ");
        dia = sc.nextInt();
        System.out.print("Digite o mês: ");
        mes = sc.nextInt();
        System.out.print("Digite o ano: ");
        ano = sc.nextInt();

        // 1.
        int r = (ano - 1900) * 365;

        // 2.
        r += (ano - 1900) / 4;

        // 3.
        if (ano % 4 == 0 && mes <= 2)
            r--;

        // 4.
        for (int i = 1; i < mes; i++)
            r += getNDaysInMonth(i);
        r += dia;

        System.out.println("r: " + r);
        System.out.println("r % 7: " + (r % 7));
        System.out.print("Dia da semana: ");

        switch (r % 7) {
            case 0:
                System.out.println("Domingo");
                break;
            case 1:
                System.out.println("Segunda");
                break;
            case 2:
                System.out.println("Terça");
                break;
            case 3:
                System.out.println("Quarta");
                break;
            case 4:
                System.out.println("Quinta");
                break;
            case 5:
                System.out.println("Sexta");
                break;
            case 6:
                System.out.println("Sábado");
                break;
        }

        sc.close();
    }

    // Retorna o número de dias no mês (ignorando anos bissextos)
    private static int getNDaysInMonth(int mes) {
        if (mes == 2) return 28;
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) return 30;
        return 31;
    }
}
