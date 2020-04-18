package life;

public class Universe {
    private Cell[][] cells;
    private int size;

    public int getSize() {
        return size;
    }

    public Universe(int size) {

        this.size = size;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }



    public void printUni(){
        for (Cell[] c: cells
        ) {
            for (Cell i: c
            ) {
                System.out.print(i.getC());
            }
            System.out.print("\n");
        }
    }
}
