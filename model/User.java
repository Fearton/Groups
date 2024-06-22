package model;

public abstract class User {
    
    private int id;
    private String name;
    private String lastName;

    public User(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format(getClass().getSimpleName() + ": id=%s, name=%s, lastName=%s", id, name, lastName);
    }

}
