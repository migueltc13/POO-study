// Exercise 5
import java.time.LocalDateTime;
import java.time.Duration;

public class Lamp {

    private int status;
    private double totalConsumption;
    private double lastConsumption;
    private LocalDateTime datetime;

    // status codes
    private static final int OFF = 0;
    private static final int ON  = 1;
    private static final int ECO = 2;

    // watts per millisecond
    private static final int CONSUMPTION_OFF = 0;
    private static final int CONSUMPTION_ON  = 100;
    private static final int CONSUMPTION_ECO = 50;

    /* Constructures */
    public Lamp() {
        this.status = 0;
        this.totalConsumption = 0;
        this.lastConsumption = 0;
        this.datetime = LocalDateTime.now();
    }

    public Lamp(int status, double totalConsumption, double lastConsumption, LocalDateTime datetime) {
        this.status = status;
        this.totalConsumption = totalConsumption;
        this.lastConsumption = lastConsumption;
        this.datetime = datetime;
    }

    public Lamp(Lamp lamp) {
        this.status = lamp.getStatus();
        this.totalConsumption = lamp.getTotalConsumption();
        this.lastConsumption = lamp.getLastConsumption();
        this.datetime = lamp.getDateTime();
    }

    public Lamp clone() {
        return new Lamp(this);
    }

    /* instance methods */
    public int getStatus() {
        return this.status;
    }

    public double getTotalConsumption() {
        return this.totalConsumption;
    }

    public double getLastConsumption() {
        return this.lastConsumption;
    }

    public LocalDateTime getDateTime() {
        return this.datetime;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTotalConsumption(double consumption) {
        this.totalConsumption = consumption;
    }

    public void setLastConsumption(double consumption) {
        this.lastConsumption = consumption;
    }

    public void setDateTime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public void updateStatus() {
        // get the last status
        int lastStatus = this.getStatus();

        // Calculate the time difference
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(this.datetime, now);
        long timeDiff = duration.toMillis();

        // calculate the latest consumption
        double consumption = 0;
        switch (lastStatus) {
            case OFF:
                consumption = timeDiff * CONSUMPTION_OFF;
                break;
            case ON:
                consumption = timeDiff * CONSUMPTION_ON;
                break;
            case ECO:
                consumption = timeDiff * CONSUMPTION_ECO;
                break;
            default:
                System.err.println("Error: invalid status");
                break;
        }

        // update the total consumption
        this.setTotalConsumption(this.getTotalConsumption() + consumption);
        this.setLastConsumption(consumption);

        // update the datetime
        this.setDateTime(now);
    }

    public void lampON() {
        this.updateStatus();
        this.setStatus(ON);
    }

    public void lampOFF() {
        this.updateStatus();
        this.setStatus(OFF);
    }

    public void lampECO() {
        this.updateStatus();
        this.setStatus(ECO);
    }

    // (d) devolver a informação de quanto se gastou desde a criação da lâmpada
    public double totalConsumo() {
        return this.getTotalConsumption();
    }

    // (e) devolver a informação de quanto se gastou desde o último reset de consumo
    public double lastConsumo() {
        return this.getLastConsumption();
    }

    public static void main(String[] args) {
        
        Lamp lamp = new Lamp();
        lamp.lampON();
        // Sleep for 250 milliseconds
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lamp.lampOFF();
        System.out.println("Total consumption: " + lamp.totalConsumo());
        System.out.println("Last consumption: " + lamp.lastConsumo());

        lamp.lampECO();
        // Sleep for 250 milliseconds
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lamp.lampOFF();
        System.out.println("Total consumption: " + lamp.totalConsumo());
        System.out.println("Last consumption: " + lamp.lastConsumo());
    }
}
