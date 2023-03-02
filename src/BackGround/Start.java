package BackGround;
import java.io.IOException;

public class Start {

    public Account account;

    public int singIn(String name, String surName, String ePosta, String userName, String password) throws IOException {

        account = new NewUser(name, surName, ePosta, userName, password);
        if (name.equals("") || surName.equals("") || ePosta.equals("") || userName.equals("") || password.equals("")) {
            return 0;
        }
        boolean ctrl;
        ctrl = ((NewUser) account).control();
        if (ctrl) {
            ((NewUser) account).Kayit();
            return 1;
        } else {
            return 2;
        }

    }

    public boolean login(String userName, String password) throws IOException {
        account=new User(userName,password);

        boolean ctrl;

        ctrl=((User)account).control();
        return ctrl;

    }

}
