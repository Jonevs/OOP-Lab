//JONATHAN EVAN SAMPURNA (2301876612) - OOP Mid Exam
package uts;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class pelanggaran {
    String nama, alamat, nik, jenisKendaraan, tipeKendaraan, telp, email;
    int jenisPelanggaran;
    
    String[][] kamusPelanggaran = {
        {"Menggunakan Gawai/Handphone saat berkendara", "750", "750"},
        {"Tidak memakai helm", "250"}, 
        {"Tidak memakai sabuk pengaman", "250"},
        {"Melanggar rambu lalu lintas dan marka jalan", "500", "500"},
        {"Memakai plat nomor palsu", "500", "500"}
    };
    
    pelanggaran(String i_nama, String i_alamat, String i_nik, String
            i_jenisKendaraan, String i_tipeKendaraan, int i_jenisPelanggaran,
            String i_telp, String i_email) {
        this.nama = i_nama;
        this.alamat = i_alamat;
        this.nik = i_nik;
        this.jenisKendaraan = i_jenisKendaraan;
        this.tipeKendaraan = i_tipeKendaraan;
        this.jenisPelanggaran = i_jenisPelanggaran;
        this.telp = i_telp;
        this.email = i_email;
    }
    
    public void show() {
        getDate();
        System.out.println("Nama Pelanggar: " + nama);
        System.out.println("Jenis Pelanggaran: " + getJenisPelanggaran(jenisPelanggaran));
        getDenda(jenisPelanggaran);
    }
    
    public void cetakSuratTilang() {
        System.out.println("\n\nSURAT TILANG");
        
        getDate();
        
        System.out.println("\nData Pelanggar\n================");
        System.out.println("Nama Pelanggar: " + nama);
        System.out.println("Alamat Pelanggar: " + alamat);
        System.out.println("NIK: " + nik);
        System.out.println("Nomor Telepon: " + telp);
        System.out.println("Email: " + email);
        
        System.out.println("\nKendaraan\n=========");
        System.out.println("Jenis Kendaraan: " + jenisKendaraan);
        System.out.println("Tipe Kendaraan: " +tipeKendaraan);
        
        System.out.println("\nData Pelanggaran\n================");
        System.out.println("Jenis Pelanggaran: " + getJenisPelanggaran(jenisPelanggaran));
        getDenda(jenisPelanggaran);
    }
    
    public void getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Tanggal Pelanggaran: " + dtf.format(now));
    }
    
    public String getJenisPelanggaran(int jenisPelanggaran) {
        if(jenisPelanggaran == 1)
        {
            return(kamusPelanggaran[0][0]);
        }
        
        if(jenisPelanggaran == 2)
        {
            return(kamusPelanggaran[1][0]);
        }
        
        if(jenisPelanggaran == 3)
        {
            return(kamusPelanggaran[2][0]);
        }

        if(jenisPelanggaran == 4)
        {
            return(kamusPelanggaran[3][0]);
        }       
        
        if(jenisPelanggaran == 5)
        {
            return(kamusPelanggaran[4][0]);
        }
        
        return null;
    };
    
    public void getDenda(int jenisPelanggaran) {
        int denda = 0;
        
        switch(jenisPelanggaran)
        {
            case 1:
            {
                denda += 750000;
                break;
            }
            
            case 2:
            {
                denda += 250000;
                break;
            }
            
            case 3:
            {
                denda += 250000;
                break;
            }
            
            case 4:
            {
                denda += 500000;
                break;
            }
            
            case 5:
            {
                denda += 500000;
                break;
            }
        }
        
        System.out.println("Denda Tilang: " + denda);
    }
    
}
