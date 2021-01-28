/**
*
* @author Muhammet Talha SAĞLAM - B141210260 , Berkan AYDIN - G141210086 /  b141210260@sakarya.edu.tr
* @since 02.04.2018
* <p>
* Rastgele IMEI numarası oluturan ve IMEI numarası kontrolü yapan sınıf.
* </p>
*/
package myPackage;
import java.util.Random;

/**
 *
 * @author Moonlight
 */
public class IMEINo {
    
    private String imei ="";
    private boolean imeiNoKontrol;
    private final static int IMEI_UZUNLUK = 15;
    
    public IMEINo()
    {
        imeiNoUret();
       
    }
    
    public IMEINo(String imeiNo)
    {
        imeiKontrol(imeiNo);
       
    }
    
    private void imeiNoUret()
    {
        int toplam=0;
        int[] imeiNo = new int[IMEI_UZUNLUK];
        Random randomSayi = new Random();
        for(int i=0;i<14;i++)
        {
            imeiNo[i]=randomSayi.nextInt(10); 
        }
     
        for(int i=0;i<14;i++)
        {
            if(i%2==0)
            {
                toplam+=imeiNo[i];
            }
         
            else
            {    
                int gecici= imeiNo[i]*2;
                     
                while(gecici >0)
                {
                
                    toplam += gecici %10;
                    gecici = gecici/10;
                
                }
            }
        }
     
        
        int imeiRakam15= (10 - (toplam%10))%10;
        imeiNo[14]= imeiRakam15;
     
        for(int i=0;i<15;i++)
        {
            imei = imei + String.valueOf(imeiNo[i]);
        }
      
    }
    
    public String imeiNoGetir(){
        
        return imei;
    
    }
    
    private void imeiKontrol(String imeiNo) {

        int toplam = 0;
        String sRakam="";
        int iRakam=0;
        int genelToplam=0;
        String sKontrolRakam="";
        int iKontrolRakam=0;
        
        if(imeiNo.length()==IMEI_UZUNLUK)
        {
        for(int i = 0;i<=13;i++) {
            
            if(i%2 ==0)
            {
                
            sRakam = imeiNo.substring(i,i+1);
            iRakam = Integer.valueOf(sRakam);
            toplam+= iRakam;
             
            }
            
            else
            {
                
            sRakam = imeiNo.substring(i,i+1);
            iRakam = Integer.valueOf(sRakam);
            iRakam=iRakam*2;
            
              while(iRakam >0)
              {
                
               toplam += iRakam %10;
               iRakam = iRakam/10;
                
              }
            }
        }
        
        sKontrolRakam = imeiNo.substring(14,15);
        iKontrolRakam = Integer.valueOf(sKontrolRakam);
        genelToplam = toplam+iKontrolRakam;
        
        imeiNoKontrol = genelToplam%10 ==0;
        }
        
        else
        imeiNoKontrol = false;

    }
   
    public boolean imeiKontrolDurum() 
    {
        return imeiNoKontrol;
    }
    
    
}
