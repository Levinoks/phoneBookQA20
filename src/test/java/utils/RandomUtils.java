package utils;

import java.util.Random;

public class RandomUtils {
    Random random= new Random();

    public String generateEmail(int lenght){
        String[] domains = { "gmail.com", "yahoo.com", "outlook.com", "example.com", "domain.com" };
        String domain = domains[random.nextInt(domains.length)];

        return (generateString(lenght) + "@" + domain);
    }

    public String generateString(int lenght){
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        char[] randomString = new char[lenght];
        int index=0;
        int charLenght = characters.length();
        for(int i=0; i<lenght; i++){
            index=random.nextInt(charLenght);
            randomString[i]=characters.charAt(index);
        }
        return new String((randomString));
    }

    public String generatePassword(int lenght){
        String[] specChars ={"$", "!", "#", "@"};
        String chars = specChars[random.nextInt(specChars.length)];

        return generateString(lenght/2)+ chars+ generateString(lenght/2).toUpperCase();
    }

}
