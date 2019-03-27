import java.util.ArrayList;
import java.util.List;

public class Event {

    private String title;
    private String date;
    private String description;

    private List<Person> personList;

    public Event(String title) {
        this.title = title;
        this.date = "";
        this.description = "";
        this.personList = new ArrayList<>();
    }

    public Event(String title, String date) {
        this.title = title;
        this.date = date;
        this.description = "";
        this.personList = new ArrayList<>();
    }

    public Event(String title, String date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.personList = new ArrayList<>();
    }

    // ---- copy constructor
    public Event(Event e) {
        this.title = e.getTitle();
        this.date = e.getDate();
        this.description = e.getDescription();
        this.personList = e.getPersonList();
    }

    // ---- testAudience
    public void addPerson(Person p) {
        for (Person per : personList) {
            if (p.equals(per))
                return;
        }
        personList.add(p);
    }

    public int getAudienceCount() {
        return personList.size();
    }

    // ---- testEventPrintOut
    @Override
    public String toString() {
        return this.getTitle() +" is a "+ this.getDescription() +" and will be held at " + this.getDate() +".";
    }

    // ---- testSameEvent
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Event))
            return false;

        Event e = (Event) obj;

        return this.getTitle().equals(e.getTitle()) && this.getDate().equals(e.getDate()) && this.getDescription().equals(e.getDescription());
    }

    // ---- getters
    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    // ---- setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
