public class Attendee extends Person {

    private boolean paid;

    public Attendee(String name) {
        this.name = name;
        this.age = 0;
        this.paid = false;
    }

    public Attendee(String name, int age) {
        this.name = name;
        this.age = age;
        this.paid = false;
    }

    @Override
    public String toString() {
        return "Attendee " + this.getName() + (this.hasPaid() ? " has":" hasn't") + " paid its registration.";
    }

    // ---- getters
    public boolean hasPaid() {
        return this.paid;
    }

    // ---- setters
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
