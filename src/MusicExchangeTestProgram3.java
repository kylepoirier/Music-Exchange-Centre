public class MusicExchangeTestProgram3 {
  public static void main(String args[]) {
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
    
    // Simulate users downloading various songs 
    discoStew.downloadSong(mec, "Bite My Arms Off", "Peter Punk"); 
    discoStew.downloadSong(mec, "Meadows", "Sleeping Sam"); 
    discoStew.downloadSong(mec, "If I Had a Hammer", "Country Candy"); 
    discoStew.downloadSong(mec, "Is that My Toenail ?", "Peter Punk"); 
    sleepingSam.downloadSong(mec, "Anvil Headache", "Peter Punk"); 
    sleepingSam.downloadSong(mec, "Is that My Toenail ?", "Disco Stew"); 
    sleepingSam.downloadSong(mec, "If I Had a Hammer", "Country Candy"); 
    countryCandy.downloadSong(mec, "Anvil Headache", "Peter Punk"); 
    countryCandy.downloadSong(mec, "Meadows", "Sleeping Sam"); 
    countryCandy.downloadSong(mec, "If I Had a Hammer", "Peter Punk"); 
    countryCandy.downloadSong(mec, "Only You Can Rock Me", "Ronnie Rocker"); 
    countryCandy.downloadSong(mec, "Is that My Toenail ?", "Disco Stew"); 
    peterPunk.downloadSong(mec, "Is that My Toenail ?", "Country Candy"); 
    peterPunk.downloadSong(mec, "Rock is Cool", "Ronnie Rocker"); 
    peterPunk.downloadSong(mec, "What?", "Ronnie Rocker"); 
    peterPunk.downloadSong(mec, "Meadows", "Sleeping Sam");
    
    // Display the downloaded songs 
    System.out.println("\nHere are the downloaded songs: "); 
    for (Song s: mec.getDownloadedSongs()){
      System.out.println(s);
    }
    
    // Display the downloaded songs alphabetically
    System.out.println("\nHere are the unique downloaded songs alphabetically: ");
    for (Song s: mec.uniqueDownloads()){
      System.out.println(s);
    }
    
    // Display the downloaded songs in order of popularity 
    System.out.println("\nHere are the downloaded songs by populariry: "); 
    for (Pair<Integer,Song> p: mec.songsByPopularity()){
      System.out.println("(" + p.getKey() + " downloads) " + p.getValue());
    }
    
    // Display the royalties
    System.out.println("\nHere are the royalties:\n");
    mec.displayRoyalties();
  }
}
