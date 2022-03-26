
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner{

   public static void main (String[] args){
      SongRater2D a = new SongRater2D("test.txt");
      try {
         a.readFile();
      }
      catch (IOException e) {
         System.out.println("Cannot find the file.");
      }
      a.getSongs();
      a.getBestSong();
   }
}