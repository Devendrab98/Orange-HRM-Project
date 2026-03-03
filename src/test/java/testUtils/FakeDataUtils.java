package testUtils;

import com.github.javafaker.Faker;

public class FakeDataUtils {

    // Thread-safe Faker instance
    private static final ThreadLocal<Faker> faker =
            ThreadLocal.withInitial(Faker::new);

    private static Faker getFaker() {
        return faker.get();
    }

    public static String firstName() {
        return getFaker().name().firstName();
    }

    public static String middleName() {
        return getFaker().name().nameWithMiddle();
    }

    public static String lastName() {
        return getFaker().name().lastName();
    }

    public static String empId_PIM() {
        return getFaker().number().digits(3);
    }

    public static String userName_PIM() {
        return getFaker().name().username();
    }

    public static String username_Ad() {
        return getFaker().name().username();
    }

    public static String email() {
        return getFaker().internet().emailAddress();
    }

    public static String contactNum() {
        return getFaker().number().digits(10);
    }
}
