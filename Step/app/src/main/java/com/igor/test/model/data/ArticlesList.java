package com.igor.test.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ArticlesList implements Serializable {

    public ArticlesList(String id, String title, String subtitle, Thumb thumb) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.thumb = thumb;
    }

    @Expose
    private Integer timestamp;

    /**
     * @return The timestamp
     */
    public Integer getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp The timestamp
     */
    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("internalId")
    @Expose
    private String internalId;
    @SerializedName("update")
    @Expose
    private Integer update;
    @SerializedName("date")
    @Expose
    private Integer date;
    @SerializedName("ranking")
    @Expose
    private Integer ranking;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("subtitle")
    @Expose
    private String subtitle;
    @SerializedName("thumb")
    @Expose
    private Thumb thumb;

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The internalId
     */
    public String getInternalId() {
        return internalId;
    }

    /**
     * @param internalId The internalId
     */
    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }

    /**
     * @return The update
     */
    public Integer getUpdate() {
        return update;
    }

    /**
     * @param update The update
     */
    public void setUpdate(Integer update) {
        this.update = update;
    }

    /**
     * @return The date
     */
    public Integer getDate() {
        return date;
    }

    /**
     * @param date The date
     */
    public void setDate(Integer date) {
        this.date = date;
    }

    /**
     * @return The ranking
     */
    public Integer getRanking() {
        return ranking;
    }

    /**
     * @param ranking The ranking
     */
    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The subtitle
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * @param subtitle The subtitle
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    /**
     * @return The thumb
     */
    public Thumb getThumb() {
        return thumb;
    }

    /**
     * @param thumb The thumb
     */
    public void setThumb(Thumb thumb) {
        this.thumb = thumb;
    }

    public static class Thumb implements Serializable {
        public Thumb(String link) {
            this.link = link;
        }

        @SerializedName("link")
        @Expose
        private String link;
        @SerializedName("md5")
        @Expose
        private String md5;

        /**
         * @return The link
         */
        public String getLink() {
            return link;
        }

        /**
         * @param link The link
         */
        public void setLink(String link) {
            this.link = link;
        }

        /**
         * @return The md5
         */
        public String getMd5() {
            return md5;
        }

        /**
         * @param md5 The md5
         */
        public void setMd5(String md5) {
            this.md5 = md5;
        }
    }
}

