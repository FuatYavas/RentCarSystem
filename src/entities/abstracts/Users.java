package entities.abstracts;

public abstract class Users {
    public int id;
    public int password;

    public Users(int id, int password) {
        this.id = id;
        this.password = password;
    }
}
