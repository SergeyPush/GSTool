package utils;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class RandomName {

    private static String name;
    private static String password;
    private static String roleName;
    private static String Toname;

    public static String getRandomName() {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date(timestamp.getTime());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        name = "testuser_" + simpleDateFormat.format(date);
        return name;
    }

    public static String getRandomRoleName() {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date(timestamp.getTime());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        roleName = "testrole_" + simpleDateFormat.format(date);
        return roleName;
    }

    public static String getRandomPassword() {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date(timestamp.getTime());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yy'_'HH:mm:ss");
        password = simpleDateFormat.format(date);
        writeToFile(name, password);
        return password;
    }

    public static String convertName(String name){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date(timestamp.getTime());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Toname =name+ "_" + simpleDateFormat.format(date);
        return Toname;
    }

    public static void writeToFile(String name, String password) {

        File file = new File("temp.txt");
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
            br.write(name);
            br.newLine();
            br.write(password);
            br.close();
        } catch (IOException e) {
            System.out.println("Unable to write to file " + file.toString());
        }
    }

    public static ArrayList<String> readFromFile() {

        ArrayList<String> out = new ArrayList<String>();

        String filename = "temp.txt";
        File textFile = new File(filename);

        Scanner in = null;
        try {
            in = new Scanner(textFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (in.hasNextLine()){
            String line = in.nextLine();
            out.add(line);
        }

        in.close();

        return out;
    }



}
