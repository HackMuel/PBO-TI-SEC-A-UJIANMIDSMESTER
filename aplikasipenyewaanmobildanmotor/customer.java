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

}
