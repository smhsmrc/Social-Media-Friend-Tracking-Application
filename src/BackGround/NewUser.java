package BackGround;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class NewUser extends Account{
    ArrayList<String> singIn=new ArrayList<>();
    ArrayList<String> dosya=new ArrayList<>();

    public NewUser(String name,String surName,String ePosta, String userName, String password) {
        super(userName, password);
        setePosta(ePosta);
        setName(name);
        setSurName(surName);
    }

    public void Kayit() throws IOException {
        singIn.add("usr");
        singIn.add(getName());
        singIn.add(getSurName());
        singIn.add(getePosta());
        singIn.add(getUserName());
        singIn.add(getPassword());

        FileWriter writer = new FileWriter("dosya.txt", true);

        for (String s : singIn) {
            writer.write(s + " ");
        }
        writer.close();

    }
    public boolean control() throws FileNotFoundException {
        File file = new File("dosya.txt");
        Scanner sc=new Scanner(file);
        while (sc.hasNext()){
            String temp= sc.next();
            dosya.add(temp);
        }
        boolean ctrl=true;

        for (int i=0;i<dosya.size();i++) {
            if(dosya.get(i).equals("usr")){

                if (dosya.get(i+4).equals(getUserName()) || dosya.get(i+3).equals((getePosta()))) {
                    ctrl=false;
                    break;
                }
            }
        }
        return ctrl;
    }

}





