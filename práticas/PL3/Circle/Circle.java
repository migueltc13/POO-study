// Exercise 1
public class Circle {

    private double x;
    private double y;
    private double radius;

    /* Constructures */
    public Circle() {
        this.x = 0;
        this.y = 0;
        this.radius = 1;
    }

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle(Circle circle) {
        this.x = circle.getX();
        this.y = circle.getY();
        this.radius = circle.getRadius();
    }

    /* instance methods */
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // clone method
    public Circle clone() {
        return new Circle(this);
    }

    // toString method
    public String toString() {
        return "x: " + this.getX() + " y: " + this.getY() + " radius: " + this.getRadius();
    }

    // equals method
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Circle c = (Circle) o;
        return this.getX() == c.getX()
            && this.getY() == c.getY()
            && this.getRadius() == c.getRadius();
    }

    // (e)
    public void alteraCentro(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // (f)
    public double calculaArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    // (g)
    public double calculaPerimetro() {
        return 2 * Math.PI * this.radius;
    }

    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle(2, 3, 4);
        Circle c3 = new Circle(c2);

        System.out.println("c1: " + c1.getX() + " " + c1.getY() + " " + c1.getRadius());
        System.out.println("c2: " + c2.getX() + " " + c2.getY() + " " + c2.getRadius());
        System.out.println("c3: " + c3.getX() + " " + c3.getY() + " " + c3.getRadius());

        c1.alteraCentro(5, 6);
        System.out.println("c1: " + c1.getX() + " " + c1.getY() + " " + c1.getRadius());

        System.out.println("Area c1: " + c1.calculaArea());
        System.out.println("Perimetro c1: " + c1.calculaPerimetro());
    }
}
