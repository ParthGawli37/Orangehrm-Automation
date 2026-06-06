package utils;

import java.util.Random;
import java.util.UUID;

public class RandomDataUtil {

    private static final Random random = new Random();

    private RandomDataUtil() {
    }

    public static String getRandomFirstName() {

        String[] names = {
                "Parth",
                "John",
                "Sarah",
                "Dean",
                "Emma",
                "Alex"
        };

        return names[random.nextInt(names.length)];
    }

    public static String getRandomLastName() {

        String[] surnames = {
                "Winchester",
                "Smith",
                "Wilson",
                "Brown",
                "Taylor",
                "Morningstar"
        };

        return surnames[random.nextInt(surnames.length)];
    }

    public static String getRandomEmail() {

        return "user"
                + System.currentTimeMillis()
                + "@testmail.com";
    }

    public static String getRandomPhoneNumber() {

        return "9"
                + (100000000L + random.nextInt(900000000));
    }

    public static String getRandomEmployeeId() {

        return String.valueOf(
                10000 + random.nextInt(90000)
        );
    }

    public static String getUUID() {

        return UUID.randomUUID()
                .toString()
                .replace("-", "");
    }
}