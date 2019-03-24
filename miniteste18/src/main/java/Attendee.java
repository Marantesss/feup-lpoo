public class Attendee extends Person {
    private boolean paid;

    Attendee(String name) {
        this.name = name;
        this.age = 0;
        this.paid = false;
    }

    Attendee(String name, int age) {
        this.name = name;
        this.age = age;
        this.paid = false;
    }

    public boolean hasPaid() {
        return paid;
    }

    @Override
    public String toString() {
        return "Attendee "+ this.getName() + (this.hasPaid() ? " has":" hasn't") + " paid its registration.";
    }
}
