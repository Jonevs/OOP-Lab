//JONATHAN EVAN SAMPURNA (2301876612) - OOP Lab Week 4
package week4lab;
import java.util.Scanner;

public class Week4lab {

    public static void main(String[] args) {
        int choice;
        String par = null;
        Scanner read = new Scanner(System.in);
   
        do
        {
            System.out.println("\n\nMENU\n====");
            System.out.println("1.Input Paragraf\n2.Tambah Paragraf\n"
                    + "3.Lihat Paragraf\n4.Cari Kata\n5.Exit");
            System.out.println("\nPilihan: ");

            choice = read.nextInt();

            read.nextLine();

            switch(choice)
            {
                case 1:
                {
                    String input, save;

                    System.out.println("\nSilahkan masukan paragraf anda:");
                    input = read.nextLine();
                    System.out.println("\nParagraf:" + input);
                    
                    do
                    {
                        System.out.println("\nApakah anda akan menyimpannya [Y/T]? ");
                        save = read.nextLine(); 
                    }while(!"Y".equals(save) && !"y".equals(save) && !"T".equals(save) && !"t".equals(save));

                    if("Y".equals(save) || "y".equals(save))
                    {
                        par = input;
                        System.out.println("\nParagraf tersimpan");
                    }
                    
                    else if("T".equals(save) || "t".equals(save))
                    {
                        System.out.println("\nParagraf tidak disimpan");
                    }

                    break;
                }
                
                case 2:
                {
                    if(par == null)
                    {
                        System.out.println("\nTidak ada paragraf yang tersimpan");
                    }
                    
                    else
                    {
                        String par2, add;
                        System.out.println("\nParagraf yang sudah diinput:");
                        System.out.println(par);   
                        
                        System.out.println("\nSilahkan masukan paragraf yang akan ditambah: ");
                        par2 = read.nextLine();
                        
                        do
                        {
                            System.out.println("\nApakah anda akan menyimpannya [Y/T]? ");
                            add = read.nextLine();
                        }while(!"Y".equals(add) && !"y".equals(add) && !"T".equals(add) && !"t".equals(add));
                        
                        if("Y".equals(add) || "y".equals(add))
                        {
                            par = par + " " + par2;
                            System.out.println("\nParagraf berhasil ditambahkan");
                        }

                        else if("T".equals(add) || "t".equals(add))
                        {
                            System.out.println("\nParagraf tidak ditambahkan");
                        }                        
                    }
                    break;
                }
                
                case 3:
                {
                    System.out.println("\nParagraf:");
                    System.out.println(par);
                    break;
                }
                
                case 4:
                {
                    
                    if(par == null)
                    {
                        System.out.println("\nTidak ada paragraf yang tersimpan");
                    }
                    
                    else
                    {
                       String find, before, after;
                       int count = 0;
                       System.out.println("\nMasukan kata yang akan dicari: ");
                       find = read.nextLine();

                       String a[] = par.split(" ");

                       for(int i = 0; i < a.length; i++)
                       {
                           if(find.equals(a[i]))
                           {
                                count++; 
                                
                                if(i == 0)
                                {
                                    before = null;
                                    after = a[i+1];
                                }
                                
                                else if(i == a.length - 1)
                                {
                                    before = a[i-1];                                      
                                    after = null;
                                }
                                
                                else
                                {
                                    before = a[i-1];                                     
                                    after = a[i+1];
                                }
                                
                                System.out.println("\n" + find + count +":");
                                System.out.println("Kata sebelum: " + before);
                                System.out.println("Kata sesudah: " + after);
                           }
                       }
                       
                       if(count == 0)
                       {
                            System.out.println("\nTidak ada kata " + find + " pada paragraf");
                       }
                       
                       else
                       {
                            System.out.println("\nHasil:");
                            System.out.println("kata " + find + " sebanyak " + count + " kali");    
                       }

                    }

                    break;
                }
                
            }     
        }while(choice != 5);
        
    }
    
}
