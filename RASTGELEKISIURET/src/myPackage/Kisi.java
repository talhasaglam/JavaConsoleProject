/**
*
* @author Muhammet Talha SAĞLAM - B141210260 , Berkan AYDIN - G141210086 /  b141210260@sakarya.edu.tr
* @since 02.04.2018
* <p>
* Kişi sınıfı
* </p>
*/
package myPackage;

/**
 *
 * @author Moonlight
 */
public class Kisi {
    
    private final KimlikNo TC ;
    private final String adSoyad;
    private final int yas;
    private final Telefon telefon;
   
    public Kisi (String dosyaAdi){
        
        KimlikNo kimlik = new KimlikNo();
        TC = kimlik;
        RastgeleKisi randomKisi  = new RastgeleKisi(dosyaAdi);
        adSoyad= randomKisi.kisiGetir();
        Telefon tlf = new Telefon();
        telefon = tlf;
        yas = randomKisi.YasGetir();
        
    }

    public String Yazdir(){
      
        String kisi =TC.tcKimlikNoGetir()+" "+adSoyad+" "+yas+" "+telefon.telefonNoGetir()+" ("+telefon.imeiNoGetir()+")";  
        return kisi;
    
    }
         
    
}
