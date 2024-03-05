package cloud.deadlock.order.common;

import java.util.Random;

public class RandomUtils {

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int NAME_LENGTH = 10;

    public static String generateRandomName() {
        StringBuilder randomName = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < NAME_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            randomName.append(randomChar);
        }

        return randomName.toString();
    }
}
