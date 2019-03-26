public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    // ---- getters
    public String getName() {
        return name;
    }

    // ---- setters
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof User))
            return false;

        User user = (User) obj;

        return this.name.equals(user.getName());
    }
}
