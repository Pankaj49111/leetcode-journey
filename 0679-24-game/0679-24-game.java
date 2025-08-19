class Solution {
    final char[] ops = {'+', '-', '*', '/'};

    // Evaluate expression with two operands and an operator
    double eval(double a, double b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': 
                if (b == 0) return Double.NaN;  // division by zero invalid
                return a / b;
        }
        return Double.NaN;
    }

    // Check if value is approximately 24
    boolean is24(double val) {
        return Math.abs(val - 24) < 1e-6;
    }

    // All ways to parenthesize 4 numbers and 3 operators (5 patterns)
    boolean checkAllGroups(double[] nums, char[] ops) {
        double a = nums[0], b = nums[1], c = nums[2], d = nums[3];
        char op1 = ops[0], op2 = ops[1], op3 = ops[2];

        // 1. ((a op1 b) op2 c) op3 d
        double r1 = eval(eval(eval(a,b,op1), c, op2), d, op3);
        if (is24(r1)) return true;

        // 2. (a op1 (b op2 c)) op3 d
        double r2 = eval(eval(a, eval(b, c, op2), op1), d, op3);
        if (is24(r2)) return true;

        // 3. a op1 ((b op2 c) op3 d)
        double r3 = eval(a, eval(eval(b, c, op2), d, op3), op1);
        if (is24(r3)) return true;

        // 4. a op1 (b op2 (c op3 d))
        double r4 = eval(a, eval(b, eval(c, d, op3), op2), op1);
        if (is24(r4)) return true;

        // 5. (a op1 b) op2 (c op3 d)
        double r5 = eval(eval(a, b, op1), eval(c, d, op3), op2);
        if (is24(r5)) return true;

        return false;
    }

    // Generate all operator combinations (4^3 = 64)
    List<char[]> generateOperators() {
        List<char[]> opCombos = new ArrayList<>();
        for (char op1 : ops)
            for (char op2 : ops)
                for (char op3 : ops)
                    opCombos.add(new char[]{op1, op2, op3});
        return opCombos;
    }

    // Generate all permutations of the 4 numbers -- backtracking
    List<double[]> permute(double[] nums) {
        List<double[]> res = new ArrayList<>();
        permuteHelper(nums, 0, res);
        return res;
    }

    void permuteHelper(double[] nums, int start, List<double[]> res) {
        if (start == nums.length) {
            res.add(nums.clone());
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            permuteHelper(nums, start + 1, res);
            swap(nums, start, i);
        }
    }

    void swap(double[] nums, int i, int j) {
        double temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public boolean judgePoint24(int[] cards) {
        double[] nums = new double[4];
        for (int i = 0; i < 4; i++) nums[i] = cards[i];

        List<double[]> permutations = permute(nums);
        List<char[]> opCombos = generateOperators();

        for (double[] perm : permutations) {
            for (char[] ops : opCombos) {
                if (checkAllGroups(perm, ops)) return true;
            }
        }
        return false;
    }
}
