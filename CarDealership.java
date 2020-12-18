/*
Anthony Greco
500903364
*/
import java.util.*; 

public class CarDealership{
     private ArrayList<Car> cars;
     SalesTeam dealershipSalesTeam;
     AccountingSystem dealershipAccountingSystem;
     boolean electricFilter;
     boolean AWDFilter;
     double minPriceFilter;
     double maxPriceFilter;

    /**
     * Constructs a default car dealership object.
     * Initializes cars array list, the sales team object, and the accounting system object.
     * Sets filters to default values.
     */
    public CarDealership(){
        this.cars = new ArrayList<Car>();
        this.dealershipSalesTeam = new SalesTeam();
        this.dealershipAccountingSystem = new AccountingSystem();
        this.electricFilter = false;
        this.AWDFilter = false;
        this.minPriceFilter = 0;
        this.maxPriceFilter = 999999999;
    }
    /**
     * Takes array list of cars and adds every car object in the list to the car dealership's cars array list
     * @param newCars given array list of cars
     */
    public void addCars(ArrayList<Car> newCars){
        for (Car tempcar : newCars) {
            cars.add(tempcar);
        }
    }
    /**
     * Takes a VIN and searches through the cars array list for a matching VIN, if found, remove it.
     * Generates a random sales member and a random date and calls the accounting system add method
     * to add the transaction to the accounting system's transaction list
     * @param userVIN VIN parameter to search for
     * @return string representation of the transaction that was made
     */
    public String buyCar(int userVIN){
        Car car = null;
        for (Car tempcar : cars) {
            if (tempcar.getVIN() == userVIN){
                car = tempcar;
                break;
            }
        }
        cars.remove(car);
        
        String salesPerson = dealershipSalesTeam.randomMember();
        Random r = new Random();
        Calendar date = new GregorianCalendar();
        
        date.set(Calendar.YEAR, 2019);
        date.set(Calendar.MONTH, r.nextInt(12));
        date.set(Calendar.DAY_OF_MONTH, r.nextInt(date.getActualMaximum(Calendar.DAY_OF_MONTH) + 1));

        return dealershipAccountingSystem.add(date, car, salesPerson, "BUY", car.getprice()); 
    }
    /**
     * Takes a transaction ID and attempts to add a previously bought car back to the accounting system transaction list.
     * Generates a random later date in the month than the date the car was bought in.
     * @param transactionID transaction ID to search for
     * @return error message if car was already returned
     *         string representation of the transaction if the car has not yet been returned
     */
    public String returnCar(int transactionID){
        
        if (dealershipAccountingSystem.alreadyReturned(transactionID) == true){
            return "Car was already returned, choose a valid transaction";
        }
        else{
            Transaction transaction = dealershipAccountingSystem.getTransaction(transactionID);
            Calendar date = transaction.getdate();
            Calendar newdate = new GregorianCalendar(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH));
            
            Random r = new Random();
            int offset = r.nextInt(1 + newdate.getActualMaximum(newdate.DAY_OF_MONTH) - newdate.get(Calendar.DAY_OF_MONTH));
            newdate.add(newdate.DAY_OF_MONTH, offset);

            cars.add(transaction.getcar());
            
            return dealershipAccountingSystem.add(newdate, transaction.getcar(), transaction.getsalesPerson(), "RET", transaction.gettransactionPrice());
        }

    }
    /**
     * Sets the electric filter to true.
     */
    public void filterByElectric(){
        electricFilter = true;
    }
    /**
     * Sets the AWD filter to true.
     */
    public void filterByAWD(){
        AWDFilter = true;
    }
    /**
     * Sets the minimum and maximum price to the given parameters.
     * @param minPriceFilter new minimum price filter
     * @param maxPriceFilter new maximum price filter
     */
    public void filterByPrice(double minPriceFilter, double maxPriceFilter){
        this.minPriceFilter = minPriceFilter;
        this.maxPriceFilter = maxPriceFilter;
    }
    /**
     * Resets all filters by setting their values back to default values.
     */
    public void FiltersClear(){
        electricFilter = false;
        AWDFilter = false;
        minPriceFilter = 0;
        maxPriceFilter = 999999999;
    }
    /**
     * Sorts cars array list by price, minimum to maximum.
     */
    public void sortByPrice(){
        Collections.sort(cars);
    }
    /**
     * Sorts cars array list by safety rating, minimum to maximum.
     */
    public void sortBySafetyRating(){
        Collections.sort(cars, new safetyRatingComparator());
    }
    /**
     * Sorts cars array list by max range, minimum to maximum.
     */
    public void sortByMaxRange(){
        Collections.sort(cars, new maxRangeComparator());
    }
    /**
     * Displays the car dealership object in string table format.
     * Method displays string representation of car objects depending on the values of
     * the electric, AWD, and price filters.
     */
    public void displayInventory(){
        System.out.println();
        System.out.printf("%s    %s  %s   %s    %s %s  %s  %s     %s    %s   %s\n", "#", "VIN", "Manufacturer", "Color", "Model", "Range", "Safety", "Powertrain", "Price", "Chg. Time", "Battery Type");
        ArrayList<Car> tempcars = new ArrayList<Car>(cars);

        for (int i = 0; i < tempcars.size(); i++) {
            Car tempcar = tempcars.get(i);
            
            if (!(electricFilter && tempcar.getGAS_ENGINE() == 1 ||
                AWDFilter && tempcar.getAWD().equals("2WD") ||
                tempcar.getprice() < minPriceFilter || 
                tempcar.getprice() > maxPriceFilter)){
                    System.out.println(String.format("%02d", i) + " " + tempcar.display()); 
                }
        }
        System.out.println();
    }
}