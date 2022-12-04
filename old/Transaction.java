import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Transaction {
    int transactionID;
    Calendar date;
    Car car;
    String salesPerson;
    String transactionType;
    double transactionPrice;

    /**
     * Constructs an transaction object with given parameters.
     * 
     * @param transactionID    the transaction ID of the transaction, from 1 to 99
     * @param date             the date object that the transaction took place on
     * @param car              the car object that the transaction holds
     * @param salesPerson      the sales person that managed the transaction
     * @param transactionType  the type of transaction, either "BUY" or "RET"
     * @param transactionPrice the car price of the transaction
     */
    public Transaction(int transactionID, Calendar date, Car car, String salesPerson, String transactionType,
            double transactionPrice) {
        this.transactionID = transactionID;
        this.date = date;
        this.car = car;
        this.salesPerson = salesPerson;
        this.transactionType = transactionType;
        this.transactionPrice = transactionPrice;
    }

    /**
     * Displays the transaction object in string format.
     * 
     * @return a string representation of the transaction object
     */
    public String display() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd, yyyy");
        String sdfdate = sdf.format(this.date.getTime());
        return String.format("%s %20s %5s %12s %5s", String.format("%02d", transactionID), sdfdate, transactionType,
                salesPerson, car.display());
    }

}