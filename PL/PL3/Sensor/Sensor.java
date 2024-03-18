// Exercise 2
public class Sensor {

    private double p; // pressure

    public Sensor() {
        this.p = 0;
    }

    public Sensor(double p) {
        this.p = p;
    }

    public Sensor(Sensor sensor) {
        this.p = sensor.getP();
    }

    public double getP() {
        return this.p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public boolean setPressure(double p) {
        if (p < 0)
            return false;

        this.p = p;
        return true;
    }

    public static void main(String[] args) {
        Sensor s1 = new Sensor();
        Sensor s2 = new Sensor(10);
        Sensor s3 = new Sensor(s2);

        System.out.println(s1.getP());
        System.out.println(s2.getP());
        System.out.println(s3.getP());

        s1.setP(5);
        System.out.println(s1.getP());

        s2.setPressure(20);
        System.out.println(s2.getP());

        s3.setPressure(-5);
        System.out.println(s3.getP());
    }
}
