import javax.naming.PartialResultException;
import java.util.ArrayList;

public class User {
  private ArrayList<Song> songList;
  private String     userName;
  private boolean    online;
  
  public User()  { this(""); }
  
  public User(String u)  {
    userName = u;
    online = false;
    songList = new ArrayList();
  }
  
  public String getUserName() { return userName; }

  public boolean isOnline() { return online; }

  public void addSong(Song s) {
    if (s.getOwner() == null) {
      Song song = new Song(s.getTitle(), s.getArtist(), s.getMinutes(), s.getSeconds());
      songList.add(song);
      song.setOwner(this);
    }
  }

  public ArrayList<Song> getSongList() {
    return songList;
  }

  public int totalSongTime() {
    int totalDuration = 0;

    for (Song s: songList) {
      if (s != null) {
       totalDuration += s.getDuration();
      }
    }
    return totalDuration;
  }
  
  public String toString()  {
    String s = "" + userName + ": "+ songList.size() + " songs (";
    if (!online) s += "not ";
    return s + "online)";
  }

  public void register(MusicExchangeCenter m) {
    m.registerUser(this);
  }

  public void logon() {
    online = true;
  }

  public void logoff() {
    online = false;
  }

  public ArrayList<String> requestCompleteSonglist(MusicExchangeCenter m) {
    int i = 0;
    String seconds;
    ArrayList<String> requestCompleteSonglist = new ArrayList<>();
    requestCompleteSonglist.add(String.format("%-30s","TITLE") + String.format("%-20s","ARTIST") + String.format("%-5s","TIME") + String.format("%-10s","OWNER"));
      for (Song s: m.allAvailableSongs()) {
        i++;
        if (s.getSeconds() < 10) {
           seconds = String.format("%02d", s.getSeconds());
        } else {
           seconds = String.format("%2d", s.getSeconds());
        }
        requestCompleteSonglist.add(String.format("%-30s" , i + ". " + s.getTitle()) + String.format("%-20s",s.getArtist()) + s.getMinutes() + ":" + String.format("%-5s", seconds) + String.format("%-10s",s.getOwner().getUserName()));
    }
    return requestCompleteSonglist;
  }

  public ArrayList<String> requestSonglistByArtist(MusicExchangeCenter m, String artist) {
    int i = 0;
    String seconds;
    ArrayList<String> requestSonglistByArtist = new ArrayList<>();
    requestSonglistByArtist.add(String.format("%-30s","TITLE") + String.format("%-20s","ARTIST") + String.format("%-5s","TIME") + String.format("%-10s","OWNER"));

    for(Song s: m.availableSongsByArtist(artist)) {
        i++;
      if (s.getSeconds() < 10) {
        seconds = String.format("%02d", s.getSeconds());
      } else {
        seconds = String.format("%2d", s.getSeconds());
      }
        requestSonglistByArtist.add(String.format("%-30s",i + ". " + s.getTitle()) + String.format("%-20s",s.getArtist()) + s.getMinutes()+":"+ String.format("%-5s", seconds) + String.format("%-10s",s.getOwner().getUserName()));
    }
    return requestSonglistByArtist;
  }

  public Song songWithTitle(String title) {
    for (Song s: songList) {
      if (s != null) {
        if (s.getTitle().equals(title)) {
          return s;
        }
      }
    }
  return null;
  }

  public void downloadSong(MusicExchangeCenter m, String title, String ownerName) {
    Song newSong = m.getSong(title,ownerName);
      if (newSong != null) {
        songList.add(newSong);
        //System.out.println(m.getSong(title, ownerName));
      }

    }




}
