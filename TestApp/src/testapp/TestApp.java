/**
*
* @author Muhammet Talha SAĞLAM - B141210260 , Berkan AYDIN - G141210086 /  b141210260@sakarya.edu.tr
* @since 02.04.2018
* <p>
* TEST sınıfı
* </p>
*/
package testapp;
import java.util.Scanner;
import myPackage.Kisi;
import myPackage.KimlikNo;
import myPackage.IMEINo;
import java.io.*;
/**
 *
 * @author Moonlight
 */
public class TestApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      try{
            
            int secim;
            String path="Kisiler.txt";
            File file = new File(path);
        
        do{
          
            System.out.print("\n 1- Random Kişi Üret \n 2- Üretilmiş dosya kontrol et \n 3- Çıkış \n Seçiminiz : ");
        
            Scanner input = new Scanner(System.in);
            secim = input.nextInt();
        
            int tcSayacGecerli = 0;
            int tcSayacGecersiz = 0;
            int imeiSayacGecersiz = 0;
            int imeiSayacGecerli = 0;
        
          switch(secim)
          {
        
            case 1:
                
                
                FileWriter dosyaYaz = new FileWriter(file.getAbsoluteFile());
                BufferedWriter yaz = new BufferedWriter(dosyaYaz);
                System.out.print("Kaç Adet Üretilsin ? : ");      
                int adet;
                int sayac=0;
                adet = input.nextInt();
                
                while (sayac < adet) 
                {
                    Kisi kisi = new Kisi("random_isimler.txt");
                    yaz.write(kisi.Yazdir());
                    yaz.newLine();
                    sayac++;
                }
                
                yaz.close();
        
               break;
               
                
            case 2:
                 
                FileReader dosyaOku = new FileReader("Kisiler.txt");
                String satir;
                String tcNo;
                String imeiNo;
                String[] satirParcala;

                BufferedReader oku = new BufferedReader(dosyaOku);

                while ((satir = oku.readLine()) != null) {
                    satirParcala = satir.split(" ");
                    tcNo = satirParcala[0];
                    imeiNo = satirParcala[5].substring(1,(satirParcala[5].length())-1); 
                    KimlikNo kimlik = new KimlikNo(tcNo);
                    IMEINo imei = new IMEINo(imeiNo);
                        if(kimlik.tcKimlikKontrolDurum())
                        {
                            tcSayacGecerli++;
                        }
                        else
                            tcSayacGecersiz++;
             
                        if(imei.imeiKontrolDurum())
                        {
                            imeiSayacGecerli++;
                        }
                         else
                            imeiSayacGecersiz++;
    
                }

                oku.close();   
                System.out.println("\nTC Kimlik Kontrol \n" +tcSayacGecerli +"    Geçerli\n"+ tcSayacGecersiz +"    Geçersiz\n");
                System.out.println("IMEI Kontrol \n" +imeiSayacGecerli +"    Geçerli \n" +imeiSayacGecersiz +"    Geçersiz \n");
               
                break;
                
            case 3:
                
                System.exit(0);
                break;
                
            default:
                
                break;
                        
          }
        }
        
        while(secim!=3);
     }
        
           catch(Exception e){
            System.out.println(e);
            }
        
    }
    
}
