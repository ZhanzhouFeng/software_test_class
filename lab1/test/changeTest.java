import static org.junit.Assert.*;
import org.junit.*;

public class changeTest {
    change c;
    @Before
    public void setup(){
        c=new change();
    }

    @Test
    public void judege() {
        assertTrue(c.judege(50));
        assertTrue(c.judege(0));
        assertFalse(c.judege(-5));
        assertFalse(c.judege(100));
        assertFalse(c.judege(4));

    }
}