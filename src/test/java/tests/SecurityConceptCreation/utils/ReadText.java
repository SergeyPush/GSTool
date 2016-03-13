package tests.SecurityConceptCreation.utils;

import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class ReadText {


    public static String readFromFile() {

        String text = "";


        String filename = "umlauts.txt";
        File textFile = new File(filename);

        Scanner in = null;
        try {
            in = new Scanner(textFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (in.hasNextLine()) {
            String line = in.nextLine();
            text += line;
        }

        in.close();

        return text;
    }

    public static void SendUmlauts(String locator) {

        String umlauts = "öüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜäöüßÜä";

        for (int i = 0; i <= 8; i++) {
            $(By.xpath(locator)).append(umlauts);

        }
    }


}
