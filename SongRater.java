/* Names: Andrew Jamieson, Nicole Poroshenko, Yujin Bae
   Date: February 28, 2022
   Teacher: Ms. Krasteva
   Program Description: This program will allow the user to rate songs. It uses arrays to hold information for songs such as song names, artists, and 3 different
                        rankings for both vocals, instrumentals, and lyrics. This program ensures that all values entered as ratings are appropriate on the
                        0-10 scale. It then displays all the songs entered and their rankings, as well as the best song based on overall ranking out of 30.
*/

public class SongRater { //Creates a class to enter and rate songs into a database
   private int currentSong; //Holds the spot in the array currently being written in
   private int songAmount; //Holds the amount of songs being put into the arrays
   private String [] songName; //Creates an array to hold the names of songs
   private String [] artist; //Creates an array to hold the song artists
   private int [] instrumentalRating; //Creates an array to hold the rating of the instrumental of the song
   private int [] vocalRating; //Creates an array to hold the rating of the vocals of the song
   private int [] lyricsRating; //Creates an array to hold the rating of the lyrics of the song
      
   public SongRater() { //Default constructor
      currentSong = 0; //Initializes the current song variable
      songAmount = 5; //Set the array lengths to 5, their default amount
      songName = new String [songAmount]; //Creates a new instance of the song name array with a length of 5
      artist = new String [songAmount]; //Creates a new instance of the artist array with a length of 5
      instrumentalRating = new int [songAmount]; //Creates a new instance of the instrumental rating array with a length of 5
      vocalRating = new int [songAmount]; //Creates a new instance of the vocal rating array with a length of 5
      lyricsRating = new int [songAmount]; //Creates a new instance of the lyrics rating array with a length of 5
   }
   
   public SongRater(int sAmount) { //Constructor with parameters
      currentSong = 0; //Initializes the current song variable
      if(sAmount >= 0) { //Allows the arrays to be set to the user entered length if its not a negative valuee
         songAmount = sAmount; //Sets the song amount variable to the number entered in the parameters
         songName = new String [songAmount]; //Creates a new instance of the song name array with the length entered in the parameter
         artist = new String [songAmount]; //Creates a new instance of the artist array with the length entered in the parameter
         instrumentalRating = new int [songAmount]; //Creates a new instance of the instrumental rating array with the length entered in the parameter
         vocalRating = new int [songAmount]; //Creates a new instance of the vocal rating array with the length entered in the parameter
         lyricsRating = new int [songAmount]; //Creates a new instance of the lyrics rating array with the length entered in the parameter
      } else { //Prints error message if the song amount variable is negative
         System.out.println("Invalid array length, try again."); //Prints error message
      }
   }
   
