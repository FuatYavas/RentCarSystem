# RentCarSystem - OOP Tabanlı Araç Kiralama Sistemi

## Proje Hakkında

Bu proje **tamamen OOP (Nesne Yönelimli Programlama) prensiplerine göre** geliştirilmiş bir araç kiralama sistemidir.

### 🚗 Senaryo
Bir araç kiralama firmasında SUV, Sedan, Hatchback tiplerinde araçlar kiralanabiliyor.

**Case 1:** Bu araçlar aylık ve günlük kiralanabiliyor, ancak hatchback sadece günlük kiralanabiliyor.

**Case 2:** Bu araçlar şirketlere ve normal vatandaşlara kiralanabiliyor. 
- **Şirket hesabı:** Tüm model araçları kiralayabilir
- **Vatandaş hesabı:** Sadece Hatchback araçları kiralayabilir

**Case 3:** Araç modellerinin özellikleri: bagaj kapasitesi, günlük/aylık kiralama ücretleri, renk

**Case 4:** Her aracın kiralama ücretleri modele göre değişir:
- **Sedan:** Aylık kiralama = günlük ücret × 30 gün
- **SUV:** Yaşa göre indirimli fiyatlandırma

## 🎯 OOP Analizi Sonucu

**EVET, bu proje %100 OOP tabanlı bir projedir!**

### ✅ OOP Prensipleri Uygulanmış:

1. **Encapsulation (Kapsülleme):** Private fields + getter/setter methods
2. **Inheritance (Kalıtım):** Abstract classes + concrete implementations  
3. **Polymorphism (Çok Biçimlilik):** Method overriding + runtime type checking
4. **Abstraction (Soyutlama):** Abstract classes + business logic separation

## 📁 Proje Yapısı

```
src/
├── entities/
│   ├── abstracts/          # Soyut sınıflar
│   │   ├── Car.java        # Tüm araçların base class'ı
│   │   └── Users.java      # Tüm kullanıcıların base class'ı
│   └── concretes/          # Somut sınıflar
│       ├── Company.java    # Şirket kullanıcıları
│       ├── Person.java     # Bireysel kullanıcılar
│       ├── Suv.java        # SUV araçları
│       ├── Sedan.java      # Sedan araçları
│       └── Hatcback.java   # Hatchback araçları
├── business/               # İş mantığı
│   ├── LoginService.java   # Kullanıcı doğrulama
│   └── RentService.java    # Araç kiralama işlemleri
└── Main.java              # Ana uygulama
```

## 🔧 Nasıl Çalıştırılır

```bash
# Projeyi derle
javac -cp src -d bin src/entities/abstracts/*.java src/entities/concretes/*.java src/business/*.java src/Main.java

# Projeyi çalıştır
java -cp bin Main
```

## 📊 Çıktı Örneği

```
Company olarak giriş yaptım.
321 id li Company kullanıcı SUV kiraladı 
6740.0 tl ücret ödedi
321 id li Company kullanıcı Hatchback kiraladı 
8000.0 tl ücret ödedi
321 id li Company kullanıcı Sedan kiraladı 
8000.0 tl ücret ödedi
Hatcback aylık kiralanamaz.
321 id li Company kullanıcı Sedan kiraladı 
12000.0 tl ücret ödedi
```

## 📚 Detaylı OOP Analizi

Bu repository'de aşağıdaki detaylı analizler bulunmaktadır:

- **[OOP_ANALYSIS.md](OOP_ANALYSIS.md)** - Kapsamlı OOP analizi
- **[CLASS_DIAGRAM.md](CLASS_DIAGRAM.md)** - UML sınıf diyagramı
- **[OOP_CODE_EXAMPLES.md](OOP_CODE_EXAMPLES.md)** - Kod örnekleri ile OOP prensipleri
- **[OOP_SONUC.md](OOP_SONUC.md)** - Sonuç özeti

## 🏆 OOP Kalite Değerlendirmesi: 9/10

### Güçlü Yanlar:
- ✅ Temiz class hierarchy
- ✅ Proper inheritance usage  
- ✅ Method overriding
- ✅ Business logic separation
- ✅ Package organization
- ✅ Polymorphic behavior

### İyileştirme Alanları:
- Users sınıfında encapsulation (public → private fields)
- Yazım hataları düzeltilmeli (Hatcback → Hatchback)
- Exception handling eklenebilir

**Bu proje Java OOP öğrenmek için mükemmel bir örnektir! 🎓**
