package site.huaya.search.bean;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 *
 * 错误 No identifier specified for entity: site.huaya.search.bean.UserInfo ====> @Id注解导包错误
 *
 */
@Entity
public class UserInfo{


    @JsonIgnore
    @Transient
    public static final int ORIGIN_COIN=6;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    //用户uid
    private String uid;

    private int coin;

    private int point;

    public String getDev() {
        return dev;
    }

    public void setDev(String dev) {
        this.dev = dev;
    }

    private String dev;


    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }



}
