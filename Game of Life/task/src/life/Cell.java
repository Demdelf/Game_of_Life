package life;

public class Cell {
    private char c;

    public Cell(char c) {
        this.c = c;
    }
    public boolean isAlive(){
        if (getC() == 'O') return true;
        else return false;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }
}
