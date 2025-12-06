import java.util.Objects;
import java.util.*;
 class Song implements Comparable<Song> {
    private String title;
    private String artist;
    private String genre;
    private int duration;  // Duration in seconds

    public Song(String title, String artist, String genre, int duration) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.duration = duration;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    // Override equals and hashCode to ensure duplicate songs based on title and artist
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return title.equals(song.title) && artist.equals(song.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist);
    }

    @Override
    public int compareTo(Song other) {
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return String.format("Title: %s, Artist: %s, Genre: %s, Duration: %d seconds",
                title, artist, genre, duration);
    }
}


 class Playlist {
    private Set<Song> songs; 
    private Map<String, List<Song>> genreMap; 

    public Playlist() {
        songs = new HashSet<>();
        genreMap = new HashMap<>();
    }

    public boolean addSong(Song song) {
        if (songs.contains(song)) {
            System.out.println("Duplicate song! This song already exists in the playlist.");
            return false;
        }
        songs.add(song);
        genreMap.computeIfAbsent(song.getGenre(), k -> new ArrayList<>()).add(song);

        return true;
    }

    public boolean removeSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                songs.remove(song);
                genreMap.get(song.getGenre()).remove(song);
                System.out.println("Song '" + title + "' removed from the playlist.");
                return true;
            }
        }
        System.out.println("Song with title '" + title + "' not found in the playlist.");
        return false;
    }
    public List<Song> getAllSongsByGenre(String genre) {
        List<Song> genreSongs = genreMap.get(genre);
        if (genreSongs == null || genreSongs.isEmpty()) {
            System.out.println("No songs found for genre: " + genre);
            return new ArrayList<>();
        }
        Collections.sort(genreSongs);
        return genreSongs;
    }
    public int getTotalPlaylistDuration() {
        int totalDuration = 0;
        for (Song song : songs) {
            totalDuration += song.getDuration();
        }
        return totalDuration;
    }
    public List<Song> getTopNSongsByDuration(int n) {
        PriorityQueue<Song> pq = new PriorityQueue<>(Comparator.comparingInt(Song::getDuration).reversed());
        pq.addAll(songs);
        
        List<Song> topSongs = new ArrayList<>();
        int count = 0;
        while (!pq.isEmpty() && count < n) {
            topSongs.add(pq.poll());
            count++;
        }
        return topSongs;
    }
    public void displayPlaylist() {
        if (songs.isEmpty()) {
            System.out.println("The playlist is empty.");
        } else {
            for (Song song : songs) {
                System.out.println(song);
            }
        }
    }
}
 class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();

        Song song1 = new Song("Shape of You","Ed Sheeran","Pop",240);
        Song song2 = new Song("Blinding Lights","The Weeknd","Pop",200);
        Song song3 = new Song("Shape of You","Ed Sheeran","Pop", 240);
        Song song4 = new Song("Savage Love","Jawsh 685,Jason Derulo","Pop",172);
        Song song5 = new Song("Happier","Ed Sheeran","Pop",210);

        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);
        playlist.addSong(song4);
        playlist.addSong(song5);

        System.out.println("\nPlaylist:");
        playlist.displayPlaylist();

        playlist.removeSong("Blinding Lights");

        System.out.println("\nPlaylist after removal:");
        playlist.displayPlaylist();

        System.out.println("\nPop Songs:");
        for (Song song : playlist.getAllSongsByGenre("Pop")) {
            System.out.println(song);
        }

        System.out.println("\nTotal Playlist Duration: " + playlist.getTotalPlaylistDuration() + " seconds");

        System.out.println("\nTop 3 Longest Songs:");
        for (Song song : playlist.getTopNSongsByDuration(3)) {
            System.out.println(song);
        }
    }
}
