# RentCarSystem - Sınıf Diyagramı ve OOP Yapısı

## UML Class Diagram (Text Format)

```
┌─────────────────────────────────────┐
│             <<abstract>>            │
│               Users                 │
├─────────────────────────────────────┤
│ + id: int                          │
│ + password: int                    │
├─────────────────────────────────────┤
│ + Users(id: int, password: int)    │
└─────────────────────────────────────┘
                    △
                    │
        ┌───────────┴───────────┐
        │                       │
┌───────────────┐       ┌───────────────┐
│    Person     │       │   Company     │
├───────────────┤       ├───────────────┤
│               │       │               │
├───────────────┤       ├───────────────┤
│ + Person(...)│       │ + Company(...)│
└───────────────┘       └───────────────┘


┌─────────────────────────────────────────────┐
│                <<abstract>>                 │
│                    Car                      │
├─────────────────────────────────────────────┤
│ - baggageCapacity: double                   │
│ - dailyRentalFee: double                    │
│ - color: String                             │
│ - typeName: String                          │
├─────────────────────────────────────────────┤
│ + Car(baggageCapacity, dailyRentalFee,     │
│       color, typeName)                      │
│ + getBaggageCapacity(): double              │
│ + setBaggageCapacity(double): void          │
│ + getDailyRentalFee(): double               │
│ + setDailyRentalFee(double): void           │
│ + getColor(): String                        │
│ + setColor(String): void                    │
│ + getTypeName(): String                     │
│ + setTypeName(String): void                 │
│ + getMontlyRentalFee(): double              │
└─────────────────────────────────────────────┘
                        △
                        │
        ┌───────────────┼───────────────┐
        │               │               │
┌───────────────┐ ┌─────────────┐ ┌─────────────┐
│   Hatcback    │ │    Sedan    │ │     Suv     │
├───────────────┤ ├─────────────┤ ├─────────────┤
│               │ │             │ │ - age: int  │
│               │ │             │ │ - AGECONSTANT│
├───────────────┤ ├─────────────┤ ├─────────────┤
│ + Hatcback(...)│ │ + Sedan(...)│ │ + Suv(...)  │
│               │ │             │ │ @Override   │
│               │ │             │ │ + getDailyRen│
│               │ │             │ │ @Override   │
│               │ │             │ │ + getMontlyRen│
└───────────────┘ └─────────────┘ └─────────────┘


┌─────────────────────────────────────────────┐
│              LoginService                   │
├─────────────────────────────────────────────┤
│                                             │
├─────────────────────────────────────────────┤
│ + Login(users: Users): Users                │
└─────────────────────────────────────────────┘


┌─────────────────────────────────────────────┐
│              RentService                    │
├─────────────────────────────────────────────┤
│                                             │
├─────────────────────────────────────────────┤
│ + DailyRentACar(users: Users, car: Car,     │
│                 day: int): void             │
│ + MontlyRentACar(users: Users, car: Car):   │
│                  void                       │
└─────────────────────────────────────────────┘
```

## İlişki Analizi

### 1. Inheritance (Kalıtım) İlişkileri:
- **Users** ← Person
- **Users** ← Company
- **Car** ← Suv
- **Car** ← Sedan
- **Car** ← Hatcback

### 2. Composition/Dependency İlişkileri:
- **RentService** uses **Users** and **Car**
- **LoginService** uses **Users**
- **Main** uses all service classes

### 3. Polymorphic Behavior:
- **Users** referansı → Person veya Company instance
- **Car** referansı → Suv, Sedan veya Hatcback instance

## Metodların Override Edilmesi

```java
// Car class (base implementation)
public double getMontlyRentalFee(){
    return this.dailyRentalFee * 30;
}

public double getDailyRentalFee(){
    return dailyRentalFee;
}

// Suv class (overridden implementation)
@Override
public double getMontlyRentalFee(){
    return getDailyRentalFee()*30;  // Uses overridden daily fee
}

@Override
public double getDailyRentalFee(){
   return super.getDailyRentalFee() - (AGECONSTANT * this.age/30);
}
```

## Runtime Polymorphism Örnekleri

```java
// RentService.java'dan örnekler
if (car instanceof Hatcback && day == 30) {
    System.out.println("Hatcback aylık kiralanamaz.");
    return;
}

if(users instanceof Person && !(car instanceof Hatcback)) {
    System.out.println("Normal vatandaşlar hatchback dışında araç kiralayamaz.");
    return;
}

String userType = (users instanceof Company) ? "Company" : "Person";
```

## OOP Design Patterns

### 1. Template Method Pattern:
- **Car** sınıfında `getMontlyRentalFee()` template method
- **Suv** sınıfında özelleştirilmiş implementasyon

### 2. Factory Pattern Potansiyeli:
- Car ve Users için factory sınıfları eklenebilir

### 3. Strategy Pattern Potansiyeli:
- Farklı kiralama stratejileri için ayrı sınıflar oluşturulabilir