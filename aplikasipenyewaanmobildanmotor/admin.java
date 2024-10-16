package aplikasipenyewaanmobildanmotor;

public class admin {
    private static void menuTambahDataKendaraan(){
        dataKendaraan dataBaru = new dataKendaraan();
        masukanDataKendaraan(dataBaru);
        kendaraan.add(dataBaru);
    }

    private static void menuHapusDataKendaraan(){
        if (!apakahDataKosong()){
            tampilkanDataKendaraan();
            System.out.print("Masukan Baris Data Kendaraan Yang Ingin Di Hapus : ");
            int indexData = input.nextInt() -1;
            hapusDataKendaraan(indexData);
        }
    }

    private static void menuEditDataKendaraan(){
        if (!apakahDataKosong()){
            dataKendaraan dataBaru = new dataKendaraan();
            tampilkanDataKendaraan();
            System.out.print("Masukan Baris Data Kendaraan Yang Ingin Di Edit : ");
            int indexData = input.nextInt() -1;
            if (apakahBarisTersedia(indexData)){
                masukanDataKendaraan(dataBaru);
                kendaraan.set(indexData,dataBaru);
            }
        }
    }

    private static void masukanTipeKendaraan(dataKendaraan dataBaru) {
        System.out.print("Masukan Tipe Kendaraan (motor / mobil) : ");
        if(input.next().equals("motor") ){
            dataBaru.apakahMotor = true;
        }else{
            dataBaru.apakahMotor = false;
        }
    }

    private static void tampilkanDataPelanggan(){
        if (!apakahDataKosong()){
            int counter = 1;
            System.out.println("No.\tNama\tNamaKendaraan\tTipe\tNomorPlat\tHarga\tStatusPembayaran\tStatusPengembalian");
            for (dataCustomer data : customer.pelanggan){
                System.out.println(counter + ".\t" + data.nama + "\t\t" + kendaraan.get(data.indexBarisData).nama + "\t\t" + tentukanTipe(kendaraan.get(data.indexBarisData).apakahMotor) +
                        "\t" + kendaraan.get(data.indexBarisData).nomorPlat + "\tRp." + kendaraan.get(data.indexBarisData).harga + "\t" + apakahSudahDibayar(data.statusPembayaran) +
                        "\t\t" + apakahSudahDiKembalikan(data.statusPengembalian));
                counter++;
            }
        }
    }

    private static boolean apakahDataKosong(){
        if(kendaraan.isEmpty()){
            System.out.println("Data Masih Kosong !!");
            return true;
        }
        return false;
    }

    private static String apakahSudahDiKembalikan(boolean statusPengembalian){
        if(!statusPengembalian){
            return "Belum Di Kembalikan";
        }
        return "Sudah Di Kembalikan";
    }

    private static String apakahSudahDibayar(boolean statusPembayaran){
        if (!statusPembayaran){
            return "Belum Di Bayar";
        }
        return "Sudah Di Bayar";
    }

    public static void tampilkanDataKendaraan(){
        if (!apakahDataKosong()){
            int counter = 1;
            System.out.println("No.\tNama\tTipe\tNomorPlat\tHarga\tStatus");
            for (dataKendaraan data : kendaraan){
                System.out.println(counter + "\t" + data.nama + "\t" + tentukanTipe(data.apakahMotor) + "\t" + data.nomorPlat + "\tRp." + data.harga + "\t" + apakahSedangDiSewa(data.statusPenyewaan));
                counter++;
            }
        }
    }

    public static ArrayList<dataKendaraan>kendaraan = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void bukaMenu(){
        while (true){
            tampilkanMenu();
            int pilih = input.nextInt();
            switch (pilih){
                case 1:
                    menuTambahDataKendaraan();
                    break;
                case 2:
                    menuEditDataKendaraan();
                    break;
                case 3:
                    menuHapusDataKendaraan();
                    break;
                case 4:
                    tampilkanDataKendaraan();
                    break;
                case 5:
                    tampilkanDataPelanggan();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Menu Yang Anda Masukan Tidak Tersedia !!");
                    break;
            }
        }
    }



}



