package com.aor.refactoring.example4;

import java.util.Objects;

public class Worker extends Person {
    private final String username;
    private final String password;

    public Worker(String name, String phone, String username, String password) {
        super(name, phone);
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        //if (o == null || getClass() != o.getClass())
        if (!(o instanceof Worker))
            return false;

        Worker worker = (Worker) o;

        boolean nameOK = this.getUsername().equals(worker.getUsername());
        boolean phoneOK = this.getPhone().equals(worker.getPhone());
        boolean usernameOK = this.getUsername().equals(worker.getUsername());
        boolean passwordOK = this.getPassword().equals(worker.getPassword());

        return nameOK && phoneOK && usernameOK && passwordOK;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, username, password);
    }

    // ---- getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
