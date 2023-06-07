package entities.concretes;

import entities.abstracts.Users;

public class Person extends Users {
    public Person(int id, int password) {
        super(id, password);
    }
}
