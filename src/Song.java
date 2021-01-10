public class Song implements Comparable<Song>{
  private String title;
  private String artist;
  private User owner;
  private int duration;
  
  public Song()  {
    this("", "", 0, 0);
  }
  
  public Song(String t, String a, int m, int s)  {
    title = t;
    artist = a;
    owner = null;
    duration = m * 60 + s;
  }

  public String getTitle() { 
    return title; 
  } 
  
  public String getArtist() { 
    return artist; 
  }
  
  public int getDuration() { 
    return duration; 
  }

  public User getOwner() {return owner;}

  public void setOwner(User owner) {this.owner = owner;}
  
  public int getMinutes() {
    return duration / 60;
  }
  
  public int getSeconds() {
    return duration % 60;
  }
  
  public String toString()  {
    return("\"" + title + "\" by " + artist + " " + (duration / 60) + ":" + (duration%60));
  }

  @Override
  public int compareTo(Song s) {
    return this.title.compareTo(s.title);
  }
}
