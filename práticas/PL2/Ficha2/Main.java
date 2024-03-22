import java.util.Scanner;

/**
 * Main class
 */
public class Main {
    private static int[] readIntArray(Scanner sc) {
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the element " + i + ": ");
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    private static void printIntArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Ficha2 f2 = new Ficha2();

        System.out.print("Enter the question number: ");
        int q = sc.nextInt();
        switch (q) {
            case 1:
                // Exercício 1.a)
                int[] v = readIntArray(sc);
                System.out.println("The minimum value is: " + f2.min(v));

                // Exercício 1.b)
                System.out.print("Enter the first index: ");
                int a = sc.nextInt();
                System.out.print("Enter the second index: ");
                int b = sc.nextInt();
                System.out.print("The array between " + a + " and " + b + " is: ");
                printIntArray(f2.range(v, a, b));

                // Exercício 1.c)
                int[] v1 = readIntArray(sc);
                printIntArray(v1);
                int[] v2 = readIntArray(sc);
                printIntArray(v2);
                System.out.print("The common elements between the two arrays are: ");
                printIntArray(f2.commum(v1, v2));
                break;

            default:
                System.out.println("Invalid question number");
                break;
        }
    }
}
