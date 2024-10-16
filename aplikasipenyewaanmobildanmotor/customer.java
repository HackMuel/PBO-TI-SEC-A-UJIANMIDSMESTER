package aplikasipenyewaanmobildanmotor;

public class customer {
    private static void login(){
        if(!kumpulanAkunPelanggan.isEmpty()){
            System.out.print("Masukan Nama Anda : ");
            input.nextLine();
            String nama = input.nextLine();
            System.out.print("Masukan Password : ");
            String password = input.nextLine();

            if(apakahPasswordDanNamaValid(nama,password)){
                dataCurrentPelanggan.nama = nama;
                dataCurrentPelanggan.password = password;
                menuPenyewaan();
            }else {
                System.out.println("Nama / Password Yang Anda Masukan Salah !!");
            }
        }else{
            System.out.println("Data Akun Masih Kosong Mohon Mendaftar Terlebih Dahulu !!");
        }
    }

    private static void sewaKendaraan(){
        admin.tampilkanDataKendaraan();
        System.out.print("Masukan Baris Data Kendaraan Yang Ingin Anda Sewa : ");
        int index = input.nextInt() -1;
        if(admin.kendaraan.get(index).statusPenyewaan == false){
            dataSewaCurrentPelanggan.indexBarisData = index;
        }else {
            System.out.println("Kendaraan Tidak Tersedia !!");
        }

    }

    private static void cancelPenyewaan(){
        dataSewaCurrentPelanggan.indexBarisData = -1;
    }

    private static int cariNomorBarisPelanggan(){
        int index = 0;
        for (dataCustomer data : pelanggan){
            if(data.nama == dataCurrentPelanggan.nama){
                return index;
            }
            index++;
        }
        return -1;
    }

    private static void ubahSewaKendaraan(){
        cancelPenyewaan();
        sewaKendaraan();
    }

    private static void menuCheckout() {
        System.out.print("Apakah Anda Ingin Checkout (y/n) : ");
        if (input.next().equals("y")){
            checkout();
            admin.kendaraan.get(dataSewaCurrentPelanggan.indexBarisData).statusPenyewaan = true;
        }
    }

    private static void menuPenyewaan(){
        while (true){
            tampilkanMenuPelanggan();
            int pilihan = input.nextInt();
            switch (pilihan){
                case 1:
                    sewaKendaraan();
                    break;
                case 2:
                    ubahSewaKendaraan();
                    break;
                case 3:
                    cancelPenyewaan();
                    break;
                case 4:
                    menuCheckout();
                    break;
                case 5:
                    kembalikanKendaraan();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Menu Yang Anda Pilih Tidak Tersedia !!");
                    break;
            }
        }
    }

}
