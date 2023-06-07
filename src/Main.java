import business.LoginService;
import business.RentService;
import entities.abstracts.Users;
import entities.concretes.*;


public class Main {
    public static void main(String[] args) {

        Person person = new Person(123,123);
        Company company = new Company(321,321);

        LoginService loginService = new LoginService();
        Users users = loginService.Login(company);
        if(users == null) return;

        Suv suv = new Suv(20, 350, "Red", "SUV", 2);
        Hatcback hatcback = new Hatcback(20,400,"Black","Hatchback");
        Sedan sedan = new Sedan(20,400,"Black","Sedan");

        RentService rentService = new RentService();
        rentService.DailyRentACar(users, suv, 20);
        rentService.DailyRentACar(users,hatcback,20);
        rentService.DailyRentACar(users,sedan,20);
        rentService.MontlyRentACar(users,hatcback);
        rentService.MontlyRentACar(users,sedan);
    }
}