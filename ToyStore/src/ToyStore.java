/* David Zammit
 * S3449686
 * 
 * class ToyStore
 * 
 * Implements the data storage and functional requirements
 * for a program that manages the inventory in a toy store.
 * 
 */

import java.io.*;

public class ToyStore {
	private static final Toy[] inventory = new Toy[8];
	private static final BufferedReader stdin = new BufferedReader(
			new InputStreamReader(System.in));

	private static Boolean function = false;
	private static Boolean searchValidate = false;
	// User input variables intitalised in preperation of calling them for the
	// main method and any helper methods.
	// i used programmed this to use three generic input variables which are
	// always reset during the initialisation
	// of a function allowing them to be manipulated individually within each
	// void function
	private static String userString = "";
	private static int userInteger = 0;
	private static char userChar = '\0';

	// the main function for this program calls a user menu which then runs
	// paticular functions
	public static void main(String[] args) throws IOException,
			InterruptedException {
		System.out.println("**********************************");
		System.out.println("**********************************");
		System.out.println("***TOY STORE INVENTORY PROGRAM****");
		System.out.println("**********************************");
		System.out.println("**********************************");

		System.out.println();
		populateFullProductList();
		System.out.println();

		do {
			// print menu to screen
			System.out.println("**********************************");
			System.out.println("**********************************");
			System.out.println("***TOY STORE INVENTORY PROGRAM****");
			System.out.println("**********************************");
			System.out.println("**********************************");

			System.out.println();

			System.out.printf("%-25s%s\n", "Display Inventory", "A");
			System.out.printf("%-25s%s\n", "Print Reorder List", "B");
			System.out.printf("%-25s%s\n", "Product Range Search", "C");
			System.out.printf("%-25s%s\n", "Accept Delivery", "D");
			System.out.printf("%-25s%s\n", "Make Sale", "E");
			System.out.printf("%-25s%s\n", "Exit Program", "X");
			System.out.println();

			// prompt user to enter selection
			System.out.print("Enter selection: ");
			userChar = stdin.readLine().toUpperCase().charAt(0);

			// process user's selection
			switch (userChar) {
			case 'A':
				System.out.println();

				System.out.println("**********************************");
				System.out.println("**********************************");
				System.out.println("****DISPLAY INVENTORY FEATURE*****");
				System.out.println("**********************************");
				System.out.println("**********************************");

				System.out.println();

				printFullProductList();
				break;

			case 'B':
				System.out.println();

				System.out.println("**********************************");
				System.out.println("**********************************");
				System.out.println("****PRINT REORDER LIST FEATURE****");
				System.out.println("**********************************");
				System.out.println("**********************************");

				System.out.println();

				printProductReorderList();
				break;

			case 'C':
				System.out.println();

				System.out.println("**********************************");
				System.out.println("**********************************");
				System.out.println("***PRODUCT RANGE SEARCH FEATURE***");
				System.out.println("**********************************");
				System.out.println("**********************************");

				System.out.println();

				searchProductDescription();
				break;

			case 'D':
				System.out.println();

				System.out.println("**********************************");
				System.out.println("**********************************");
				System.out.println("*****ACCEPT DELIVERY FEATURE******");
				System.out.println("**********************************");
				System.out.println("**********************************");

				System.out.println();

				acceptDeliveryOfProduct();
				break;

			case 'E':
				System.out.println();

				System.out.println("**********************************");
				System.out.println("**********************************");
				System.out.println("*********MAKE SALE FEATURE********");
				System.out.println("**********************************");
				System.out.println("**********************************");

				System.out.println();

				sellAProduct();
				break;

			case 'X':
				System.out.println();

				System.out.println("**********************************");
				System.out.println("**********************************");
				System.out.println("**EXITING THE PROGRAM, THANK YOU**");
				System.out.println("**********************************");
				System.out.println("**********************************");
				System.exit(0);
				break;

			default:
				System.out.println();

				System.out.println("**********************************");
				System.out.println("**********************************");
				System.out.println("******ERROR!!! INVALID INPUT******");
				System.out.println("**********************************");
				System.out.println("**********************************");

				System.out.println();
			}

			System.out.println();

		} while (userChar != 'X');

	}

