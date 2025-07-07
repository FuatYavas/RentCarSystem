# RentCarSystem - OOP (Nesne Yönelimli Programlama) Analizi

## Özet
Bu proje **tamamen OOP tabanlı** bir Java uygulamasıdır. Araç kiralama sistemi için tasarlanmış olan bu proje, OOP'nin temel prensiplerini başarılı bir şekilde uygular.

## OOP Prensiplerinin Uygulanması

### 1. Kapsülleme (Encapsulation)

#### Başarılı Örnekler:
- **Car sınıfı**: Tüm alanlar private olarak tanımlanmış
  ```java
  private double baggageCapacity;
  private double dailyRentalFee;
  private String color;
  private String typeName;
  ```
- **Getter/Setter metotları**: Veri erişimi kontrollü şekilde sağlanıyor
  ```java
  public double getBaggageCapacity() { return baggageCapacity; }
  public void setBaggageCapacity(double baggageCapacity) { this.baggageCapacity = baggageCapacity; }
  ```

#### İyileştirme Önerileri:
- **Users sınıfı**: `id` ve `password` alanları public olarak tanımlanmış, private olmalı
  ```java
  // Mevcut (iyileştirilmeli):
  public int id;
  public int password;
  
  // Önerilen:
  private int id;
  private int password;
  ```

### 2. Kalıtım (Inheritance)

#### Mükemmel Hiyerarşik Yapı:

**Araç Hiyerarşisi:**
```
Car (abstract)
├── Suv
├── Sedan
└── Hatcback
```

**Kullanıcı Hiyerarşisi:**
```
Users (abstract)
├── Person
└── Company
```

#### Kod Örnekleri:
- **SUV sınıfı** Car'dan miras alır:
  ```java
  public class Suv extends Car {
      private int age;
      public Suv(double baggageCapacity, double dailyRentalFee, String color, String typeName, int age) {
          super(baggageCapacity, dailyRentalFee, color, typeName);
          this.age = age;
      }
  }
  ```

### 3. Polimorfizm (Polymorphism)

#### Method Override Örnekleri:
- **SUV sınıfında** yaş faktörüne göre özelleştirilmiş fiyat hesaplama:
  ```java
  @Override
  public double getDailyRentalFee(){
     return super.getDailyRentalFee() - (AGECONSTANT * this.age/30);
  }
  
  @Override
  public double getMontlyRentalFee(){
      return getDailyRentalFee()*30;
  }
  ```

#### Runtime Polimorfizm:
- **RentService** sınıfında `instanceof` kontrolü ile runtime tip belirleme:
  ```java
  if(users instanceof Person && !(car instanceof Hatcback)) {
      System.out.println("Normal vatandaşlar hatchback dışında araç kiralayamaz.");
  }
  ```

### 4. Soyutlama (Abstraction)

#### Abstract Sınıflar:
- **Car**: Tüm araç tiplerinin ortak özelliklerini tanımlar
- **Users**: Tüm kullanıcı tiplerinin ortak özelliklerini tanımlar

#### İş Mantığının Ayrılması:
- **LoginService**: Kullanıcı doğrulama işlemlerini yönetir
- **RentService**: Araç kiralama işlemlerini yönetir

## Proje Yapısı ve Organizasyon

### Package Yapısı:
```
src/
├── entities/
│   ├── abstracts/     # Soyut sınıflar
│   │   ├── Car.java
│   │   └── Users.java
│   └── concretes/     # Somut sınıflar
│       ├── Company.java
│       ├── Hatcback.java
│       ├── Person.java
│       ├── Sedan.java
│       └── Suv.java
├── business/          # İş mantığı sınıfları
│   ├── LoginService.java
│   └── RentService.java
└── Main.java         # Ana uygulama
```

## İş Mantığı ve OOP Tasarımı

### Kullanıcı Tipleri ve Yetkiler:
- **Person**: Sadece Hatchback araç kiralayabilir
- **Company**: Tüm araç tiplerini kiralayabilir

### Araç Tipleri ve Özellikler:
- **SUV**: Yaşa göre indirimli fiyatlandırma
- **Hatchback**: Aylık kiralama kısıtlaması
- **Sedan**: Standart kiralama koşulları

## OOP Tasarım Kalitesi

### Güçlü Yanlar:
✅ **Temiz class hierarchy**  
✅ **Interface segregation** (abstract classes)  
✅ **Encapsulation** (Car sınıfında)  
✅ **Polymorphism** (method overriding)  
✅ **Single Responsibility** (ayrılmış service sınıfları)  

### İyileştirme Alanları:
❗ **Users sınıfında encapsulation eksik**  
❗ **Hatchback yazım hatası** (Hatcback olarak yazılmış)  
❗ **Monthly yazım hatası** (Montly olarak yazılmış)  
❗ **Exception handling** eksik  
❗ **Input validation** yetersiz  

## Sonuç

Bu proje **kesinlikle OOP tabanlı** bir projedir ve OOP'nin dört temel prensibini başarılı şekilde uygular. Proje, nesne yönelimli tasarım kalıplarını kullanarak:

- **Kod tekrarını azaltır** (inheritance ile)
- **Esneklik sağlar** (polymorphism ile)
- **Veri güvenliği** sunar (encapsulation ile)
- **Karmaşıklığı gizler** (abstraction ile)

Küçük iyileştirmelerle bu proje OOP'nin mükemmel bir örneği haline getirilebilir.