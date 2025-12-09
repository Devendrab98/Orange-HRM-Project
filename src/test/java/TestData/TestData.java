package TestData;

import Utils.TestDataUtils;

import java.util.Random;

public class TestData {

    // Login Page Test
    public static final String loginID = "Admin";
    public static final String loginPass = "admin123";

    public static final String Invalid_Id = "Admin" ;
    public static final String Invalid_Pass = "admin12345";

    // Admin page Test

    // Admin Page > PIM Page User create data
    public  static  String EmployeeFName = "Sam";
    public  static  String EmployeeMName = "Ron";
    public  static  String EmployeeLName = "Wilson";

    public  static String employeeId = TestDataUtils.UniqueID();   // unique employee ID
    public  static String employeeLoginUser = TestDataUtils.UniqueUsername("E");  // unique login for employee
    public static String PIMUserPass = "Sam@1234";
    public static String PIMUserCofmPass = "Sam@1234";

    // Admin Page User Create data
    public  static String UserRoleDropD = "Admin";
    public  static String StatusDropD = "Enabled";
    public  static String password = "Pass@123";
    public  static String EmployeeName = "Sam Ron Wilson";
    public  static  String adminUsername = "Samm" + (char)('A' + new Random().nextInt(26));   // unique admin user

    // PIM Page Test Data
    public  static String adUsername = "Waan" + (char) ('A' + new Random().nextInt(26));   // unique admin user

    public static String JobTitle ="QA Engineer";

    // Leave Page Test Data
    // --------- Generate Unique Username ---------
    public  static String uniqueUser = "Sam" + System.currentTimeMillis();

    // --------- Create Employee ---------
    public  static  String EmployeeFirName = "Sam";
    public  static  String EmployeeMidName = "Bob";
    public  static  String EmployeeLstName = "Wilson";

    // --------- Assign Leave to that Employee ---------
    public static String LveEmplyName = "Sam Bob Wilson";
    public static String LeaveType = "CAN - Personal";
    public static String LeavePeriod = "2025-01-01 - 2025-31-12";
    public static int EntitlementValue = 5;

    // Recruitment Page Test Data
    public static String RecFirstName = "Lisa";
    public static String RecMiddName = "Van";
    public static String RecLastName = "Will";

    public static String Vacancy = "Software Engineer";
    public static String Email = "Lisa@yopmail.com";
    public static String ContactNo = "+12345678908";

    public static String CandidateName = "Lisa";

}
