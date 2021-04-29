// Kyle Knopp
// File: Queen.java 

/***********************************************************************************************************
*A Queen is an object representing a queen in the game of chess. It carries with is the coordinates 
*corresponding with where it would be placed on a chess board. This class allows for the creation of a Queen
*as well as comparing it to other queens to see if either would be able to attack each other on a chess board 
*following the rules of chess pertaining to queens.
*@note
*(1) Those rules state a queen can attack if another piece (in this case queen) is in the same row, column, or
*diagonal in a grid format (nxn) known as a board.
*April 12, 2020
************************************************************************************************************/
public class Queen{
   //Invariant of the UnboundedInt class:
   // 1. Row is an integer representing the x coordinate of the chess board.
   // 2. Column is an integer representing the y coordinate of the chess board.
   private int row, column;
   
//----------------------------Constructors----------------------------
   //-----------------Queen()--------------------
   /**
   * Initialize an empty Queen object.
   * @param - none
   * <dt><b>Postcondition:</b><dd>
   *   This queen is initialized with no coordinates.
   **/    
   public Queen(){
   }
   
   //-----------------Queen(int x, int y)--------------------
   /**
   * Initialize a Queen object with coordinates x and y which represent where on a chess
   * board this queen is placed.
   * @param - x: integer representing row the queen is placed in
   * @param - y: integer representing column the queen is placed in
   * @Postcondition: Queen is initialized at x,y coordinates of "chess board"
   *   
   **/    
   public Queen(int x, int y){
      row=x;
      column=y;
   }
   
//-----------------conflict(Queen)--------------------
   /**
   *A method that checks if this.queen object is in conflict with any other queen placed on the board.
   * returns true if is in conflict, returns false if there is no conflict with other queen object.
   *@param- Queen attempt
   *  A Queen object to test against calling object.
   *@precondition- calling queen object is not empty.
   *@postcondition- 
   *  Tells you if there is a conflict with another queen on board or not.
   *@return-boolean: returns true if in conflict, false if there is no conflict
   *@exception IllegalStateException indicates calling object has no coordinates, or attempt has no coordinates
   */ 
   public boolean conflict(Queen attempt){
      //checks if in same row or column
      if(attempt.getX()==this.row||attempt.getY()==this.column)
         return true;
      //checks if in diagonal leftwards and upwards
      for(int i=1; i<attempt.getX();i++){
         int tempX=attempt.getX()-i;
         int tempY=attempt.getY()+i;
         if(tempX==this.row && tempY==this.column){
            return true;
         }
      }
      //checks if in diagonal leftwards and downwards
      for(int i=1; i<attempt.getX();i++){
         int tempX=attempt.getX()-i;
         int tempY=attempt.getY()-i;
         if(tempX==this.row && tempY==this.column){
            return true;
         }
      }

      return false;
   }
   
//-----------------getX()--------------------
   /**
   * Accessor method to determine the row of queen
   * @param - none
   * @return
   *   The row that this.queen is in
   **/ 
   public int getX(){
      return row;
   }
   
//-----------------getY()--------------------
   /**
   * Accessor method to determine the column of queen
   * @param - none
   * @return
   *   The column that this.queen is in
   **/    
   public int getY(){
      return column;
   }
   
//-----------------toString()--------------------
   /**
   *A method that represents the Queen object as a String. Overrides Object class toString.
   *@param-none
   *@precondition- 
   *  UnboundedInt not empty
   *@postcondition-
   *  Returns a String of Queen coordinates represented by rows and columns
   *@return-
   *  Returns a String named temp that represents this Queens rows and columns
   *@exception- IllegalStateException
   *  Indicates this Queen has no x or y data
   */    
   public String toString(){
      String temp=("row: "+getX()+" column: "+getY());
      return temp;
   }
}