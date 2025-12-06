
import java.util.*;
public class Q1S20230010045_Assignment9{
    public static void dividing(int a){
        int b;
        int[] c=new int[4];
        String str="abc";
        try{
           if(a==1){
           b=a/0;
           System.out.println("This is not printed");}
           else if(a==2){
               System.out.println(c[4]);
           }
           else if(a==3){
               System.out.println(str.charAt(8));
           }
           else if(a==4){
               int d=Integer.parseInt(str);
           }
        }
        catch(ArithmeticException e){
            System.out.println("divided by zero");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndex is invalid");
        }
        catch(StringIndexOutOfBoundsException  e){
            System.out.println("Index is Invalid");
        }
        catch(NumberFormatException e){
            System.out.println("Format mismatch");
        }
        finally{
        System.out.println("Exception Handling Completed");
        }
    }
    public static void main(String[] args) {
        for(int a=1;a<5;a++){
        dividing(a);
        }
    }
}