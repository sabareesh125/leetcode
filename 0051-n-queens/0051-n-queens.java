class Solution {
    class State {
        private final char[][] board;
        private final Set<Integer> cols, diagonals, antiDiagonals;
        private final int N;
        State(int n) {
            this.N = n;
            this.board = new char[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    this.board[i][j] = '.';
                }
            }
            this.cols = new HashSet<>();
            this.diagonals = new HashSet<>();
            this.antiDiagonals = new HashSet<>();
        }
        void place(int r, int c) {
            this.board[r][c] = 'Q';
            this.cols.add(c);
            this.diagonals.add(r-c);
            this.antiDiagonals.add(r+c);
        }
        void remove(int r, int c) {
            this.board[r][c] = '.';
            this.cols.remove(c);
            this.diagonals.remove(r-c);
            this.antiDiagonals.remove(r+c);
        }
        boolean canPlace(int r, int c) {
            return !this.cols.contains(c) && !this.diagonals.contains(r-c) && !this.antiDiagonals.contains(r+c);
        }
        List<String> getResult() {
            List<String> result = new ArrayList<>();
            for(char[] row : this.board) {
                result.add(new String(row));
            }
            return result;
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        solve(0, new State(n), result);
        return result;
    }
    private void solve(int row, State state, List<List<String>> result) {
        if(row == state.N) {//N queens have been placed
            result.add(state.getResult());
            return;
        }
        for(int col = 0; col < state.N; col++) {
            if(state.canPlace(row, col)) {
                state.place(row, col);
                solve(row+1, state, result);
                state.remove(row, col);
            }
        }
    }
}