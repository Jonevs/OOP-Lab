//JONATHAN EVAN SAMPURNA (2301876612) - OOP Lec GSLC 1 Week 4
package gslc1;
import java.util.Scanner;

public class Gslc1 {

//No.1    
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);
        int choice;
        double data[][] = new double[3][3];
        double precision = 0, recall = 0, fmeasure, accuracy, total = 0;
        
        try
        {
            do
            {
                System.out.println("\nMachine Learning Menu");
                System.out.println("=====================");
                System.out.println("1.Input\n2.Precision\n3.Recall"
                        + "\n4.F Measure\n5.Accuracy\n6.Exit");
                System.out.println("\nChoice: ");

                choice = read.nextInt();  

                switch(choice)
                {
                    case 1:
                    {
                        System.out.println("Actual Negative - Prediction Negative: ");
                        data[0][0] = read.nextDouble();                        

                        System.out.println("Actual Negative - Prediction Neutral: ");
                        data[0][1] = read.nextDouble();

                        System.out.println("Actual Negative - Prediction Positive: ");
                        data[0][2] = read.nextDouble(); 

                        System.out.println("Actual Neutral - Prediction Negative: ");
                        data[1][0] = read.nextDouble();                    

                        System.out.println("Actual Neutral - Prediction Neutral: ");
                        data[1][1] = read.nextDouble();

                        System.out.println("Actual Neutral - Prediction Positive: ");
                        data[1][2] = read.nextDouble();  

                        System.out.println("Actual Positive - Prediction Negative: ");
                        data[2][0] = read.nextDouble();

                        System.out.println("Actual Positive - Prediction Neutral: ");
                        data[2][1] = read.nextDouble();

                        System.out.println("Actual Positive - Prediction Positive: ");
                        data[2][2] = read.nextDouble();                    

                        break;
                    }

                    case 2:
                    {
                        precision = data[2][2] / (data[2][2] + data[0][0] + data[1][1]);
                        System.out.println("Precision: " + precision);

                        break;
                    }

                    case 3:
                    {
                        recall = data[2][2] / (data[2][2] + data[1][0] + data[0][1]);
                        System.out.println("Recall: " + recall);   

                        break;
                    }

                    case 4:
                    {
                        fmeasure = 2 * precision * recall / (precision + recall);
                        System.out.println("F Measure: " + fmeasure); 

                        break;
                    }

                    case 5:
                    {
                        for(int i = 0; i < 3; i++)
                        {
                            for(int j = 0; j < 3; j++)
                            {
                                total += data[i][j];
                            }
                        }

                        accuracy = (data[0][0] + data[1][1] + data[2][2])/total;
                        System.out.println("Accuracy: " + accuracy);                     

                        break;
                    }

                }
            }while(choice != 6);              
        }
        
        catch(Exception e)
        {
            System.out.println("Error, wrong input, program stopped.");
        }
        
    }
    
    
//No.2
//    
//    public static void main(String[] args) {
//        
//        Scanner read = new Scanner(System.in);
//        String input;
//        int temp;
//        
//        System.out.println("Input a paragraph: ");
//        input = read.nextLine();
//        
//        input = input.replaceAll("[^a-zA-Z0-9]", " ");
//        
//        input = input.toLowerCase();
//        
//        input = input.replaceAll("[^A-Za-z]", " ");
//        
//        System.out.println("\nOutput:\n" + input);
//        
//        System.out.print("\nWords counter:");
//        
//        String a[] = input.split(" ");
//        
//        
//        for(int i = 0; i < a.length; i++)
//        {
//            temp = 1;
//            
//            for(int j = i + 1; j < a.length; j++)
//            {
//                if(a[i].equals(a[j]))
//                {
//                    temp++;
//                    a[j] = a[j].replaceAll(a[j], "");
//                }
//            }
//            
//            if(a[i].equals(""))
//            {
//                continue;
//            }
//
//            else
//            {
//                System.out.println("\n" + a[i] + " : " + temp);
//            }
//
//        }
//  
//    }
            
}
