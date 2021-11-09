import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * .
 * @author Perry Bunn
 * @version 4/12/2017
 */
public class BakedItemList {
   private String listName;
   private BakedItem[] itemList = new BakedItem[100];
   private int itemCount;
   private String[] excludedRecords = new String[30];
   private int excludedCount;
   private static int listCount = 0;

   /**
    * .
    */
   public BakedItemList() {
      listName = "";
      itemCount = 0;
      excludedCount = 0;
      BakedItemList.listCount++;
   }

   /**
    *
    * @return returns the name of the list
    */
   public String getListName() {
      return listName;
   }

   /**
    *
    * @param listNamein sets the name of the list
    */
   public void setListName(String listNamein) {
      this.listName = listNamein;
   }

   /**
    *
    * @return gets the items in the list
    */
   public BakedItem[] getItemList() {
      return itemList;
   }

   /**
    *
    * @param itemListin sets the items in the list
    */
   public void setItemList(BakedItem[] itemListin) {
      this.itemList = itemListin;
   }

   /**
    *
    * @return gets the numbers of items in the list
    */
   public int getItemCount() {
      return itemCount;
   }

   /**
    *
    * @param itemCountin sets the number of items in the list
    */
   public void setItemCount(int itemCountin) {
      this.itemCount = itemCountin;
   }

   /**
    *
    * @return retuns the excluded items from the list
    */
   public String[] getExcludedRecords() {
      return excludedRecords;
   }

   /**
    *
    * @param excludedRecordsin sets the excludued items
    */
   public void setExcludedRecords(String[] excludedRecordsin) {
      this.excludedRecords = excludedRecordsin;
   }

   /**
    *
    * @return returns the number of excluded items
    */
   public int getExcludedCount() {
      return excludedCount;
   }

   /**
    *
    * @param excludedCountin sets the number of excluded items
    */
   public void setExcludedCount(int excludedCountin) {
      this.excludedCount = excludedCountin;
   }

   /**
    *
    * @return gets teh number of list
    */
   public static int getListCount() {
      return listCount;
   }

   /**
    *
    */
   public static void resetListCount() {
      BakedItemList.listCount = 0;
   }

   /**
    *
    * @param fileName input for the file name to parse.
    * @throws IOException throws an exception if the file is not found
    */
   public void readItemFile(String fileName) throws IOException {
      Scanner scan = new Scanner(new File(fileName));
      listName = scan.nextLine();
      String[] elements;
      char type;
      String typeS;
      while (scan.hasNext()) {
         String input = scan.nextLine();
         elements = input.split(",");
         typeS = elements[0];
         type = typeS.toUpperCase().charAt(0);

         // Switch variables
         String nameIn;
         String flavorIn;
         int quantityIn;
         double crustCostIn;
         int layersIn;
         int tiersIn;
         String[] ingredients = new String[50];
         int j;
         String[] ingredientsTrim;

         switch (type) {
            case 'C':
               nameIn = elements[1];
               flavorIn = elements[2];
               quantityIn = Integer.parseInt(elements[3]);
               j = 0;
               for (int i = 0; i < elements.length - 4; i++) {
                  ingredients[i] = elements[i + 4];
                  j++;
               }
               ingredientsTrim = Arrays.copyOf(ingredients, j);
               Cookie c = new Cookie(nameIn, flavorIn, quantityIn,
                     ingredientsTrim);
               itemList[itemCount] = c;
               itemCount++;
               break;

            case 'P':
               nameIn = elements[1];
               flavorIn = elements[2];
               quantityIn = Integer.parseInt(elements[3]);
               crustCostIn = Double.parseDouble(elements[4]);
               j = 0;
               for (int i = 0; i < elements.length - 5; i++) {
                  ingredients[i] = elements[i + 5];
                  j++;
               }
               ingredientsTrim = Arrays.copyOf(ingredients, j);
               Pie p = new Pie(nameIn, flavorIn, quantityIn, crustCostIn,
                     ingredientsTrim);
               itemList[itemCount] = p;
               itemCount++;
               break;

            case 'K':
               nameIn = elements[1];
               flavorIn = elements[2];
               quantityIn = Integer.parseInt(elements[3]);
               layersIn = Integer.parseInt(elements[4]);
               j = 0;
               for (int i = 0; i < elements.length - 5; i++) {
                  ingredients[i] = elements[i + 5];
                  j++;
               }
               ingredientsTrim = Arrays.copyOf(ingredients, j);
               Cake k = new Cake(nameIn, flavorIn, quantityIn, layersIn,
                     ingredientsTrim);
               itemList[itemCount] = k;
               itemCount++;
               break;

            case 'W':
               nameIn = elements[1];
               flavorIn = elements[2];
               quantityIn = Integer.parseInt(elements[3]);
               layersIn = Integer.parseInt(elements[4]);
               tiersIn = Integer.parseInt(elements[5]);
               j = 0;
               for (int i = 0; i < elements.length - 6; i++) {
                  ingredients[i] = elements[i + 6];
                  j++;
               }
               ingredientsTrim = Arrays.copyOf(ingredients, j);
               WeddingCake w = new WeddingCake(nameIn, flavorIn, quantityIn,
                     layersIn, tiersIn, ingredientsTrim);
               itemList[itemCount] = w;
               itemCount++;
               break;

            default:
               excludedRecords[excludedCount] = input;
               excludedCount++;
               break;
         }
      }
   }

