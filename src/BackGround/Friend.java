package BackGround;

import java.util.ArrayList;
import java.util.Random;
public class Friend{
    Random rand =new Random();
    public static ArrayList<String> frList=new ArrayList<>();
    String []bots={"Semih","Semerci","Metehan","Ateş","Erol","Atik","Ömer","Faruk","Yiğit","Tarık","Uçar","Fly","Fire","Sencermen","Tuğra",
            "TuğraHan","Güler","Gülerci","Eyüp","Ensari","Karakuş","Ege","Kaleli","Bora","Kıraslan","Abuzer","ÖUFC","Mehmet","Ali","Mali",
            "Gülyurdu","Süleyman","Polat","Aslan","Akbey","Çakır","Alemdar","Memati"};
    public void FriendList(){

        for (int i=0;i<5;i++){
            int botIndex1=rand.nextInt(38);
            int botIndex2=rand.nextInt(38);
            if(botIndex2==botIndex1){
                botIndex2=rand.nextInt(38);
            }
            else{
                frList.add(bots[botIndex1]+bots[botIndex2]);
            }

        }
    }
}



