import java.util.ArrayList;

public class ConferenceRoom {

    private int capacity;
    private ArrayList<Guest> guests;
    private String name;

    public ConferenceRoom(int capacity, String name){
        this.capacity = capacity;
        this.guests = new ArrayList<Guest>();
        this.name = name;

    }

    public int getCapacity() {
        return capacity;
    }

    public int guestCount() {
        return guests.size();
    }

    public String getName() {
        return name;
    }

    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    public void removeGuest(Guest guest){
        guests.remove(guest);
    }
}
