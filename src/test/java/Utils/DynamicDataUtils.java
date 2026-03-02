package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class DynamicDataUtils {
    public static String timestamp() {
        return new SimpleDateFormat("yyyyMMddHHmmss")
                .format(new Date());
    }

    public static String date() {
        return new SimpleDateFormat("yyyyMMdd")
                .format(new Date());
    }

    public static String randomNumber(int digits) {
        int min = (int) Math.pow(10, digits - 1);
        int max = (int) Math.pow(10, digits) - 1;
        return String.valueOf(
                ThreadLocalRandom.current().nextInt(min, max)
        );
    }

}
