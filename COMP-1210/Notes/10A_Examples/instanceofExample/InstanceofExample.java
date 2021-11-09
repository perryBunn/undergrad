public class InstanceofExample {

   public static void main(String[] args) {
   
      A a = new A();
      B b = new B();
      C c = new C();
      A a2 = new C();
   
      
      if (a instanceof A) {
         System.out.println("a is-an A");
      }
      
      if (b instanceof B) {
         System.out.println("b is-a B");
      }
      
      if (b instanceof A) {
         System.out.println("b is-an A");
      }
      
      if (c instanceof C) {
         System.out.println("c is-a C");
      }
      
      if (c instanceof B) {
         System.out.println("c a is-a B");
      }
      
      if (c instanceof A) {
         System.out.println("c is-an A");
      }
      
   }
}

class A {
   double x = 10;
   public A() {
   
   }
}

class B extends A {
   double y = 20;
   public B() {
      super();
   }
}

class C extends B {
   double z = 30;
   public C() {
      super();
   }
}
