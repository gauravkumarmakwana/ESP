package EHMS;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Portal {
    boolean patPassword(int uID,String password)throws IOException{
        BufferedReader filer = new BufferedReader(new FileReader("Patient.csv"));
        filer.readLine();
        String line;
        String[] data;
        while ((line = filer.readLine()) != null) {
            data = line.split(",");
            if (uID == Integer.parseInt(data[0]) && password.equals(data[1])) {
                return true;
            }
        }
        return false;
    }
    boolean docPassword(int uID,String password)throws IOException{

        BufferedReader filer = new BufferedReader(new FileReader("Doctor.csv"));
        filer.readLine();
        String line;
        String[] data;
        while ((line= filer.readLine())!=null) {
            data = line.split(",");
            if (uID==Integer.parseInt(data[0]) && password.equals(data[1])) {
                return true;
            }
        }
        return false;
    }
    public void adminPortal() throws IOException {
        int choice;
        String pass,userName;
        Scanner input=new Scanner(System.in);
        Headers header=new Headers();
        Admin admin=new Admin();
        while (true){
            System.out.print("Enter User Name : ");
            userName=input.next();
            System.out.print("Password : ");
            pass=input.next();
            if(pass.equals("admin") && userName.equals("APPK")){
                while (true){
                    header.AdminHeader();
                    System.out.print("Enter Your Choice : ");
                    choice=input.nextInt();
                    input.nextLine();
                    if(choice>=1 && choice<=7){
                        switch (choice){
                            case 1 : admin.viewDoctor(); break;
                            case 2 : admin.viewPatient(); break;
                            case 3 : admin.addDoctor(); break;
                            case 4 : admin.removeDoctor(); break;
                            case 5 : admin.viewAppointments(); break;
                            case 6 : admin.viewFeedbacks();break;
                        }
                    }
                    else if (choice == 8){
                        break;
                    }
                    else {
                        System.out.println("Invalid Entry!!.");
                    }
                }
                break;
            }
            else {
                System.out.println("Invalid Password or User Name!!");
            }
        }
    }
    public void doctorPortal() throws IOException {
        int id;
        String pass;
        int choice;
        boolean status;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("User : ");
            id = input.nextInt();
            System.out.print("Password  : ");
            pass = input.next();
            Headers headers=new Headers();
            status = docPassword(id,pass);
            if (status) {
                while (true) {
                    Doctor doctor = new Doctor();
                    headers.DoctorHeader();
                    System.out.print("Enter your choice : ");
                    choice = input.nextInt();
                    input.nextLine();
                    if (choice >= 1 && choice <= 3) {
                        switch (choice) {
                            case 1:
                                doctor.viewProfile(id);
                                break;
                            case 2:
                                doctor.viewAppointment(id);
                                break;
                            case 3:
                                doctor.diagnosePatient(id);
                                break;
                        }
                    } else if (choice == 4) {

                        break;
                    } else {
                        System.out.println("Invalid Entry!!.");
                    }
                }
                break;

            } else {
                System.out.println("Invalid Password or User-Id !!");
            }
        }
    }
    public void patientPortal()throws IOException{
        int id;
        String pass;
        int choice;
        boolean status;
        Scanner input = new Scanner(System.in);
        Headers head = new Headers();
        while (true) {
            System.out.print("ID : ");
            id = input.nextInt();
            System.out.print("Password  : ");
            pass = input.next();
            status = patPassword(id, pass);
            if (status) {
                while (true) {
                    head.PatientHeader();
                    Patient patient = new Patient();
                    Admin admin = new Admin();
                    System.out.print("Enter your choice ");
                    choice = input.nextInt();
                    input.nextLine();
                    if (choice >= 1 && choice <= 5) {
                        switch (choice) {
                            case 1:
                                patient.viewProfile(id);
                                break;
                            case 2:
                                admin.viewDoctor();
                                break;
                            case 3:
                                patient.bookAppointment(id);
                                break;
                            case 4:
                                patient.viewAppointment(id);
                                break;
                            case 5:
                                patient.feedBack(id);
                                break;

                        }
                    } else if (choice == 6) {

                        break;
                    } else {
                        System.out.println("Invalid Entry!!.");
                    }

                }
                break;

            } else {
                System.out.println("Invalid Password or User-Id !!");

            }

        }
    }
    public void newSignup() throws IOException {

        NewPatient signup = new NewPatient();
        signup.newPatient();
    }
}
