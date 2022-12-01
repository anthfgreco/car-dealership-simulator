public class ElectricCar extends Car {
    private int rechargeTime;
    private String batteryType;

    /**
     * Constructs an electric car object with given parameters.
     * 
     * @param mfr            the manufacturer of the electric car
     * @param color          the color of the electric car
     * @param power          the power of the electric car
     * @param numWheels      the number of wheels of the electric car
     * @param ELECTRIC_MOTOR 1 if electric car has an electric motor, 0 if not
     * @param GAS_ENGINE     1 if electric car has a gas engine, 0 if not
     * @param model          the model of electric car, uses Model enum
     * @param maxRange       the max range of the electric car
     * @param safetyRating   the safety rating of the electric car
     * @param AWD            whether electric car is "2WD" or "AWD"
     * @param price          the price of the electric car
     * @param rechargeTime   the recharge time of the electric car
     * @param batteryType    the battery type of the electric car
     */
    public ElectricCar(String mfr, String color, int power, int numWheels, int ELECTRIC_MOTOR, int GAS_ENGINE,
            Model model, int maxRange, double safetyRating, String AWD, double price, int rechargeTime,
            String batteryType) {
        super(mfr, color, power, numWheels, ELECTRIC_MOTOR, GAS_ENGINE, model, maxRange, safetyRating, AWD, price);
        this.rechargeTime = rechargeTime;
        this.batteryType = batteryType;
    }

    /**
     * Gets the current recharge time of the electric car.
     * 
     * @return the current recharge time
     */
    public int getrechargeTime() {
        return rechargeTime;
    }

    /**
     * Gets the current battery type of the electric car.
     * 
     * @return the current battery type
     */
    public String getbatteryType() {
        return batteryType;
    }

    /**
     * Sets the current recharge time of the electric car.
     * 
     * @param rechargeTime new recharge time
     */
    public void setrechargeTime(int rechargeTime) {
        this.rechargeTime = rechargeTime;
    }

    /**
     * Sets the current battery type of the electric car.
     * 
     * @param batteryType new recharge time
     */
    public void setbatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    /**
     * Displays the electric car object in string format.
     * 
     * @return a string representation of the electric car object
     */
    public String display() {
        return String.format("%s %12s %13s", super.display(), rechargeTime, batteryType);
    }
}