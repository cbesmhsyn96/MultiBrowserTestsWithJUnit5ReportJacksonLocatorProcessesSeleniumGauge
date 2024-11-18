package utils;
import io.grpc.internal.DnsNameResolver;
import org.openqa.selenium.devtools.v85.dom.model.ShadowRootType;

import javax.xml.validation.SchemaFactoryConfigurationError;
import java.util.*;

import static com.fasterxml.jackson.databind.type.LogicalType.Array;

public class TestDataClass {
    /*Eklenecekler --> api ile gerçek adresleri çekerek gerçek datalarla
    adres test dataları oluşturulması*/
    protected static Random random = new Random();
    protected static List<String> nameDatas = List.of(
            "Huseyin",
            "Sema",
            "Sinan",
            "Serhat",
            "Polat",
            "Gamze",
            "Sıla",
            "Cenk",
            "Timur"
    );
    protected static List<String> surnameDatas = List.of(
            "Tosun",
            "Kara",
            "Alemdar",
            "Deniz",
            "Akcan",
            "Taşan",
            "Rüzgar",
            "Harbi",
            "Öztürk"
    );

    protected static List<String> tckNos = List.of(
            "12345678922",
            "12342278922",
            "12345672222",
            "12245678922",
            "12341178922",
            "12345678822",
            "12555678922",
            "12555605922",
            "12045678922"
    );

    protected static List<String> mahalleMockDatas = List.of(
            "Yeni",
            "Eski",
            "Tophane",
            "Komando",
            "Bordo",
            "Ateş",
            "Su",
            "Toprak",
            "Hava",
            "Aristo",
            "Platon"
    );

    protected static List<String> sokakMockDatas = List.of(
            "Tarım",
            "Sanayi",
            "Teknoloji",
            "Bölge",
            "Renk",
            "Metal",
            "Rock",
            "Rap",
            "Formül",
            "Toplayan",
            "Faktoriyel",
            "Random"
    );

    protected static List<String> siteAdiMockDatas = List.of(
            "Aktütün",
            "Şahinler",
            "Hançerler",
            "Aslanlar",
            "Kurtlar",
            "Otağ",
            "Ayılar"
    );
    protected static List<String> blokMockDatas = List.of(
      "A",
      "B",
      "C",
      "Ç",
      "D",
      "E",
      "F",
      "G",
      "Ğ",
      "H",
      "T",
      "R",
      "V",
      "Z",
      "P"
    );

    protected static Map<String, List<String>> ilVeIlceMockDataMap = new HashMap<>();
    static{
        ilVeIlceMockDataMap.put("İstanbul", Arrays.asList("Sarıyer","Silivri","Beşiktaş"));
        ilVeIlceMockDataMap.put("Ankara",Arrays.asList("Çankaya","Sincan","Ulus"));
        ilVeIlceMockDataMap.put("Adıyaman",Arrays.asList("Sincik","Besni","Merkez"));
    }
    protected static String selectedCity;
    protected static String getRandomStrFromList(List<String> list){
        int randIndex = random.nextInt(list.size()-1);
        return list.get(randIndex);
    }

    protected static int randNumber(int origin, int bound){
        return random.nextInt(bound - origin) + origin;
    }

    protected static Boolean getRandBooleanValue() {
        return random.nextBoolean();
    }

    private static String getRandCityFromMockData(){
        List<String> citiesList = new ArrayList<>();
        citiesList.addAll(ilVeIlceMockDataMap.keySet());
        selectedCity = getRandomStrFromList(citiesList);
        return selectedCity;
    }

    private static String getRandDistrictFromMockData(String city){
        List<String> districtList = ilVeIlceMockDataMap.get(city);
        int randomIndex = random.nextInt(districtList.size());
        return districtList.get(randomIndex);
    }

    protected static String createAdressFromMockDatas(){
        return getRandomStrFromList(mahalleMockDatas) + " Mahallesi " +
                getRandomStrFromList(sokakMockDatas) + " Sokak " +
                getRandomStrFromList(siteAdiMockDatas) + " Sitesi "+
                getRandomStrFromList(blokMockDatas)+ " Blok "+
                "Kat " +randNumber(-1,10)+
                " No " + randNumber(1,21) +
                " "+getRandCityFromMockData()+"/"+
                getRandDistrictFromMockData(selectedCity);
    }
}