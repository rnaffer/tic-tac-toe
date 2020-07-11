import java.util.ArrayList;
import java.util.stream.Collectors;

public class Board {
    int size;
    ArrayList<BoardRow> rows;

    public Board(int size, ArrayList<BoardRow> rows) {
        this.size = size;
        this.rows = rows;
    }

    public int availableIndexesCount() {
        int availableIndexes = 0;

        for (BoardRow row : this.rows) {
            availableIndexes += row.availableIndexesCount();
        }

        return availableIndexes;
    }

    public int usedIndexesCount() {
        return (this.size * this.size) - this.availableIndexesCount();
    }

    public ArrayList<Integer> availableIndexes() {
        ArrayList<Integer> availableIndexes = new ArrayList<>();

        for (int i = 0; i < this.rows.size(); i++) {
            int finalI = i;
            availableIndexes.addAll(this.rows.get(i).availableIndexes().stream().map(n -> n + (this.size * finalI)).collect(Collectors.toList()));
        }

        return availableIndexes;
    }

    public void setCharToIndex(int index, String identifyChar) {
        if (!this.isValidIndex(index)) {
            throw new IllegalArgumentException();
        }

        int rowIndex = (int) Math.floor((double) index / this.size);
        int subRowIndex = index - (rowIndex * this.size);
        this.rows.get(rowIndex).setCharInIndex(subRowIndex, identifyChar);
    }

    private boolean isValidIndex(int index) {
        return this.indexIsInBoardRange(index) && !this.indexIsAlreadyTaken(index);
    }

    private boolean indexIsInBoardRange(int index) {
        return index >= 0 && index <= (this.size * this.size);
    }

    private boolean indexIsAlreadyTaken(int index) {
        int rowIndex = (int) Math.floor((double) index / this.size);
        int subRowIndex = index - (rowIndex * this.size);

        return this.rows.get(rowIndex).getIndexValue(subRowIndex).equals("X")
                || this.rows.get(rowIndex).getIndexValue(subRowIndex).equals("O");
    }
}
