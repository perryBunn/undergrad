public class AnagramCounter {
   public static void main(String[] args) {
      String s1 = "GARDEN";
      String s2 = "DANGER";
      int[] c1 = new int[26];
      int[] c2 = new int[26];
      int EAX = 1;
      
      for(int i = 0; i < s1.length(); i++) {
         char c = s1.charAt(i);
         c1[c - 65]++;
         c = s2.charAt(i);
         c2[c - 65]++;
      }
      
      for(int i = 0; i < c1.length; i++) {
         if (c1[i] != c2[i]) {
            EAX = 0;
            break;
         }
      }      
   }
}