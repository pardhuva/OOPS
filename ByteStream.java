import java.io.*;
import java.util.*;
public class ByteStream{
    static File f=new File("file1.txt");
    static File file=new File("file2.txt");

    public static void filecreation(){
        try{
        
         if(file.createNewFile()){
             System.out.println("file is created: "+file.getName());
         }
         else{
            System.out.print("fiel already exists: ");
            System.out.println(file.exists());
         }
        
        try{
            if(f.createNewFile()){
                System.out.println("file is created: "+f.getName());
            }
            else{
                System.out.println("file already exists");
                System.out.println(f.getAbsolutePath());
            }
        }
        catch(IOException e){
            System.out.println("error ccured: "+e);
        }
       }
        catch(IOException e){
            System.out.println("Exception:"+e);
        }
    }

    public static void writeintofile(){
        try(  //these classes might throw exception so we keep inside try block
        // write to a file of byte stream 
        FileOutputStream fi1 = new FileOutputStream("file1.txt");
        //file to write of char stream
        FileWriter fi2 = new FileWriter("file2.txt")){
        //to read for byte stream
        InputStream is=System.in;
        //to read for charstream
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the data for byte stream(press enter to finish): ");
        int data;
         
            while((data=is.read())!=-1&&data!='\n'){
              fi1.write(data);
            }
           System.out.println("data is written");
           fi1.close();

           System.out.println("enter characters for charStream(enter 'q' to exit):");
           char c;
           do{
           c=(char)br.read();
           if(c!='q'){
           fi2.write(c);
           }
           }while(c!='q');
           fi2.close();
        }
        catch(IOException e){
            System.out.println("Exception: "+e);
        }
        
    }

    public static void displaycontents(){
        try(
        //to read characters from a file 
        FileReader fr2=new FileReader("file2.txt");
        //to read bytes from a file
        FileInputStream fr1=new FileInputStream("file1.txt");
        )
        {
            int data1;
            int data2;
            System.out.println("File1 contents:");
            while((data1=fr1.read())!=-1){
                System.out.print((char)data1);
            }
            System.out.println("File2 contents: ");
            while((data2=fr2.read())!=-1){
               System.out.print((char)data2);
            }
            
        }
        catch(IOException e){
          System.out.println("Exception: "+e);
        }
    }
    public static void displaycount(){
        try(
        //to read from the char stream file

        BufferedReader br=new BufferedReader(new FileReader("file2.txt"))){
            char c;
            int charcount=0;
            int linecount=0;
            int wordcount=0;
            String line;
           
           while((line=br.readLine())!=null){
             linecount++;
             charcount += line.length();
             String[] words = line.split("\\s+");
             wordcount += words.length;
           }
           
           
           System.out.println("char count: "+charcount);
           System.out.println("line count: "+linecount);
           System.out.println("word count: "+wordcount);
        }
        catch(IOException e){
            System.out.println("eception occured "+e);
        }
    }
    public static void searchkeyword(){
        try(
            BufferedReader br=new BufferedReader(new FileReader("file2.txt"))
        ){
            System.out.println("enter the word to be searched:");
            Scanner sc=new Scanner(System.in);
            String cmp=sc.next();
            String line;
            int cnt=0;
            while((line=br.readLine())!=null){
                String[] words=line.split("\\+");
                for(String w:words){
                    if(w.equals(cmp)){
                      cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
        catch(IOException e){
            System.out.println("exception occured"+e);
        }
    }
    public static void main(String args[]){

        filecreation();
        writeintofile();
        displaycontents();
        displaycount();
        searchkeyword();
    }
}