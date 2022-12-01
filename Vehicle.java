import java.util.Random;

public class Vehicle {
    private String mfr;
    private String color;
    private int power;
    private int numWheels;
    public int ELECTRIC_MOTOR;
    public int GAS_ENGINE;
    public int VIN;

    /**
     * Constructs a vehicle object with given parameters.
     * 
     * @param mfr            the manufacturer of the vehicle
     * @param color          the color of the vehicle
     * @param power          the power of the vehicle
     * @param numWheels      the number of wheels of the vehicle
     * @param ELECTRIC_MOTOR 1 if vehicle has an electric motor, 0 if not
     * @param GAS_ENGINE     1 if vehicle has a gas engine, 0 if not
     */
    public Vehicle(String mfr, String color, int power, int numWheels, int ELECTRIC_MOTOR, int GAS_ENGINE) {
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
     * Tests to see if current vehicle object is equal to the other given vehicle
     * object.
     * 
     * This should really just be a simple VIN comparison.
     * 
     * @param other vehicle object that current vehicle object will be compared to
     * @return true; if both vehicle's manufacturers, power, and number of wheels
     *         are equal
     *         false; otherwise
     */
    public boolean equals(Object other) {
        Vehicle other1 = (Vehicle) other;
        if (this.mfr == other1.mfr &&
                this.power == other1.power &&
                this.numWheels == other1.numWheels) {
            return true;
        }

        return false;
    }

    /**
     * Displays the vehicle object in string format.
     * 
     * @return the string representation of the vehicle object
     */
    public String display() {
        return String.format("%5s %13s %7s", VIN, mfr, color);
    }
}
