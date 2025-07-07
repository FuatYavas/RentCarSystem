# OOP Prensiplerine Göre Kod Örnekleri

Bu dokümanda RentCarSystem projesindeki OOP prensiplerinin uygulandığı somut kod örnekleri gösterilmiştir.

## 1. Encapsulation (Kapsülleme) Örnekleri

### Başarılı Encapsulation - Car Sınıfı

```java
public abstract class Car {
    // Private fields - dış erişime kapatılmış
    private double baggageCapacity;
    private double dailyRentalFee;
    private String color;
    private String typeName;

    // Constructor ile kontrollü initialization
    public Car(double baggageCapacity, double dailyRentalFee, String color, String typeName) {
        this.baggageCapacity = baggageCapacity;
        this.dailyRentalFee = dailyRentalFee;
        this.color = color;
        this.typeName = typeName;
    }

    // Getter methods - kontrollü okuma erişimi
    public double getBaggageCapacity() {
        return baggageCapacity;
    }

    public double getDailyRentalFee() {
        return dailyRentalFee;
    }

    // Setter methods - kontrollü yazma erişimi
    public void setBaggageCapacity(double baggageCapacity) {
        this.baggageCapacity = baggageCapacity;
    }

    public void setDailyRentalFee(double dailyRentalFee) {
        this.dailyRentalFee = dailyRentalFee;
    }
}
```

### İyileştirilmesi Gereken - Users Sınıfı

```java
// Mevcut (güvenli değil):
public abstract class Users {
    public int id;        // Direkt erişim mümkün
    public int password;  // Güvenlik riski
}

// Önerilen (güvenli):
public abstract class Users {
    private int id;
    private int password;
    
    public Users(int id, int password) {
        this.id = id;
        this.password = password;
    }
    
    public int getId() { return id; }
    public boolean checkPassword(int password) { 
        return this.password == password; 
    }
}
```

## 2. Inheritance (Kalıtım) Örnekleri

### Araç Kalıtım Hiyerarşisi

```java
// Base class
public abstract class Car {
    protected double baggageCapacity;
    protected double dailyRentalFee;
    // ... other fields and methods
}

// Derived class - SUV
public class Suv extends Car {
    private int age;  // SUV'a özel field
    private static final int AGECONSTANT = 200;

    public Suv(double baggageCapacity, double dailyRentalFee, 
               String color, String typeName, int age) {
        super(baggageCapacity, dailyRentalFee, color, typeName);  // Parent constructor
        this.age = age;  // Child-specific initialization
    }
}

// Derived class - Sedan (basit kalıtım)
public class Sedan extends Car {
    public Sedan(double baggageCapacity, double dailyRentalFee, 
                 String color, String typeName) {
        super(baggageCapacity, dailyRentalFee, color, typeName);
    }
    // Parent'ın tüm methodlarını inherit eder
}
```

### Kullanıcı Kalıtım Hiyerarşisi

```java
// Base class
public abstract class Users {
    public int id;
    public int password;
    
    public Users(int id, int password) {
        this.id = id;
        this.password = password;
    }
}

// Company kullanıcısı
public class Company extends Users {
    public Company(int id, int password) {
        super(id, password);
    }
    // Company'ye özel methodlar eklenebilir
}

// Individual kullanıcısı
public class Person extends Users {
    public Person(int id, int password) {
        super(id, password);
    }
    // Person'a özel methodlar eklenebilir
}
```

## 3. Polymorphism (Çok Biçimlilik) Örnekleri

### Method Overriding

```java
// Parent class method
public abstract class Car {
    public double getMontlyRentalFee(){
        return this.dailyRentalFee * 30;  // Standart hesaplama
    }
    
    public double getDailyRentalFee(){
        return dailyRentalFee;  // Standart fiyat
    }
}

// Child class overriding
public class Suv extends Car {
    @Override
    public double getMontlyRentalFee(){
        return getDailyRentalFee() * 30;  // Overridden daily fee kullanır
    }
    
    @Override
    public double getDailyRentalFee(){
        // Yaşa göre indirimli fiyat hesaplama
        return super.getDailyRentalFee() - (AGECONSTANT * this.age/30);
    }
}
```

