package leetcode.contests.contest_297;

public class CalculateAmountInTaxes {
    public static void main(String[] args) {
        CalculateAmountInTaxes calc = new CalculateAmountInTaxes();
        calc.calculateTax(new int[][]{{3, 50}, {7, 10}, {12, 25}}, 10);

        calc.calculateTax(new int[][]{{3, 50}, {7, 10}, {12, 25}}, 10);

        calc.calculateTax(new int[][]{{4, 8}, {5, 49}}, 2);
    }

    public double calculateTax(int[][] brackets, int income) {
        int totalRemaining = income;
        double totalTax = 0;

        for (int i = 0; i < brackets.length; i++) {
            int[] bracket = brackets[i];
            if (i == 0) {
                if (income <= bracket[0]) {
                    double tax = (double) (income * bracket[1]) / 100;
                    totalTax += tax;
                } else {
                    double tax = (double) (bracket[0] * bracket[1]) / 100;
                    totalTax += tax;
                }
                totalRemaining -= bracket[0];
            } else {
                double taxableIncome = bracket[0] - brackets[i - 1][0];
                double tax;
                if (totalRemaining < taxableIncome) {
                    tax = (double) (totalRemaining * bracket[1]) / 100;
                } else {
                    tax = (double) (taxableIncome * bracket[1]) / 100;
                }
                totalTax += tax;
                totalRemaining -= taxableIncome;
            }
            if (totalRemaining <= 0) break;

        }
        System.out.println(totalTax);
        return totalTax;
    }

}