   /**
    * @return returns a string of the itemlist as is
    */
   public String generateReport() {
      String result = "---------------------------------------\n"
            + "Report for Auburn's Best Bakery\n"
            + "---------------------------------------\n\n";
      for (int i = 0; i < itemCount; i++) {
         result += itemList[i].toString() + "\n\n";
      }
      return result;
   }

   /**
    * @return returns a string of the itemlist ordered by the class name
    */
   public String generateReportByClass() {
      BakedItem[] itemListCopy = Arrays.copyOf(itemList, itemCount);
      Arrays.sort(itemListCopy);
      String result = "---------------------------------------\n"
            + "Report for Auburn's Best Bakery (by Class)\n"
            + "---------------------------------------\n\n";
      for (int i = 0; i < itemCount; i++) {
         result += itemListCopy[i].toString() + "\n\n";
      }
      return result;
   }

   /**
    * @return returns a string of the itemlist ordered by the price
    */
   public String generateReportByPrice() {
      BakedItem[] itemListCopy = Arrays.copyOf(itemList, itemCount);
      Arrays.sort(itemListCopy, new PriceComparator());
      String result = "---------------------------------------\n"
            + "Report for Auburn's Best Bakery (by Price)\n"
            + "---------------------------------------\n\n";
      for (int i = 0; i < itemCount; i++) {
         result += itemListCopy[i].toString() + "\n\n";
      }
      return result;
   }

   /**
    * @return returns a string of the itemlist ordered by the flavor
    */
   public String generateReportByFlavor() {
      BakedItem[] itemListCopy = Arrays.copyOf(itemList, itemCount);
      Arrays.sort(itemListCopy, new FlavorComparator());
      String result = "---------------------------------------\n"
            + "Report for Auburn's Best Bakery (by Flavor)\n"
            + "---------------------------------------\n\n";
      for (int i = 0; i < itemCount; i++) {
         result += itemListCopy[i].toString() + "\n\n";
      }
      return result;
   }

   /**
    * @return returns a string of the excludedlist
    */
   public String generateExcludedRecordsReport() {
      String result = "---------------------------------------\n"
            + "Excluded Records Report\n"
            + "---------------------------------------\n\n";
      for (int i = 0; i < excludedCount; i++) {
         result += "*** invalid category *** for line:\n"
               + excludedRecords[i] + "\n";
      }
      return result;
   }
}
