import java.lang.reflect.Array;
import java.util.*;

public class MusicExchangeCenter {

    private ArrayList<User> users = new ArrayList<>();

    private HashMap<String, Float> royalties = new HashMap<>();

    private ArrayList<Song> downloadedSongs = new ArrayList<>();

    private HashMap<Song, Integer> popSongs = new HashMap<>();


    public MusicExchangeCenter() {
    }

    public ArrayList<User> onlineUsers() {
        ArrayList<User> onlineUsers = new ArrayList();
        for (User u : users) {
            if (u != null) {
                if (u.isOnline() == true) {
                    onlineUsers.add(u);
                }
            }
        }
        return onlineUsers;
    }

    public ArrayList<Song> allAvailableSongs() {
        ArrayList<Song> allAvailableSongs = new ArrayList();
        for (User u : onlineUsers()) {
            if (u != null) {
                allAvailableSongs.addAll(u.getSongList());
            }
        }
        return allAvailableSongs;
    }

    public String toString() {
        String s = ("Music Exchange Center (" + onlineUsers().size() + " users online, " + allAvailableSongs().size() + " song available)");
        return s;
    }

    public User userWithName(String s) {
        for (User u : users) {
            if (u != null) {
                if (u.getUserName().contains(s)) {
                    return u;
                }
            }
        }
        return null;
    }

    public void registerUser(User x) {
        if (userWithName(x.getUserName()) == null) {
            users.add(x);
        }
    }

    public ArrayList<Song> availableSongsByArtist(String artist) {
        ArrayList<Song> availableSongsByArtist = new ArrayList();
        for (Song s : allAvailableSongs()) {
            if (s != null) {
                if (s.getArtist().contains(artist)) {
                    availableSongsByArtist.add(s);
                }
            }
        }
        return availableSongsByArtist;
    }

    public Song getSong(String title, String ownerName) {
        for (User u : onlineUsers()) {
            if (u != null) {
                Song tempSong = u.songWithTitle(title);
                if (tempSong != null && u.getUserName().equals(ownerName)) {

                    downloadedSongs.add(tempSong);

                    royalties.put(tempSong.getArtist(), royalties.getOrDefault(tempSong.getArtist(), (float) 0)+1);

                    popSongs.put(tempSong, popSongs.getOrDefault(tempSong, 0)+1);

                    return tempSong;
                }
            }
        }
        return null;
    }

    public void displayRoyalties() {
        System.out.println(String.format("%-10s", "Amount") + String.format("%-10s", "Artist"));
        System.out.println("------------------");
        for (String artists : royalties.keySet()) {
            System.out.println(String.format("%-10s", "$" + 0.25*royalties.get(artists)) + String.format("%-10s", artists));
        }
    }


    public TreeSet<Song> uniqueDownloads() {
        TreeSet<Song> uniqueDownloads = new TreeSet<>();
        uniqueDownloads.addAll(downloadedSongs);
        return uniqueDownloads;
    }

    public ArrayList<Pair<Integer, Song>> songsByPopularity() {
        ArrayList<Pair<Integer, Song>> pairArrayList = new ArrayList<>();

        for (Song s : uniqueDownloads()) {

            Pair newPair = new Pair<Integer, Song>((int) (1 * popSongs.get(s)),s);
            pairArrayList.add(newPair);
        }

        Collections.sort(pairArrayList, (p1, p2) -> {
            int difference = p1.getKey() - p2.getKey();
            if (difference > 0) {
                return -1;
            }
            if (difference == 0) {
                return 0;
            }
            return 1;
        });
        return pairArrayList;
    }

    public ArrayList<Song> getDownloadedSongs() {
        ArrayList<Song> getDownloadedSongs = new ArrayList<>();
        getDownloadedSongs.addAll(downloadedSongs);

        return getDownloadedSongs;
    }
}

