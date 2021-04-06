//JONATHAN EVAN SAMPURNA (2301876612) - OOP Lab Week 7
package weeklab7;

public class cake {
    String flavor, topping;
    int flour, sugar = 100;
    boolean isBaked = false;
    
    cake(String iFlavor, int iFlour, String iTopping) {
        this.flavor = iFlavor;
        this.flour = iFlour;
        this.topping = iTopping;
    }

    public void show() {
        System.out.println("Cake flavor: " + flavor);
        System.out.println("Cake flour: " + flour + " gram");
        System.out.println("Cake sugar: " + sugar + " gram");
        System.out.println("Cake topping: " + topping);
        
        if(isBaked == true)
        {
            System.out.println("The cake has been baked");
        }
        
        else
        {
            System.out.println("The cake has not been baked yet");
        }
    }    
    
    public void updateTopping(String newTopping) {
        this.topping = newTopping;
        System.out.println("The topping is changed!");
    }
}