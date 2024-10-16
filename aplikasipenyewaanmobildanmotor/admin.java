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

}



