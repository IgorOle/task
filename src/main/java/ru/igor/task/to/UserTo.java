package ru.igor.task.to;

public class UserTo {
    String fio;
    String email;

    public UserTo(String fio, String email) {
        this.fio = fio;
        this.email = email;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getEmail() {
        return email;
    }
}
