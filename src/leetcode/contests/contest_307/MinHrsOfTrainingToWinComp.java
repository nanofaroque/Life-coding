package leetcode.contests.contest_307;

import java.util.Arrays;

public class MinHrsOfTrainingToWinComp {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int res = 0;
        int totalEnergyNeeded = Arrays.stream(energy).sum() - initialEnergy + 1;
        if (totalEnergyNeeded > 0) {
            res += totalEnergyNeeded;
        }

        int totalExpNeeded = initialExperience;
        for (int exp : experience) {
            if (exp >= totalExpNeeded) {
                int diff = exp - totalExpNeeded + 1;
                totalExpNeeded += diff;
                res += diff;
            }
            totalExpNeeded += exp;
        }
        return res;
    }
}
