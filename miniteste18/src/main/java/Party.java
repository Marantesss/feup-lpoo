import java.util.ArrayList;
import java.util.List;

public class Party extends Event{

    private List<Event> eventList;

    Party(String title, String date, String description) {
        super(title, date, description);
        this.eventList= new ArrayList<>();
    }

    public void addEvent(Event e) {
        List<Person> eventPersonList = e.getPersonList();
        List<Person> partyPersonList = this.getPersonList();

        for (Person p : eventPersonList) {
            if (!partyPersonList.contains(p)) {
                this.addPerson(p);
            }
        }
    }

    // ---- getters
    public List<Event> getEventList() {
        return eventList;
    }
}
