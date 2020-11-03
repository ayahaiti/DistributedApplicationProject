import java.util.ArrayList;

public class Computer extends Player {

    // record the previous moves of computer
    private ArrayList<Point> previousMoves;
    private boolean isInHittingMode;
    private int hittingStartIndex;

    public Computer(BattleGrid grid) {
        super(grid);
        previousMoves = new ArrayList<Point>();
        isInHittingMode = false;
    }

    public void addMove(Point p) {
        previousMoves.add(p);
    }

    // get previous move point
    // 1 <= n <= previousMoves.size()
    public Point getPrevMove(int n) {
        if (n > previousMoves.size() || n < 1)
            return null;
        else
            return previousMoves.get(previousMoves.size() - n);
    }

    public int prevMoveSize() {
        return previousMoves.size();
    }

    public void setIsInHittingMode(boolean mode) {
        isInHittingMode = mode;
        if (mode)
            hittingStartIndex = previousMoves.size();
    }

    public int hittingMoveSize() {
        return previousMoves.size() - hittingStartIndex + 1;
    }

    public boolean isInHittingMode() {
        return isInHittingMode;
    }

}
