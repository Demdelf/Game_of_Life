package life;
import java.util.Random;

public class UniverseUtil {


    private Universe universe;
    private int gen = 0;
    private long alive;
    private boolean start = true;

    public long getAlive() {
        return alive;
    }

    public int getGen() {
        return gen;
    }

    public Universe getUniverse() {
        return universe;
    }

    public UniverseUtil(Universe universe) {
        this.universe = universe;
    }

    public void newGeneration(){
        Cell[][] cells = universe.getCells();

        long alives = 0L;
        if(!start){
            int n = cells.length;
            Cell[][] newCells = new Cell[n][n];


            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (willBeAlive(cells, i, j)){
                        newCells[i][j] = new Cell('O');
                        alives++;
                    }else newCells[i][j] = new Cell(' ');
                }
            }
            universe.setCells(newCells);
            gen++;
        }else {
            start = false;
            int n = universe.getSize();
            Random random = new Random(/*seed*/);
            Cell[][] newCells = new Cell[n][n];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    newCells[i][j] = new Cell(getCell(random.nextBoolean()));
                    if (newCells[i][j].isAlive()) alives++;
                }
            }
            universe.setCells(newCells);
            gen = 0;
        }

        this.alive = alives;
    }

    public boolean willBeAlive(Cell[][] cells, int i, int j){

        int n = cells.length;
        int qOfAlives = getNE(cells, i, j) + getNW(cells, i, j) + getSE(cells, i, j)
                + getSW(cells, i, j);

        if (i == 0) {
            if (cells[n - 1][j].isAlive()) qOfAlives++;
        }
        else {
            if (cells[i - 1][j].isAlive()) qOfAlives++;
        }

        if (i == n - 1) {
            if (cells[0][j].isAlive()) qOfAlives++;
        }
        else {
            if (cells[i + 1][j].isAlive()) qOfAlives++;
        }

        if (j == 0) {
            if (cells[i][n - 1].isAlive()) qOfAlives++;
        }
        else {
            if (cells[i][j - 1].isAlive()) qOfAlives++;
        }

        if (j == n - 1) {
            if (cells[i][0].isAlive()) qOfAlives++;
        }
        else {
            if (cells[i][j + 1].isAlive()) qOfAlives++;
        }

        if (cells[i][j].isAlive()){
            if (qOfAlives == 3 || qOfAlives == 2) return true;
            else return false;
        }else {
            if (qOfAlives == 3) return true;
            else return false;
        }
    }

    public int getNW(Cell[][] cells, int i, int j){
        int n = cells.length;
        if (i == 0) i = n;
        if (j == 0) j = n;
        if (cells[i - 1][j - 1].isAlive()) return 1;
        return 0;
    }

    public int getSW(Cell[][] cells, int i, int j){
        int n = cells.length;
        if (i == n - 1) i = -1;
        if (j == 0) j = n;
        if (cells[i + 1][j - 1].isAlive()) return 1;
        return 0;
    }

    public int getSE(Cell[][] cells, int i, int j){
        int n = cells.length;
        if (i == n - 1) i = -1;
        if (j == n - 1) j = -1;
        if (cells[i + 1][j + 1].isAlive()) return 1;
        return 0;
    }

    public int getNE(Cell[][] cells, int i, int j){
        int n = cells.length;
        if (i == 0) i = n;
        if (j == n - 1) j = -1;
        if (cells[i - 1][j + 1].isAlive()) return 1;
        return 0;
    }

    public static char getCell(boolean b){
        if (b) return 'O';
        else return ' ';
    }
}
