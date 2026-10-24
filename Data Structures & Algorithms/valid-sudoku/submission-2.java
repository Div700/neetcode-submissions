
class Solution {
    public boolean isValidSudoku(char[][] board) {
        char boxBoard[][] = new char[board.length][board.length];
        Map<Integer, Set<String>> boxList = new HashMap<>();

        int column = 0;

        for (int row = 0; row < board.length; row++) {
            Set<String> rowElements = new HashSet<>();

            for (int i = 0; i < board.length; i++) {
                char c = board[row][i];
                String element = getElement(c, i);
                rowElements.add(element);

                // Modified 3x3 box logic
                int boxIndex = (row / 3) * 3 + (i / 3);

                Set<String> arraySet = boxList.computeIfAbsent(
                    boxIndex, k -> new HashSet<>()
                );

                if (c == '.') {
                    arraySet.add(row + "," + i);
                } else {
                    arraySet.add(element);
                }
            }

            // Row validation
            if (rowElements.size() != board.length) {
                return false;
            }

            // Column validation
            Set<String> columnElements = new HashSet<>();

            for (int i = 0; i < board.length; i++) {
                char c = board[i][column];
                String element = getElement(c, i);
                columnElements.add(element);
            }

            if (columnElements.size() != board.length) {
                return false;
            }

            column++;
        }

        // Box validation
        for (Set<String> value : boxList.values()) {
            if (value.size() < 9) {
                return false;
            }
        }

        return true;
    }

    public String getElement(char c, int index) {
        if (c == '.') {
            return Integer.toString(index) + c;
        } else {
            return String.valueOf(c);
        }
    }
}