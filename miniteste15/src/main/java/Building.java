import java.util.ArrayList;
import java.util.List;

public class Building implements Facility {

    private String name;
    private int minFloor;
    private int maxFloor;
    List<Room> roomList;

    public Building(String name, int minFloor, int maxFloor) {
        this.name = name;
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        this.roomList = new ArrayList<>();
        if (minFloor > maxFloor)
            throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return "Building(" + this.getName() + ")";
    }

    public void addRoom(Room r) throws DuplicateRoomException {
        for (Room room : roomList) {
            if (r.equals(room))
                throw new DuplicateRoomException();
        }
        roomList.add(r);
    }

    public boolean canEnter(User user) {
        for (Room room : roomList) {
            if(room.canEnter(user))
                return true;
        }
        return false;
    }

    // ---- getters
    public String getName() {
        return name;
    }

    public int getMinFloor() {
        return minFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public int getCapacity() {
        int capacity = 0;
        for (Room room : roomList) {
            capacity += room.getCapacity();
        }
        return capacity;
    }

    // ---- setters
    public void setName(String name) {
        this.name = name;
    }

    public void setMaxFloor(int maxFloor) {
        this.maxFloor = maxFloor;
    }

    public void setMinFloor(int minFloor) {
        this.minFloor = minFloor;
    }

}
