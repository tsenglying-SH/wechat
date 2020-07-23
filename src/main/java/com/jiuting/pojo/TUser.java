package com.jiuting.pojo;

import javax.persistence.*;

@Table(name = "t_user")
public class TUser {
    @Id
    private String id;

    private String username;

    private String password;

    @Column(name = "face-img")
    private String faceImg;

    @Column(name = "face-img-big")
    private String faceImgBig;

    @Column(name = "nick-name")
    private String nickName;

    private String qrcode;

    private String cid;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return face-img
     */
    public String getFaceImg() {
        return faceImg;
    }

    /**
     * @param faceImg
     */
    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }

    /**
     * @return face-img-big
     */
    public String getFaceImgBig() {
        return faceImgBig;
    }

    /**
     * @param faceImgBig
     */
    public void setFaceImgBig(String faceImgBig) {
        this.faceImgBig = faceImgBig;
    }

    /**
     * @return nick-name
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return qrcode
     */
    public String getQrcode() {
        return qrcode;
    }

    /**
     * @param qrcode
     */
    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    /**
     * @return cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * @param cid
     */
    public void setCid(String cid) {
        this.cid = cid;
    }
}