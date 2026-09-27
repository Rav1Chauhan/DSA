class Solution {
    public List<Integer> getRow(int rowIndex) {
        return generateRow(rowIndex + 1);
    }

    private List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();

        ansRow.add(1);

        for (int col = 1; col < row; col++) {
            ans = ans * (row - col) / col;
            ansRow.add((int) ans);
        }

        return ansRow;
    }
}