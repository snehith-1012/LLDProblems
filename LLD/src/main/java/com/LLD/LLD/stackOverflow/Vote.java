package com.LLD.LLD.stackOverflow;

public class Vote {

    private  int value;
    private User votedByUser;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public User getVotedByUser() {
        return votedByUser;
    }

    public void setVotedByUser(User votedByUser) {
        this.votedByUser = votedByUser;
    }

    public Vote(User votedBy, int value){
        this.votedByUser = votedBy;
        this.value = value;
    }
}
