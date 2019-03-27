public class Speaker extends Person {

    private int fee;

    public Speaker(String name, int age) {
        this.name = name;
        this.age = age;
        this.fee = 0;
    }

    public Speaker(String name) {
        this(name, 0);
    }

    @Override
    public String toString() {
        return "Speaker "+ this.getName() + " as a fee value of " +  this.getFee() + ".";
    }

    // ---- getters
    public int getFee() {
        return fee;
    }

    // ---- setters
    public void setFee(int fee) {
        this.fee = fee;
    }
}
