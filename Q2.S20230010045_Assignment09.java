
import java.util.*;
public class Q2S20230010045_Assignment9 {
    static void exceptionA(String s) throws Exception{
        char a='d';
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'){
                a=s.charAt(i);
            }
        }
        if(a=='d'){
            System.out.println("string doesnot contain vowels");
            throw new Exception();
        }
    }
    static void exceptionB() throws Exception{
        ArrayList<Integer>list =new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the count");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int t=sc.nextInt();
            if(list.contains(t)){
                throw new Exception();
            }
            else{
                list.add(t);
            }
        }
    }
    static void  Unreachablecatchblockerror(){
        int p=3;
        try{
            int j=p/(p-p);
        }
        catch(Exception e){
            System.out.println("exception is caught");
        }
        // catch(ArithmeticException e){
        //     System.out.println("arithmetic exception is found");
        // }
    }
    static void exceptionC() throws ArithmeticException,NullPointerException{
        int y=4;
        try{
            int z=4/0;
        }
        catch(ArithmeticException e){
            System.out.println("arithmetic exception is caught");
        }
        String str=null;
        try{
            int len=str.length();
        }
        catch(NullPointerException e){
            System.out.println("nullpointer exception is caught");
        }
    }
    public static void main(String[] args) {
        try{
        exceptionA("str");
        }
        catch(Exception e){
            System.out.println("exception is caught");
        }
        try{
            exceptionB();
        }
        catch(Exception e){
            System.out.println("Duplicates found");
            System.out.println("exception is caught");
        }
        Unreachablecatchblockerror();
        
        exceptionC();
        
        
        
    }
}