package business;

import entities.abstracts.Users;
import entities.concretes.Company;
import entities.concretes.Person;

public class LoginService {
    public Users Login(Users users){
        if (users.id==123 && users.password==123 && users instanceof Person) {
            System.out.println("Person olarak giriş yaptım.");
            return users;
        }
        if (users.id==321 && users.password==321 && users instanceof Company) {
            System.out.println("Company olarak giriş yaptım.");
            return users;
        }
        System.out.println("Kullanıcı adı ya da şifreniz yanlış.");
        return null;
    }
}
