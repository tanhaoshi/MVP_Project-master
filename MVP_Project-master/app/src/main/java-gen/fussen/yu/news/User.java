package fussen.yu.news;

import fussen.yu.news.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "USER".
 */
public class User {

    private Long userID;
    /** Not-null value. */
    private String nickName;
    /** Not-null value. */
    private String uid;
    /** Not-null value. */
    private String avatarUrl;
    /** Not-null value. */
    private String mobile;
    /** Not-null value. */
    private String gender;
    private Long sportID;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient UserDao myDao;

    private Sport sport;
    private Long sport__resolvedKey;


    public User() {
    }

    public User(Long userID) {
        this.userID = userID;
    }

    public User(Long userID, String nickName, String uid, String avatarUrl, String mobile, String gender, Long sportID) {
        this.userID = userID;
        this.nickName = nickName;
        this.uid = uid;
        this.avatarUrl = avatarUrl;
        this.mobile = mobile;
        this.gender = gender;
        this.sportID = sportID;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserDao() : null;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    /** Not-null value. */
    public String getNickName() {
        return nickName;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /** Not-null value. */
    public String getUid() {
        return uid;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /** Not-null value. */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /** Not-null value. */
    public String getMobile() {
        return mobile;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /** Not-null value. */
    public String getGender() {
        return gender;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getSportID() {
        return sportID;
    }

    public void setSportID(Long sportID) {
        this.sportID = sportID;
    }

    /** To-one relationship, resolved on first access. */
    public Sport getSport() {
        Long __key = this.sportID;
        if (sport__resolvedKey == null || !sport__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SportDao targetDao = daoSession.getSportDao();
            Sport sportNew = targetDao.load(__key);
            synchronized (this) {
                sport = sportNew;
            	sport__resolvedKey = __key;
            }
        }
        return sport;
    }

    public void setSport(Sport sport) {
        synchronized (this) {
            this.sport = sport;
            sportID = sport == null ? null : sport.getSportID();
            sport__resolvedKey = sportID;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
