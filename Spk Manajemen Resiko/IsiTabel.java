
import java.util.Scanner;

public class IsiTabel {
    UkuranTabel besarTabel = new UkuranTabel();
    Barang databarang = new Barang();

    public int jumlah = besarTabel.jumlah;
    public int untung = databarang.untung;
    public int modal = databarang.produksi;
    public double[] probabilitas = new double[jumlah];
    public int[] pengunjung = new int[jumlah];
    public int[] stock = new int[jumlah];
    public int[][] tabelResiko = new int[jumlah][jumlah];
    public int pendapatan;

    public void BuatTabel(){
        Scanner scan = new Scanner(System.in);
        int i=0;
        while (i<jumlah) {
            System.out.println("Masukkan jumlah pengunjung ke-" + (i+1)+": ");
            pengunjung[i] = scan.nextInt();
            stock[i] = pengunjung[i];
            System.out.println("probabilitas : ");
            probabilitas[i] = scan.nextDouble();
            i++;
        }
        TabelHasil();
        Cetak();
    }
    public void TabelHasil(){
        int a = 0;
        while (a<jumlah) {
            int b = 0;
            while (b<jumlah) {
                if (stock[a] != pengunjung[b]) {
                    if (stock[a] <= pengunjung[b]) {
                        if (stock[a]<pengunjung[b]){
                            tabelResiko[a][b]=untung*stock[a];
                            int gagaluntung = (-1)*(stock[a]-pengunjung[b]);
                            tabelResiko[a][b] = tabelResiko[a][b] - (gagaluntung*untung);
                        }
                    } else {
                        tabelResiko[a][b]=untung*pengunjung[b];
                        var sisa = stock[a]-pengunjung[b];
                        tabelResiko[a][b]=tabelResiko[a][b]-(sisa*modal);
                    }
                } else {
                    tabelResiko[a][b] = untung * pengunjung[b];
                }
                b++;
            }
            a++;
        }
    }
    public void Cetak(){
        System.out.printf("\t");
        {
            int i=0;
            while (i<jumlah) {
                System.out.printf(pengunjung[i]+"\t");
                i++;
            }
        }
        System.out.printf("\n");
        System.out.printf("\t");
        int i=0;
        while (i<jumlah) {
            System.out.printf("("+probabilitas[i]+")\t");
            i++;
        }
        System.out.printf("\n");
        int a = 0;
        while (a<jumlah) {
            System.out.printf(stock[a]+"\t");
            int b =0;
            while (b<jumlah) {
                System.out.printf(tabelResiko[a][b]+"\t");
                b++;
            }
            System.out.printf("\n");
            a++;
        }
    }
}
