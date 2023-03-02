package BackGround;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class User extends Account implements Settings{

    ArrayList<String> tempFollowing= new ArrayList<>();
    ArrayList<String> tempFollowers=new ArrayList<>();
    public static ArrayList<String> Following=new ArrayList<>();
    public static ArrayList<String> Followers=new ArrayList<>();

    public ArrayList<String> logIn=new ArrayList<>();
    public static ArrayList<String> dosya=new ArrayList<>();


    public User(String userName, String password)  {
        super(userName,password);
    }

    public User() {

    }


    public boolean control() throws FileNotFoundException {
        logIn.add(getUserName());
        logIn.add(getPassword());

        File file=new File("dosya.txt");

        Scanner sc=new Scanner(file);

        while (sc.hasNext()){
            String temp= sc.next();
            dosya.add(temp);
        }

        for(int i=0;i<dosya.size();i++){
            if(dosya.get(i).equals(getUserName())){
                if(dosya.get(i+1).equals(getPassword())){
                    return true;
                }
            }

        }
        return false;
    }




    public void OnePage(String bot,String tempUserName)  {
        boolean ctrl = true;
        File file1=new File("following.txt");
        Scanner sc= null;
        try {
            sc = new Scanner(file1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        FileWriter writer = null;
        try {
            writer = new FileWriter("following.txt", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (sc.hasNext()){
            String temp = sc.next();
            tempFollowing.add(temp);
        }
        if(tempFollowing.size()==0){
            try {
                writer.write("usr " + tempUserName + " " + bot + " ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {

            for (String s : tempFollowing) {
                if (s.equals(bot)) {
                    ctrl = false;
                    break;
                }
            }
            if (ctrl) {
                try {
                    writer.write("usr " + tempUserName + " " + bot + " ");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        tempFollowing.clear();
    }
    public void TwoPageShowFollowing(String tempUserName) {
        File file1 = new File("following.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (sc.hasNext()) {
            String temp = sc.next();
            tempFollowing.add(temp);
        }
        for (int i = 0; i < tempFollowing.size(); i++) {
            if (tempFollowing.get(i).equals("usr")) {
                if (tempFollowing.get(i + 1).equals(tempUserName)) {
                    Following.add(tempFollowing.get(i + 2));
                }
            }
        }
        tempFollowing.clear();
    }

    public void TwoPageUnfollow(String botUserName) throws IOException {
        File file1 = new File("following.txt");
        Scanner sc = new Scanner(file1);
        while (sc.hasNext()) {
            String temp = sc.next();
            tempFollowing.add(temp);
        }
        for (int i=0;i<tempFollowing.size();i++){

            if(tempFollowing.get(i).equals(botUserName)){
                tempFollowing.remove(i);
                tempFollowing.remove(i-1);
                tempFollowing.remove(i-2);
                FileWriter writer=new FileWriter("following.txt");
                for (String s : tempFollowing) {
                    writer.write(s + " ");
                }
                writer.close();
            }
        }
        Following.clear();
        tempFollowing.clear();
    }
    public  void ThreePageConfirm(String tempUserName,int botindex,ArrayList<String> frList) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("followers.txt", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.write("usr "+tempUserName+" "+ frList.get(botindex) + " ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public  void FourPageShowFollowers(String tempUserName)  {
        File file2 = new File("followers.txt");
        Scanner sc= null;
        try {
            sc = new Scanner(file2);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (sc.hasNext()){
            String temp= sc.next();
            tempFollowers.add(temp);
        }
        for(int i=0;i<tempFollowers.size();i++){
            if(tempFollowers.get(i).equals("usr")){
                if(tempFollowers.get(i+1).equals(tempUserName)){
                    Followers.add(tempFollowers.get(i+2));
                }
            }
        }
        tempFollowers.clear();
    }
    public  void FourPageUnFollowers(String botUserName) {
        File file1 = new File("followers.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (sc.hasNext()) {
            String temp = sc.next();
            tempFollowers.add(temp);
        }
        for (int i=0;i<tempFollowers.size();i++){
            if(tempFollowers.get(i).equals(botUserName)){
                tempFollowers.remove(i);
                tempFollowers.remove(i-1);
                tempFollowers.remove(i-2);
                FileWriter writer= null;
                try {
                    writer = new FileWriter("followers.txt");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                for (String tempFollower : tempFollowers) {
                    try {
                        writer.write(tempFollower + " ");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                try {
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        Followers.clear();
        tempFollowers.clear();
    }

    @Override
    public void Settings(String tempUserName, String newItem,int key)  {
        dosya.clear();
        File file=new File("dosya.txt");
        Scanner sc= null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (sc.hasNext()) {
            String temp = sc.next();
            dosya.add(temp);
        }
        for (int i = 0; i < dosya.size(); i++) {
            if (dosya.get(i).equals(tempUserName)) {

                dosya.set((i + key), newItem);
            }
        }
        FileWriter writer = null;
        try {
            writer = new FileWriter("dosya.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String s : dosya) {
            try {
                writer.write(s + " ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void ChangeFollowers(String tempUserName, String newItem)  {
        File file=new File("followers.txt");
        Scanner sc= null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (sc.hasNext()) {
            String temp = sc.next();
            tempFollowers.add(temp);
        }
        for(int i =0;i<tempFollowers.size();i++){
            if(tempFollowers.get(i).equals(tempUserName)){

                tempFollowers.set(i,newItem);
            }
        }

        FileWriter writer = null;
        try {
            writer = new FileWriter("followers.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String tempFollower : tempFollowers) {
            try {
                writer.write(tempFollower + " ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void ChangeFollowing(String tempUserName, String newItem)  {
        File file=new File("following.txt");
        Scanner sc= null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (sc.hasNext()) {
            String temp = sc.next();
            tempFollowing.add(temp);
        }
        for(int i =0;i<tempFollowing.size();i++){
            if(tempFollowing.get(i).equals(tempUserName)){

                tempFollowing.set(i,newItem);
            }
        }

        FileWriter writer = null;
        try {
            writer = new FileWriter("following.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String s : tempFollowing) {
            try {
                writer.write(s + " ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}




