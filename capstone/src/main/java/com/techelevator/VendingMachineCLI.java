package com.techelevator;

import com.techelevator.view.*;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class VendingMachineCLI {
	//FINAL
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	private static final String FEEDMONEY_MENU_OPTION_ONE_DOLLAR = "$1";
	private static final String FEEDMONEY_MENU_OPTION_TWO_DOLLAR = "$2";
	private static final String FEEDMONEY_MENU_OPTION_FIVE_DOLLAR = "$5";
	private static final String FEEDMONEY_MENU_OPTION_TEN_DOLLAR = "$10";
	private static final String[] FEEDMONEY_MENU_OPTIONS = {FEEDMONEY_MENU_OPTION_ONE_DOLLAR, FEEDMONEY_MENU_OPTION_TWO_DOLLAR, FEEDMONEY_MENU_OPTION_FIVE_DOLLAR, FEEDMONEY_MENU_OPTION_TEN_DOLLAR};


	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}


	public void run() throws IOException {

		PaymentSystem pos = new PaymentSystem();
		Inventory inv = new Inventory();

		System.out.println("*******************************");
		System.out.printf("Welcome to the Vendo-Matic 800\n");
		System.out.println("*******************************");





		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				inv.displayInventory();


			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				boolean isPurchasing = true;
				while (isPurchasing) {


					String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					switch (purchaseChoice) {
						case PURCHASE_MENU_OPTION_FEED_MONEY:

							String feedMoneyChoice = (String) menu.getChoiceFromOptions(FEEDMONEY_MENU_OPTIONS);
							switch (feedMoneyChoice) {
								case FEEDMONEY_MENU_OPTION_ONE_DOLLAR:
									pos.insertMoney(Currency.ONE_DOLLAR);
									break;
								case FEEDMONEY_MENU_OPTION_TWO_DOLLAR:
									pos.insertMoney(Currency.TWO_DOLLAR);
									break;
								case FEEDMONEY_MENU_OPTION_FIVE_DOLLAR:
									pos.insertMoney(Currency.FIVE_DOLLAR);
									break;
								case FEEDMONEY_MENU_OPTION_TEN_DOLLAR:
									pos.insertMoney(Currency.TEN_DOLLAR);
									break;
							}
							break;
						case PURCHASE_MENU_OPTION_SELECT_PRODUCT:
							inv.displayInventory();

							System.out.println("Please enter the slot ID of your choice: ");
							Scanner sc = new Scanner(System.in);
							String itemCode = sc.next().toUpperCase(Locale.ROOT);
							Product prod = inv.getProductSelection().get(itemCode);
							if (prod == null || inv.getProductSelection().isEmpty()) {
								System.out.println("Please enter a valid slot ID");
							} else {
								pos.dispenseProduct(prod);
							}

							break;
						case PURCHASE_MENU_OPTION_FINISH_TRANSACTION:
							//return change using smallest amount of coins
							//update current balance to $0
							System.out.println(pos.calculateChange());

							isPurchasing = false;
							break;
					}
				}
			} else { //MAIN_MENU_OPTION_EXIT
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();

	}
}
