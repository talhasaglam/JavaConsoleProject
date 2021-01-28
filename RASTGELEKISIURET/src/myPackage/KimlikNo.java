/**
*
* @author Muhammet Talha SAĞLAM - B141210260 , Berkan AYDIN - G141210086 /  b141210260@sakarya.edu.tr
* @since 02.04.2018
* <p>
* Rastgele TC kimlik numarası oluşutran ve TC kimlik kontrolu yapmayı sağlayan sınıf
* </p>
*/
package myPackage;
import java.util.Random;
/**
 *
 * @author Moonlight
 */
public class KimlikNo {
    
    private String kimlikNo="";
    private boolean tcKimlikNoKontrol;
    private final static int TC_UZUNLUK = 11;
    
    public KimlikNo()
    {
        tcKimlikNoUret();
    
    }
    
    public KimlikNo(String tcKimlikNo)
    {
        tcKimlikKontrol(tcKimlikNo);
     
    }
    
    private void tcKimlikNoUret()
    {
    
        int ciftIndekslerToplami =0;
        int tekIndekslerToplami =0;
        int[] tcKimlik = new int[TC_UZUNLUK];
        Random randomSayi = new Random();
        tcKimlik[0]= randomSayi.nextInt(9)+1;

        for(int i=1;i<9;i++)
        {
            tcKimlik[i]=randomSayi.nextInt(10);
        }
    
        for (int i=0;i<9;i++)
        { 
            if(i%2 ==0)
        
                ciftIndekslerToplami += tcKimlik[i];
    
            else
        
                tekIndekslerToplami += tcKimlik[i];    

        }
        
        int gecici = ciftIndekslerToplami * 7 ;
        int gecici2 = gecici - tekIndekslerToplami;
        int tcRakam10 = gecici2 %10;
        tcKimlik[9]= tcRakam10;
        int tcRakam11=0;

        for(int i=0;i<10;i++)
        {
            tcRakam11+= tcKimlik[i];
        }
            tcRakam11= tcRakam11 % 10;
            tcKimlik[10]=tcRakam11;

        for(int i=0;i<11;i++)
        {
            kimlikNo = kimlikNo + String.valueOf(tcKimlik[i]);
        }
    
    }
    
    public String tcKimlikNoGetir()
    {
        return kimlikNo;
    }
    
  private void tcKimlikKontrol(String tcKimlikNo)
  {
      
        String sRakam="";
        int iRakam=0;
        int ciftIndekslerToplami = 0;
        int tekIndekslerToplami = 0;
        int toplam = 0;
        String sBirinciRakam = tcKimlikNo.substring(0,1);
        int iBirinciRakam = Integer.valueOf(sBirinciRakam);
 
        if (tcKimlikNo.length()!= TC_UZUNLUK || iBirinciRakam == 0)
        {
            tcKimlikNoKontrol= false;
        }
        else
        { 
            
            String sRakam10 = tcKimlikNo.substring(9,10);
            int tcRakam10 = Integer.valueOf(sRakam10);
            String sRakam11 = tcKimlikNo.substring(10,11);
            int tcRakam11 = Integer.valueOf(sRakam11);
 
            for (int i = 0; i < 9; i++)
            {
                sRakam = tcKimlikNo.substring(i,i+1);
                iRakam = Integer.valueOf(sRakam);
                    if (i % 2 == 0)
                        ciftIndekslerToplami += iRakam;
                    else
                        tekIndekslerToplami += iRakam;
 
                toplam += iRakam;
            }
 
            int yeniTcRakam10 = ((ciftIndekslerToplami * 7) - tekIndekslerToplami) % 10;
 
            tcKimlikNoKontrol = (tcRakam10 == yeniTcRakam10) && (tcRakam11 == (toplam + yeniTcRakam10) % 10);
    }
  }
  
   public boolean tcKimlikKontrolDurum()
   {
        return tcKimlikNoKontrol;
   }
    
}
