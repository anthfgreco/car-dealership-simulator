/*
Anthony Greco
500903364
*/
import java.util.Random;

public class Vehicle{
    private String mfr;
    private String color;
    private int power;
    private int numWheels;
    public int ELECTRIC_MOTOR;
    public int GAS_ENGINE;
    public int VIN;

    /**
     * Constructs a vehicle object with given parameters.
     * @param mfr the manufacturer of the vehicle
     * @param color the color of the vehicle
     * @param power the power of the vehicle
     * @param numWheels the number of wheels of the vehicle
     * @param ELECTRIC_MOTOR 1 if vehicle has an electric motor, 0 if not
     * @param GAS_ENGINE 1 if vehicle has a gas engine, 0 if not
     */ 
    public Vehicle(String mfr, String color, int power, int numWheels, int ELECTRIC_MOTOR, int GAS_ENGINE){
        this.mfr = mfr;
        this.color = color;
        this.power = power;
        this.numWheels = numWheels;
        this.ELECTRIC_MOTOR = ELECTRIC_MOTOR;
        this.GAS_ENGINE = GAS_ENGINE;
        Random r = new Random();
        this.VIN = r.nextInt(400) + 100;
    }
    /**
     * Gets the current manufacturer of the vehicle.
     * @return the current manufacturer
     */
    public String getmfr(){
        return mfr;
    }
    /**
     * Gets the current color of the vehicle.
     * @return the current color
     */
    public String getcolor(){
        return color;
    }
    /**
     * Gets the current power of the vehicle.
     * @return the current power
     */
    public int getpower(){
        return power;
    }
    /**
     * Gets the current number of wheels of the vehicle.
     * @return the current number of wheels
     */
    public int getnumWheels(){
        return numWheels;
    }
    /**
     * Gets the current ELECTRIC_MOTOR of the vehicle, 0 or 1.
     * @return the current ELECTRIC_MOTOR
     */
    public int getELECTRIC_MOTOR(){
        return ELECTRIC_MOTOR;
    }
    /**
     * Gets the current GAS_ENGINE of the vehicle, 0 or 1.
     * @return the current GAS_ENGINE
     */
    public int getGAS_ENGINE(){
        return GAS_ENGINE;
    }
    /**
     * Gets the current VIN of the vehicle, from 100 to 499
     * @return the current VIN
     */
    public int getVIN(){
        return VIN;
    }
    /**
     * Sets current manufacturer of vehicle to given parameter.
     * @param mfr new current manufacturer
     */
    public void setmfr(String mfr){
        this.mfr = mfr;
    }
    /**
     * Sets current color of vehicle to given parameter.
     * @param color new current color
     */
    public void setcolor(String color){
        this.color = color;
    }
    /**
     * Sets current power of vehicle to given parameter.
     * @param power new current power
     */
    public void setpower(int power){
        this.power = power;
    }
    /**
     * Sets current number of wheels of vehicle to given parameter.
     * @param numWheels new current number of wheels
     */
    public void setnumWheels(int numWheels){
        this.numWheels = numWheels;
    }
    /**
     * Sets current ELECTRIC_MOTOR of vehicle to given parameter, 0 or 1.
     * @param ELECTRIC_MOTOR new ELECTRIC_MOTOR
     */
    public void setELECTRIC_MOTOR(int ELECTRIC_MOTOR){
        this.ELECTRIC_MOTOR = ELECTRIC_MOTOR;
    }
    /**
     * Sets current GAS_ENGINE of vehicle to given parameter, 0 or 1.
     * @param GAS_ENGINE new GAS_ENGINE
     */
    public void setGAS_ENGINE(int GAS_ENGINE){
        this.GAS_ENGINE = GAS_ENGINE;
    }
    /**
     * Tests to see if current vehicle object is equal to the other given vehicle object.
     * @param other vehicle object that current vehicle object will be compared to
     * @return true; if both vehicle's manufacturers, power, and number of wheels are equal
     *         false; otherwise
     */
    public boolean equals(Object other){
        Vehicle other1 =  (Vehicle)other;
        if (this.getmfr() == other1.getmfr() && 
            this.getpower() == other1.getpower() &&
            this.getnumWheels() == other1.getnumWheels()){
                return true;
            }
        
        return false;
    }
    /**
     * Displays the vehicle object in string format.
     * @return the string representation of the vehicle object
     */
    public String display(){
        return String.format("%5s %13s %7s", VIN, mfr, color);
    }
}
