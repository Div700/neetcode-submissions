class Solution {
    public boolean isValidSudoku(char[][] board) {
        char boxBoard[][] = new char[board.length][board.length];
        Map<Integer, Set<String>> boxList = new HashMap<>();
        int column = 0;
        int startingIndex = -1;
        for (int row = 0; row < board.length; row++) {
            Set<String> rowElements = new HashSet<>();
            if (row % 3 == 0) {
                startingIndex = row;
            }
            int boxRow = startingIndex;
            for (int i = 0; i < board.length; i++) {
                char c = board[row][i];
                String element = getElement(c, i);
                rowElements.add(element);
                if (i != 0 && i % 3 == 0) {
                    boxRow++;
                }
                Set<String> arraySet = boxList.get(boxRow);
                if (arraySet != null) {
                    if (c == '.') {
                        int length = arraySet.size();
                        arraySet.add(Integer.toString(length) + c);
                    } else {
                        arraySet.add(element);
                    }
                } else {
                    Set<String> set = new HashSet<>();
                    if (c == '.') {
                        set.add("0.");
                    } else {
                        set.add(element);
                    }
                    boxList.put(boxRow, set);
                }
            }
            if (rowElements.size() != board.length) {
                return false;
            }

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
        System.out.println(boxList);
        for (Integer key : boxList.keySet()) {
            Set<String> value = boxList.get(key);
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
