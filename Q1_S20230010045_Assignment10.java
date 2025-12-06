import java.io.*;
import java.util.*;

public class Q1_S20230010045_Assignment10 {
    static File f = new File("file1.txt");
    static File file = new File("file2.txt");

    // File creation
    public static void filecreation() {
        try {
            if (file.createNewFile()) {
                System.out.println("file is created: " + file.getName());
            } else {
                System.out.print("file already exists: ");
                System.out.println(file.exists());
            }

            try {
                if (f.createNewFile()) {
                    System.out.println("file is created: " + f.getName());
                } else {
                    System.out.println("file already exists");
                    System.out.println(f.getAbsolutePath());
                }
            } catch (IOException e) {
                System.out.println("error occurred: " + e);
            }
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    // Writing to file
    public static void writeintofile() {
        try (
                FileOutputStream fi1 = new FileOutputStream("file1.txt");
                FileWriter fi2 = new FileWriter("file2.txt")) {
            // to read for byte stream
            InputStream is = System.in;
            // to read for charstream
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("enter the data for byte stream(press enter to finish): ");
            int data;

            while ((data = is.read()) != -1 && data != '\n') {
                fi1.write(data);
            }
            System.out.println("data is written");
            fi1.close();

            System.out.println("enter characters for charStream(enter 'q' to exit):");
            char c;
            do {
                c = (char) br.read();
                if (c != 'q') {
                    fi2.write(c);
                }
            } while (c != 'q');
            fi2.close();
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    // Display contents of file1 and file2
    public static void displaycontents() {
        try (
                FileReader fr2 = new FileReader("file2.txt");
                FileInputStream fr1 = new FileInputStream("file1.txt")) {
            int data1;
            int data2;
            System.out.println("File1 contents:");
            while ((data1 = fr1.read()) != -1) {
                System.out.print((char) data1);
            }
            System.out.println("\nFile2 contents: ");
            while ((data2 = fr2.read()) != -1) {
                System.out.print((char) data2);
            }
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    // Count characters, lines, and words in file2
    public static void displaycount() {
        try (
                BufferedReader br = new BufferedReader(new FileReader("file2.txt"))) {
            char c;
            int charcount = 0;
            int linecount = 0;
            int wordcount = 0;
            String line;

            while ((line = br.readLine()) != null) {
                linecount++;
                charcount += line.length();
                String[] words = line.split("\\s+");
                wordcount += words.length;
            }

            System.out.println("char count: " + charcount);
            System.out.println("line count: " + linecount);
            System.out.println("word count: " + wordcount);
        } catch (IOException e) {
            System.out.println("Exception occurred: " + e);
        }
    }

    // Copy contents from file1 to file2 line by line
    public static void copyLineByLine() {
        try (
                BufferedReader br1 = new BufferedReader(new FileReader("file1.txt"));
                FileWriter fw2 = new FileWriter("file2.txt", true)) { // Append mode
            String line;
            while ((line = br1.readLine()) != null) {
                fw2.write(line + "\n");
            }
            System.out.println("Contents copied line by line.");
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    // Copy contents from file1 to file2 word by word
    public static void copyWordByWord() {
        try (
                BufferedReader br1 = new BufferedReader(new FileReader("file1.txt"));
                FileWriter fw2 = new FileWriter("file2.txt", true)) { // Append mode
            String line;
            while ((line = br1.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    fw2.write(word + " ");
                }
            }
            System.out.println("Contents copied word by word.");
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    // Copy contents from file1 to file2 character by character
    public static void copyCharByChar() {
        try (
                FileInputStream fr1 = new FileInputStream("file1.txt");
                FileWriter fw2 = new FileWriter("file2.txt", true)) { // Append mode
            int data;
            while ((data = fr1.read()) != -1) {
                fw2.write(data);
            }
            System.out.println("Contents copied character by character.");
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    // Search for a keyword in file2 and count occurrences
    public static void searchKeywordInFile() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the keyword to search: ");
        String keyword = sc.nextLine();

        try (
                BufferedReader br = new BufferedReader(new FileReader("file2.txt"))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(keyword)) {
                        count++;
                    }
                }
            }
            System.out.println("The keyword '" + keyword + "' appeared " + count + " times.");

            // Append the count to file2
            try (FileWriter fw2 = new FileWriter("file2.txt", true)) {
                fw2.write("\nThe keyword '" + keyword + "' appeared " + count + " times.\n");
            }

        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    public static void main(String[] args) {
        filecreation();
        writeintofile();
        displaycontents();
        displaycount();

        
        copyLineByLine();
        copyWordByWord();
        copyCharByChar();
        searchKeywordInFile();
    }
}
