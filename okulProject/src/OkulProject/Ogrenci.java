package OkulProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Ogrenci {
    static Map<String,String> ogrenciMap = new HashMap<>();
    static Scanner scan=new Scanner(System.in);
    public static void feykOgrenciEkle(){
        ogrenciMap.put("123456987411","Ali, Can, 2008, 3569, 12, A");
        ogrenciMap.put("123456987412","Veli, Yan, 2008, 3559, 12, B");
        ogrenciMap.put("123456987413","Ayse, Can, 2007, 4569, 12, A");
        ogrenciMap.put("123456987414","Ali, San, 2009, 1569, 11, A");
        ogrenciMap.put("123456987415","Alp, Yan, 2009, 3769, 11, A");

    }
    public static void ogrenciMenu() throws InterruptedException {
        String tercih="";
        do {
            System.out.println("============= YILDIZ KOLEJI =============\n" +
                    "=========== OGRENCI MENU ============\n" +
                    "\t   1- Ogrenci Listesi Yazdir\n" +
                    "\t   2- Soyisimden Ogrenci Bulma\n" +
                    "\t   3- Sinif ve Sube Ile Ogrenci Bulma\n" +
                    "\t   4- Bilgilerini Girerek Ogrenci Ekleme\n" +
                    "\t   5- Kimlik No Ile Kayit Silme \t\n" +
                    "\t   A- ANAMENU\n" +
                    "\t   Q- ÇIKIŞ");
            tercih=scan.nextLine();
            switch (tercih){
                case "1" :
                    ogrenciListeYazdir();
                    break;
                case "2" : // Soyisimden Ogrenci Bulma
                    soyisimdenOgrenciBulma();
                    break;
                case "3" : // Sinif ve Sube Ile Ogrenci Bulma
                    sinifVeSubeIleOgrenciBulma();
                    break;
                case "4" : // Bilgilerini Girerek Ogrenci Ekleme
                    ogrenciEkle();
                    break;
                case "5" :
                    tcNoIleOgrenciSilme();
                    break;
                case "a" :
                case "A" :
                    Depo.anamenu();
                    break;
                case "q" :
                case "Q" :
                    Depo.projeDurdur();
                    break;
                default  :
                    System.out.println("Lutfen gecerli bir tercih giriniz");
            }


        } while(!tercih.equalsIgnoreCase("q"));
        Depo.projeDurdur();

    }

    private static void tcNoIleOgrenciSilme() {
        System.out.println("Silinecek Öğrenci Kimlik Numarasını Girin :");
        String silinecekOgretmen= scan.nextLine();

        String silinecekValue= ogrenciMap.get(silinecekOgretmen);

        String sonucValue= ogrenciMap.remove(silinecekOgretmen);
        try {
            boolean sonuc = sonucValue.equals(sonucValue);
        } catch (Exception e) {
            System.out.println("istediğiniz TC numarası ile öğrenci bulunamadı");
        }
    }

    private static void ogrenciEkle() {
        System.out.println("Tc no");
        String tcNo=scan.nextLine();
        System.out.println("isim");
        String isim=scan.nextLine();
        System.out.println("soyisim");
        String soyisim=scan.nextLine();
        System.out.println("Dogum yili");
        String dYili=scan.nextLine();
        System.out.println("okulNo");
        String okulNo=scan.nextLine();
        System.out.println("Sınıf");
        String sinif=scan.nextLine();
        System.out.println("Şube");
        String sube=scan.nextLine();

        String key = tcNo;
        String value= isim+ ", " + soyisim + ", " + dYili+ ", " + okulNo+ ", " + sinif+ ", " + sube;
        ogrenciMap.put(key,value);
    }

    private static void sinifVeSubeIleOgrenciBulma() throws InterruptedException {
        Set<Map.Entry<String,String>> myEntrySet=ogrenciMap.entrySet();
        System.out.println("İstediğiniz sinifini Yazınız : ");
        String istenilenSinif = scan.nextLine();
        System.out.println("İstediğiniz şubesini Yazınız : ");
        String istenilenSube = scan.nextLine();

        System.out.println("============= YILDIZ KOLEJI =============\n" +
                "=========== OGRENCI LISTESI ============\n" +
                "Tc No        Isim   Soyisim   D Yili  Okul No  Sinif  Sube");
        for (  Map.Entry<String,String> each :  myEntrySet ) {

            String eachKey = each.getKey();
            String eachvalue = each.getValue();


            String eachValueArr[]  = eachvalue.split(", ");
            if (istenilenSinif.equalsIgnoreCase(eachValueArr[4])&& istenilenSube.equalsIgnoreCase(eachValueArr[5])){
                System.out.printf("%-12s %-6s %-9s %-7s %-8s %-5s %-2s \n",eachKey,eachValueArr[0],eachValueArr[1],
                        eachValueArr[2],eachValueArr[3], eachValueArr[4],eachValueArr[5]);
            }

        }
        Thread.sleep(5000);
    }

    private static void soyisimdenOgrenciBulma() throws InterruptedException {
        Set<Map.Entry<String,String>> myEntrySet=ogrenciMap.entrySet();
        System.out.println("İstediğiniz Soyisimini Yazınız : ");
        String istenilenSoyisim = scan.nextLine();

        System.out.println("============= YILDIZ KOLEJI =============\n" +
                "=========== OGRENCI LISTESI ============\n" +
                "Tc No        Isim   Soyisim   D Yili  Okul No  Sinif  Sube");
        for (  Map.Entry<String,String> each :  myEntrySet ) {

            String eachKey = each.getKey();
            String eachvalue = each.getValue();


            String eachValueArr[]  = eachvalue.split(", ");
            if (istenilenSoyisim.equalsIgnoreCase(eachValueArr[1])){
                System.out.printf("%-12s %-6s %-9s %-7s %-8s %-5s %-2s \n",eachKey,eachValueArr[0],eachValueArr[1],
                        eachValueArr[2],eachValueArr[3], eachValueArr[4],eachValueArr[5]);
            }

        }
        Thread.sleep(5000);

    }

    private static void ogrenciListeYazdir() throws InterruptedException {

        Set<Map.Entry<String,String>> myEntrySet=ogrenciMap.entrySet();
        System.out.println("============= YILDIZ KOLEJI =============\n" +
                "=========== OGRENCI LISTESI ============\n" +
                "Tc No        Isim   Soyisim   D Yili  Okul No  Sinif  Sube");
        for (  Map.Entry<String,String> each :  myEntrySet ) {

            String eachKey = each.getKey();
            String eachvalue = each.getValue();


            String eachValueArr[]  = eachvalue.split(", ");
            System.out.printf("%-12s %-6s %-9s %-7s %-8s %-5s %-2s \n",eachKey,eachValueArr[0],eachValueArr[1],
                    eachValueArr[2],eachValueArr[3], eachValueArr[4],eachValueArr[5]);

        }
        Thread.sleep(5000);

        }
    }

