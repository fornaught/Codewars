package com.company;

import java.util.Arrays;
import java.util.List;

public class User {
    public List<Integer> ranks = Arrays.asList(8,7,6,5,4,3,2,1,-1,-2,-3,-4,-5,-6,-7,-8);
    public int rank;
    public int progress;

    public User() {
        this.rank = -8;
        this.progress = 0;
    }

    public void setProgress(int progress) {
        this.progress += progress;
        while (this.progress > 99 && rank != 8) {
            this.rank = ranks.get(ranks.indexOf(this.rank) -1);
            this.progress -= 100;
        }
        if (this.rank == 8) {
            this.progress = 0;
        }
    }

    public void incProgress(int activityRank) throws IllegalArgumentException {
        if (activityRank > 8 || activityRank == 0 || activityRank < -8)
        {
            throw new IllegalArgumentException();
        }
        int difference = ranks.indexOf(this.rank) - ranks.indexOf(activityRank);

        if (difference  == -1) {
            this.setProgress(1);
        }
        if (difference == 0) {
            this.setProgress(3);
        }
        else if (difference > 0) {
            this.setProgress(10 * difference * difference);
        }
    }
}
