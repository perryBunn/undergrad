/**
* @author Perry Bunn
* @version 2/6/2017
*/
public class UserInfo {
   // instance variables
   private String firstName;
   private String lastName;
   private String location;
   private int age;
   private int status;
   private static final int OFFLINE = 0, ONLINE = 1;
   // constructor
   /**
   * @param firstNameIn user inputs a first name.
   * @param lastNameIn user inputs a last name.
   */
   public UserInfo(String firstNameIn, String lastNameIn) {
      firstName = firstNameIn;
      lastName = lastNameIn;
      location = "Not Specified";
      age = 0;
      status = OFFLINE;
   }
   // methods
   /**
   * @return returns inputs as strings
   */
   public String toString() {
      String output = "Name: " + firstName + " "
         + lastName + "\n";
      output += "Location: " + location + "\n";
      output += "Age: " + age + "\n";
      output += "Status: ";
      if (status == OFFLINE) {
         output += "Offline";
      } else {
         output += "online";
      }
      return output;
   }
   /**
   * @param locationIn takes input from user for the location
   */
   public void setLocation(String locationIn) {
      location = locationIn;
   }
   /**
   * @param ageIn takes input from the user for the age
   * @return returns the variable age and isSet
   */
   public boolean setAge(int ageIn) {
      boolean isSet = false;
      if (ageIn > 0) {
         age = ageIn;
         isSet = true;
      }
      return isSet;
   }
   /**
   * @return returns the age
   */
   public int getAge() {
      return age;
   }
   /**
   * @return returns the location
   */
   public String getLocation() {
      return location;
   }
   /**
   */
   public void logOff() {
      status = OFFLINE;
   }
   /**
   */
   public void logOn() {
      status = ONLINE;
   }
}