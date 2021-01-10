import java.util.ArrayList;

public class MusicExchangeTestProgram2 {
  public static void main(String args[]) {
    ArrayList<String> catalog;
    
    // Create a new music exchange center
    MusicExchangeCenter   mec = new MusicExchangeCenter();
    
    // Create some users and give them some songs
    User discoStew = UserGenerator.DiscoStew();
    User sleepingSam = UserGenerator.SleepingSam();
    User ronnieRocker = UserGenerator.RonnieRocker(); 
    User countryCandy = UserGenerator.CountryCandy(); 
    User peterPunk = UserGenerator.PeterPunk();
    
    // Register the users 
    discoStew.register(mec); 
    ronnieRocker.register(mec); 
    sleepingSam.register(mec); 
    countryCandy.register(mec); 
    peterPunk.register(mec);
    
    // Log on all users
    
    discoStew.logon(); 
    sleepingSam.logon(); 
    ronnieRocker.logon(); 
    countryCandy.logon(); 
    peterPunk.logon(); 
    System.out.println("Status: " + mec);
    
    // Simulate a user requesting a list of songs 
    catalog = discoStew.requestCompleteSonglist(mec); 
    System.out.println("Complete Song List: ");
    for (String s: catalog){
      System.out.println("  " + s);
    }
    
    // Simulate a user downloading 3 songs from the list 
    System.out.println("\nDisco Stew before downloading: " + discoStew); 
    discoStew.downloadSong(mec, "Bite My Arms Off", "Peter Punk"); 
    discoStew.downloadSong(mec, "Meadows", "Sleeping Sam"); 
    discoStew.downloadSong(mec, "If I Had a Hammer", "Country Candy"); 
    discoStew.downloadSong(mec, "Sandy Toes", "Country Candy"); 
    
    ronnieRocker.logoff(); // log off Ronnie, next download should not go through 
    discoStew.downloadSong(mec, "Only You Can Rock Me", "Ronnie Rocker"); 
    System.out.println("Disco Stew after downloading: " + discoStew);
    
    ronnieRocker.logon(); // log on Ronnie, next download should go through 
    discoStew.downloadSong(mec, "Only You Can Rock Me", "Ronnie Rocker"); 
    System.out.println("Disco Stew after downloading Ronnie’s: " + discoStew + "\n");
    
    // Simulate a user requesting a list of songs by a specific artist 
    catalog = discoStew.requestSonglistByArtist(mec, "Jaw");
    System.out.println("Song’s by Jaw: ");
    for (String s: catalog){
      System.out.println("  " + s);
    }
  }
}
