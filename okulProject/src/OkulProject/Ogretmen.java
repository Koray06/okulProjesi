package OkulProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Ogretmen {
    static Scanner scan = new Scanner(System.in);
    static Map<String,String> ogretmenlerMap= new HashMap<>();
    public static void feykOgretmenEkle() {
        ogretmenlerMap.put("12345678912","Ali, CAN, 1980, Matematik");
        ogretmenlerMap.put("98765432109","Veli, YAN, 1981, Fizik");
        ogretmenlerMap.put("89767545633","Ayşe, CAN, 1982, Kimya");
        ogretmenlerMap.put("23456789876","Ali, SAN, 1983, Kimya");
        ogretmenlerMap.put("34256787543","Alp, YAN, 1984, Matematik");
    }

    public static void ogretmenMenu() throws InterruptedException {
        String tercih = "";

        do{

            System.out.println("===================KORAY KOLEJİ=======================\n" +
                    "\t===============ÖĞRETMEN MENÜ================\n" +
                    "\n" +
                    "\t    1- Öğretmen Listesi Yazdır \n  " +
                    "\t    2- Soyisimden Öğretmen Bulma\n" +
                    "\t    3- Branştan Öğretmen Bulma\n" +
                    "\t    4- Bilgilerini Girerek Öğretmen Ekleme\n" +
                    "\t    5- Kimlik No ile Kayıt Silme\n" +
                    "\t    A- ANA MENU\n" +
                    "\t    Q- ÇIKIŞ\n");
            tercih=scan.nextLine();

            switch (tercih){

                case "1" : // Öğretmen Listesi Yazdır

                    ogretmenListesiYazdir();
                    break;
                case "2" : //Soyisimden Öğretmen Bulma

                    soyisimdenOgretmenBulma();

                    break;
                case "3" :  //Branştan Öğretmen Bulma
                    branstanOgretmenBulma();
                    break;
                case "4" :  //Bilgilerini Girerek Öğretmen Ekleme
                    ogretmenEkleme();
                    break;
                case "5" :  // Kimlik No ile Kayıt Silme
                    tcNoileOgretmenSil();
                    break;
                case "a" :
                case "A" :
                    Depo.anamenu();
                    break;
                case "q" :
                case "Q" :
                    break;
                default:
                    System.out.println("Lütfen geçerli tercih yapınız !");
            }

        }while (!tercih.equalsIgnoreCase("q"));
        Depo.projeDurdur();
    }

    public static void tcNoileOgretmenSil() {
        System.out.println("Silinecek Öğretmen Kimlik Numarasını Girin :");
        String silinecekOgretmen= scan.nextLine();

        String silinecekValue= ogretmenlerMap.get(silinecekOgretmen);

        String sonucValue=ogretmenlerMap.remove(silinecekOgretmen);
        try {
            boolean sonuc = sonucValue.equals(sonucValue);
        } catch (Exception e) {
            System.out.println("istediğiniz TC numarası ile öğretmen bulunamadı");
        }
    }

    public static void ogretmenEkleme() {
        System.out.println("Tc no");
        String tcNo=scan.nextLine();
        System.out.println("isim");
        String isim=scan.nextLine();
        System.out.println("soyisim");
        String soyisim=scan.nextLine();
        System.out.println("Dogum yili");
        String dYili=scan.nextLine();
        System.out.println("Brans");
        String brans=scan.nextLine();

        String eklenecekValue= isim + ", " + soyisim+ ", " + dYili+ ", " + brans;
        ogretmenlerMap.put(tcNo, eklenecekValue);

    }

    public static void branstanOgretmenBulma() throws InterruptedException {
        System.out.println("Öğretmenin Branşını Giriniz :");
        String istenenBrans = scan.nextLine();
        Set<Map.Entry<String,String>> ogretmenEntrySet= ogretmenlerMap.entrySet();
        System.out.println("===================KORAY KOLEJİ=======================\n" +
                "\t==========BRANŞ İLE ÖĞRETMEN ARAMA============\n"+
                "Tc NO       Isim  Soyisim  D.Yılı  Branş");

        for ( Map.Entry<String,String>each :  ogretmenEntrySet ) {

            String eachKey = each.getKey();
            String eachvalue = each.getValue();

            String eachValuearr[]= eachvalue.split(", ");
            if (istenenBrans.equalsIgnoreCase(eachValuearr[3])){
                System.out.printf("%11s %-6s %-8s %4s  %s \n", eachKey,eachValuearr[0],eachValuearr[1],
                        eachValuearr[2],eachValuearr[3]);
            }


        }
        Thread.sleep(5000);
    }

    public  static void soyisimdenOgretmenBulma() throws InterruptedException {
        System.out.println("Öğretmenin Soyisimini Giriniz :");
        String istenenSoyisim = scan.nextLine();
        Set<Map.Entry<String,String>> ogretmenEntrySet= ogretmenlerMap.entrySet();
        System.out.println("===================KORAY KOLEJİ=======================\n" +
                "\t==========SOYİSİM İLE ÖĞRETMEN ARAMA============\n"+
                "Tc NO       Isim  Soyisim  D.Yılı  Branş");

        for ( Map.Entry<String,String>each :  ogretmenEntrySet ) {

            String eachKey = each.getKey();
            String eachvalue = each.getValue();

            String eachValuearr[]= eachvalue.split(", ");
          if (istenenSoyisim.equalsIgnoreCase(eachValuearr[1])){
              System.out.printf("%11s %-6s %-8s %4s %s \n", eachKey,eachValuearr[0],eachValuearr[1],
                      eachValuearr[2],eachValuearr[3]);
          }


        }
        Thread.sleep(5000);
    }

    public static void ogretmenListesiYazdir() throws InterruptedException {
       Set<Map.Entry<String,String>> ogretmenEntrySet= ogretmenlerMap.entrySet();
        System.out.println("===================KORAY KOLEJİ=======================\n" +
                "\t===============ÖĞRETMEN LİSTESİ================\n"+
                "Tc NO       Isim  Soyisim  D.Yılı  Branş");

        for (Map.Entry<String,String> each: ogretmenEntrySet
        ) {
            String eachKey=each.getKey();
            String eachValue=each.getValue();

            String eachValuarr[]=eachValue.split(", ");
            System.out.printf("%11s %-6s  %-8s %4s    %s \n" , eachKey,eachValuarr[0],eachValuarr[1],
                    eachValuarr[2],eachValuarr[3]);
        }
        Thread.sleep(5000);
    }
}
