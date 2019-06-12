import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookingTest {

    Bedroom bedroom1;
    Bedroom bedroom2;
    Booking booking1;

    @Before
    public void before(){
        bedroom1 = new Bedroom(22, "single", 20);
        bedroom2 = new Bedroom(0, "double", 30);
        booking1 = new Booking(bedroom1, 3);
    }

    @Test
    public void bookingHasBedroom(){
        assertEquals(bedroom1, booking1.getBedroom());
    }

    @Test
    public void bookingHasNumberOfNights(){
        assertEquals(3, booking1.getNumberOfNights());
    }


}
