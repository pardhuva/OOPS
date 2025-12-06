import java.util.Objects;
import java.util.*;
 class Book {
    private String isbn;
    private String title;
    private String author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    @Override
    public String toString() {
        return "ISBN: " + isbn + ", Title: " + title + ", Author: " + author;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isbn.equals(book.isbn);
    }
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}

 class Library {
    private Map<String, Book> books;

    public Library() {
        books = new HashMap<>();
    }
    public void addBook(String isbn, String title, String author) {
        if (books.containsKey(isbn)) {
            Book book = books.get(isbn);
            book.setTitle(title);
            book.setAuthor(author);
            System.out.println("Updated book with ISBN: " + isbn);
        } else {
            books.put(isbn, new Book(isbn, title, author));
            System.out.println("Added new book with ISBN: " + isbn);
        }
    }
    public void removeBook(String isbn) {
        if (books.containsKey(isbn)) {
            books.remove(isbn);
            System.out.println("Removed book with ISBN: " + isbn);
        } else {
            System.out.println("Book with ISBN " + isbn + " not found.");
        }
    }
    public String findBookByIsbn(String isbn) {
        Book book = books.get(isbn);
        if (book != null) {
            return "Title: " + book.getTitle() + ", Author: " + book.getAuthor();
        } else {
            return "Book not found.";
        }
    }
    public void listAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        books.values().stream()
                .sorted(Comparator.comparing(Book::getIsbn))
                .forEach(System.out::println);
    }
}
class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook("978-0-43913-636-5","Harry Potter and the Prisoner of Azkaban","J.K.Rowling");
        library.addBook("978-1-86197-876-9", "1984", "George Orwell");
        library.addBook("978-0-7432-7356-5", "To Kill a Mockingbird", "Harper Lee");
        library.addBook(" 978-0-14312-774-1","The Alchemist","Paulo Coelho");
        System.out.println("\nList of all books:");
        library.listAllBooks();

        System.out.println("\nFind book by ISBN '978-0-43913-636-5':");
        System.out.println(library.findBookByIsbn("978-0-43913-636-5"));

        library.removeBook("978-1-86197-876-9");

        System.out.println("\nList of all books after removal:");
        library.listAllBooks();

        System.out.println("\nFind book by ISBN '978-1-86197-876-9':");
        System.out.println(library.findBookByIsbn("978-1-86197-876-9"));
    }
}
