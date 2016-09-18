package com.igor.test.model.data;

/**
 * Created by Igor on 13.09.2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Article {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("internalId")
    @Expose
    private String internalId;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("categoryId")
    @Expose
    private String categoryId;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("date")
    @Expose
    private Integer date;
    @SerializedName("lireAussi")
    @Expose
    private List<LireAussi> lireAussi = new ArrayList<LireAussi>();
    @SerializedName("photos")
    @Expose
    private List<Photo> photos = new ArrayList<Photo>();
    @SerializedName("shareArticleUrl")
    @Expose
    private String shareArticleUrl;
    @SerializedName("subtitle")
    @Expose
    private String subtitle;
    @SerializedName("tags")
    @Expose
    private List<Tag> tags = new ArrayList<Tag>();
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("update")
    @Expose
    private Integer update;
    @SerializedName("videos")
    @Expose
    private List<Video> videos = new ArrayList<Video>();
    @SerializedName("thumb")
    @Expose
    private Thumb thumb;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The _id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The internalId
     */
    public String getInternalId() {
        return internalId;
    }

    /**
     *
     * @param internalId
     * The internalId
     */
    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }

    /**
     *
     * @return
     * The author
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     * The author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *
     * @return
     * The categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     *
     * @param categoryId
     * The categoryId
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     *
     * @return
     * The content
     */
    public String getContent() {
        return content;
    }

    /**
     *
     * @param content
     * The content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     *
     * @return
     * The date
     */
    public Integer getDate() {
        return date;
    }

    /**
     *
     * @param date
     * The date
     */
    public void setDate(Integer date) {
        this.date = date;
    }

    /**
     *
     * @return
     * The lireAussi
     */
    public List<LireAussi> getLireAussi() {
        return lireAussi;
    }

    /**
     *
     * @param lireAussi
     * The lireAussi
     */
    public void setLireAussi(List<LireAussi> lireAussi) {
        this.lireAussi = lireAussi;
    }

    /**
     *
     * @return
     * The photos
     */
    public List<Photo> getPhotos() {
        return photos;
    }

    /**
     *
     * @param photos
     * The photos
     */
    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    /**
     *
     * @return
     * The shareArticleUrl
     */
    public String getShareArticleUrl() {
        return shareArticleUrl;
    }

    /**
     *
     * @param shareArticleUrl
     * The shareArticleUrl
     */
    public void setShareArticleUrl(String shareArticleUrl) {
        this.shareArticleUrl = shareArticleUrl;
    }

    /**
     *
     * @return
     * The subtitle
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     *
     * @param subtitle
     * The subtitle
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    /**
     *
     * @return
     * The tags
     */
    public List<Tag> getTags() {
        return tags;
    }

    /**
     *
     * @param tags
     * The tags
     */
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The update
     */
    public Integer getUpdate() {
        return update;
    }

    /**
     *
     * @param update
     * The update
     */
    public void setUpdate(Integer update) {
        this.update = update;
    }

    /**
     *
     * @return
     * The videos
     */
    public List<Video> getVideos() {
        return videos;
    }

    /**
     *
     * @param videos
     * The videos
     */
    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    /**
     *
     * @return
     * The thumb
     */
    public Thumb getThumb() {
        return thumb;
    }

    /**
     *
     * @param thumb
     * The thumb
     */
    public void setThumb(Thumb thumb) {
        this.thumb = thumb;
    }

}

 class LireAussi {

    @SerializedName("articleId")
    @Expose
    private String articleId;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("title")
    @Expose
    private String title;

    /**
     *
     * @return
     * The articleId
     */
    public String getArticleId() {
        return articleId;
    }

    /**
     *
     * @param articleId
     * The articleId
     */
    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    /**
     *
     * @return
     * The type
     */
    public Integer getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The link
     */
    public String getLink() {
        return link;
    }

    /**
     *
     * @param link
     * The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

}

 class Photo {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("md5")
    @Expose
    private String md5;
    @SerializedName("legend")
    @Expose
    private String legend;
    @SerializedName("credits")
    @Expose
    private String credits;
    @SerializedName("isDefault")
    @Expose
    private Integer isDefault;
    @SerializedName("width")
    @Expose
    private String width;
    @SerializedName("height")
    @Expose
    private String height;

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The md5
     */
    public String getMd5() {
        return md5;
    }

    /**
     *
     * @param md5
     * The md5
     */
    public void setMd5(String md5) {
        this.md5 = md5;
    }

    /**
     *
     * @return
     * The legend
     */
    public String getLegend() {
        return legend;
    }

    /**
     *
     * @param legend
     * The legend
     */
    public void setLegend(String legend) {
        this.legend = legend;
    }

    /**
     *
     * @return
     * The credits
     */
    public String getCredits() {
        return credits;
    }

    /**
     *
     * @param credits
     * The credits
     */
    public void setCredits(String credits) {
        this.credits = credits;
    }

    /**
     *
     * @return
     * The isDefault
     */
    public Integer getIsDefault() {
        return isDefault;
    }

    /**
     *
     * @param isDefault
     * The isDefault
     */
    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    /**
     *
     * @return
     * The width
     */
    public String getWidth() {
        return width;
    }

    /**
     *
     * @param width
     * The width
     */
    public void setWidth(String width) {
        this.width = width;
    }

    /**
     *
     * @return
     * The height
     */
    public String getHeight() {
        return height;
    }

    /**
     *
     * @param height
     * The height
     */
    public void setHeight(String height) {
        this.height = height;
    }

}

 class Tag {

    @SerializedName("tagId")
    @Expose
    private String tagId;
    @SerializedName("name")
    @Expose
    private String name;

    /**
     *
     * @return
     * The tagId
     */
    public String getTagId() {
        return tagId;
    }

    /**
     *
     * @param tagId
     * The tagId
     */
    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

}

 class Thumb {

    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("md5")
    @Expose
    private String md5;

    /**
     *
     * @return
     * The link
     */
    public String getLink() {
        return link;
    }

    /**
     *
     * @param link
     * The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     *
     * @return
     * The md5
     */
    public String getMd5() {
        return md5;
    }

    /**
     *
     * @param md5
     * The md5
     */
    public void setMd5(String md5) {
        this.md5 = md5;
    }

}

 class Video {

    @SerializedName("md5")
    @Expose
    private String md5;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("thumb")
    @Expose
    private String thumb;
    @SerializedName("videoUrl")
    @Expose
    private String videoUrl;

    /**
     *
     * @return
     * The md5
     */
    public String getMd5() {
        return md5;
    }

    /**
     *
     * @param md5
     * The md5
     */
    public void setMd5(String md5) {
        this.md5 = md5;
    }

    /**
     *
     * @return
     * The link
     */
    public String getLink() {
        return link;
    }

    /**
     *
     * @param link
     * The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     *
     * @return
     * The type
     */
    public Integer getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The thumb
     */
    public String getThumb() {
        return thumb;
    }

    /**
     *
     * @param thumb
     * The thumb
     */
    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    /**
     *
     * @return
     * The videoUrl
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     *
     * @param videoUrl
     * The videoUrl
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

}
