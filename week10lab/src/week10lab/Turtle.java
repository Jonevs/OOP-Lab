//JONATHAN EVAN SAMPURNA (2301876612) - OOP Lab Week 10
package week10lab;
import static week10lab.Week10lab.r;

/**
 *
 * @author jonathan
 */
public class Turtle extends Animal implements SpecialMove, Comparable <Animal> {
    
    private int move, distance = 0, sm, boost;
    
    public Turtle(String name, String type, int speed) {
        super(name, type, speed);
    }
    
    @Override
    public int move() {
        this.move = r.nextInt(super.getSpeed()) + 1;
        return move;
    }
    
    @Override
    public int specialMove() {
        this.sm = r.nextInt(10) + 1;
        
        if(sm > 7)
        {
            boost = 15;
        }
        
        else
        {
            boost = 0;
        }
        
        return boost;
    }

    @Override
    public int compareTo(Animal a) {
        int compare = ((Animal)a).getDistance();
        return this.distance - compare;
    }    
    
    @Override
    void setDistance() {
        this.distance = distance + move;
    }
    
    @Override
    int getDistance() {
        return distance;
    }    
    
    @Override
    void setDistanceZero() {
        this.distance = 0;
    }
}
