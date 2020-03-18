import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Wallet {
    public static boolean isUpdated = false;
    public static int currentMoney = 1000;
    public static Scanner input = new Scanner(System.in);
    public static Scanner yesno = new Scanner(System.in);

    static void viewWallet() throws IOException {
        if(!isUpdated) {
            System.out.println("You have $" + currentMoney + '\n');
        } else {
            System.out.println("You have $" + currentMoney + '\n');
        }
        Bookstore.entrance();
    }

    // specifies the exact book to buy, sends to bookPrice
    public static void theOneBook(String bookInput, List<Book> shortBooks) throws IOException {
        shortBooks = Class.shortBooks(Class.getData());
        for (Book theBook : shortBooks) {
            if (theBook.getTitle().equals(bookInput) || theBook.getAuthor().equals(bookInput)) {
                bookPrice(theBook);
            }
        }
    }

    // receives theBook sends to updateWallet and updateCopies
    public static void bookPrice(Book theBook) throws IOException {
        int thePrice = theBook.getPrice();
        System.out.println("Do you want to buy " + theBook.getTitle() +
                " by " + theBook.getAuthor() + "for $" + thePrice +  "? (y/n)" + '\n');
        char ans = yesno.next().charAt(0);
        if (ans == 'n') {
            Bookstore.buyBook(Bookstore.titleListMaker(), Bookstore.authorListMaker());
        } else if (ans == 'y') {
            updateWallet(thePrice);
        }
    }

    // receives thePrice and subtracts from currentMoney
    private static void updateWallet(int thePrice) throws IOException {
        currentMoney = currentMoney - thePrice;
        if (currentMoney < 0) {
            System.out.println("You have insufficient funds." + '\n');
            currentMoney = currentMoney + thePrice;
        } else {
            System.out.println("You have successfully purchased the book." + '\n');
        }
        isUpdated = true;
        afterUpdate();
    }


    private static void afterUpdate() throws IOException {
        System.out.println("1 - View Wallet" + '\n'
                + "2 - Main Menu");
        char num = input.next().charAt(0);
        if (num == '1') {
            viewWallet();
        } else if (num == '2') {
            Bookstore.entrance();
        } else {
            System.out.println("You have entered an invalid character." + '\n');
            afterUpdate();
        }
    }


}

