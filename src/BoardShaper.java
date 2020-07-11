import java.util.ArrayList;

public class BoardShaper {
    int size;

    public BoardShaper(int size) {
        this.size = size;
    }

    public ArrayList<BoardRow> boardInitialValues() {
        ArrayList<BoardRow> rowValues = new ArrayList<>();

        for (int i = 0; i < this.size; i++) {
            ArrayList<String> row = new ArrayList<>();

            for (int j = 0; j < this.size; j++) {
                row.add(String.valueOf((i*size)+(j)));
            }

            rowValues.add(new BoardRow(row));
        }

        return rowValues;
    }
}
