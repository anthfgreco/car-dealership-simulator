/*
Anthony Greco
500903364
*/
import java.util.*; 

public class Car extends Vehicle implements Comparable<Car>{
    private Model model;
    private int maxRange;
    private double safetyRating;
    private String AWD;
    private double price;

    /**
     * Constructs a car object with given parameters.
     * @param mfr the manufacturer of the car
     * @param color the color of the car
     * @param power the power of the car
     * @param numWheels the number of wheels of the car
     * @param ELECTRIC_MOTOR 1 if car has an electric motor, 0 if not
     * @param GAS_ENGINE 1 if car has a gas engine, 0 if not
     * @param model the model of car, uses Model enum
     * @param maxRange the max range of the car
     * @param safetyRating the safety rating of the car
     * @param AWD whether car is "2WD" or "AWD"
     * @param price the price of the car
     */
    public Car(String mfr, String color, int power, int numWheels, int ELECTRIC_MOTOR, int GAS_ENGINE, Model model, int maxRange, double safetyRating, String AWD, double price){
        super(mfr, color, power, numWheels, ELECTRIC_MOTOR, GAS_ENGINE);
        this.model = model;
        this.maxRange = maxRange;
        this.safetyRating = safetyRating;
        this.AWD = AWD;
        this.price = price;
    }
    public static enum Model{
        SEDAN, SUV, SPORTS, MINIVAN;
    }
    /**
     * Gets the current model of the car.
     * @return the current model
     */
    public Model getmodel(){
        return model;
    }
    /**
     * Gets the current AWD of the car, either "AWD" or "2WD".
     * @return the current AWD
     */
    public String getAWD(){
        return AWD;
    }
    /**
     * Gets the current price of the car.
     * @return the current price
     */
    public double getprice(){
        return price;
    }
    /**
     * Gets the current safety rating of the car, from 0 to 10.
     * @return the current safety rating
     */
    public double getsafetyRating(){
        return safetyRating;
    }
    /**
     * Gets the current max range of the car.
     * @return the current max range
     */
    public int getmaxRange(){
        return maxRange;
    }
    /**
     * Displays the car object in string format.
     * @return a string representation of the car object
     */
    public String display(){
        return String.format("%s %8s %5s %7s %10s %10s", super.display(), model, maxRange, safetyRating, AWD, price);
    }
    /**
     * Tests to see if the current car object is equal to the other given car object.
     * @param other car object that current car object will be compared to
     * @return true; if both car's manufacturers, power, number of wheels, model, and AWD are equal
     *         false; if otherwise
     */
    public boolean equals(Object other){
        Car other1 = (Car)other;
        if (super.equals(other1) &&
            this.getmodel() == other1.getmodel() &&
            this.getAWD() == other1.getAWD()){
                return true;
            }
        return false;
    }
    /**
     * Compares current car object to other car object based on price.
     * @param other car object that current car object will be compared to
     * @return -1; if current car price is lower than other car price
     *          0; if current car price is equal than other car price
     *          1; if current car price is greater than other car price
     */
    public int compareTo(Car other){
        if      (this.getprice() < other.getprice()) {return -1;}
        else if (this.getprice() > other.getprice()) {return 1;}
        else    {return 0;}    
    }
}

/**
 * Compares car object a to car object b based on their safety ratings.
 * @param a car object
 * @param b car object
 * @return -1; if car a's safety is lower than car b's safety rating
 *          0; if car a's safety is equal than car b's safety rating
 *          1; if car a's safety is greater than car b's safety rating
 */
class safetyRatingComparator implements Comparator<Car> { 
    public int compare(Car a, Car b) { 
        if      (a.getsafetyRating() < b.getsafetyRating()) {return -1;}
        else if (a.getsafetyRating() > b.getsafetyRating()) {return 1;}
        else    {return 0;}
    } 
} 

/**
 * Compares car object a to car object b based on their safety ratings.
 * @param a car object
 * @param b car object
 * @return -1; if car a's max range is lower than car b's max range
 *          0; if car a's max range is equal than car b's max range
 *          1; if car a's max range is greater than car b's max range
 */
class maxRangeComparator implements Comparator<Car> { 
    public int compare(Car a, Car b) { 
        if      (a.getmaxRange() < b.getmaxRange()) {return -1;}
        else if (a.getmaxRange() > b.getmaxRange()) {return 1;}
        else    {return 0;}
    } 
} 