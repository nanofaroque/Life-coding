package leetcode.contests.contest_314;

public class HardestWorker {
    public static void main(String[] args) {
        HardestWorker hw = new HardestWorker();
        int res = hw.hardestWorker(10, new int[][]{{0, 3}, {2, 5}, {0, 9}, {1, 15}});
        System.out.println(res);
    }

    public int hardestWorker(int n, int[][] logs) {

        int longestTask = logs[0][1];
        int hardestWorker = logs[0][0];


        for (int i = 1; i < logs.length; i++) {
            int[] task = logs[i];
            int lastTaskEnd = logs[i - 1][1];

            int time = task[1] - lastTaskEnd;
            if (time > longestTask) {
                longestTask = time;
                hardestWorker=task[0];

            }else if(time==longestTask){
                hardestWorker = Math.min(hardestWorker, task[0]);
            }
        }

        return hardestWorker;
    }
}
