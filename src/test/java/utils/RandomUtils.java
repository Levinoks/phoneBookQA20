package utils;

import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class RandomUtils {

    public static String[] name = {"Peter.", "Mary.", "Helen.", "George.", "Klaus."};
    public static String[] lastName = {"Anderson", "Evans", "McKenna", "Fraiser", "Rogriges", "Clark"};
    public static char at = '@';
    public static String[] postOperator = {"yandex", "rambler", "yahoo", "gmail"};
    public static String[] domain = {".uk", ".ua", ".com", ".il"};


    Random random = new Random();

    public String generateEmail(int lenght) {
        String[] domains = {"gmail.com", "yahoo.com", "outlook.com", "example.com", "domain.com"};
        String domain = domains[random.nextInt(domains.length)];

        return (generateString(lenght) + "@" + domain);
    }

    public String generateString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        char[] randomString = new char[length];
        int index = 0;
        int charLenght = characters.length();
        for (int i = 0; i < length; i++) {
            index = random.nextInt(charLenght);
            randomString[i] = characters.charAt(index);
        }
        return new String((randomString));
    }

    public String generatePassword(int length) {
        String[] specChars = {"$", "!", "#", "@"};
        String chars = specChars[random.nextInt(specChars.length)];

        return generateString(length / 2) + chars + generateString(length / 2).toUpperCase();
    }

    public String[] pass() {
        String[] symbols = {"!", "@", "#", "$",  "^", "&","~", "*","_"};// "%", "_", "-", ".", "?","~"
        String temp = "Qwert12";
       // String[] passwords = new String[symbols.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < symbols.length; i++) {
            sb.append(temp).append(symbols[i]).append(" ");
        }

        return sb.toString().trim().split(" ");

    }

    public String[] emailGen(int n) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {

            String ename = name[random.nextInt(name.length)];
            String eLastName = lastName[random.nextInt(lastName.length)];
            String postOp = postOperator[random.nextInt(postOperator.length)];
            String dom = domain[random.nextInt(domain.length)];
            sb.append(ename).append(eLastName).append(at).append(postOp).append(dom).append(" ");

        }

        return sb.toString().trim().split(" ");

    }




    }

