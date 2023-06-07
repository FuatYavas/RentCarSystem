package business;

import entities.abstracts.Car;
import entities.abstracts.Users;
import entities.concretes.Company;
import entities.concretes.Hatcback;
import entities.concretes.Person;

public class RentService {
    public void DailyRentACar(Users users, Car car,int day){
        if (car instanceof Hatcback && day == 30) {
            System.out.println("Hatcback aylık kiralanamaz.");
            return;
        }

        if(users instanceof Person && !(car instanceof Hatcback)) {
            System.out.println("Normal vatandaşlar hatchback dışında araç kiralayamaz.");
            return;
        }

        System.out.println(users.id +" id li "+ ((users instanceof Company) ? "Company" : "Person") + "  kullanıcı "+car.getTypeName() +" kiraladı ");
        System.out.println((car.getDailyRentalFee()*day) +" tl ücret ödedi");
    }

    public void MontlyRentACar(Users users, Car car){
        this.DailyRentACar(users,car,30);
    }
}
