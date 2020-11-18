package metier.beans;

public class Grid {

    static int[][] sharedGrid = new int [10][10];

    public void initializeGrid(){
        for(int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                sharedGrid[i][j] = 0;
            }
        }
    }

    public int[][] getSharedGrid() {
        return sharedGrid;
    }

    public void setSharedGrid(int[][] sharedGrid) {
        this.sharedGrid = sharedGrid;
    }
}
