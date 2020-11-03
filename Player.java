public class Player {
    // Grid on which the player places ships
    BattleGrid myGrid;

    public Player(BattleGrid grid) {
        myGrid = grid;
    }

    public BattleGrid getBattleGrid() {
        return myGrid;
    }

    public boolean hasShips() {
        return !myGrid.gameOver();
    }
}
