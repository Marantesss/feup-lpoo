public abstract class Person implements Comparable, User {
    protected String name;
    protected int age;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Person))
            return false;

        Person p = (Person) obj;

        return this.getName().equals(p.getName());
    }

    @Override
    public String getUsername() {
        return this.getName() + this.getAge();
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    @Override
    public int compareTo(Object o) {
        return this.hashCode() - o.hashCode();
    }

    // ---- getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // ----
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
