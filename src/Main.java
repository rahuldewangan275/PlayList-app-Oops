import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

      Album arijitAlbum = new Album("arijitSongs" , "Arijit Singh");
      Album MoosewalaAlbum = new Album("MoosewalaSongs" , "Siddhu Moosewala");

      arijitAlbum.addSongToAlbum("Tum Hi Ho" , 4.1);
      arijitAlbum.addSongToAlbum("Kesaria" , 3.5);
      arijitAlbum.addSongToAlbum("Kabhi Jo Badal Barse" , 4.7);

      MoosewalaAlbum.addSongToAlbum("395",3.5);
      MoosewalaAlbum.addSongToAlbum("The Last Ride",3.9);
      MoosewalaAlbum.addSongToAlbum("Same Beef",3.5);

      LinkedList <Song> myPlayList = new LinkedList();  //myPlaylist
     // add songs to myPlayList
      System.out.println(arijitAlbum.addToPlayListFromAlbum("Kesaria" , myPlayList));
      System.out.println(arijitAlbum.addToPlayListFromAlbum(1 , myPlayList));
      System.out.println(arijitAlbum.addToPlayListFromAlbum(5, myPlayList)); // wrong index

      System.out.println(MoosewalaAlbum.addToPlayListFromAlbum("Same Beef" , myPlayList));
      System.out.println(MoosewalaAlbum.addToPlayListFromAlbum("395" , myPlayList));
      System.out.println(MoosewalaAlbum.addToPlayListFromAlbum(2 , myPlayList));
      System.out.println(MoosewalaAlbum.addToPlayListFromAlbum(7 , myPlayList)); // wrong index

      play(myPlayList);
    }


    public static void play(LinkedList<Song>myPlayList){
      if(myPlayList.size()==0){
        System.out.println("Your PlayList Is Empty");
        return;
      }

      // using List Iterator to iterate myPlayList
      ListIterator<Song> itr = myPlayList.listIterator();
      System.out.println("Now Playing: "+itr.next());

      Scanner sc = new Scanner(System.in);
      printMenu();

      boolean quit = false;
             boolean wasNext = true; // direction right
      while(!quit){
        System.out.println("Please enter your choice");
        int choice = sc.nextInt();

        switch(choice){

          case 1:
                printMenu();
                break;

          case 2:
            if(wasNext == false){
              itr.next();
            }
            if(itr.hasNext()){
             System.out.println( "currently playing is :"+itr.next());
              wasNext = true;
            }else{
              System.out.println("You are at the end song of playlist");
              wasNext = true;
            }
            break;

          case 3:
            if(wasNext == true && itr.hasPrevious()){
              itr.previous();
            }
            if(itr.hasPrevious()){
              System.out.println("Currently Playing is :"+ itr.previous());
            }else{
              System.out.println("yoy are starting of the song");
            }
            wasNext = false;
            break;

          case 4 :
            if(wasNext==true){
              System.out.println("Currently playing : "+itr.previous());
              wasNext=false;
            }else if(wasNext==false) {
              System.out.println("Currently playing : "+ itr.next());
              wasNext=true;
            }
            break;

          case 5: // delete current song
            if(wasNext==true && itr.hasPrevious()){
              itr.previous();
              itr.remove();
            }else if(wasNext==false && itr.hasNext()) {
             itr.next();
             itr.remove();
            }

            if(itr.hasNext()){
              System.out.println("Currently playing : "+itr.next());
              wasNext=true;
            }else if(itr.hasPrevious()){
              System.out.println("Currently playing : "+itr.previous());
            }else{
              System.out.println("Playlist is Empty");
            }
            break;

          case 6 :
            if(myPlayList.size()==0){
              System.out.println("Your PlayList is Empty");
            }
            printSongs(myPlayList);
            break;

          case 7 :
            quit = true;
            break;

          default:
            System.out.println("Wrong choice. Please select again");
        }
      }
    }

    private static void printSongs(LinkedList<Song> myPlayList){
      for(Song song : myPlayList){
        System.out.println(song);
      }
      return;
    }
    private static void printMenu(){
      System.out.println("1. Show the menu again");
      System.out.println("2. Play next song");
      System.out.println("3. Play previous song");
      System.out.println("4. Play current song again");
      System.out.println("5. Delete current song from playlist");
      System.out.println("6. Print all the songs in playlist");
      System.out.println("7. Quit application");
    }
}