   public void setNewSong(int cSong, String sName, String art, double iRating, double vRating, double lRating) { //Method to enter a new song
      currentSong = cSong; //Sets the current song to the number entered in the parameter
      
      if(0 <= currentSong && currentSong < songAmount && songName [currentSong] == null) { //Allows values to be entered in the array if the spot in the array exists and is not already filled
         songName [currentSong] = sName; //Enters the song name into the song name array
         artist [currentSong] = art; //Enters the artist into the artist name array
         
         if(iRating >= 0 && iRating <= 10) { //Sets the instrumental rating between 0 and 10 if a valid number is entered
            instrumentalRating [currentSong] = (int)Math.round(iRating); //Rounds a double to the nearest number and changes it into an integer to be put in the instrumental rating array
         } else if (iRating < 0) { //If the instrumental rating entered is less than zero, the insturmental rating is set to 0
            instrumentalRating [currentSong] = 0; //Sets the instrumental rating to 0
            System.out.println("Instrumental rating of '"+songName[currentSong]+"' is less than the acceptable range, so it is set to 0."); //Prints out an error message, telling the user the rating was set to 0
         } else if (iRating > 10) { //If the instrumental rating entered is greater than ten, the instrumental rating is set to 10
            instrumentalRating [currentSong] = 10; //Sets the instrumental rating to 10
            System.out.println("Instrumental rating of '"+songName[currentSong]+"' is greater than the acceptable range, so it is set to 10."); //Prints out an error message, telling the user the rating was set to 10
         }
         
         if(vRating >= 0 && vRating <= 10) { //Sets the vocal rating between 0 and 10 if a valid number is entered
            vocalRating [currentSong] = (int)Math.round(vRating); //Rounds a double to the nearest number and changes it into an integer to be put in the vocal rating array
         } else if (vRating < 0) { //If the vocal rating entered is less than zero, the vocal rating is set to 0
            vocalRating [currentSong] = 0; //Sets the vocal rating to 0
            System.out.println("Vocal rating of '"+songName[currentSong]+"' is less than the acceptable range, so it is set to 0."); //Prints out an error message, telling the user the rating was set to 0
         } else if (vRating > 10) { //If the instrumental rating entered is greater than ten, the vocal rating is set to 10
            vocalRating [currentSong] = 10; //Sets the vocal rating to 10
            System.out.println("Vocal rating of '"+songName[currentSong]+"' is greater than the acceptable range, so it is set to 10."); //Prints out an error message, telling the user the rating was set to 10
         }
         
         if(lRating >= 0 && lRating <= 10) { //Sets the lyrics rating between 0 and 10 if a valid number is entered
            lyricsRating [currentSong] = (int)Math.round(lRating); //Rounds a double to the nearest number and changes it into an integer to be put in the lyrics rating array
         } else if (lRating < 0) { //If the lyrics rating entered is less than zero, the lyrics rating is set to 0
            lyricsRating [currentSong] = 0; //Sets the lyrics rating to 0
            System.out.println("Lyrics rating of '"+songName[currentSong]+"' is less than the acceptable range, so it is set to 0."); //Prints out an error message, telling the user the rating was set to 0
         } else if (lRating > 10) { //If the lyrics rating entered is greater than ten, the lyrics rating is set to 10
            lyricsRating [currentSong] = 10; //Sets the lyrics rating to 10
            System.out.println("Lyrics rating of '"+songName[currentSong]+"' is greater than the acceptable range, so it is set to 10."); //Prints out an error message, telling the user the rating was set to 10   
         } 
      
         else { //If all the conditions to set the values in the array are not met, an error message is printed
            System.out.println("Invalid song place chosen. Please try again."); //Prints an error message
         }
      }
   }
      public void getSongs(){ // displays a menu of all the songs inputted 
         boolean printMenu = true; //Variable to check if all locations in the arrays are filled
         for(int i = 0; i < songName.length; i++) { //Loop to check to see if any locations in the song name array are null
            if(songName [i] == null) { //Sets the print menu variable to false if any song name is null
               printMenu = false; //Sets print menu to false
            }
         }
         if(printMenu == true) { //Prints the menu if each spot in the song array is full
            System.out.println("\nVoila! Here is a menu with all of the songs you have inputted:");
            for (int i = 0; i < songAmount; i++){ // run the array one entry at a time
               int count = i+1; // increase the counter by one to get rid of the '0' value that an array holds
               System.out.println(count+") "+songName[i]+" by "+artist[i]); // print song and artist
               System.out.println("\tInstrumental Rating: "+ instrumentalRating[i]); // print instrumental rating
               System.out.println("\tVocal Rating: "+ vocalRating[i]); // print vocal rating
               System.out.println("\tLyrics Rating: "+ lyricsRating[i]); // print lyrics rating
               System.out.println(); // new line
            }
         } else { //If not all song spots are filled an error message is printed
            System.out.println("Menu not printed, not all song locations are filled in"); //Prints error message
         }
      } 
      
      public void getBestSong(){ // displays the best rated song
         int [] sum = new int [songAmount];
         int max = 0; // variable to hold the highest total rating
         int num = 0; // variable used to hold the number of the best
         boolean printBestSong = true; //Variable to check if all locations in the arrays are filled
         int maxCount = 0; // set maximum score counter to 0
         
         for(int i = 0; i < songName.length; i++) { //Loop to check to see if any locations in the song name array are null
            if(songName [i] == null) { //Sets the print best song variable to false if any song name is null
               printBestSong = false; //Sets print best song to false
            }
         }
         if(printBestSong == true) { //Runs the best song algorithm and printer if each spot in the song array is full
            for (int i = 0; i < songAmount; i++){ // run the array one entry at a time
               sum[i] = instrumentalRating[i] + vocalRating[i] + lyricsRating[i]; // the total rating of each song is a sum of instrumental, vocal, and lyrics
               if(sum[i] > max){ // if the sum of a particular song in the array is greater than max (originally set to 0)
                  max = sum[i]; // make the sum the new maximum
                  num = i; // set i to global variable num to be used in printing outside of the loop
               }
            }
            for (int i = 0; i < songAmount; i++) { // run the array one entry at a time
               if(max == sum [i]) { // if the previous maxiumum score is equal to the new sum
                  maxCount++; // increase the counter by 1
               }
            }
            if(maxCount > 1) { // if the counter is greater than one, a.k.a there is a tie, display tie message
               System.out.println("\nThere are " + maxCount + " songs that are tied for first place! As per our tie rules, the first and best song you entered is:");
            } 
            else { // otherwise, print the best song
            System.out.println("\nThe best song is...");
            }
            System.out.println((num+1)+") "+songName[num]+" by "+ artist[num]); // print song #, name, and artist
            System.out.println("\tInstrumental Rating: "+ instrumentalRating[num]); // print instrumental rating
            System.out.println("\tVocal Rating: "+ vocalRating[num]); // print vocal rating
            System.out.println("\tLyrics Rating: "+ lyricsRating[num]); // print lyrics rating
            System.out.println("\tTOTAL RATING: "+max+"/30 !"); // display total rating out of 30
            } 
            else { //If not all song spots are filled an error message is printed
            System.out.println("Best song not printed, not all song locations are filled in"); //Prints error message
            }
      }
}