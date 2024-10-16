package aplikasipenyewaanmobildanmotor;

import java.util.Scanner;

public class main {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        while (true){
            tampilkanMenu();
            int pilih = input.nextInt();
            switch (pilih){
                case 1:
                    admin.bukaMenu();
                    break;
                case 2:
                    customer.bukaMenu();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Menu Yang Anda Masukan Tidak Tersedia !!");
                    break;
            }
        }
    }

    private static void tampilkanMenu() {
        System.out.println("SELAMAT DATANG DI APLIKASI PENYEWAAN KENDARAAN \n");
        System.out.println("1.Masuk Sebagai Admin");
        System.out.println("2.Masuk Sebagai Pelanggan");
        System.out.println("3.Keluar Aplikasi");
        System.out.print("Masukan Pilihan Anda : ");
    }

}
