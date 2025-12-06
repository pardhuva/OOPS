class Library {
    public String Name;
    public String Location;
    Book[] books;
    int bookcount;

    public Library(String Name, String Location){
        this.Name = Name;
        this.Location = Location;
        this.books = new Book[50];
        this.bookcount= 0;
        

    }



    public void displayLibraryInfo(){
        System.out.println("\nthe name of the library is: " + Name);
        System.out.println("Location : " + Location);

    }

    void addBook(String title, String author, String ISBN) {
        Book newBook = new Book(title, author, ISBN); 
        books[bookcount] = newBook;
        bookcount++;
        newBook.displayBookInfo();
    }

    void showBooks() {
        System.out.println("\nBooks in the Library:");
        for (int i = 0; i < bookcount; i++) {
            books[i].displayBookInfo();
        }
    }
}

class Book{
    public String title;
    public String author;
    public String ISBN;

    Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        
    }

    public void displayBookInfo(){
        System.out.println("\nTitle : " + title);
        System.out.println("Author : " + author);
        System.out.println("ISBN : " + ISBN);
    }
}

public class S202300100045_practice6p1 {
    public static void main(String[] args) {
        
        Library library = createLibrary();

        
        addBooksToLibrary(library);

        
        library.displayLibraryInfo();

        
        library.showBooks();
    }

    
    private static Library createLibrary() {
        return new Library("City Library", "123 Main St");
    }

    
    private static void addBooksToLibrary(Library library) {
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");
        library.addBook("To Kill a Mockingbird", "Harper Lee", "9780061120084");
        library.addBook("1984", "George Orwell", "9780451524935");
        library.addBook("The Catcher in the Rye", "J.D. Salinger", "9780316769488");
    }
}

