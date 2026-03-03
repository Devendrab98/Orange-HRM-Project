package Utils;

import com.github.javafaker.Faker;

public class FakeDataUtils {

    private static final Faker faker = new Faker();

    public static String firstName() {
        return faker.name().firstName();
    }

    public static String middleName() {
        return faker.name().nameWithMiddle();
    }

    public static String lastName() {
        return faker.name().lastName();
    }

    public static String empId_PIM() {
        return faker.number().digits(3);
    }

    public static String userName_PIM() {
        return faker.name().username();
    }

    public static String username_Ad() {
        return faker.name().username();
    }

    public static String email() {
        return faker.internet().emailAddress();
    }

    public static String contactNum() {
        return faker.number().digits(10);
    }
}
