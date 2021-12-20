package binarySearch;

public class Budget {
    public int solution(int[] budgets, int M) {
        int lb = 0, ub = budgets[0], mid;
        long sum = 0;
        for (int budget : budgets) {
            ub = Math.max(ub, budget);
            sum += budget;
        }
        if (sum < M)
            return ub;
        return binaryBudgets(budgets, M, lb, ub);
    }

    private int binaryBudgets(int[] budgets, int M, int lb, int ub) {
        if (lb > ub)
            return ub;
        long sum = 0;
        int mid = (lb + ub) / 2;
        for (int budget : budgets) {
            sum += Math.min(budget, mid);
        }
        if (sum >= M)
            return binaryBudgets(budgets, M, lb, mid - 1);
        else
            return binaryBudgets(budgets, M, mid + 1, ub);
    }
}
