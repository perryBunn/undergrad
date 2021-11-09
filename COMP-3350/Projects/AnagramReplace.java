public class AnagramReplace {
   public static void main(String[] args) {
      String s1 = "GARDENA";
      String s2 = "DANGERZ";
      int eax = 1;
      
      for(int i = 0; i < s1.length(); i++) {
         char c = s1.charAt(i);
         for(int j = 0; j < s2.length(); j++) {
            if(c == s2.charAt(j)) {
               s2 = s2.substring(0, j) + s2.substring(j + 1);
               break;
            }
         }
      }
      if(s2.length() > 0){
         eax = 0;
      }
   }
}