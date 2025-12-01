package Utils;

public class TestDataUtils {

    // Simple unique suffix based on current time
    public static String  UniqueID(){
        String time = String.valueOf(System.currentTimeMillis());
        return time.substring(time.length() - 5);
    }

    public static String UniqueUsername(String prefix){
        return prefix + System.currentTimeMillis();
    }
}
