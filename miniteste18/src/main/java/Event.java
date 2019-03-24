public class Event {
    private String title = "";
    private String date = "";
    private String description = "";

    public Event(String title) {
        this.title = title;

    }

    public Event(String title, String date) {
        this.title = title;
        this.date = date;
    }

    public Event(String title, String date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
    }

    // ---- Copy constructor
    Event(Event e) {
        this.title = e.title;
        this.date = e.date;
        this.description = e.description;
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
        return title.equals(e.title) && description.equals(e.description) && date.equals(e.date);
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
