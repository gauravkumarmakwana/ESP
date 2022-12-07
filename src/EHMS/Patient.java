package EHMS;

import java.io.*;
public class Patient extends Variables{
    public void viewProfile(int pID) throws IOException {

        filer = new BufferedReader(new FileReader("Patient.csv"));
        filer.readLine();
        while ((line = filer.readLine()) != null) {
            data = line.split(",");
            if (pID == Integer.parseInt(data[0])) {
                System.out.printf("Patient ID:     %-15s\n", data[0]);
                System.out.printf("Patient Name:   %-15s\n", data[2]);
                System.out.printf("Gender:         %-15s\n", data[4]);
                System.out.printf("Blood Group:    %-15s\n", data[6]);
                System.out.printf("Contact Number: %-15s\n", data[7]);
            }
        }
        filer.close();
    }
    public void bookAppointment(int pID) throws IOException {
        req=new Required();
        String  problem,specialization=null,docnm=null,doctype=null,qulif=null;
        int dID;
        int aID= req.AutoId("Appointment.csv");
        System.out.println("Appointment ID : "+ aID);
        System.out.print("Enter Your Problem : ");
        problem=input.nextLine();
        System.out.println("+------------------------+");
        System.out.printf("| 1] %-8s 2]%-8s |\n","ENT","EYES");
        System.out.printf("| 3] %-8s 4]%-8s |\n","HEART","LUNGS");
        System.out.printf("| 5] %-8s 6]%-8s |\n","KIDNEY","GENERAL");
        System.out.println("+------------------------+");
        while (true){
            System.out.print("Enter Your Choice : ");
            choice=input.nextInt();
            if(choice==1||choice==2||choice==3||choice==4||choice==5||choice==6){
                switch (choice){
                    case 1:specialization="ENT"; break;
                    case 2:specialization="EYES"; break;
                    case 3:specialization="HEART"; break;
                    case 4:specialization="LUNGS"; break;
                    case 5:specialization="KIDNEY"; break;
                    case 6:specialization="GENERAL"; break;
                }
                break;
            }
            else {
                System.out.println("Invalid entry!!");
            }
        }
        filer=new BufferedReader(new FileReader("Doctor.csv"));
        filer.readLine();
        while((line=filer.readLine())!=null){
            data=line.split(",");
            if(specialization.equals(data[9])){
                System.out.println("+------------------------------------+");
                System.out.printf("| Doctor ID :        %-15s |\n",data[0]);
                System.out.printf("| Name :             %-15s |\n",data[2]);
                System.out.printf("| Qualification :    %-15s |\n",data[8]);
                System.out.printf("| Specialization :   %-15s |\n",data[9]);
                System.out.println("+------------------------------------+");
            }
        }
        System.out.print("Choose Doctor ID : ");
        dID=input.nextInt();
        input.nextLine();
        System.out.println("Appointment Booked Successfully");
        filer.close();
        filer=new BufferedReader(new FileReader("Doctor.csv"));
        filer.readLine();
        while((line=filer.readLine())!=null) {
            data = line.split(",");
            if(dID==Integer.parseInt(data[0])){
                docnm=data[2];
                doctype=data[9];
                qulif=data[8];
                break;
            }
        }
        filer.close();

        filer=new BufferedReader(new FileReader("Patient.csv"));
        filer.readLine();
        String pName=null;
        while((line=filer.readLine())!=null){
            data = line.split(",");
            if(pID==Integer.parseInt(data[0])){
                pName=data[2];
                break;
            }
        }
        filer.close();

        int status=0;
        String appdata=(aID+","+pID+","+problem+","+docnm+","+dID+","+doctype+","+qulif+","+pName+","+null+","+null+","+status+"\n");
        filew=new BufferedWriter(new FileWriter("Appointment.csv",true));
        filew.write(appdata);
        filew.close();
    }
    public void viewAppointment(int pID) throws IOException {
        req=new Required();
        if(req.check("Appointment.csv",pID)){
            filer = new BufferedReader(new FileReader("Appointment.csv"));
            filer.readLine();
            while ((line = filer.readLine()) != null) {
                data = line.split(",");
                if (pID == Integer.parseInt(data[1])) {
                    System.out.println("+----------------------------+");
                    System.out.printf("| Appointment ID:  %-9s |\n", data[0]);
                    System.out.printf("| Patient ID:      %-9s |\n", data[1]);
                    System.out.printf("| Doctor ID:       %-9s |\n", data[4]);
                    System.out.printf("| Doctor Name :    %-9s |\n", data[3]);
                    System.out.printf("| Problem:         %-9s |\n", data[2]);
                    System.out.println("+----------------------------+");
                }
            }
            filer.close();
        }
        else {
            System.out.println("No Appointment");
        }

    }
    public void feedBack(int pID) throws IOException{
        filew=new BufferedWriter(new FileWriter("Feedback.csv",true));
        int points;
        String nature,comments;
        System.out.println("Patient Id : " + pID );
        System.out.print("Please Give The Points To our Service Out Of 10 : ");
        points=input.nextInt();
        input.nextLine();
        System.out.print("Nature Of The Doctor : ");
        nature=input.nextLine();
        System.out.print("Your Comment : ");
        comments=input.nextLine();
        String fdata=(pID+","+points+","+nature+","+comments);
        filew.write("\n"+fdata);
        filew.close();
    }
}
