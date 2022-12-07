import EHMS.Headers;
import EHMS.Portal;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)throws IOException {
        boolean status = true;
        Scanner input = new Scanner(System.in);
        Headers header = new Headers();
        Portal portal = new Portal();
        System.out.println("+----------------------------------------+");
        System.out.println("+  --> E-Hospital Management System <--  +");
        System.out.println("+----------------------------------------+");
        while (status) {
            header.MainHeader();
            int choice;
            System.out.print("Enter Your Choice : ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    portal.adminPortal();
                    break;
                case 2:
                    portal.doctorPortal();
                    break;
                case 3:
                    portal.patientPortal();
                    break;
                case 4:
                    portal.newSignup();
                    break;
                case 5:
                    System.out.println("Byeee");
                    status = false;
                    break;
                default:
                    System.out.println("Invalid Entry!!.");
                    break;
            }
        }
    }
}
