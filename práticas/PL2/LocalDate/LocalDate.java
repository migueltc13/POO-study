import java.util.Date;

// Exercício 2
public class LocalDate {

    private int CAP_DATES = 10;
    private int CUR_DATES = 0;
    private LocalDate dates[];

    public LocalDate() {
        this.dates = new LocalDate[CAP_DATES];
    }

    public LocalDate(int cap) {
        this.CAP_DATES = cap;
        this.dates = new LocalDate[CAP_DATES];
    }

    public LocalDate(LocalDate[] d, int n) {
        this.CAP_DATES = n;
        this.CUR_DATES = d.length;
        this.dates = new LocalDate[CAP_DATES];

        for (int i = 0; i < CUR_DATES; i++)
            this.dates[i] = d[i];
    }

    public LocalDate(LocalDate d) {
        this.CAP_DATES = d.CAP_DATES;
        this.CUR_DATES = d.CUR_DATES;
        this.dates = new LocalDate[CAP_DATES];

        for (int i = 0; i < CUR_DATES; i++)
            this.dates[i] = d.dates[i];
    }

    private int compareTo(LocalDate d) {
        return this.CUR_DATES - d.CUR_DATES;
    }

    // Exercício 2.a)
    public void insereData(LocalDate data) {
        if (CUR_DATES >= CAP_DATES)
            System.out.println("insereData error dates array is full");

        this.dates[CUR_DATES++] = data;
    }

    // Exercício 2.b)
    public LocalDate dataMaisProxima(LocalDate data) {
        if (dates.length == 0)
            System.out.println("dataMaisProxima error array is empty");

        LocalDate r = this.dates[0];
        int min = Math.abs(data.compareTo(dates[0]));

        for (int i = 0; i < dates.length; i++) {
            int diff = Math.abs(data.compareTo(dates[i]));
            if (diff < min) {
                min = diff;
                r = dates[i];
            }
        }

        return r;
    }

    // Exercício 2.c)
    public String toString() {
        String r = new String();

        for (int i = 0; i < dates.length; i++)
            r += dates[i].toString();

        return r;
    }

    public static void main(String[] args) {
        
    }
}
