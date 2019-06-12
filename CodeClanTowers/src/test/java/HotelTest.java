import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HotelTest {

    Hotel hotel;
    Bedroom bedroom1;
    Bedroom bedroom2;
    ConferenceRoom conferenceRoom;
    ConferenceRoom conferenceRoom2;
    Guest guest1;
    Guest guest2;
    Booking booking;


    @Before
    public void before(){
        hotel = new Hotel("CodeClanTowers");
        bedroom1 = new Bedroom(23, "double", 30);
        bedroom2 = new Bedroom(4, "single", 20);
        conferenceRoom = new ConferenceRoom(7, "Poggers: How to Meme Hard");
        conferenceRoom2 = new ConferenceRoom(1, "The Ricardo Flick");
        guest1 = new Guest("Ricardo");
        guest2 = new Guest("Pepe");
        booking = new Booking(bedroom1, 3);
    }

    @Test
    public void hotelHasAName(){
        assertEquals("CodeClanTowers", hotel.getName());
    }

    @Test
    public void hotelStartsWithNoBedroom(){
        assertEquals(0, hotel.bedroomCount());
    }

    @Test
    public void hotelStartsWithNoConferenceRoom(){
        assertEquals(0, hotel.conferenceRoomCount());
    }

    @Test
    public void canAddBedRoomToHotel(){
        hotel.addBedroom(bedroom1);
        hotel.addBedroom(bedroom2);
        assertEquals(2, hotel.bedroomCount());
    }

    @Test
    public void canAddConferenceRoomToHotel(){
        hotel.addConferenceRoom(conferenceRoom);
        assertEquals(1, hotel.conferenceRoomCount());
    }

    @Test
    public void canCheckInGuestToBedroom(){
        hotel.bedroomCheckIn(guest1, bedroom1);
        assertEquals(1, bedroom1.guestCount());
    }

    @Test
    public void isRoomAvailableForCheckIn(){
        hotel.bedroomCheckIn(guest1, bedroom1);
        hotel.bedroomCheckIn(guest2, bedroom1);
        assertEquals(1,bedroom1.guestCount());
    }

    @Test
    public void canCheckInGuestConferenceRoom(){
        hotel.conferenceRoomCheckIn(guest1, conferenceRoom);
        hotel.conferenceRoomCheckIn(guest2, conferenceRoom);
        assertEquals(2, conferenceRoom.guestCount());
    }

    @Test
    public void cannotCheckInGuestToConferenceAtFullCapacity(){
        hotel.conferenceRoomCheckIn(guest1, conferenceRoom2);
        hotel.conferenceRoomCheckIn(guest2, conferenceRoom2);
        assertEquals(1, conferenceRoom2.guestCount());
    }

    @Test
    public void canCheckOutGuestsFromBedroom(){
        hotel.bedroomCheckIn(guest1, bedroom1);
        hotel.checkOut(bedroom1);
        assertEquals(0, bedroom1.guestCount());
    }

    @Test
    public void canCheckOutGuestsFromConferenceRoom(){
        hotel.conferenceRoomCheckIn(guest1, conferenceRoom);
        hotel.conferenceRoomCheckIn(guest2, conferenceRoom);
        hotel.checkOut(conferenceRoom, guest1);
        assertEquals(1, conferenceRoom.guestCount());
    }

    @Test
    public void canCreateBooking(){
        assertTrue(hotel.bookRoom(bedroom1, 3).getClass().isInstance(booking));
    }

    @Test
    public void hotelHasBookings(){
        assertEquals(0, hotel.bookingCount());
    }

    @Test
    public void hotelCanAddBooking(){
        hotel.addBooking(booking);
        hotel.addBooking(booking);
        assertEquals(2, hotel.bookingCount());
    }

    @Test
    public void hotelCanGetTotalBill(){
        hotel.addBooking(booking);
        assertEquals(90, hotel.getTotalBill(booking));
    }



}
