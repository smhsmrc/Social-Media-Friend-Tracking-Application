package BackGround;
import java.io.IOException;
public interface Settings {
    public void Settings(String tempUserName,String newItem,int key) throws IOException;
    public void ChangeFollowers(String tempUserName,String newItem) throws IOException;
    public void ChangeFollowing(String tempUserName,String newItem) throws IOException;
}
