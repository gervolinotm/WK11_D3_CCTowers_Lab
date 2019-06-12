import java.util.ArrayList;

public class Bedroom {

    private int roomNumber;
    private int capacity;
    private ArrayList<Guest> guests;
    private String bedSize;
    private int nightRate;

    public Bedroom(int roomNumber, String bedSize, int nightRate){
        this.roomNumber = roomNumber;
        this.capacity = 3;
        this.guests = new ArrayList<Guest>();
        this.bedSize = bedSize.toLowerCase();
        this.nightRate = nightRate;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getBedSize() {
        return bedSize;
    }

    public int getNightRate(){
        return nightRate;
    }

    public boolean isEmpty() {
        return guests.isEmpty();
    }

    public int guestCount() {
        return guests.size();
    }

    public void addGuest(Guest guest) {
        if (this.capacity > this.guests.size()){
            guests.add(guest);
        }
    }

    public void emptyRoom() {
        guests.clear();
    }
}
