import java.util.ArrayList;
import java.util.List;

public class Event {
    private String title = "";
    private String date = "";
    private String description = "";

    protected List<Person> personList;

    public Event(String title) {
        this.title = title;
        this.personList = new ArrayList<>();
    }

    public Event(String title, String date) {
        this.title = title;
        this.date = date;
        this.personList = new ArrayList<>();
    }

    public Event(String title, String date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.personList = new ArrayList<>();
    }

    // ---- Stuff for exercises
    // ---- Copy constructor
    Event(Event e) {
        this.title = e.getTitle();
        this.date = e.getDate();
        this.description = e.getDescription();
        this.personList = e.getPersonList();
    }

    // ---- Overriding toString()
    @Override
    public String toString() {
        return this.title + " is a " + this.description + " and will be held at " + this.date + ".";
    }

    // Overriding equals() to compare two Event objects
    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Event or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Event)) {
            return false;
        }

        // typecast o to Event so that we can compare data members
        Event e = (Event) o;

        // Compare the data members and return accordingly
        return this.title.equals(e.getTitle()) && this.description.equals(e.getDescription()) && this.date.equals(e.getDate());
    }

    public void addPerson(Person p) {
        // See if p is already in personList
        if (!this.personList.contains(p)) {
            personList.add(p);
        }
        /*
        for (Person person : personList) {
            if (person.equals(p))
                return;
        }
        personList.add(p);
        */
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

    public int getAudienceCount() {
        return this.personList.size();
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
