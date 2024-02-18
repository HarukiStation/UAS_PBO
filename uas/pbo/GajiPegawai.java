package uas.pbo;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;
import uas.pbo.Absensi;

public class GajiPegawai {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();


        String nama;
        int[] tunak = new int[2];
        int gol, jmasuk, jkeluar, jlembur, gapok, transport, tun_istri, tun_anak,  jpot;
        double gajibersih, gtun_istri, gpot, gtun_anak, glembur ;

        tun_anak = 0;
        gtun_anak = 0;
        jpot = 0;
        gpot = 0;

        System.out.println("PROGRAM MENGHITUNG GAJI KARYAWAN");
        System.out.println("-------------------------------------------------");

        System.out.print("Masukan Nama : ");
        nama=input.next();
        System.out.println("Pilih Jabatan : ");
        System.out.println("1. SPV (Supervisor) ");
        System.out.println("2. HRD (HRD) ");
        System.out.println("3. TKN (Teknisi) ");
        System.out.println("4. KRY (Karyawan) ");
        System.out.print("Pilihan Anda : ");
        gol=input.nextInt();
        System.out.println("Punya Istri ? ");
        System.out.println("1. Ya ");
        System.out.println("2. Tidak ");
        System.out.print("Pilihan Anda : ");
        tun_istri=input.nextInt();

        if (tun_istri == 1 ){
            System.out.println("Punya Anak ? ");
            System.out.println("0. Tidak ");
            System.out.println("1. Ya (satu orang) ");
            System.out.println("2. Ya (lebih dari 1) ");
            System.out.print("Pilihan Anda : ");
            tun_anak = input.nextInt();
        }

        System.out.print("Masukan Jam Kerja : ");
        jmasuk=input.nextInt();
        System.out.print("Masukan Jam Keluar : ");
        jkeluar=input.nextInt();

        jlembur = 0;
        if ((jmasuk < 7) || (jkeluar > 16) ){
            jlembur = (7 - jmasuk) + (jkeluar - 16) ;
        }
        //System.out.print("Jumlah Lembur  : "+jlembur);
        Lembur lembur = new Lembur(gol, jlembur);
        glembur = (int) lembur.hitungLembur(gol,jlembur);

        switch(gol){
            case 1 : 
                gapok=10000000;
                transport=1000000;
                gtun_istri=300000;
                tunak[0] = 100000;
                tunak[1] = 200000;                        
                break;
            case 2 :
                gapok=5000000;
                transport=750000;
                gtun_istri=250000;
                tunak[0] = 90000;
                tunak[1] = 190000;
                break;
            case 3 :
                gapok=3000000;
                transport=500000;
                gtun_istri=200000;
                tunak[0] = 75000;
                tunak[1] = 150000;
                break;
            case 4 :
                gapok=1500000;
                transport=250000;
                gtun_istri=200000;
                tunak[0] = 60000;
                tunak[1] = 130000;
                break;
            default :
                gapok=0;
                transport=0;
                gtun_istri=0;
                tunak[0] = 0;
                tunak[1] = 0;
        }

        if (tun_istri == 2){
            gtun_istri = 0;
        }

        if (tun_anak == 1){
            gtun_anak = tunak[0];
        } else if (tun_anak == 2){
            gtun_anak = tunak[1];
        }

        if (jmasuk > 7 || jkeluar < 16 ){
            jpot = (jmasuk - 7) + (16 - jkeluar ) ;
            gpot = jpot * 100000;
        }

            
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);

        gajibersih=((gapok+transport+glembur+gtun_istri+gtun_anak)-gpot);

        System.out.println("=============================================");
        System.out.println("                 STRUK GAJI");
        System.out.println("=============================================");
        System.out.println("Nama Pegawai       : "+nama);
        System.out.println("Gaji Pokok         : "+ kursIndonesia.format(gapok));
        System.out.println("Uang Transport     : "+ kursIndonesia.format(transport) );
        System.out.println("Uang Lembur        : "+ kursIndonesia.format(glembur));
        System.out.println("Tunjangan Istri    : "+ kursIndonesia.format(gtun_istri));
        System.out.println("Tunjangan Anak     : "+ kursIndonesia.format(gtun_anak));
        System.out.println("Potongan           : "+ kursIndonesia.format(gpot));
        System.out.println("---------------------------------");
        System.out.println("Gaji Diterima    : "+ kursIndonesia.format(gajibersih));
    }    
}
