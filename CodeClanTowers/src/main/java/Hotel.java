import java.util.ArrayList;

public class Hotel {

    private ArrayList<Bedroom> bedroomCollection;
    private ArrayList<ConferenceRoom> conferenceRoomCollection;
    private String name;
    private ArrayList<Booking> collectionOfBookings;

    public Hotel(String name){
        this.name = name;
        this.bedroomCollection = new ArrayList<Bedroom>();
        this.conferenceRoomCollection = new ArrayList<ConferenceRoom>();
        this.collectionOfBookings = new ArrayList<Booking>();
    }

    public String getName() {
        return name;
    }

    public int bedroomCount() {
        return bedroomCollection.size();
    }

    public int conferenceRoomCount() {
        return conferenceRoomCollection.size();
    }

    public int bookingCount(){
        return collectionOfBookings.size();
    }

    public void addBedroom(Bedroom bedroom) {
        bedroomCollection.add(bedroom);
    }

    public void addConferenceRoom(ConferenceRoom conferenceRoom) {
        conferenceRoomCollection.add(conferenceRoom);
    }

    public void bedroomCheckIn(Guest guest, Bedroom bedroom) {
        if (bedroom.isEmpty()){
            bedroom.addGuest(guest);
        }
    }

    public void conferenceRoomCheckIn(Guest guest, ConferenceRoom conferenceRoom) {
        if (conferenceRoom.getCapacity() > conferenceRoom.guestCount()){
            conferenceRoom.addGuest(guest);
        }
    }

    public void checkOut(Bedroom bedroom) {
        bedroom.emptyRoom();
    }

    public void checkOut(ConferenceRoom conferenceRoom, Guest guest) {
        conferenceRoom.removeGuest(guest);
    }

    public Booking bookRoom(Bedroom bedroom, int numberOfNights){
        Booking booking = new Booking(bedroom, numberOfNights);
        this.addBooking(booking);
        return booking;
    }

    public void addBooking(Booking booking){
        collectionOfBookings.add(booking);
    }

    public int getTotalBill(Booking booking) {
       int billTotal = booking.getNumberOfNights() * booking.getBedroom().getNightRate();
       return billTotal;
    }
}
