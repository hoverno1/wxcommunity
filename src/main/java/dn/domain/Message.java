package dn.domain;

public class Message {
    private Integer mid;
    private Integer postId;
    private Integer nid;
    private String message;

    public Message() {
    }

    public Message(Integer mid, Integer postId, Integer nid, String message) {
        this.mid = mid;
        this.postId = postId;
        this.nid = nid;
        this.message = message;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "mid=" + mid +
                ", postId=" + postId +
                ", nid=" + nid +
                ", message='" + message + '\'' +
                '}';
    }
}
