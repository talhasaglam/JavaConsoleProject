/**
*
* @author Muhammet Talha SAĞLAM - B141210260 , Berkan AYDIN - G141210086 /  b141210260@sakarya.edu.tr
* @since 02.04.2018
* <p>
* Rastgele Telefon numarası oluşturan Sınıf.
* </p>
*/
package myPackage;
import java.util.Random;

/**
 *
 * @author Moonlight
 */
public class Telefon {
    
    private String telefonNo;
    private String imeiNo="";
    
    public Telefon(){
        
        IMEINo imei = new IMEINo();
        imeiNo = imei.imeiNoGetir();
        telefonNoUret();

    }
    
    private void telefonNoUret(){
        
        Random rand = new Random();
        int iNumara = rand.nextInt(89999999) + 10000000;
        String sNumara = String.valueOf(iNumara);
        telefonNo = "053"+ sNumara;
   
    }
    
    public String telefonNoGetir(){
        
        return telefonNo;
    }
    
     public String imeiNoGetir(){
        
        return imeiNo;
    }
    
}
