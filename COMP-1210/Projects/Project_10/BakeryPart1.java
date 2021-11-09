package com.perryBunn.java;

/**
 *
 */
public class BakeryPart1 {
   /**
    * @param args command line arguments
    */
   public static void main(String[] args) {
      // BakedItem class

      // Cookie class
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12,
            "flour", "sugar", "dark chocolate chips",
            "butter", "baking soda", "salt");
            
      System.out.println("Cookie");
      System.out.println(c.toString());
      System.out.println("\tc cost: " + c.price() + "\n");
      
      Cookie cITest = new Cookie("Chips Delight", "Chocolate Chip", 12,
            "flour", "sugar", "dark chocolate chips",
            "butter", "baking soda", "salt", "flour", "sugar", 
            "dark chocolate chips", "butter", "baking soda", "salt");
      System.out.println(cITest.toString());

      // Pie class
      Pie p1 = new Pie("Weekly Special", "Apple", 1, 0,
            "flour", "sugar", "apples", "cinnamon",
            "butter", "baking soda", "salt");
      Pie p2 = new Pie("Summer Special", "Key Lime", 1, 2.0,
            "flour", "sugar", "lime juice", "lemon juice",
            "graham crackers", "butter", "baking soda", "salt");
            
      System.out.println("Pie");
      System.out.println(p1.toString());
      System.out.println("\tp1 price: $" + p1.price());
      System.out.print("\tp1 crust cost: " + p1.getCrustCost() + " --> ");
      p1.setCrustCost(3);
      System.out.println(p1.getCrustCost());
      System.out.println("\tp1 price: $" + p1.price() + "\n");
      System.out.println(p2.toString());
      System.out.println("\tp2 price: $" + p2.price());
      System.out.print("\tp2 crust cost: " + p2.getCrustCost() + " --> ");
      p2.setCrustCost(1);
      System.out.println(p2.getCrustCost());
      System.out.println("\tp2 price: $" + p2.price() + "\n");
      
      // Cake class
      Cake c1 = new Cake("Birthday", "Chocolate", 1, 1,
            "flour", "sugar", "cocoa powder", "vanilla", "eggs",
            "butter", "baking soda", "baking powder", "salt");
      Cake c2 = new Cake("2-Layer", "Red Velvet", 1, 2,
            "flour", "sugar", "cocoa powder", "food coloring",
            "eggs", "butter", "baking soda", "baking powder",
            "salt");
            
      System.out.println("Cake");
      System.out.println(c1.toString());
      System.out.println("\tc1 price: $" + c1.price());
      System.out.print("\tc1 layers: " + c1.getLayers() + " --> ");
      c1.setLayers(3);
      System.out.println(c1.getLayers());
      System.out.println("\tc1 price: $" + c1.price() + "\n");
      System.out.println(c2.toString());
      System.out.println("\tc2 price: $" + c2.price());
      System.out.print("\tc2 layers: " + c2.getLayers() + " --> ");
      c2.setLayers(6);
      System.out.println(c2.getLayers());
      System.out.println("\tc2 price: $" + c2.price() + "\n");
      
      // WeddingCake class
      WeddingCake c3 = new WeddingCake("3-Layer/3-Tier", "Vanilla", 1, 3, 3,
            "flour", "sugar", "buttermilk", "coffee",
            "eggs", "butter", "baking soda", "baking powder",
            "salt");
            
      System.out.println("Wedding Cake");
      System.out.println(c3.toString());
      System.out.println("\tc3 price: $" + c3.price());
      System.out.print("\tc3 Tiers: " + c3.getTiers() + " --> ");
      c3.setTiers(1);
      System.out.println(c3.getTiers());
      System.out.println("\tc3 price: $" + c3.price());
   }
}