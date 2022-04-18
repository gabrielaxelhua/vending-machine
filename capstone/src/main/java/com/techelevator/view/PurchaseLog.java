package com.techelevator.view;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PurchaseLog {


    //Each purchase must generate a line in the following format
    //01/01/2016 12:00:00 PM FEED MONEY: $5.00 $5.00

    public static String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
        Date currentDate = new Date();
        return dateFormat.format(currentDate);
    }

    public static void log(String message, double startingBalance, double endingBalance) {
        File f = new File("log.txt");

        try (PrintWriter pw = new PrintWriter(new FileOutputStream(f, true))){
            pw.println(getCurrentTime()
                    + "  " + message
                    + " $" + String.format("%,.2f", startingBalance)
                    + " $" + String.format("%,.2f", endingBalance));
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
