import java.io.File;
import java.awt.Desktop;

/**   */
public class OpenFileInDesktop {

   /**  @param args not used */
   public static void main(String[] args) {
   
      try  // open file in desktop with default application
      {
         File f = new File("01_war_eagle.mp3");  
         //File f = new File("IMG_0861.jpg");
         Desktop dt = Desktop.getDesktop();
         dt.open(f);
      }
      catch (Exception exc) { /*handle exception*/
         exc.printStackTrace();    
      }
   }
}