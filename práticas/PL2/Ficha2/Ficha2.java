import java.time.LocalDate;

/**
 * Ficha2
 */
public class Ficha2 {

    // Exercício 1.a)
    public int min(int[] a) {
        int n = a.length;
        if (n == 0)
            return -1;

        int m = a[0];
        for (int i = 1; i < n; i++)
            if (m > a[i])
                m = a[i];
        return m;
    }

    // Exercício 1.b)
    public int[] range(int[] v, int a, int b) {
        final int n = b - a + 1;
        int r[] = new int[n];

        for (int i = 0; i < n; i++)
            r[i] = v[a + i];

        return r;
    }

    // Exercício 1.c) Alternative CopyOfRange or arraycopy
    public int[] commum(int[] a, int[] b) {
        int[] r = new int[a.length > b.length ? a.length : b.length];
        int ri = 0;

        // complexity: N*N (sort one array to achieve N*log(N))
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j])
                r[ri++] = a[i];
            }
        }

        // trim array
        int[] result = new int[ri];
        System.arraycopy(r, 0, result, 0, ri);

        return result;
    }

    // Exercício 2 (LocalDate)

    // Exercício 3
    private void swap(int[] v, int a, int b) {
        int tmp = v[a];
        v[a] = v[b];
        v[b] = tmp;
    }

    // Exercício 3.a)
    public int[] sort(int[] a) {
        int n = a.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j])
                    swap(a, i, j);
            }
        }

        return a;
    }

    // Exercício 3.b) TODO: procura binário de um elemento do array

    // Exercício 4.a)
    public String[] uniqStrings(String[] a) {
        int n = a.length;
        String[] r = new String[n];
        int ri = 0;

        for (int i = 0; i < n; i++) {
            boolean isDuplicate = false;
            for (int j = i + 1; j < n; j++) {
                if (a[i].equals(a[j]))
                    isDuplicate = true;
            }
            if (!isDuplicate)
                r[ri++] = a[i];
        }

        return r;
    }

    // Exercício 4.b)
    public String getBiggestString(String[] a) {
        int n = a.length;
        if (n == 0) return "";
        String r = a[0];
        int max_l = r.length();
        for (int i = 1; i < n; i++) {
            int cur_l = a[i].length();
            if (cur_l > max_l) {
                r = a[i];
                max_l = cur_l;
            }
        }
        return r;
    }

    // Exercício 4.c)
    public String[] dupStrings(String[] a) {
        int n = a.length;
        String[] r = new String[n];
        int ri = 0;

        for (int i = 0; i < n; i++) {
            boolean isDuplicate = false;
            for (int j = i + 1; j < n; j++) {
                if (a[i].equals(a[j]))
                    isDuplicate = true;
            }
            if (isDuplicate)
                r[ri++] = a[i];
        }

        return r;
    }

    // Exercício 4.d)
    public int countString(String a[], String x) {
        int c = 0;

        int n = a.length;
        if (n == 0)
            return c;

        for (int i = 0; i < n; i++)
            if (a[i].equals(x))
                c++;

        return c;
    }

    // Exercício 5
    // private int[][] notasTurma; // int[5][5]
}
