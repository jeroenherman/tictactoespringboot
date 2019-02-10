package be.leerstad.tictactoe.business;

/**
* The Cell class models each individual cell of the game board.
*/
public class Cell {  // save as Cell.java
  // package access
  Seed content; // content of this cell of type Seed.
                // take a value of Seed.EMPTY, Seed.CROSS, or Seed.NOUGHT
  int row, col;
    /** test constructor **/
    public Cell() {
    }

    /** Constructor to initialize this cell */
  public Cell(int row, int col) {
     this.row = row;
     this.col = col;
     clear();  // clear content
  }

  /** Clear the cell content to EMPTY */
  public void clear() {
     content = Seed.EMPTY;
  }

    public Seed getContent() {
        return content;
    }

    public void setContent(Seed content) {
        this.content = content;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}