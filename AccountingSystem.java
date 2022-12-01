import java.util.*;
import java.text.DateFormatSymbols;

public class AccountingSystem {
    private ArrayList<Transaction> transactionList;

    /**
     * Constructs a default accounting system object.
     * Initializes transactionList array list.
     */
    public AccountingSystem() {
        this.transactionList = new ArrayList<Transaction>();
    }

    /**
     * Takes transaction parameters to create a transaction object and adds it to
     * the transactionList array list.
     * Prints current transaction to console.
     * 
     * @param date        the date object that the transaction took place on
     * @param car         the car object that the transaction holds
     * @param salesPerson the sales person that managed the transaction
     * @param type        the type of transaction, either "BUY" or "RET"
     * @param salePrice   the car price of the transaction
     * @return string representation of current transaction
     */
    public String add(Calendar date, Car car, String salesPerson, String type, double salePrice) {
        Random r = new Random();
        int transactionID = r.nextInt(99) + 1;
        Transaction newTransaction = new Transaction(transactionID, date, car, salesPerson, type, salePrice);
        transactionList.add(newTransaction);
        return String.format("\n%s                  %s  %s  %s  %s  %s   %s   %s   %s %s  %s     %s    %s   %s\n%s",
                "#", "Date", "Type", "Sales Member", "VIN", "Manufacturer", "Color", "Model", "Range", "Safety",
                "Powertrain", "Price", "Chg. Time", "Battery Type", newTransaction.display());
    }

    /**
     * Takes a transaction ID and searches the transactionList array list for a
     * matching ID.
     * 
     * @param id transaction ID to search for
     * @return tempTransaction; if the parameter ID matches an ID found in the
     *         transactionList
     *         null; if no match found
     */
    public Transaction getTransaction(int id) {
        for (Transaction tempTransaction : transactionList) {
            if (tempTransaction.getID() == id) {
                return tempTransaction;
            }
        }
        return null;
    }

    /**
     * Displays the account system object in a string table format.
     * 
     * @return the string representation of the accounting system object
     */
    public String displayTransactionList() {
        String result = "";
        System.out.printf("\n%s                  %s  %s  %s  %s  %s   %s   %s   %s %s  %s     %s    %s   %s", "#",
                "Date", "Type", "Sales Member", "VIN", "Manufacturer", "Color", "Model", "Range", "Safety",
                "Powertrain", "Price", "Chg. Time", "Battery Type");
        for (Transaction tempTransaction : transactionList) {
            result += tempTransaction.display() + "\n";
        }
        return "\n" + result;
    }

    /**
     * Takes a transaction ID and searches through the transactionList array list if
     * the car was already returned.
     * 
     * @param transactionID transaction ID to search for
     * @return true; if the transaction type is "RET" OR if the car object for the
     *         transaction ID has been returned before
     *         false; otherwise
     */
    public boolean alreadyReturned(int transactionID) {
        boolean isReturned = false;

        Transaction tempTransaction = this.getTransaction(transactionID);
        Car tempCar = tempTransaction.getcar();

        if (tempTransaction.gettransactionType().equals("RET")) {
            isReturned = true;
        }

        for (int i = 0; i < transactionList.size(); i++) {
            Transaction forLoopTransaction = transactionList.get(i);
            if (tempCar.equals(forLoopTransaction.getcar()) && forLoopTransaction.gettransactionType().equals("RET")) {
                isReturned = true;
            }

        }

        return isReturned;
    }

    /**
     * Calculates which sales members have the most number of sales and returns a
     * string of the result.
     * This method uses a map to map sales members to number of sales, then uses
     * Collections.max to find the
     * max value of the map and adds every key (sales member) that has this max
     * value to the resulting string.
     * This means if every sales member has an equal amount of sales, every sales
     * member is a top sales member.
     * 
     * @return string representation of top sales member(s)
     */
    public String topSalesMembers() {
        Map<String, Integer> salesMap = new HashMap<String, Integer>();
        String returnString = "Top Sales Member(s): ";

        for (Transaction tempTransaction : transactionList) {
            String tempSalesPerson = tempTransaction.getsalesPerson();
            String tempType = tempTransaction.gettransactionType();

            if (tempType.equals("BUY")) {
                if (salesMap.containsKey(tempSalesPerson)) {
                    int newCount = salesMap.get(tempSalesPerson) + 1;
                    salesMap.put(tempSalesPerson, newCount);
                } else {
                    salesMap.put(tempSalesPerson, 1);
                }
            }
        }

        int maxValueInMap = (Collections.max(salesMap.values()));

        for (String key : salesMap.keySet()) {
            if (salesMap.get(key) == maxValueInMap) {
                returnString += String.format("%s %s ", key, maxValueInMap);
            }
        }

        return "\n" + returnString + "\n";
    }

