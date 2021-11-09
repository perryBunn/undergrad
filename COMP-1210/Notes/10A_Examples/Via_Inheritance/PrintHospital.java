public class PrintHospital {

   public static void main(String[] args) 
   {
      Person[] personArray = new Person[3];   
      personArray[0] = new Patient("Jane", "Lane", "US", 1970);   
      personArray[1] = new Doctor("Joan", "Doe", "Lab", "none");	
      personArray[2] = new MaternityPatient("Bo", "Smith", 1980, 40);
   	
      for (int i = 0; i < personArray.length; i++) {
         System.out.println("\n " + personArray[i].getId());
      }
      
      System.out.println();
         
      for (Person p : personArray) {
         System.out.println("\n " + p);
      }   
   }
}