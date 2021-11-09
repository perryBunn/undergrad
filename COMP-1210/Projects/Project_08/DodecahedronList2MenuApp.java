import java.io.IOException;
import java.util.Scanner;

/**
 @author perry bunn
 @version 3/6/17
 */
public class DodecahedronList2MenuApp {
   /**
    *
    * @param args not used
    * @throws IOException in case a file is not found
    */
   public static void main(String[] args) throws IOException {
      
      String listName = "*** no list name assigned ***";
      Dodecahedron[] dodObj = new Dodecahedron[20];
      DodecahedronList2 dodObjList = new DodecahedronList2(listName, dodObj, 0);
      String fileName;
      
      String userInput;
      Scanner scanInput = new Scanner(System.in);
      
      System.out.println("Dodecahedron List System Menu\n"
                       + "R - Read File and Create Dodecahedron List\n"
                       + "P - Print Dodecahedron List\n" 
                       + "S - Print Summary\n"
                       + "A - Add Dodecahedron\n"   
                       + "D - Delete Dodecahedron\n"   
                       + "F - Find Dodecahedron\n"
                       + "E - Edit Dodecahedron\n"
                       + "Q - Quit");
      
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         
         String label;
         String color;
         double edge;
         
         userInput = scanInput.nextLine();
         if (userInput.length() == 0) {
            continue;
         }
         userInput = userInput.toUpperCase();
         char userChar = userInput.charAt(0);
         
         
         switch (userChar) {
            case 'R':
               System.out.print("\tFile name: ");
               fileName = scanInput.nextLine();
               
               dodObjList = dodObjList.readFile(fileName);
               System.out.println("\tFile read in and Dodecahedron "
                                                   + "List created\n");
               
               break;
               
            case 'P':
            
               System.out.println(dodObjList.toString());
               break;
               
            case 'S':
               System.out.println("\n" + dodObjList.summaryInfo() + "\n");
               break;
               
            case 'A':
               System.out.print("\tLabel: ");
               label = scanInput.nextLine();
               System.out.print("\tColor: ");
               color = scanInput.nextLine();
               System.out.print("\tEdge: ");
               edge = Double.parseDouble(scanInput.nextLine());
               
               dodObjList.addDodecahedron(label, color, edge);
               
               System.out.println("\t*** Dodecahedron added ***\n");
               break;
               
            case 'D':
               System.out.print("\tLabel: ");
               label = scanInput.nextLine();
               
               if (dodObjList.deleteDodecahedron(label) != null) {
                  dodObjList.deleteDodecahedron(label);
                  System.out.println("\t\"" + label + "\" deleted\n");
               } else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break;
               
            case 'F':
               System.out.print("\tLabel: ");
               label = scanInput.nextLine();
               
               if (dodObjList.findDodecahedron(label) != null) {
                  System.out.println(dodObjList.findDodecahedron(label)
                                                      .toString() + "\n");
               } else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break;
            
            case 'E':
               System.out.print("\tLabel: ");
               label = scanInput.nextLine();
               System.out.print("\tColor: ");
               color = scanInput.nextLine();
               System.out.print("\tEdge: ");
               edge = Double.parseDouble(scanInput.nextLine());
               
               if (dodObjList.findDodecahedron(label) != null) {
                  dodObjList.editDodecahedron(label, color, edge);
                  System.out.println("\"" + label + "\" successfully edited\n");
               } else {
                  System.out.println("\"" + label + "\" not found\n");
               }
               break;
               
            case 'Q': case 'q':
               break;
            
            default:
               System.out.println("\t*** invalid code ***\n");
         }
      } while (!userInput.equalsIgnoreCase("Q"));
   }
}