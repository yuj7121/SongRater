/* Names: Andrew Jamieson, Nicole Poroshenko, Yujin Bae
   Date: February 28, 2022
   Teacher: Ms. Krasteva
   Program Description: This is the main class for the program that allows the user to rate songs. It allows for object creastion to hold information 
                        for songs such as song names, artists, and 3 different rankings for both vocals, instrumentals, and lyrics. It displays any
                        messages relating to changes made in the data entered, and then displays all the songs entered and their rankings, as well as 
                        the best song based on overall ranking out of 30.
*/

public class SongRaterMain {

   public static void main (String[] args) {
      SongRater sr1 = new SongRater(5);
      sr1.setNewSong(0, "A Lot", "21 Savage", 9, 9, 9);
      sr1.setNewSong(1, "Off the Grid", "Kanye West", 9, 9, 9);
      sr1.setNewSong(2, "Macarena", "The Beetles", 10, 10, 10);
      sr1.setNewSong(3, "Happy", "I Forget", 10, 10, 10);
      sr1.setNewSong(4, "Despacito", "Johnny Depp", 9, 9, 9);
      sr1.getSongs();
      sr1.getBestSong();
   }
}