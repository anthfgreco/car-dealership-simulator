/*
Anthony Greco
500903364
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CarDealershipSimulator {
	
	/**
	 * Creates a fileCars array list of car objects.
	 * Reads from "cars.txt" file and creates car objects and adds them to the fileCars car list.
	 * @return fileCars array list of car objects
	 * @throws FileNotFoundException if no file is found
	 */
	public static ArrayList<Car> getCarsFromFile() throws FileNotFoundException {
		// Initializes file object which holds car.txt
		// Initializes fileIn scanner to read from cars.txt file
		// Initializes fileCars ArrayList to hold the list of Car objects being made from the cars.txt file
		File inputFile = new File("cars.txt");
		Scanner fileIn = new Scanner(inputFile);
		ArrayList<Car> fileCars = new ArrayList<Car>();

		// Main file loop
		while (fileIn.hasNextLine()){
			// Stores each entry from each line of cars.txt into temporary variables
			String nextLine = fileIn.nextLine();
			String[] splitLine = nextLine.split("\\s+");

			String tempManufacturer = splitLine[0];
			String tempColor = splitLine[1];
			Car.Model tempModel = Car.Model.valueOf(splitLine[2]);
			int tempGAS_ENGINE = 1;
			int tempELECTRIC_ENGINE = 0;
			if (splitLine[3].equals("ELECTRIC_MOTOR")){
				tempGAS_ENGINE = 0;
				tempELECTRIC_ENGINE = 1;
			}
			double tempSafetyRating = Double.parseDouble(splitLine[4]);
			int tempMaxRange = Integer.parseInt(splitLine[5]);
			String tempAWD = splitLine[6];
			int tempPrice = Integer.parseInt(splitLine[7]);
			
			// If there are 8 entries in a line, create a Car object and add it to the fileCars ArrayList
			if (splitLine.length == 8){
				fileCars.add(new Car(tempManufacturer, tempColor, 300, 4, tempELECTRIC_ENGINE, tempGAS_ENGINE, tempModel, tempMaxRange, tempSafetyRating, tempAWD, tempPrice));
			}
			// Else, create an ElectricCar object and add it to the fileCars ArrayList
			else{
				int tempChargeTime = Integer.parseInt(splitLine[8]);
				fileCars.add(new ElectricCar(tempManufacturer, tempColor, 300, 4, tempELECTRIC_ENGINE, tempGAS_ENGINE, tempModel, tempMaxRange, tempSafetyRating, tempAWD, tempPrice, tempChargeTime, "Lithium-Ion"));
				
			}
		}
		fileIn.close();
		return fileCars;
	}
  public static void main(String[] args)
  {
	  	// Initiliazes fileCars variable to hold the Car objects read from the cars.txt file
		ArrayList<Car> fileCars = new ArrayList<Car>();
		// Gets car objects from cars.txt and adds them to fileCars
	  	try{
			fileCars = getCarsFromFile();
		  }
		catch(FileNotFoundException e){
			System.out.println("File not found.");
		}
	  	// Create a CarDealership object
		CarDealership dealership = new CarDealership();

		// Prints welcome message to user
		System.out.println("\nWelcome to the dealership! Type 'HELP' for help.");
		
		// Creates scanner for user to input commands
		Scanner mainScanner = new Scanner(System.in);
		
		// Main scanner loop

		while (mainScanner.hasNextLine()) {
			
			String newline = mainScanner.nextLine();
		
			// User input "L", displays inventory
			if (newline.equals("L")){
				dealership.displayInventory();
			}
			// User input "Q", quits program
			else if (newline.equals("Q")){
				mainScanner.close();
				break;
			}
			// Commands that are 3 characters or longer
			else if (newline.length() >= 3){
				if (newline.equals("HELP")){
					System.out.println();
					System.out.println("\"L\" displays current inventory");
					System.out.println("\"Q\" quits the program");
					System.out.println("\"BUY i\" buys car number i");
					System.out.println("\"RET\" returns last bought car");
					System.out.println("\"ADD\" adds the inventory of cars to current inventory");
					System.out.println("\"SPR\" sorts by price");
					System.out.println("\"SSR\" sorts by safety rating");
					System.out.println("\"SMR\" sorts by max range");
					System.out.println("\"FPR x y\" filters by price where x <= price <= y");
					System.out.println("\"FEL\" filters by electric");
					System.out.println("\"FAW\" filters by AWD");
					System.out.println("\"FCL\" clears filters");
					System.out.println("\"SALES\" prints all transactions for the year");
					System.out.println("\"SALES TEAM\" prints the names of all sales persons");
					System.out.println("\"SALES TOPSP\" prints sale person(s) with the most sold cars");
					System.out.println("\"SALES m\" prints transactions for month number m");
					System.out.println("\"SALES STATS\" prints stats of sales for the year");
					System.out.println();
				}
				// User input "BUY n", where n is an integer, removes car from dealership list, prints cars information
				else if (newline.substring(0, 3).equals("BUY")){
					try{
						int userVIN = Integer.parseInt(newline.substring(4));
						System.out.println(dealership.buyCar(userVIN) + "\n");
					}
					catch(NullPointerException e){
						System.out.println("Please enter a valid index.");
					}
					catch(NumberFormatException e){
						System.out.println("Please enter a valid integer index.");
					}
					catch(StringIndexOutOfBoundsException e){
						System.out.println("Please enter a valid integer index.");	
					}
				}

				// User input "RET", adds last car bought back to dealership list
				else if (newline.substring(0, 3).equals("RET")){
					try{
						int transactionID = Integer.parseInt(newline.substring(4));
						System.out.println(dealership.returnCar(transactionID) + "\n");
					}
					catch(NullPointerException e){
						System.out.println("Please enter a valid index.");
					}
					catch(NumberFormatException e){
						System.out.println("Please enter a valid integer index.");
					}
					catch(StringIndexOutOfBoundsException e){
						System.out.println("Please enter a valid integer index.");	
					}
				}

				// User input "ADD", adds array list of car objects to dealership object's array list
				else if (newline.equals("ADD")){
					dealership.addCars(fileCars);	
				}

				// User input "SPR", sorts inventory by price
				else if (newline.equals("SPR")){
					dealership.sortByPrice();
				}
				
				// User input "SSR", sorts inventory by safety rating
				else if (newline.equals("SSR")){
					dealership.sortBySafetyRating();
				}

				// User input "SMR", sorts inventory by max range
				else if (newline.equals("SMR")){
					dealership.sortByMaxRange();
				}

				// User input "FEL", filters inventory by electric vehicles 
				else if (newline.equals("FEL")){
					dealership.filterByElectric();
				}

				// User input "FAW", filters inventory by AWD vehicles
				else if (newline.equals("FAW")){
					dealership.filterByAWD();
				}

				// User input "FCL", clears all filters
				else if (newline.equals("FCL")){
					dealership.FiltersClear();
				}

				// User input "FPR x y", where x and y are doubles, sets filter so x <= price <= y
				else if (newline.substring(0, 3).equals("FPR")){
					try{
						String[] newlineSplit = newline.split(" ");
						double newMinPrice = Double.parseDouble(newlineSplit[1]);
						double newMaxPrice = Double.parseDouble(newlineSplit[2]);
						dealership.filterByPrice(newMinPrice, newMaxPrice);
					}
					catch(NumberFormatException e){
						System.out.println("Please enter two valid numbers");
					}
					catch(ArrayIndexOutOfBoundsException e){
						System.out.println("Please enter two valid numbers");
					}
				}
				// User input "SALES", displays all transactions
				else if (newline.equals("SALES")){
					if (dealership.dealershipAccountingSystem.getTransactionListSize() == 0){
						System.out.println("Error, no recorded sales yet.");
					}
					else{
						System.out.println(dealership.dealershipAccountingSystem.displayTransactionList());
					}
				}
				// User input "SALES TEAM", displays all sales members
				else if (newline.equals("SALES TEAM")){
					System.out.println(dealership.dealershipSalesTeam.display());
				}
				// User input "SALES TOPSP", displays top sales member(s)
				else if (newline.equals("SALES TOPSP")){
					try{
						System.out.println(dealership.dealershipAccountingSystem.topSalesMembers());	
					}
					catch(NoSuchElementException e){
						System.out.println("Error, no cars have been bought yet.");
					}
				}
				// User input "SALES STATS", displays total sales, net total sales, average sales per month, 
                // net average sales per month, cars sold, cars returned, and the highest month(s) of sales
				else if (newline.equals("SALES STATS")){
					try{
						System.out.println(dealership.dealershipAccountingSystem.displayStats());	
					}
					catch(NoSuchElementException e){
						System.out.println("Error, no transaction records.");
					}
				}

				else if (newline.length() >= 5){
					// User input "SALES m", where m is an integer from 0-11, displays all transactions that
					// have occured in month m
				 	if (newline.substring(0, 5).equals("SALES")){
						try{
							int month = Integer.parseInt(newline.substring(6));
							if (month < 0 || month > 11){
								System.out.println("Please enter a month from 0-11.");
							}
							else{
								System.out.println(dealership.dealershipAccountingSystem.displayMonthTransactionList(month));
							}
						}
						catch(NullPointerException e){
							System.out.println("Please enter a valid index.");
						}
						catch(NumberFormatException e){
							System.out.println("Please enter a valid integer index.");
						}
					 }
					 else{
						System.out.println("Command not recognized. Type 'HELP' for help.");
					}	
				}
					
				else{
					System.out.println("Command not recognized. Type 'HELP' for help.");
				}	
				
			}	

			else{
				System.out.println("Command not recognized. Type 'HELP' for help.");
			}
		}
	}
}