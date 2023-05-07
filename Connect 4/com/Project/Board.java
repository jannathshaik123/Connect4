public class Board
{
    private static int rows=6;
    private static int columns=7;
    Piece [][]ourBoard;
    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        
        ourBoard = new Piece[rows][columns];
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < columns; col++){
                ourBoard[row][col] = null;
            }
        }
    }

    public Piece[][] getOurBoard() {
        return ourBoard;
    }
     public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }
        
    public boolean checkBoard(){
        boolean flag=true;
        for(int row = 0; row < getRows(); row++){
            for(int col = 0; col < getColumns(); col++){
                if(ourBoard[row][col] == null){
                    flag=false;
                    break;
            }
        }
        }
        return flag;
    }
    
    public int addPiece(int colToAdd, String color) {
        if(colToAdd >= 0 && colToAdd < columns) {   
            if(ourBoard[0][colToAdd] == null) {
                boolean addedThePiece = false;
                int addedRow = -1;
                for(int row = rows - 1; row >= 0; row--)
                    if(ourBoard[row][colToAdd] == null) {
                        ourBoard[row][colToAdd] = new Piece();
                        ourBoard[row][colToAdd].setColor(color);
                        addedThePiece = true;
                        addedRow = row;
                        break;
                    }
                return addedRow;
            } else {
                // that row is full
                System.err.println("This column is full, please choose another.");
                return -1;
            }
        } else {
            // outside normal range
            System.err.println("You are trying to add somewhere that is not supported.");
            return -1;
        }
    }
}
