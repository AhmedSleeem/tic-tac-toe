package AI;

import java.util.Arrays;
import java.util.Random;

public class BacktrackMiniMax {
    
   private final static int[] boardArr = {0,0,0,0,0,0,0,0,0};
   private int level; // 1: Easy , 2:Normal, 3:Hard ,, else will be default the Normal level 

    public BacktrackMiniMax(int Lev) {
       level = Lev;   
    }

   public void setPlayer(int i){
       boardArr[i]=1;
   }
   public void setComp(int i){
       boardArr[i]=2;
   }
   public void resetStr(){
       Arrays.fill(boardArr, 0);
   } 
   
   public int move(String sp) {
       
       if ( level <= 2 ){
         int ret=0;
      for(;boardArr[ret]!=0;){
          ret=Shuffle();//7
          
       
      }
        
            return ret;
      } 
      else {
       return minimax(2, sp)[1]; 
       
   }
   }

   
   private int[] minimax(int depth, String st) {
      int bestScore = ("O".equals(st)) ? -9000 : 9000;
      int currentScore;
      int best = 1;
 
      if ( depth == 0 ) {
        
         bestScore = evaluate();    
      } else {
         for (int x = 0 ; x < 9 ; x++) {
            if ( boardArr[x] == 0){
           
                if ( "X".equals(st) )boardArr[x] = 1; 
                else boardArr[x] = 2; 
                
                if ("O".equals(st)) { 
                   currentScore = minimax(depth - 1, "X")[0];
                   if (currentScore > bestScore) {
                      bestScore = currentScore;
                      best = x;
                   }
                } else {  
                   currentScore = minimax(depth - 1, "O")[0];
                   if (currentScore < bestScore) {
                      bestScore = currentScore;
                      best = x;
                   }
                }
             
            boardArr[x] = 0;
            }
         }
      }
      return new int[] {bestScore, best};
   }
 
   private int evaluate() {
      int score = 0;
      score += evaluateLine("r", 0, 0);  // Evaluate row 1
      score += evaluateLine("r", 0, 3);  // Evaluate row 2
      score += evaluateLine("r", 0, 6);  // Evaluate row 3
      score += evaluateLine("c", 0, 0);  // Evaluate col 1
      score += evaluateLine("c", 1, 0);  // Evaluate col 2
      score += evaluateLine("c" ,2, 0);  // Evaluate col 3
      score += evaluateLine("d", 0, 6);  // Evaluate diagonal (\)
      score += evaluateLine("d", 2, 6);  // Evaluate alternate diagonal (/)
      return score;
   }
 
   private int evaluateLine(String st, int j, int i) {
      int score = 0;
// First cell
      if ( ((boardArr[i] == 2) && ("r".equals(st)) ) ||  ((boardArr[j] == 2) && ("c".equals(st))) ||  ((boardArr[j] == 2) && ("d".equals(st))) ) {
         score = 1;
      } else if ( ((boardArr[i] == 1) && ("r".equals(st))) || ((boardArr[j] == 1) && ("c".equals(st))) || ((boardArr[j] == 1) && ("d".equals(st))) ) {
         score = -1;
      }
// Second cell
      if ( ((boardArr[i+1] == 2) && ("r".equals(st)))  ||  ((boardArr[j+3] == 2) && ("c".equals(st))) ||  ((boardArr[4] == 2) && ("d".equals(st)))) {
          switch (score) {
              case 1: // cell1 is "O"
                  score = 10;
                  break;
              case -1: // cell1 is "X"
                  score = 0;
                  break;
              default: // cell1 is empty
                  score = 1;
                  break;}
      } else if (((boardArr[i+1] == 1) && ("r".equals(st))) || ((boardArr[j+3] == 1) && ("c".equals(st))) ||  ((boardArr[4] == 1) && ("d".equals(st))) ) {
          switch (score) {
              case -1: // cell1 is "X"
                  score = -10;
                  break;
              case 1: // cell1 is "O"
                  score = 0;
                  break;
              default: // cell1 is empty
                  score = -1;
                  break;}
      }
// Third cell
      if ( ((boardArr[i+2] == 2) && ("r".equals(st))) ||  ((boardArr[j+6] == 2) && ("c".equals(st))) ||  ((boardArr[i+2-j] == 2) && ("d".equals(st))) ) {
         if (score > 0) {  // cell1 and/or cell2 is "O"
            score *= 10;
         } else if (score < 0) {  // cell1 and/or cell2 is "X"
            score = 0;
         } else {  // cell1 and cell2 are empty
            score = 1;}
      } else if ( ((boardArr[i+2] == 1) && ("r".equals(st))) || ((boardArr[j+6] == 1) && ("c".equals(st))) ||  ((boardArr[i+2-j] == 1) && ("d".equals(st))) ) {
         if (score < 0) {  // cell1 and/or cell2 is "X"
            score *= 10;
         } else if (score > 1) {  // cell1 and/or cell2 is "O"
            score = 0;
         } else {  // cell1 and cell2 are empty
            score = -1;}
      }
      return score;}
   
    private int Shuffle(){
        
		Random rand = new Random();
                int randomIndexToSwap = rand.nextInt(boardArr.length);
                return randomIndexToSwap;//1 2 3 4 ... 9
    }
}  

