import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    Bedroom bedroom1;
    Bedroom bedroom2;
    Guest guest;

    @Before
    public void before(){
        bedroom1 = new Bedroom(21, "Double");
        bedroom2 = new Bedroom(43, "Single");
        guest = new Guest("Pepe");
    }

    @Test
    public void roomHasRoomNumber(){
        assertEquals(21, bedroom1.getRoomNumber());
    }

    @Test
    public void roomStartsEmpty(){
        assertEquals(true, bedroom1.isEmpty());
    }

    @Test
    public void canAddGuestToRoom(){
        bedroom1.addGuest(guest);
        bedroom1.addGuest(guest);
        assertEquals(2, bedroom1.guestCount());
    }

    @Test
    public void cannotAddGuestIfRoomAtCapacity(){
        bedroom1.addGuest(guest);
        bedroom1.addGuest(guest);
        bedroom1.addGuest(guest);
        bedroom1.addGuest(guest);
        assertEquals(3, bedroom1.guestCount());
    }

    @Test
    public void canEmptyGuestsFromRoom(){
        bedroom1.addGuest(guest);
        bedroom1.emptyRoom();
        assertEquals(0, bedroom1.guestCount());
    }

    @Test
    public void roomHasBedSize(){
        assertEquals("Single", bedroom2.getBedSize());
    }

}
