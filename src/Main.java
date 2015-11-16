import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.*;

public class Main {

   public static void main(String[] args) {
       //LoginTemp GUI = new LoginTemp();
       //LoginGUI loginGUI = new LoginGUI();
       User user = new User("Bob");
       user.setBio("This is Bob's bio. Yeah, a little boring.");
       //NewChirpWindow chirpWindow = new NewChirpWindow(user);
       //User user2 = new User("Carl", "kjhf;kajhfd");
       //HomePageGUI homePageGUI = new HomePageGUI(user);
       //homePageGUI.setVisible(true);
       //HomeGUI homeGUI = new HomeGUI();homeGUI.setVisible(true);
       //GuestHomeGUI guestHomeGUI = new GuestHomeGUI();
       //ViewProfile viewProfile = new ViewProfile();
       System.out.println(user.getBio());
       EditBioGUI editBio = new EditBioGUI(user);
   }
}