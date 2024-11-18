--> Proje çoklu browser ile web otomasyon testi yapma özelliğine sahiptir.
--> Loglama aracı olarak log4j kullanıldı.
--> Console' da loglar öncesinde çıkan slf4j bildirimleri slf4j-nop ile önlendi.
--> log4j2.xml dosyasında logun nereden görüleceği ve log formatı yer alır.
--> StepImplementation.java classında spec dosyalarındaki senaryo adımlarının kullandığı metotlar yer alır.
github(cbesmhsyn96) repolar kısmındaki son otomasyon projelerinin birinde(ikaslı olan olması gerekiyor)
79 metot var. Metotlar java-otp ile otp doğrulama içeren senaryolar için kullanılan metodu da içeriyor.
--> Base classlarının inherit noktası LocatorMethods.java. Yani testlerin çalıştırılmak istendiği base classı
buradan ayarlanır.