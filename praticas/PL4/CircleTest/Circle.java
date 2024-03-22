// Exercise 1
public class Circle {

    private Point point;
    private double radius;

    /* Constructures */
    public Circle() {
        this.point = new Point();
        this.radius = 1;
    }

    public Circle(Point point, double radius) {
        this.point = point;
        this.radius = radius;
    }

    public Circle(Circle circle) {
        this.point = circle.getPoint();
        this.radius = circle.getRadius();
    }

    /* instance methods */
    public Point getPoint() {
        return this.point;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setPoint(Point point) {
        this.point = point;
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
        return "x: " + this.point.getX() + " y: " + this.point.getY() + " radius: " + this.getRadius();
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
        return this.point.equals(c.getPoint())
            && this.getRadius() == c.getRadius();
    }

    // (e)
    public void alteraCentro(Point point) {
        this.point = point;
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
        Circle c2 = new Circle(new Point(3, 4), 5);
        Circle c3 = new Circle(c2);

        System.out.println("c1: " + c1.getPoint().getX() + " " + c1.getPoint().getY() + " " + c1.getRadius());
        System.out.println("c2: " + c2.getPoint().getX() + " " + c2.getPoint().getY() + " " + c2.getRadius());
        System.out.println("c3: " + c3.getPoint().getX() + " " + c3.getPoint().getY() + " " + c3.getRadius());

        Point centro = new Point(5, 6);
        c1.alteraCentro(centro);
        System.out.println("c1: " + c1.getPoint().getX() + " " + c1.getPoint().getY() + " " + c1.getRadius());

        System.out.println("Area c1: " + c1.calculaArea());
        System.out.println("Perimetro c1: " + c1.calculaPerimetro());
    }
}
