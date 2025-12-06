
class Book{
    public String title;
    public String author;
    public double price;

    Book(String title,String author,double price){
        this.title=title;
        this.author=author;
        this.price=price; 
    }

    public void displayInfo(){
        System.out.println("Book Details: ");
        System.out.println("Book title: "+this.title);
        System.out.println("Book author: "+this.author);
        System.out.println("Book Price: "+this.price);
    }
    

}

class EBook extends Book{
      public double fileSize;

      EBook(String title,String author,double price,double fileSize){
        super(title,author,price);
        this.fileSize=fileSize;
      }

      public void displayInfo(){
          super.displayInfo();
          System.out.println("File Size: "+this.fileSize);
          System.out.println();
      }

      public String gettitle(){
        return super.title;
      }
      public String getauthor(){
         return super.author;
      }
      public double getprice(){
        return super.price;
      }
      public double getfilesize(){
        return super.fileSize;
      }
}

final class PrintedBook extends Book{
    public int numberOfPages;
    
    PrintedBook(String title,String author,double price,int numberOfPages){
        super(title,author,price);
        this.numberOfPages=numberOfPages;
    }

    public void displayInfo(){
        super.displayInfo();
        System.out.println("Number of Pages: "+numberOfPages);
        System.out.println();
    }
    public String gettitle(){
        return super.title;
    }
    public String getauthor(){
         return super.author;
    }  
    public double getprice(){
        return super.price;
    }
    public int getnumberOfPages(){
        return super.numberOfPages;
    }
}

public class Library{

    public static void main(String args[]){

        EBook e1=new EBook("Swami and his Friends","R.K Narayan",999.25,700.13);
        e1.displayInfo();
        EBook e2=new EBook("To Kill a MockingBird","Harper Lee",700.95,800.45);
        e2.displayInfo();
        System.out.println();
         
        PrintedBook p1=new PrintedBook("Panchathantra","Vishnu Sharma",900.25,1000);
        PrintedBook p2=new PrintedBook("Harry Potter","J.K Rowling",15000,3000);
        p1.displayInfo();
        p2.displayInfo();
    }
}