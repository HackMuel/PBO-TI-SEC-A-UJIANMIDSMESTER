package aplikasipenyewaanmobildanmotor;

public class customer {
    private static void login(){
        public static ArrayList<dataCustomer>pelanggan = new ArrayList<>();
        private static ArrayList<dataAkun> kumpulanAkunPelanggan = new ArrayList<>();
        private static dataAkun dataCurrentPelanggan = new dataAkun();
        private static dataCustomer dataSewaCurrentPelanggan = new dataCustomer();

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

    private static void tulisKeteranganPenyewaan(){
        if(dataSewaCurrentPelanggan.indexBarisData != -1){
            System.out.println("\tAnda Sedang Menyewa : " + admin.kendaraan.get(dataSewaCurrentPelanggan.indexBarisData).nama + " (" + admin.kendaraan.get(dataSewaCurrentPelanggan.indexBarisData).nomorPlat + "),Seharga :Rp." + admin.kendaraan.get(dataSewaCurrentPelanggan.indexBarisData).harga + "\n");
        }else {
            System.out.println("\tAnda Masih Belum Memesan !! \n");
        }
    }
    private static void tampilkanMenuPelanggan(){
        System.out.println("SELAMAT DATANG DI MENU PELANGGAN\n");
        System.out.println("\tHalo, " + dataCurrentPelanggan.nama);
        tulisKeteranganPenyewaan();
        System.out.println("1.Sewa Kendaraan");
        System.out.println("2.Edit Kendaraan Yang Di Sewa");
        System.out.println("3.Cancel Penyewaan");
        System.out.println("4.CheckOut");
        System.out.println("5.Kembalikan Kendaraan");
        System.out.println("6.Logout");
        System.out.print("Masukan Pilihan Anda : ");
    }

    private static void daftarPelanggan(){
        dataAkun dataAkunBaru = new dataAkun();
        System.out.print("Masukan Nama Anda : ");
        input.nextLine();
        dataAkunBaru.nama = input.nextLine();
        System.out.print("Masukan Password Anda : ");
        dataAkunBaru.password = input.nextLine();
        kumpulanAkunPelanggan.add(dataAkunBaru);
    }


}
