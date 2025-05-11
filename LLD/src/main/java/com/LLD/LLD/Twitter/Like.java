package com.LLD.LLD.Twitter;

public class Like implements Interaction {

    private int likeId;
    private Boolean isLiked;

    public Like(int likeId, Boolean isLiked) {
        this.likeId = likeId;
        this.isLiked = isLiked;
    }

    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int likeId) {
        this.likeId = likeId;
    }

    public Boolean getLiked() {
        return isLiked;
    }

    public void setLiked(Boolean liked) {
        isLiked = liked;
    }

    @Override
    public int getInteractionId() {
        return this.likeId;
    }
}
