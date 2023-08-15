import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
private String name;
private String artist;
private List<Song> songs;

    public Album() {
    }

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }


    // functionalities in the album
    public boolean findSong(String title){
        for(Song song : songs){
            if(song.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }

    // add songs
    public String addSongToAlbum(String title , double duration){
        if(!findSong(title)){ // if song is not present in List then add the song
            Song song = new Song(title , duration);
            songs.add(song);
            return "Song has been added to the Album";
        }
          // song is already present in List
        return "Song already exists";
    }


    public String addToPlayListFromAlbum(String title ,  LinkedList<Song>playList){
        // chek the song is present in our album or not
        for(Song song : songs){
            if(song.getTitle().equals(title)){
                playList.add(song);
                return "Song has been added to your playlist";
            }
        }
        return "Song doesn't exist in album";
    }

    /**
     * polymorphism: method overloading
     * @param songNo
     * @param playList
     * @return
     */
    public String  addToPlayListFromAlbum(int songNo , LinkedList<Song>playList){
        int index = songNo-1;
        // check the index is valid or not
       //if valid then add otherwise dont add
       if(index>=0 && index<songs.size()){
           playList.add(songs.get(index));
           return "Song has been added successfully";
       }
        return "Incorrect song number!!";
    }
}
