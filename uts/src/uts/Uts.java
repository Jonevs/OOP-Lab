//JONATHAN EVAN SAMPURNA (2301876612) - OOP Mid Exam
package uts;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;


public class Uts {
    
    static Scanner read = new Scanner(System.in);
    
    static ArrayList<pelanggaran> listPelanggaran = new ArrayList<>();
    
    static boolean isLogin = false;
    
    public static void pressAnyKey() { 
        System.out.print("\nPress any key to continue...");
        try
        {
            System.in.read();
        }  
        catch(IOException e)
        {

        }  
    }
    
    public static void menu() {
        System.out.println("=======================================\n"
                + "|      E-TILANG KOTA WARNA WARNI      |"
                + "\n=======================================");
        System.out.println("dikelola Kepolisian Kota Warna Warni\n\n");
        System.out.println("1.Login\n2.Pendataan Pelanggaran\n3.Melihat "
                + "Pelanggaran\n4.Menampilkan Surat Tilang\n5.Logout");
        System.out.print("\nPilihan: ");
    }
    
    public static void login() {
        String username, password;
        
        if(isLogin == true)
        {
            System.out.println("Login berhasil!");
            pressAnyKey();
        }
        
        else
        {
            System.out.print("Masukkan username: ");
            username = read.next();

            System.out.print("Masukkan password: ");
            password = read.next();

            System.out.println("Selamat datang " + username);
            
            isLogin = true;
            pressAnyKey();            
        }
    }
    
    public static void addPelanggaran() {
        if(isLogin == false)
        {
            System.out.println("Login terlebih dahulu!");
            pressAnyKey();
        }
        
        else
        {
            String i_nama, i_alamat, i_nik, i_jenisKendaraan, 
                    i_tipeKendaraan, i_email, i_telp;
            int i_jenisPelanggaran;
            
            System.out.println("Pendataan Pelanggaran"
                    + "\n=====================\n");
            
            System.out.print("Nama: ");
            i_nama = read.next();
            System.out.print("\n");

            System.out.print("Alamat: ");
            i_alamat = read.next();
            System.out.print("\n");

            System.out.print("NIK: ");
            i_nik = read.next();
            System.out.print("\n");

            System.out.print("Jenis Kendaraan: ");
            i_jenisKendaraan = read.next();
            System.out.print("\n");

            System.out.print("Tipe Kendaraan: ");
            i_tipeKendaraan = read.next();
            System.out.println("\n");

            do
            {
                System.out.print("Jenis Pelanggaran: ");
                i_jenisPelanggaran = read.nextInt();
                System.out.print("\n");                
            }while(i_jenisPelanggaran<1 || i_jenisPelanggaran>5);

            System.out.print("Nomor Telepon: ");
            i_telp = read.next();
            System.out.print("\n");

            System.out.print("Email: ");
            i_email = read.next();
            System.out.print("\n");

            pelanggaran pelanggaran = new pelanggaran(i_nama, i_alamat, i_nik, 
            i_jenisKendaraan, i_tipeKendaraan, i_jenisPelanggaran, i_telp, i_email);

            listPelanggaran.add(pelanggaran);
            
            System.out.println("Data Tersimpan!");

            pressAnyKey();            
        }
    }
    
    public static void viewPelanggaran() {
        if(isLogin == false)
        {
            System.out.println("Login terlebih dahulu!");
            pressAnyKey();
        }

        else
        {
            if(listPelanggaran.isEmpty())
            {
                System.out.println("Belum ada data pelanggaran");
                pressAnyKey();
                return;
            }

            for(int i = 0; i < (listPelanggaran.size()); i++)
            {
                System.out.println("\nNomor " + (i+1) + "\n===========");
                listPelanggaran.get(i).show();
            }    

            pressAnyKey();            
        }
        
    }
    
    public static void suratTilang() {
        if(isLogin == false)
        {
            System.out.println("Login terlebih dahulu!");
            pressAnyKey();
        }
        
        else
        {
            if(listPelanggaran.isEmpty())
            {
                System.out.println("Belum ada data pelanggaran");
                pressAnyKey();
                return;
            }

            for(int i = 0; i < (listPelanggaran.size()); i++)
            {
                System.out.println("\nNomor " + (i+1) + "\n===========");
                listPelanggaran.get(i).show();
            }    

        int input;
        
        if(listPelanggaran.size() == 1)
        {
            System.out.print("\nCetak[" + listPelanggaran.size() + "..1]: ");
        }
        
        else
        {
            System.out.print("\nCetak[1.." + listPelanggaran.size() + "]: ");
        }
        
        input = read.nextInt();
        
        for(int j = 0; j < listPelanggaran.size(); j++)
        {
            if(input - 1 == j)
            {
                listPelanggaran.get(j).cetakSuratTilang();
            }
        }
        
        pressAnyKey();
        }
    }
    
    public static void main(String[] args) {
        int choice;
        try
        {
            do
            {
                menu();

                choice = read.nextInt();

                switch(choice)
                {
                    case 1:
                    {
                        login();
                        break;
                    }

                    case 2:
                    {
                        addPelanggaran();
                        break;
                    }

                    case 3:
                    {
                        viewPelanggaran();
                        break;
                    }

                    case 4:
                    {
                        suratTilang();
                        break;
                    }
                }            
            }while(choice != 5);            
        }
        
        catch(Exception e)
        {
            System.out.println("ERROR! Perhatikan apa yang diinput");
        }


    }
    
}
