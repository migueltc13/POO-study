import java.util.Scanner;

/**
 * TestePrograma
 */
public class TestePrograma {
    public static void main(String[] args) {
        // Initialize scanner
        Scanner scanner = new Scanner(System.in);

        // Initialize Ficha1
        Ficha1 f = new Ficha1();

        // Initialize Ficha1.Exe2
        Ficha1.Exe2 e2 = f.new Exe2();

        // Exercicio 1
        System.out.println("Exercicio 1");
        System.out.print("Enter temperature in Celsius: ");
        double celsius = scanner.nextDouble();
        System.out.println("celsiusParaFarenheit(" + celsius + ")" + " = " + e2.celsiusParaFarenheit(celsius));

        // Exercicio 2
        System.out.println("Exercicio 2");
        System.out.print("Enter first integer: ");
        int a = scanner.nextInt();
        System.out.print("Enter second integer: ");
        int b = scanner.nextInt();
        System.out.println("max(" + a + ", " + b + ")" + " = " + e2.maximoNumeros(a, b));

        // Exercicio 3
        System.out.println("Exercicio 3");
        System.out.print("Enter a name: ");
        String name = scanner.next();
        System.out.print("Enter a saldo: ");
        double saldo = scanner.nextDouble();
        System.out.println("criaDescricaoConta(" + name + ", " + saldo + ")" + " = " + e2.criaDescricaoConta(name, saldo));

        // Exercicio 4
        System.out.println("Exercicio 4");
        System.out.print("Enter a value in euros: ");
        double euros = scanner.nextDouble();
        System.out.print("Enter a exchange rate: ");
        double exchangeRate = scanner.nextDouble();
        System.out.println("eurosParaLibras(" + euros + ", " + exchangeRate + ")" + " = " + e2.eurosParaLibras(euros, exchangeRate));

        // Exercicio 5
        System.out.println("Exercicio 5");
        System.out.print("Enter first integer: ");
        a = scanner.nextInt();
        System.out.print("Enter second integer: ");
        b = scanner.nextInt();
        System.out.println(a< b ? a + ", " + b : b + ", " + a);
        System.out.println("media: " + ((double) (a + b) / 2));

        // Exercicio 6
        System.out.println("Exercicio 6");
        System.out.print("Enter integer: ");
        a = scanner.nextInt();
        System.out.println("factorial(" + a + ")" + " = " + e2.factorial(a));

        // Exercicio 7
        System.out.println("Exercicio 7");
        System.out.println("factorial(5000) took " + e2.tempoGasto() + "ms");

        scanner.close();
    }
}
