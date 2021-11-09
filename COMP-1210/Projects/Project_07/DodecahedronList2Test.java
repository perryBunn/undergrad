import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

/**
*
*/
public class DodecahedronList2Test {

   // Variables, objects and list
   private String listName = "List Test Name";
   private static int arrSizeTest = 0;
   private Dodecahedron[] dodObjList = new Dodecahedron[20];
   private Dodecahedron[] dodObjNullList = new Dodecahedron[20];

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Before
   public void setUp() throws Exception {
      arrSizeTest = 0;
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void getNameTest() throws Exception {
      DodecahedronList2 dodTest2 = new DodecahedronList2(listName,  
                                                   dodObjList, arrSizeTest);
      Assert.assertEquals("", "List Test Name", dodTest2.getName());
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void numberOfDodecahedronsTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Dodecahedron dodObj = new Dodecahedron("test" + i, "color"  
                                                            + i, i + .25);
         dodObjList[i] = dodObj;
         arrSizeTest++;
      }
      DodecahedronList2 dodTest2 = new DodecahedronList2(listName, 
                                                   dodObjList, arrSizeTest);
      Assert.assertEquals("", 5, dodTest2.numberOfDodecahedrons());

      DodecahedronList2 dodNullTest2 = new DodecahedronList2(listName,  
                                                   dodObjNullList, 1);
      Assert.assertEquals("", 0, dodNullTest2.numberOfDodecahedrons());
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void totalSurfaceAreaTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Dodecahedron dodObj = new Dodecahedron("test" + i, "color"  
                                                            + i, i + .25);
         dodObjList[i] = dodObj;
         arrSizeTest++;
      }
      DodecahedronList2 dodTest2 = new DodecahedronList2(listName,  
                                                   dodObjList, arrSizeTest);
      double total = 0;
      for (int i = 0; i < arrSizeTest; i++) {
         total += dodObjList[i].surfaceArea();
      }
      Assert.assertEquals("", total, dodTest2.totalSurfaceArea(), .001);
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void totalVolumeTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Dodecahedron dodObj = new Dodecahedron("test" + i, "color"  
                                                            + i, i + .25);
         dodObjList[i] = dodObj;
         arrSizeTest++;
      }
      DodecahedronList2 dodTest2 = new DodecahedronList2(listName,  
                                                   dodObjList, arrSizeTest);
      double total = 0;
      for (int i = 0; i < arrSizeTest; i++) {
         total += dodObjList[i].volume();
      }
      Assert.assertEquals("", total, dodTest2.totalVolume(), .001);
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void averageSurfaceAreaTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Dodecahedron dodObj = new Dodecahedron("test" + i, "color"  
                                                            + i, i + .25);
         dodObjList[i] = dodObj;
         arrSizeTest++;
      }
      DodecahedronList2 dodTest2 = new DodecahedronList2(listName,  
                                                   dodObjList, arrSizeTest);
      double total = 0;
      for (int i = 0; i < arrSizeTest; i++) {
         total += (dodObjList[i].surfaceArea()) / arrSizeTest;
      }
      Assert.assertEquals("", total, dodTest2.averageSurfaceArea(), .001);
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void averageVolumeTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Dodecahedron dodObj = new Dodecahedron("test" + i, "color"  
                                                            + i, i + .25);
         dodObjList[i] = dodObj;
         arrSizeTest++;
      }
      DodecahedronList2 dodTest2 = new DodecahedronList2(listName,  
                                                   dodObjList, arrSizeTest);
      double total = 0;
      for (int i = 0; i < arrSizeTest; i++) {
         total += (dodObjList[i].volume()) / arrSizeTest;
      }
      Assert.assertEquals("", total, dodTest2.averageVolume(), .0001);
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void averageSurfaceToVolumeRatioTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Dodecahedron dodObj = new Dodecahedron("test" + i, "color"  
                                                            + i, i + .25);
         dodObjList[i] = dodObj;
         arrSizeTest++;
      }
      DodecahedronList2 dodTest2 = new DodecahedronList2(listName,  
                                                   dodObjList, arrSizeTest);
      double total = 0;
      for (int i = 0; i < arrSizeTest; i++) {
         total += dodObjList[i].surfaceToVolumeRatio()
                 / arrSizeTest;
      }
      Assert.assertEquals("", total, dodTest2.averageSurfaceToVolumeRatio(), 
                                                                     .0001);
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void toStringTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Dodecahedron dodObj = new Dodecahedron("test" + i, "color"  
                                                            + i, i + .25);
         dodObjList[i] = dodObj;
      }
      Assert.assertEquals("", true, dodObjList[4].toString()
                                    .contains(" with 30 edges of length "));
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void summaryInfoTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Dodecahedron dodObj = new Dodecahedron("test" + i, "color"  
                                                            + i, i + .25);
         dodObjList[i] = dodObj;
      }
      DodecahedronList2 dodTest2 = new DodecahedronList2(listName,  
                                                   dodObjList, arrSizeTest);
      Assert.assertEquals("", true, dodTest2.summaryInfo()
                                                .contains("Total Volume: "));
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void getListTest() throws Exception {
      setUp();
      DodecahedronList2 dodTest2 = new DodecahedronList2(listName,  
                                                   dodObjList, arrSizeTest);
      Assert.assertArrayEquals("", dodObjList, dodTest2.getList());
   }

   /**
    *
    * @throws IOException thows exception bc it might not fine a file
    */
   @Test
   public void readFileTest() throws IOException {
      DodecahedronList2 dodList2 = new DodecahedronList2("test list", null, 0);
      dodList2 = dodList2.readFile("dodecahedron_data_1.txt");
      Assert.assertEquals("", "Dodecahedron Test List", dodList2.getName());
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void addDodecahedronTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Dodecahedron dodObj = new Dodecahedron("test" + i, "color"  
                                                            + i, i + .25);
         dodObjList[i] = dodObj;
         arrSizeTest++;
      }
      DodecahedronList2 dodTest2 = new DodecahedronList2(listName,  
                                                   dodObjList, arrSizeTest);
      Dodecahedron dTrue = new Dodecahedron("test", "cyan", 2.5);
      dodTest2.addDodecahedron("test", "cyan", 2.5);

      Assert.assertEquals("", dTrue, dodObjList[arrSizeTest]);
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void findDodecahedronTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Dodecahedron dodObj = new Dodecahedron("test" + i, "color"  
                                                            + i, i + .25);
         dodObjList[i] = dodObj;
         arrSizeTest++;
      }
      DodecahedronList2 dodTest2 = new DodecahedronList2(listName,  
                                                   dodObjList, arrSizeTest);
      Dodecahedron dTrue = new Dodecahedron("test4", "color4", 4.25);
      Assert.assertEquals("", dTrue, dodTest2.findDodecahedron("test4"));
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void deleteDodecahedronTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Dodecahedron dodObj = new Dodecahedron("test" + i, "color"  
                                                            + i, i + .25);
         dodObjList[i] = dodObj;
         arrSizeTest++;
      }
      DodecahedronList2 dodTest2 = new DodecahedronList2(listName, 
                                                dodObjList, arrSizeTest);
      dodTest2.deleteDodecahedron("test4");
      Dodecahedron dTrue = new Dodecahedron("test2", "color2", 2.25);
      Assert.assertFalse("", dTrue == dodTest2.findDodecahedron("test2"));
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void editDodecahedronTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Dodecahedron dodObj = new Dodecahedron("test" + i, "color" 
                                                            + i, i + .25);
         dodObjList[i] = dodObj;
         arrSizeTest++;
      }
      DodecahedronList2 dodTest2 = new DodecahedronList2(listName, 
                                                dodObjList, arrSizeTest);
      dodTest2.editDodecahedron("test4", "cyan", 425);
      Dodecahedron dTrue = new Dodecahedron("test4", "cyan", 425);
      Assert.assertEquals("", dTrue, dodTest2.findDodecahedron("test4"));
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
    public void findDodecahedronWithShortestEdgeTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Dodecahedron dodObj = new Dodecahedron("test" + i, "color" 
                                                            + i, i + .25);
         dodObjList[i] = dodObj;
         arrSizeTest++;
      }
      DodecahedronList2 dodTest2 = new DodecahedronList2(listName, 
                                                dodObjList, arrSizeTest);
      Dodecahedron dTrue = new Dodecahedron("test0", "color0", .25);
      Assert.assertEquals("", dTrue, 
                              dodTest2.findDodecahedronWithShortestEdge());
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void findDodecahedronWithLongestEdgeTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Dodecahedron dodObj = new Dodecahedron("test" + i, "color" 
                                                            + i, i + .25);
         dodObjList[i] = dodObj;
         arrSizeTest++;
      }
      DodecahedronList2 dodTest2 = new DodecahedronList2(listName, 
                                                dodObjList, arrSizeTest);
      Dodecahedron dTrue = new Dodecahedron("test4", "color4", 4.25);
      Assert.assertEquals("", dTrue, 
                              dodTest2.findDodecahedronWithLongestEdge());
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void findDodecahedronWithSmallestVolumeTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Dodecahedron dodObj = new Dodecahedron("test" + i, "color"
                                                               + i, i + .25);
         dodObjList[i] = dodObj;
         arrSizeTest++;
      }
      DodecahedronList2 dodTest2 = new DodecahedronList2(listName, 
                                                dodObjList, arrSizeTest);
      Dodecahedron dTrue = new Dodecahedron("test0", "color0", .25);
      Assert.assertEquals("", dTrue, 
                           dodTest2.findDodecahedronWithSmallestVolume());
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void findDodecahedronWithLargestVolumeTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Dodecahedron dodObj = new Dodecahedron("test" + i, "color" 
                                                         + i, i + .25);
         dodObjList[i] = dodObj;
         arrSizeTest++;
      }
      DodecahedronList2 dodTest2 = new DodecahedronList2(listName, 
                                             dodObjList, arrSizeTest);
      Dodecahedron dTrue = new Dodecahedron("test4", "color4", 4.25);
      Assert.assertEquals("", dTrue, 
                        dodTest2.findDodecahedronWithLargestVolume());
   }
}