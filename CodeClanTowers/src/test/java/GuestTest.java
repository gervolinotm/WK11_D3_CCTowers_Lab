import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {

    Guest guest;

    @Before
    public void before(){
        guest = new Guest("Pepe");
    }

    @Test
    public void guestHasName(){
        assertEquals("Pepe", guest.getName());
    }
}
