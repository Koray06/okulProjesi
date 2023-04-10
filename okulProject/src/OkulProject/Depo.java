package OkulProject;

import java.util.Scanner;

public class Depo {
    static Scanner scan = new Scanner(System.in);
    public static void anamenu() throws InterruptedException {

        String tercih = "";
        do{

        System.out.println("===================KORAY KOLLEJİ=======================\n" +
                "\t===============ANA MENÜ================\n" +
                "\n" +
                "\t    1- Okul Bilgileri Görüntüle \n  " +
                "\t    2- Ogretmen Menu\n" +
                "\t    3- Ogrenci Menu\n" +
                "\t    Q- Çıkış \n");
        System.out.println("Lütfen Menüden Tercihinizi Yapınız : ");
        tercih=scan.nextLine();
        switch (tercih){
            case "1" :// okul bilgileri
                Depo.okulBilgileriniYazdir();
                break;
            case "2" :// Ogretmen menu
                Ogretmen.ogretmenMenu();

                break;
            case "3" :// Ogrenci bilgileri
                Ogrenci.ogrenciMenu();
                break;
            case "q" :// okul bilgileri
            case "Q":
                break;
            default:
                System.out.println("Lütfen Geçerli Bir Tercih Giriniz ?");

        }

        }while (!tercih.equalsIgnoreCase("Q"));
        Depo.projeDurdur();
    }

    public static void okulBilgileriniYazdir() throws InterruptedException {
        System.out.println("===================KORAY KOLLEJİ=======================\n"+
                "\t\t Adres : " + Okul.adres +
                "\n\t\t Telofon : " + Okul.telefon);
        Thread.sleep(5000);

    }

    public static void projeDurdur() {
        System.out.println("Okul Projesinden Çıktınız. ");
        System.exit(0);
    }
}
