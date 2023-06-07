package entities.concretes;

import entities.abstracts.Users;

public class Company extends Users {
    public Company(int id, int password) {
        super(id, password);
    }
}
