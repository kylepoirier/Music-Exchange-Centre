public class UserGenerator{
 // Various Users for test purposes
  public static User DiscoStew() {
    User  discoStew = new User("Disco Stew");
    discoStew.addSong(new Song("Hey Jude", "The Beatles", 4, 35));
    discoStew.addSong(new Song("Barbie Girl", "Aqua", 3, 54));
    discoStew.addSong(new Song("Only You Can Rock Me", "UFO", 4, 59)); discoStew.addSong(new Song("Paper Soup Cats", "Jaw", 4, 18)); return discoStew;
  }
  
  public static User SleepingSam() {
    User sleepingSam = new User("Sleeping Sam");
    sleepingSam.addSong(new Song("Meadows", "Sleepfest", 7, 15)); sleepingSam.addSong(new Song("Calm is Good", "Waterfall", 6, 22)); return sleepingSam;
  }
  
  public static User RonnieRocker() {
    User ronnieRocker = new User("Ronnie Rocker");
    ronnieRocker.addSong(new Song("Rock is Cool", "Yeah", 4, 17));
    ronnieRocker.addSong(new Song("My Girl is Mean to Me", "Can't Stand Up", 3, 29)); ronnieRocker.addSong(new Song("Only You Can Rock Me", "UFO", 4, 52)); ronnieRocker.addSong(new Song("We're Not Gonna Take It", "Twisted Sister", 3, 9)); return ronnieRocker;
  }
  
  public static User CountryCandy() {
    User countryCandy = new User("Country Candy");
    countryCandy.addSong(new Song("If I Had a Hammer", "Long Road", 4, 15)); countryCandy.addSong(new Song("My Man is a 4x4 Driver", "Ms. Lonely", 3, 7)); countryCandy.addSong(new Song("This Song is for Johnny", "Lone Wolf", 4, 22)); return countryCandy;
  }
  
  public static User PeterPunk() {
    User peterPunk = new User("Peter Punk");
    peterPunk.addSong(new Song("Bite My Arms Off", "Jaw", 4, 12));
    peterPunk.addSong(new Song("Where's My Sweater", "The Knitters", 3, 41)); peterPunk.addSong(new Song("Is that My Toenail ?", "Clip", 4, 47)); peterPunk.addSong(new Song("Anvil Headache", "Clip", 4, 34)); peterPunk.addSong(new Song("My Hair is on Fire", "Jaw", 3, 55));
    return peterPunk;
  } 
}