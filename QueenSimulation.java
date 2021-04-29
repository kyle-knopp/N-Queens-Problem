// Kyle Knopp
// File: SequenceTest.java 

/**************************************************************************************************************
*QueenSimulation takes an input integer of N size to create a chess board of NxN size and tries to place a 
*N amount of queens where no queen is attacking another. If solutions are calculated it outprints the  
*solution coordinates for each queen along with the number of solutions that N amount of queens and board size.
*@Note
*(1)This class uses a stack application, LinkedStack, to implement without recursion and use a blunt force 
*algorithm to check every possible coordinate, backtracking if no solution for that placed queen is found, or 
*if a valid solution is found, to find all possible solutions.
*(2)The column value is iterated by using the number of queens pushed in the stack and the row by a for loop.
(3)Queens only pushed in stack if no conflict with other queen is found.
*
*April 12, 2020
**************************************************************************************************************/
import java.util.*;

public class QueenSimulation {
    public static void main(String[]args) {
        int boardSize;
        Scanner in = new Scanner(System.in);
        int numSolutions=0;
        boolean exit=false;
        
        do{ 
        System.out.println("Please enter the size of the board: ");
        boardSize = in.nextInt();
        if (boardSize < 4) {
            System.out.println("There is no solution");
        }

        LinkedStack<Queen> queens = new LinkedStack<Queen>();
        int startRow = 1;
        while(true) {
            int column = queens.size() + 1;
            boolean queenAdded = false;
            for (int row = startRow; row <= boardSize; row++) {
                Queen queen = new Queen(column, row);
                boolean conflict = false;
                LinkedStack<Queen> previousQueens = queens.clone();
                while (!conflict && !previousQueens.isEmpty()) {
                    conflict = previousQueens.pop().conflict(queen);
                }
                if (!conflict) {
                    queens.push(queen);
                    queenAdded = true;
                    startRow = 1;
                    break;
                }
            }
            if (!queenAdded) {
                if(queens.size() > 0) {
                    startRow = queens.pop().getY() + 1;
                } else {
                    break;
                }
            } else if(queens.size() == boardSize) {
                numSolutions++;
                printSolution(boardSize, queens.clone(),numSolutions);
                if(queens.size() > 0) {
                    startRow = queens.pop().getY() + 1;
                } else {
                    break;
                }
            }
        }
        System.out.println("There are "+numSolutions+" solutions for "+boardSize+" N queens");
        numSolutions=0;
        System.out.println("\nWould you like to test another number? \n----------------------------------------------------------\n\t Enter (Y) or hit any other key and enter to exit: \n----------------------------------------------------------");
        String select=in.next();
        if(select.equals("y")||select.equals("Y")){
          exit=false;
        }else{
          exit=true;
          }
        }while(!exit); 
    
    }//end main
    
//----------------------------PrintSolution---------------------------------------------------------    
    private static void printSolution(int boardSize, LinkedStack<Queen> queens,int numSolutions){
      LinkedStack<Queen> correctOrder = new LinkedStack<Queen>();
           
      System.out.print("Solution #"+numSolutions+": ");             
      Queen q= new Queen();                                                             
      while(!queens.isEmpty()) { // [edit] maybe a little easier?
         q=queens.pop();
         correctOrder.push(q);
      }
      while(!correctOrder.isEmpty()){               
         System.out.print("{ "+correctOrder.pop().toString()+"} ");          //popped to second stack and then popped off that to make it print correctly
      }
         System.out.print("}");
         System.out.println();                
   }//end Print Solution
   
}//end class
