package classloader;

public class ExtensionDemo {
 public static void main(String[] args) {
  try {
   System.out.println(Class.forName("classloader.BootStrapDemo").getClassLoader().getClass());
  } catch (ClassNotFoundException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
 }
}
