/* Names: Andrew Jamieson, Nicole Poroshenko, Yujin Bae
   Date: February 28, 2022
   Teacher: Ms. Krasteva
   Program Description:2D array
*/

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SongRater2D {
   private String [] [] songs;  //the name of the songs 2d array
   private String fileName;     //filename
   private int songAmount;      //number of songs in the file

   public SongRater2D() {     //default constructor
   }
   
   public SongRater2D(String name) {      //constructor that takes in the parameter, the file name
      fileName = name;
      try {
         readFile(); //run the readfile method
      }
      catch (IOException e) {    //if it can't find the file
         System.out.println("Cannot find the file.");    //print that it can't find the file
      }
   }
   
   //this method will read in the file and store the information into the songs array
   private void readFile() throws IOException{      
      Scanner file = new Scanner(new File(fileName)); //creates a new scanner object
      ArrayList<String> lines = new ArrayList<String>(); //creates an arraylist to temporarly store values from the file
      
      //puts all data in the file into the arraylist
      while (file.hasNext())  //as long as the file has next line
      {
         String nextWord = file.nextLine();  //stores what's on the line to this temporarly variable
         lines.add(nextWord); //stores that to the arraylist
      }
      
      //takes data from the arraylist and put it into the 2d array
      songAmount = (lines.size() / 5 );   //each song has 5 lines of information, therefore, the number of songs is numebr of lines divided by 5
      songs = new String [songAmount] [5];   //creates a new 2d array with the amoun tof songs and 5
      for (int i = 0; i < songAmount; i++){  //i is the index number for the osng
         for ( int j = 0; j < 5; j++){    //j is the index numebr for ratings. j=0 is name, j=1 is artist, j=2 is instrumentla rating, j=3 is vocal rating, and j=4 is lyrics rating. 
            songs [i] [j] = lines.get(i*5 + j);    //assigns the correct elements fom the arraylist into the 2d array
         }
      }
   }
   
   private int check(int songIndex, int rateIndex){ //takes in the index of the song and the index of the rating and returns the rating as a proper int value
      int rate;   //this is the rating value this method will return
      try{
         rate = (int) (Double.parseDouble(songs[songIndex][rateIndex]) + 0.5); //rounds and assigns the rating from 2d array into rate
         if (rate < 0){ //if the value is less than 0
            System.out.println("\t*Rating less than range, value set to 0. ");
            rate = 0;
         } else if (rate > 10){  //is the value is greater than 10
            System.out.println("\t*Rating greater than range, value set to 10. ");
            rate = 10;
         } //end of if
      } catch (NumberFormatException ex) {   //if the value is not a number
         System.out.println("\t*Rating is not a number. Therfore, value of 0 was automatically assigned to it. ");
         rate = 0;
      }  //end of try catch block
      return rate;      //returns rate
   }  //end of the check method
   
   public void getSongs(){ // displays a menu of all the songs inputted 
      boolean printMenu = true; //Variable to check if all locations in the arrays are filled
      for(int i = 0; i < songAmount; i++) { //Loop to check to see if any locations in the song name array are null
         if(songs[i][0] == "") { //Sets the print menu variable to false if any song name is null
            printMenu = false; //Sets print menu to false
         }
      }
      if(printMenu == true) { //Prints the menu if each spot in the song array is full
         System.out.println("\nVoila! Here is a menu with all of the songs you have inputted:");
         for (int i = 0; i < songAmount; i++){ // run the array one entry at a time
            int count = i+1; // increase the counter by one to get rid of the '0' value that an array holds
            System.out.println(count+") "+ songs[i][0]+" by " + songs[i][1]); // print song and artist
            System.out.println("\tInstrumental Rating: "+ check(i, 2)); // print instrumental rating
            System.out.println("\tVocal Rating: " + check(i, 3)); // print vocal rating
            System.out.println("\tLyrics Rating: " + check(i, 4)); // print lyrics rating
            System.out.println();
         }
      } else { //If not all song spots are filled an error message is printed
         System.out.println("Menu not printed, not all song locations are filled in"); //Prints error message
      }
   } //end of get songs method
   
   
   public void getBestSong(){ // displays the best rated song
      boolean printBestSong = true; //Variable to check if all locations in the arrays are filled
      int maxCount = 0; // set maximum score counter to 0
      int max = 0; // variable to hold the highest total rating
      int num = 0; // variable used to hold the number of the best
      int [] sum = new int [songAmount]; // used to calculate the sum of all the lyric, instrumental, and vocal ratings of every song
      for(int i = 0; i < songAmount; i++) { //Loop to check to see if any locations in the song name array are null
         if(songs[i] [0] == "") { //Sets the print best song variable to false if any song name is null
            printBestSong = false; //Sets print best song to false
         }
      }
      if(printBestSong == true) { //Runs the best song algorithm and printer if each spot in the song array is full
         for (int i = 0; i < songAmount; i++){ // run the array one entry at a time
            sum[i] = check(i,2) + check(i,3) + check(i,4); // the total rating of each song is a sum of instrumental, vocal, and lyrics
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
         System.out.println((num+1)+") "+songs[num][0]+" by "+ songs[num][1]); // print song #, name, and artist
         System.out.println("\tInstrumental Rating: "+ check(num, 2)); // print instrumental rating
         System.out.println("\tVocal Rating: "+ check(num, 2)); // print vocal rating
         System.out.println("\tLyrics Rating: "+ check(num, 2)); // print lyrics rating
         System.out.println("\tTOTAL RATING: "+max+"/30 !"); // display total rating out of 30
         } 
         else { //If not all song spots are filled an error message is printed
         System.out.println("Best song not printed, not all song locations are filled in"); //Prints error message
         }
   } //end of get best sng method

} //end of class