    /**
     * Similar to displayTransactionList, displays the account system object for the
     * given month in a string table format.
     * 
     * @param m month integer from 0-11
     * @return the string representation of the transactions held by the accounting
     *         system object for month m
     */
    public String displayMonthTransactionList(int m) {
        String result = String.format(
                "\n%s                  %s  %s  %s  %s  %s   %s   %s   %s %s  %s     %s    %s   %s", "#", "Date", "Type",
                "Sales Member", "VIN", "Manufacturer", "Color", "Model", "Range", "Safety", "Powertrain", "Price",
                "Chg. Time", "Battery Type");

        for (Transaction tempTransaction : transactionList) {
            if (tempTransaction.getdate().get(Calendar.MONTH) == m) {
                result += "\n" + tempTransaction.display();
            }
        }
        return result + "\n";
    }

    /**
     * Calculates which months have the most number of sales and returns a string of
     * the result.
     * This method uses a map to map months to number of sales, then uses
     * Collections.max to find the
     * max value of the map and adds every key (month) that has this max value to
     * the resulting string.
     * This means if every month has an equal amount of sales, every month is also a
     * top month.
     * 
     * @return string representation of top month(s)
     */
    public String getTopMonths() {
        Map<Integer, Integer> monthMap = new HashMap<Integer, Integer>();
        String returnString = "";

        for (Transaction tempTransaction : transactionList) {
            int month = tempTransaction.getdate().get(Calendar.MONTH);
            String tempType = tempTransaction.gettransactionType();

            if (tempType.equals("BUY")) {
                if (monthMap.containsKey(month)) {
                    int newCount = monthMap.get(month) + 1;
                    monthMap.put(month, newCount);
                } else {
                    monthMap.put(month, 1);
                }
            }
        }

        int maxValueInMap = (Collections.max(monthMap.values()));

        for (int key : monthMap.keySet()) {
            if (monthMap.get(key) == maxValueInMap) {
                returnString += new DateFormatSymbols().getMonths()[key] + " ";
            }
        }
        return returnString;
    }

    /**
     * Calculates stats based on transactions in the transactionList array list and
     * returns them in string format.
     * 
     * @return string representation of total sales, net total sales, average sales
     *         per month, net
     *         average sales per month, cars sold, cars returned, and the highest
     *         month(s) of sales
     */
    public String displayStats() {
        int totalSales = 0;
        int totalSalesNet = 0;
        int averageSalesPerMonth = 0;
        int averageNetSalesPerMonth = 0;
        int carsSold = 0;
        int carsReturned = 0;
        String highestSalesMonths = this.getTopMonths();

        for (Transaction tempTransaction : transactionList) {
            if (tempTransaction.gettransactionType().equals("BUY")) {
                carsSold++;
                totalSales += tempTransaction.gettransactionPrice();
                totalSalesNet += tempTransaction.gettransactionPrice();
            }
            if (tempTransaction.gettransactionType().equals("RET")) {
                carsReturned++;
                totalSalesNet -= tempTransaction.gettransactionPrice();
            }
        }
        averageSalesPerMonth = totalSales / 12;
        averageNetSalesPerMonth = totalSalesNet / 12;

        return String.format(
                "\nTotal Sales: $%s\nTotal Net Sales: $%s\nAverage Sales Per Month: $%s\nAverage Net Sales Per Month: $%s\nCars Sold: %s\nTotal Returned: %s\nBest Month(s): %s\n",
                totalSales, totalSalesNet, averageSalesPerMonth, averageNetSalesPerMonth, carsSold, carsReturned,
                highestSalesMonths);
    }

    /**
     * Gets the current number of transactions in the transactionList array list.
     * 
     * @return size of transactionList array list
     */
    public int getTransactionListSize() {
        return transactionList.size();
    }
}