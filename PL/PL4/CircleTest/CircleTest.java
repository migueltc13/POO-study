import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CircleTest {
    @Test
    @DisplayName("Testa alteração do centro do círculo")
    public void testAlteraCentro() {
        Point point = new Point(1, 1);
        Circle circle = new Circle(point, 1);
        circle.setPoint(new Point(2, 2));
        assertEquals("x: 2 y: 2 radius: 1", circle.toString());
    }

    @Test
    public void testCalculaArea() {

    }

    @Test
    public void testCalculaPerimetro() {

    }

    @Test
    public void testClone() {

    }

    @Test
    public void testEquals() {

    }

    @Test
    public void testGetPoint() {

    }

    @Test
    public void testGetRadius() {

    }

    @Test
    public void testMain() {

    }

    @Test
    public void testSetPoint() {

    }

    @Test
    public void testSetRadius() {

    }

    @Test
    public void testToString() {

    }

    public static void main(String[] args) {
        
    }
}
