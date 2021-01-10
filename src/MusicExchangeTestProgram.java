public class MusicExchangeTestProgram {
  public static void main(String args[]) {
    // Create a new music exchange center
    MusicExchangeCenter mec = new MusicExchangeCenter();
    
    // Create some users and give them some songs
    User discoStew = UserGenerator.DiscoStew();
    User sleepingSam = UserGenerator.SleepingSam(); 
    User ronnieRocker = UserGenerator.RonnieRocker(); 
    User countryCandy = UserGenerator.CountryCandy(); 
    User peterPunk = UserGenerator.PeterPunk();
    
    // Register the users, except SleepingSam
    discoStew.register(mec); 
    ronnieRocker.register(mec); 
    countryCandy.register(mec); 
    peterPunk.register(mec);
    
    // Display the state of things before anyone logs on 
    System.out.println("Status: " + mec); 
    System.out.println("On-Line Users: " + mec.onlineUsers());
    System.out.println("Available Songs: " + mec.allAvailableSongs() + "\n");
    
    // Attempt to log on two registered users and one unregistered user
    discoStew.logon(); 
    sleepingSam.logon(); // Should not work 
    ronnieRocker.logon(); 
    System.out.println("Status: " + mec);
    System.out.println("On-Line Users: " + mec.onlineUsers());
    System.out.println("Available Songs: " + mec.allAvailableSongs() + "\n");
    
    // Log on two more users 
    countryCandy.logon(); 
    peterPunk.logon(); 
    System.out.println("Status: " + mec);
    System.out.println("On-Line Users: " + mec.onlineUsers());
    System.out.println("Available Songs: " + mec.allAvailableSongs());
    System.out.println("Available Songs By Jaw: " + mec.availableSongsByArtist("Jaw") + "\n");
    
    // Log off three users (one is not even logged in)
    countryCandy.logoff();
    discoStew.logoff(); sleepingSam.logoff(); System.out.println("Status: " + mec);
    System.out.println("On-Line Users: " + mec.onlineUsers());
    System.out.println("Available Songs: " + mec.allAvailableSongs());
    System.out.println("Available Songs By Jaw: " + mec.availableSongsByArtist("Jaw") + "\n");
    
    // Log off the last two users 
    peterPunk.logoff(); 
    ronnieRocker.logoff(); 
    System.out.println("Status: " + mec);
    System.out.println("On-Line Users: " + mec.onlineUsers());
    System.out.println("Available Songs: " + mec.allAvailableSongs()); 
    System.out.println("Available Songs By Jaw: " + mec.availableSongsByArtist("Jaw") + "\n");
  }
}

