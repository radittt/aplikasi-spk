
import java.util.Scanner;
import java.util.*;

public class Barang {
    static int produksi,penjualan,untung;
    
    public void dataBarang(){
        
        Scanner scan = new Scanner(System.in);

        System.out.println("Program Manajemen Resiko \n");
        System.out.println("Masukkan harga produksi per unit ");
        produksi = scan.nextInt();
        
        System.out.println("Masukkan harga jual per unit: ");
        penjualan = scan.nextInt();
        
        untung = penjualan-produksi;
        
        System.out.println("keuntungan : " + untung);
    }
}
