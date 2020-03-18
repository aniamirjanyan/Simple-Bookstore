import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bookstore {
    public static Scanner input = new Scanner(System.in);

    public static void entrance() throws IOException {
        System.out.println("Choose your action:");
        System.out.println("1 - View Books" + '\n' +
                "2 - View Wallet");
        char num = input.next().charAt(0);
        if (num == '1') {
            viewBooks();
        } else if (num == '2') {
            Wallet.viewWallet();
        } else {
            System.out.println("You have entered an invalid character." + '\n');
            entrance();
        }
    }

    private static void viewBooks() throws IOException {
        List<Book> viewList = Class.shortBooks(Class.getData());
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.printf("%40s %21s %20s %8s", "TITLE", "AUTHOR", "GENRE", "PRICE");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------");
        for (Book book : viewList) {
            System.out.format("%40s %21s %20s %8s",
                    book.getTitle(), book.getAuthor(), book.getGenre(), book.getPrice());
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------------------------");

        System.out.println("1 - Buy a book." + '\n' +
            "2 - Go back.");
        char num = input.next().charAt(0);
        if (num == '1') {
            buyBook(titleListMaker(), authorListMaker());
        } else if (num == '2') {
            entrance();
        } else {
            System.out.println("You have entered an invalid character.");
            viewBooks();
        }
    }

    // makes a list of titles to be used for buyBook method to scan through
    public static List<String> titleListMaker() throws IOException {
        List<Book> list = Class.shortBooks(Class.getData());
        List<String> titleList = new ArrayList<>();

        for (Book book : list) {
            titleList.add(book.getTitle());
        }
        return titleList;
    }
    // makes a list of authors to be used for buyBook method to scan through
    public static List<String> authorListMaker() throws IOException {
        List<Book> list = Class.shortBooks(Class.getData());
        List<String> authorList = new ArrayList<>();

        for (Book book : list) {
            authorList.add(book.getAuthor());
        }
        return authorList;
    }

    public static void buyBook(List<String> titleList, List<String> authorList) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title or the author of the book: ");
        String bookInput = scanner.nextLine();
        boolean matchFound = false;
        for (int i = 0; i < titleList.size(); i++) {
            if (bookInput.equals(titleList.get(i))) {
                //System.out.println("You picked " + bookInput + '\n');
                matchFound = true;
                Wallet.theOneBook(bookInput, Class.shortBooks(Class.getData()));
            } else if (bookInput.equals(authorList.get(i))) {
                //System.out.println("You picked " + bookInput + '\n');
                matchFound = true;
                // sends to theOneBook
                Wallet.theOneBook(bookInput, Class.shortBooks(Class.getData()));
            }
        }
        if (!matchFound) {
            System.out.println("There is no book with that title.");
            buyBook(titleList, authorList);
        }
    }

}
