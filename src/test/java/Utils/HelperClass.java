package Utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
class User
{
    public String name;
    public String email;
    public String password;
    public String title ;
    public String dob;
    public String firstName;
    public String lastName;
    public String company;
    public String address;
    public String address2;
    public String country;
    public String state;
    public String city;
    public String zipcode;
    public String mobileNumber ;
    
}
public class HelperClass {
    private static final String TestPrjRoot = "src/test/java/";
    private static final String TestDataFolder = "Testing_Data/";

    // User model (matches JSON fields)
    public static class User {
        public String name;
        public String email;
        public String password;
        public String title ;
        public Dob dob;
        public String firstName;
        public String lastName;
        public String company;
        public String address;
        public String address2;
        public String country;
        public String state;
        public String city;
        public String zipcode;
        public String mobileNumber;
        public String subject ;
        public String message ;
        public String filePath ;
    }
    
public static class Dob {
    public String day;
    public String month;
    public String year;
}

    // Read all users from JSON
    public static User[] ReadUsers(String fileName) throws FileNotFoundException {
        FileReader reader = new FileReader(TestPrjRoot + TestDataFolder + fileName);
        return new Gson().fromJson(reader, User[].class);
    }
}
