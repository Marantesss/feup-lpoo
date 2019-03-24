public abstract class Person implements Comparable, User {
    protected String name;
    protected int age;

    // Overriding equals() to compare two Person objects
    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Person or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Person)) {
            return false;
        }

        // typecast o to Person so that we can compare data members
        Person e = (Person) o;

        // Compare the data members and return accordingly
        return this.name.equals(e.getName());
    }

    @Override
    public int compareTo(Object o) {
        if(this.equals(o))
            return 0;

        return this.name.compareTo((String)o);
    }

    @Override
    public String getUsername() {
        return this.getName() + this.getAge();
    }

    // ---- Getters
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    // ---- Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
