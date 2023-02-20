public class Grid {
    public class Cell {
        private int value;
        private Cell left;
        private Cell right;
        private Cell top;
        private Cell bottom;

        public Cell(int value, Cell left, Cell right, Cell top, Cell bottom){
            this.value = value;
            this.left = left;
            this.right = right;
            this.top = top;
            this.bottom = bottom;
        }
    }
    
    // Cell positions
    /*
     * 1 |  2 | 3  | 4
     * 5 |  6 | 7  | 8
     * 9 | 10 | 11 | 12
     */

    public Grid(){
        Cell one = new Cell(25,null,10,null,1);
        Cell two = new Cell(10,25,1,null,5);
        Cell three = new Cell(1,10,10,null,5);
        Cell four = new Cell(10,1,null,null,10);
        Cell five = new Cell(1,null,5,25,1);
        Cell six = new Cell(5,1,5,10,10);
        Cell seven = new Cell(5,5,10,1,5);
        Cell eight = new Cell(10,5,null,10,-1);
        Cell nine = new Cell(1,null,10,1,null);
        Cell ten = new Cell(10,1,1,5,null);
        Cell eleven = new Cell(1,10,-1,5,null);
        Cell twelve = new Cell(-1,1,null,10,null);
    }

    public boolean move(Cell box){
        // TODO
        return true;
    }

    public boolean check_complete(){
        if(one.value == nine.value || two.value == ten.value || three.value == eleven.value || four.value == twelve.value){
            return true;
        }
        return false;
    }

    public void solve_game(){
        // TODO
    }
}