	// this function is used to hardcoded the stores inventory
	private static void populateFullProductList() throws InterruptedException {
		function = true;
		System.out
				.println("Populating inventory with hardcoded information...");
		Thread.sleep(3000);

		Toy toy1 = new Toy();
		Toy toy2 = new Toy();
		Toy toy3 = new Toy();
		Toy toy4 = new Toy();
		Toy toy5 = new Toy();
		Toy toy6 = new Toy();
		Toy toy7 = new Toy();
		Toy toy8 = new Toy();

		toy1.setCode("LEG-301");
		toy1.setDesc("Lego Star Wars Super Pack");
		toy1.setPrice(119.99);
		toy1.setQuantity(2);
		toy2.setCode("LEG-210");
		toy2.setDesc("Lego Friends Sunshine Ranch");
		toy2.setPrice(79.99);
		toy2.setQuantity(1);
		toy3.setCode("TOY-005");
		toy3.setDesc("Toy Story - Talking Sheriff Woody");
		toy3.setPrice(54.99);
		toy3.setQuantity(12);
		toy4.setCode("NER-020");
		toy4.setDesc("Nerf Rapid N-Strike Kit");
		toy4.setPrice(38.00);
		toy4.setQuantity(15);
		toy5.setCode("HOT-101");
		toy5.setDesc("Hot Wheels Cascade Blitz");
		toy5.setPrice(99.99);
		toy5.setQuantity(10);
		toy6.setCode("LEG-401");
		toy6.setDesc("Lego Movie Evil Business Lord's Lair");
		toy6.setPrice(69.99);
		toy6.setQuantity(10);
		toy7.setCode("LEG-420");
		toy7.setDesc("Lego Movie Clock - Bad Cop");
		toy7.setPrice(24.99);
		toy7.setQuantity(0);
		toy8.setCode("TOY-008");
		toy8.setDesc("Toy Story - Jessie the Talking Cowgirl");
		toy8.setPrice(39.99);
		toy8.setQuantity(15);

		inventory[0] = toy1;
		inventory[1] = toy2;
		inventory[2] = toy3;
		inventory[3] = toy4;
		inventory[4] = toy5;
		inventory[5] = toy6;
		inventory[6] = toy7;
		inventory[7] = toy8;

		function = false;
	}

	// this function will iterate through the hardcoded information and print
	// using a method from Toy.class
	private static void printFullProductList() throws InterruptedException,
			IOException {
		function = true;

		System.out.println(" ");
		for (int i = 0; i < inventory.length; i++)
			System.out.println(" " + inventory[i].toString());
		System.out.println(" ");
		Thread.sleep(3000);
		pressAnyKey();
	}

	// any product below the specified stock level will print
	private static void printProductReorderList() throws InterruptedException,
			IOException {
		function = true;

		System.out.println(" ");
		System.out.println("Product Code\tDescription\tStock Levels");
		for (int i = 0; i < inventory.length; i++)
			if (inventory[i].getQuantity() < 5)
				System.out.println(inventory[i].getCode() + "\t"
						+ inventory[i].getDesc() + "\t"
						+ inventory[i].getQuantity());
		System.out.println(" ");
		Thread.sleep(3000);
		pressAnyKey();

	}

	/*
	 * this allows the user to search the description of each product for
	 * related keywords
	 */
	private static void searchProductDescription() throws IOException,
			InterruptedException

	{
		function = true;
		userString = "";
		userChar = '\0';
		userInteger = 0;
		searchValidate = false;
		String availability = "";

		do {

			System.out.print("Enter search criteria: ");
			userString = stdin.readLine().toUpperCase();
			Thread.sleep(1000);

			System.out.println(" ");

			for (int i = 0; i < inventory.length; i++)
				if (inventory[i].toString().toUpperCase().contains(userString)) {
					if (inventory[i].getQuantity() <= 0) {
						availability = "out of stock";
					} else {
						availability = "in stock";
					}
					System.out.println(inventory[i].getDesc() + "\t"
							+ inventory[i].getPrice() + "\t" + availability);
					searchValidate = true;
				}

			if (searchValidate == false) {
				System.out
						.println("Keyword search did not return any matching results.");
				searchProductDescription();
			}

			System.out.println(" ");
			System.out.print("Would you like to search again?");
			yesOrNo();

		} while (function == true);
	}

	/*
	 * this function uses the restock function of Toy.class to adjust stock
	 * levels
	 */
	private static void acceptDeliveryOfProduct() throws IOException,
			InterruptedException

