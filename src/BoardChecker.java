public class BoardChecker {
    final int MIN_AVAILABLE_INDEXES_FOR_DRAW = 2;

    public CheckStatus check(Board board) {
        return currentPlayerWins(board) ? CheckStatus.PLAYER_WIN :
                (isGameDraw(board) ? CheckStatus.GAME_DRAW : CheckStatus.KEEP_PLAYING);
    }

    private boolean currentPlayerWins(Board board) {
        return haveAtLeastEnoughPlays(board) &&
                (isSameCharInAllSameIndexes(board) || haveAtLeastARowWithSameCharInAllIndexes(board)
                        || isSameCharInAllStaggeredIndexes(board));
    }

    private boolean haveAtLeastEnoughPlays(Board board) {
        return board.usedIndexesCount() >= board.size * 2 - 1;
    }

    private boolean haveAtLeastARowWithSameCharInAllIndexes(Board board) {
        for (BoardRow row : board.rows) {
            if(row.allIndexesHaveAreSameChar()) return true;
        }

        return false;
    }

    private boolean isSameCharInAllSameIndexes(Board board) {
        for (int i = 0; i < board.size; i++) {
            String lastRowIndexValue = "";
            int matches = 0;

            for (int j = 0; j < board.rows.size(); j++) {
                if (lastRowIndexValue.equals("")) lastRowIndexValue = board.rows.get(j).getIndexValue(i);

                if(board.rows.get(j).getIndexValue(i).equals(lastRowIndexValue)) matches += 1;

                if (matches == board.rows.size()) return true;
            }
        }

        return false;
    }

    private boolean isSameCharInAllStaggeredIndexesLeftRight(Board board) {
        String lastRowIndexValue = "";
        int matches = 0;

        for (int i = 0; i < board.size; i++) {
            if (lastRowIndexValue.equals("")) lastRowIndexValue = board.rows.get(i).getIndexValue(i);

            if(board.rows.get(i).getIndexValue(i).equals(lastRowIndexValue)) matches += 1;

            if (matches == board.size) return true;
        }

        return false;
    }

    private boolean isSameCharInAllStaggeredIndexesRightLeft(Board board) {
        String lastRowIndexValue = "";
        int matches = 0;
        int j = board.size - 1;

        for (int i = 0; i < board.size; i++) {
            if (lastRowIndexValue.equals("")) lastRowIndexValue = board.rows.get(i).getIndexValue(j);

            if(board.rows.get(i).getIndexValue(j).equals(lastRowIndexValue)) matches += 1;

            if (matches == board.size) return true;
            j -= 1;
        }

        return false;
    }

    private boolean isSameCharInAllStaggeredIndexes(Board board) {
        return this.isSameCharInAllStaggeredIndexesLeftRight(board)
                || this.isSameCharInAllStaggeredIndexesRightLeft(board);
    }

    private boolean isGameDraw(Board board) {
        if (!boardHasAvailableIndexes(board)) return true;

        return leftInBoardMinimumAvailableIndexesForDraw(board);
    }

    private boolean boardHasAvailableIndexes(Board board) {
        return board.availableIndexesCount() != 0;
    }

    private boolean leftInBoardMinimumAvailableIndexesForDraw(Board board) {
        return board.availableIndexesCount() <= this.MIN_AVAILABLE_INDEXES_FOR_DRAW;
    }
}
