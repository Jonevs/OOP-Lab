//JONATHAN EVAN SAMPURNA (2301876612) - OOP Lab Week 10
package week10lab;
import static week10lab.Week10lab.r;

/**
 *
 * @author jonathan
 */
public class Hare extends Animal implements Comparable<Animal> {
    
    private int move, distance = 0;
    
    public Hare(String name, String type, int speed) {
        super(name, type, speed);
    }
    
    @Override
    public int move() {
        this.move = r.nextInt(super.getSpeed()) + 1;
        return move;
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
    public int compareTo(Animal a) {
        int compare = ((Animal)a).getDistance();
        return this.distance - compare;
    }
 
    @Override
    void setDistanceZero() {
        this.distance = 0;
    }

    
}
