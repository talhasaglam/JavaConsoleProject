/**
*
* @author Muhammet Talha SAĞLAM - B141210260 , Berkan AYDIN - G141210086 /  b141210260@sakarya.edu.tr
* @since 02.04.2018
* <p>
* Rastgele kişi oluşturan ve rastgele yaş oluşturan sınıf
* </p>
*/
package myPackage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Moonlight
 */
public class RastgeleKisi {
    
    private String adSoyad="";
    private int yas=0;
    
    public RastgeleKisi(String dosyaAdi){
        
        randomKisiuret(dosyaAdi);      
        yasUret();
    }
    
    private void randomKisiuret(String dosyaAdi)
    {
   
        List<String> kisiler = new ArrayList<>();
        String dosyaninAdi = dosyaAdi;
        String satir="";
        int rastgeleKisiIndeks= 0;
        FileReader fileReader = null;
     
        try {
            
            fileReader = new FileReader(dosyaninAdi);
            
        } catch (FileNotFoundException ex) {
            
            Logger.getLogger(RastgeleKisi.class.getName()).log(Level.SEVERE, null, ex);
            
        }

       try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
           
           while ((satir = bufferedReader.readLine()) != null) {
               
               kisiler.add(satir);
           }
           
            Random rand = new Random();
            rastgeleKisiIndeks = rand.nextInt(kisiler.size());
            adSoyad =kisiler.get(rastgeleKisiIndeks);
     
       } catch (IOException ex) {   
             Logger.getLogger(RastgeleKisi.class.getName()).log(Level.SEVERE, null, ex);
         }   
       
    }
    
    public String kisiGetir()
    {
        return adSoyad;
    }
    
     private void yasUret()
    {
        Random rand = new Random();
        yas = rand.nextInt(100);
       
    }
     
     public int YasGetir()
     {
         return yas;
     }
    
}