	{
		function = true;
		userString = "";
		userChar = '\0';
		userInteger = 0;
		searchValidate = false;

		do {
			System.out
					.print("Search for the product code you would like to recieve: ");
			userString = stdin.readLine().toUpperCase();
			String tempCode = userString;
			System.out.println();

			for (int i = 0; i < inventory.length; i++)
				if (inventory[i].getCode().toUpperCase().equals(tempCode)) {
					int backup = inventory[i].getQuantity();
					System.out.println(inventory[i].toString());
					System.out.println();

					Boolean parseVar = false;
					while (parseVar == false) {
						System.out
								.print("Enter the number of units recieved for restock: ");
						userString = stdin.readLine();
						try {
							userInteger = Integer.parseInt(userString);
							parseVar = true;
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							System.out.println("Invalid input, try again");
						}
					}
					System.out.println();
					int units = userInteger;
					Thread.sleep(1000);

					inventory[i].restock(units);
					System.out.println("You have successfully recieved "
							+ units + " of " + tempCode + " in to stock.");
					System.out.println();
					System.out.println("Stock level of " + tempCode + " is "
							+ inventory[i].getQuantity());
					System.out.println();
					System.out.print("Please confirm YES/NO: ");
					yesOrNo();
					userChar = userString.toUpperCase().charAt(0);
					if (userChar == 'N') {
						System.out
								.println("Cancelling update request, please standby...");
						int quantity = backup;
						inventory[i].setQuantity(quantity);
						System.out.println("Stock level of " + tempCode
								+ " is " + inventory[i].getQuantity());
						System.out.println("Delivery Cancelled!");
					} else {
						System.out.println();
						System.out.println("Delivery Complete!");
					}
					searchValidate = true;
				}

			if (searchValidate == false) {
				System.out
						.println("Product code selected did not return any matching results.");
				acceptDeliveryOfProduct();
			}

			System.out.println(" ");
			System.out.print("Would you like to recieve another delivery?");
			yesOrNo();
		} while (function == true);
	}

	/*
	 * this uses the sell function from Toy.class to adjust stock levels and
	 * display item costs
	 */
	private static void sellAProduct() throws IOException, InterruptedException {
		function = true;
		userString = "";
		userChar = '\0';
		userInteger = 0;
		searchValidate = false;

		do {
			System.out
					.print("Search for the product code you would like to sell: ");
			userString = stdin.readLine().toUpperCase();
			String tempCode = userString;

			System.out.println();

			for (int i = 0; i < inventory.length; i++) {
				if (inventory[i].getCode().equals(tempCode)) {
					System.out.println(inventory[i].toString());
					System.out
							.print("\nEnter the number of units being purchased: ");
					userString = stdin.readLine();

					// i have added a try/catch here to stop the user from
					// hitting enter by accident and causing an exception within
					// the parse to integer
					try {
						userInteger = Integer.parseInt(userString);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						userString = ""; // clear the variable to make sure
											// there is no old data being stored
											// as a value
						System.out
								.print("\nEnter the number of units being purchased: ");
						userString = stdin.readLine();
						userInteger = Integer.parseInt(userString);
					}

					System.out.println();
					System.out.println("Sell " + userInteger + " units of "
							+ inventory[i].getCode());

					System.out.print("\nConfirm Y/N: ");
					yesOrNo();
					userChar = userString.toUpperCase().charAt(0);
					if (userChar == 'Y') {
						int units = userInteger;
						Double cost = inventory[i].sell(units);
						if (cost.isNaN()) {
							System.out.println();

							System.out
									.println("INSUFFICIENT STOCK!!! Units sold exceeds current stock levels.");
						} else {
							System.out.println();

							System.out.printf("Total cost: %.2f", cost);

							System.out.println();
						}
						searchValidate = true;
					}
				}
				if (searchValidate == false) {
					System.out
							.println("Product code selected did not return any matching results.");
					sellAProduct();
				}

				System.out.println();
				System.out.print("Would you like to sell another product?");
				yesOrNo();
			}

		} while (function == true);

	}

	// i have created this fucntion paticularly for the print functions so the
	// user may have time to read before proceeding
	private static void pressAnyKey() throws IOException {
		System.out.println("Press any key to continue...");
		String anyKey = stdin.readLine();
		if (anyKey != null) {
			function = false;
		} else {
			System.out.println("Invalid input, unable to detect key press");
		}
	}

	// this is a nice little helper to clean up the other functions and have a
	// generic yes or no function for all questions requiring a Y or N input
	// from the user
	private static void yesOrNo() throws IOException, InterruptedException {
		Boolean counter = false;
		userString = "";
		do {
			userString = stdin.readLine().toUpperCase();
			System.out.println(" ");
			switch (userString) {
			case "Y":
				counter = true;
				function = true;
				break;
			case "N":
				counter = true;
				function = false;
				break;
			default:
				counter = false;
				System.out.println("Invalid input, please enter Y/N");
				break;
			}
		} while (counter == false);
	}
}