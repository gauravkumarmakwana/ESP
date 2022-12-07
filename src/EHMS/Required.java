package EHMS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Variables{
    Scanner input=new Scanner(System.in);
    Required req =null;
    BufferedReader filer=null;
    BufferedWriter filew=null;
    String line,firstline,password, confpass,fullname, lastname, contactNum,gender,bloodg,quilification, mailID,spec=null;
    String[] data;
    int userId,autoId,choice,count=0;
    int age;
}
public class Required extends Variables{
    public int AutoId(String fname) throws IOException {
        if(check(fname)){
            filer = new BufferedReader(new FileReader(fname));
            filer.readLine();
            while ((line = filer.readLine()) != null) {
                data = line.split(",");
                autoId = Integer.parseInt(data[0]);
            }
            filer.close();
            return autoId + 1;
        }
        else {
            return 1;
        }
    }
    public boolean check(String name,int id)throws IOException {
        filer = new BufferedReader(new FileReader(name));
        filer.readLine();
        while ((line=filer.readLine())!=null){
            data=line.split(",");
            if((Integer.parseInt(data[4])==id && Integer.parseInt(data[10])==0)||(Integer.parseInt(data[1])==id && Integer.parseInt(data[10])==0)){
                count++;
            }
        }
        filer.close();
        return count > 0;
    }
    public boolean check(String name)throws IOException{
        filer = new BufferedReader(new FileReader(name));
        filer.readLine();
        while ((line=filer.readLine())!=null){
            count++;
        }
        filer.close();
        return count > 0;
    }
}
