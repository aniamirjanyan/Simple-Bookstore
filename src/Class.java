import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Class {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Bookstore." + '\n');
        Bookstore.entrance();
    }

    // ---------- SHORT ------------
    public static List<Book> shortBooks(List<String[]> data) throws IOException {
        data = getData();
        List<Book> shortBooks = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            String[] s = data.get(i);
            Book book = shortFormat(s); // receiving each line as an object
            shortBooks.add(book); // adding objects to the cars list
        }
        return shortBooks;
    }

    // ----------- FULL ------------
    public static List<Book> fullBooks(List<String[]> data) throws IOException {
        data = getData();
        List<Book> fullBooks = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            String[] s = data.get(i);
            Book book = fullFormat(s); // receiving each line as an object
            fullBooks.add(book); // adding objects to the cars list
        }
        return fullBooks;
    }

    // gets data from the csv file
    public static List<String[]> getData() throws IOException {
        String file = "C:\\Users\\aniam\\Documents\\JAVA\\BookData.csv";
        List<String[]> data = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] l = line.split(",");
            data.add(l); //storing each line into content list as an array
        }
        return data;
    }

    public static Book shortFormat(String[] arr) {
        return new Book(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], Integer.parseInt(arr[4]), Integer.parseInt(arr[5]));
    }

    public static Book fullFormat(String[] arr) {
        return new Book(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], Integer.parseInt(arr[4]), Integer.parseInt(arr[5]), arr[6]);
    }

}
