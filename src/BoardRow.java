import java.util.ArrayList;

public class BoardRow {
    ArrayList<String> row;

    public BoardRow(ArrayList<String> row) {
        this.row = row;
    }

    public void setCharInIndex(int index, String identifyChar) {
        row.set(index, identifyChar);
    }

    public String getIndexValue(int index) {
        return row.get(index);
    }

    public int size() {
        return this.row.size();
    }

    public ArrayList<String> get() {
        return row;
    }

    public int availableIndexesCount() {
        int availableIndexes = 0;

        for (String r : this.row) {
            availableIndexes += r.equals("X") || r.equals("O") ? 0 : 1;
        }

        return availableIndexes;
    }

    public ArrayList<Integer> availableIndexes() {
        ArrayList<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < this.row.size(); i++) {
            if (this.row.get(i).equals("X") || this.row.get(i).equals("O")) continue;

            indexes.add(i);
        }

        return indexes;
    }

    public boolean allIndexesHaveAreSameChar() {
        if (availableIndexesCount() != 0) return false;

        String lastChar = this.row.get(0);

        for (String r: this.row) {
            if (!r.equals(lastChar)) return false;
        }

        return true;
    }


}
