import java.io.*;
 
public class TestClass {
 
  public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
   
    String strFilePath = "C://demo.ser";
    ObjectOutputStream output;
   
     try
     {
       
      FileOutputStream fos = new FileOutputStream(strFilePath, true);
      
      output=new  ObjectOutputStream(fos);
      
      String strContent = "Append output to a file example\n",str="Jawad";
     
      output.writeObject(strContent);
      output.writeObject(str);
      
     
       output.close();
     
     }
     catch(FileNotFoundException ex)
     {
      System.out.println("FileNotFoundException : " + ex);
     }
     catch(IOException ioe)
     {
      System.out.println("IOException : " + ioe);
     }
     
     
     
     ObjectInputStream input = new ObjectInputStream(new FileInputStream(strFilePath));
     
   
     System.out.println(input.readObject());
     System.out.println(input.readObject());


     input.close();
     
  	}
  }
