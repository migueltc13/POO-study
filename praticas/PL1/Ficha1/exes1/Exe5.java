import java.util.Scanner;

/** Exe5
 *
 * Escrever um programa que leia sucessivas vezes a base e altura de um triângulo retângulo
 * (valores reais) e calcule a área e o perímetro respectivos. Usar printf() para apresentar os
 * resultados com uma precisão de 5 casas decimais. O programa apenas deverá terminar com
 * a leitura de uma base = 0.0.
 */
public class Exe5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Insira a base: ");
            double base = sc.nextDouble();
            if (base <= 0) {
                System.out.println("Exit");
                sc.close();
                return;
            }

            System.out.print("Insira a altura: ");
            double altura = sc.nextDouble();
            if (altura <= 0) {
                System.out.println("Altura inválida");
                continue;
            }

            double area = (base * altura) / 2;
            double perimetro = base + altura + Math.sqrt(base * base + altura * altura);

            System.out.printf("A área do triângulo é %.5f\n", area);
            System.out.printf("O perímetro do triângulo é %.5f\n", perimetro);}
    }
}
