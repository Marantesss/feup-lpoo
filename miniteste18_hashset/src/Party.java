import java.util.List;

public class Party extends Event {

    public Party(String title, String date, String description) {
        super(title, date, description);
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
}
