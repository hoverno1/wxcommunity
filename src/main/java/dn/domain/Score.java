package dn.domain;

public class Score {
    private String aid;
    private String postId;
    private Integer score;

    public Score() {
    }

    public Score(String aid, String postId, Integer score) {
        this.aid = aid;
        this.postId = postId;
        this.score = score;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "aid=" + aid +
                ", postId=" + postId +
                ", score=" + score +
                '}';
    }
}