### Runtime Polymorphism

```java
public class RentService {
    public void DailyRentACar(Users users, Car car, int day){
        // Runtime'da gerçek tip belirlenir
        if (car instanceof Hatcback && day == 30) {
            System.out.println("Hatcback aylık kiralanamaz.");
            return;
        }

        // Kullanıcı tipine göre farklı davranış
        if(users instanceof Person && !(car instanceof Hatcback)) {
            System.out.println("Normal vatandaşlar hatchback dışında araç kiralayamaz.");
            return;
        }

        // Polymorphic method call - gerçek sınıfın methodu çağrılır
        double fee = car.getDailyRentalFee() * day;
        
        // Runtime type checking
        String userType = (users instanceof Company) ? "Company" : "Person";
        System.out.println(users.id + " id li " + userType + " kullanıcı " + 
                          car.getTypeName() + " kiraladı ");
    }
}
```

### Polymorphic Usage

```java
public class Main {
    public static void main(String[] args) {
        // Polymorphic object creation
        Users person = new Person(123, 123);     // Users reference, Person object
        Users company = new Company(321, 321);   // Users reference, Company object
        
        Car suv = new Suv(20, 350, "Red", "SUV", 2);        // Car reference, Suv object
        Car sedan = new Sedan(20, 400, "Black", "Sedan");   // Car reference, Sedan object
        
        RentService rentService = new RentService();
        
        // Polymorphic method calls - runtime'da doğru method çağrılır
        rentService.DailyRentACar(company, suv, 20);    // Suv.getDailyRentalFee() çağrılır
        rentService.DailyRentACar(company, sedan, 20);  // Car.getDailyRentalFee() çağrılır
    }
}
```

## 4. Abstraction (Soyutlama) Örnekleri

### Abstract Classes

```java
// Car abstraction - ortak interface tanımlar
public abstract class Car {
    // Common properties for all cars
    private double baggageCapacity;
    private double dailyRentalFee;
    
    // Common behavior for all cars
    public double getMontlyRentalFee(){
        return this.dailyRentalFee * 30;
    }
    
    // Abstract classes can have concrete methods
    public String getTypeName() {
        return typeName;
    }
}

// Users abstraction - ortak kullanıcı davranışları
public abstract class Users {
    public int id;
    public int password;
    
    // Common constructor
    public Users(int id, int password) {
        this.id = id;
        this.password = password;
    }
}
```

### Business Logic Abstraction

```java
// LoginService - Authentication logic'i soyutlar
public class LoginService {
    public Users Login(Users users){
        // Complex authentication logic hidden from caller
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

// RentService - Rental business logic'i soyutlar
public class RentService {
    // Complex rental logic hidden from caller
    public void DailyRentACar(Users users, Car car, int day){
        // Business rules implementation
        // Caller doesn't need to know internal logic
    }
    
    public void MontlyRentACar(Users users, Car car){
        // Delegates to daily rental with 30 days
        this.DailyRentACar(users, car, 30);
    }
}
```

## OOP Prensiplerinin Faydaları Bu Projede

### 1. Code Reusability
- `Car` sınıfının common functionality'si tüm araç tiplerinde kullanılıyor
- `Users` sınıfının ortak özellikleri Person ve Company'de paylaşılıyor

### 2. Maintainability
- Yeni araç tipi eklemek için sadece `Car`'dan inherit etmek yeterli
- Business logic service sınıflarında centralized

### 3. Extensibility
- Yeni kullanıcı tipleri `Users`'dan türetilebilir
- Yeni rental rules `RentService`'e eklenebilir

### 4. Data Security
- Private fields ile data protection (Car sınıfında)
- Controlled access via getters/setters