import java.util.ArrayList;
import java.util.List;

public class Room implements Facility {

    private Building building;
    private String number;
    private int floor;
    private int capacity;
    private List<User> authorizedUsers;

    public Room(Building building, String number, int floor) throws DuplicateRoomException {
        this(building, number, floor, 0);
    }

    public Room(Building building, String number, int floor, int capacity) throws DuplicateRoomException {
        this.building = building;
        this.number = number;
        this.floor = floor;
        this.capacity = capacity;
        this.authorizedUsers = new ArrayList<>();
        this.building.addRoom(this);
        if (Character.getNumericValue(number.charAt(0)) != floor) {
            throw new IllegalArgumentException();
        }
    }

    public void authorize(User user) {
        this.authorizedUsers.add(user);
    }

    public boolean canEnter(User user) {
        for (User u : authorizedUsers) {
            if (user.equals(u))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Room(" + this.getBuilding().getName() + "," + this.getNumber() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Room))
            return false;

        Room room = (Room) obj;

        return this.building.equals(room.building) && this.number.equals(room.number);
    }

    // ---- getters
    public Building getBuilding() {
        return building;
    }

    public String getNumber() {
        return number;
    }

    public int getFloor() {
        return floor;
    }

    public String getName() {
        return this.getBuilding().getName() + this.getNumber();
    }

    public int getCapacity() {
        return capacity;
    }

    // ---- setters
    public void setBuilding(Building building) {
        this.building = building;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
