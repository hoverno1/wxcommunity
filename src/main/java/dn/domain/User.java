package dn.domain;

public class User {
    private Integer aid;
    private String author;
    private String password;
    private Integer status;

    public User() {
    }

    public User(Integer aid, String author, String password, Integer status) {
        this.aid = aid;
        this.author = author;
        this.password = password;
        this.status = status;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "aid=" + aid +
                ", author='" + author + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
}
