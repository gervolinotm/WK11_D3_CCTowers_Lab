import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    ConferenceRoom conferenceRoom;
    Guest keyNoteSpeaker;

    @Before
    public void before(){
        conferenceRoom = new ConferenceRoom(10, "Poggers: How to Meme Hard");
        keyNoteSpeaker = new Guest("Pepe");
    }

    @Test
    public void hasCapacity(){
        assertEquals(10, conferenceRoom.getCapacity());
    }

    @Test
    public void conferenceRoomStartsEmpty(){
        assertEquals(0, conferenceRoom.guestCount());
    }

    @Test
    public void conferenceRoomHasName(){
        assertEquals("Poggers: How to Meme Hard", conferenceRoom.getName());
    }

    @Test
    public void canAddGuestsToConferenceRoom(){
        conferenceRoom.addGuest(keyNoteSpeaker);
        assertEquals(1, conferenceRoom.guestCount());
    }
}
