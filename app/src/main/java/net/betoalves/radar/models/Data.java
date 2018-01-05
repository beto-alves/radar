package net.betoalves.radar.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by beto on 04/01/18.
 */

public class Data {

    @SerializedName("publicationTitle")
    @Expose
    private String publicationTitle;
    @SerializedName("publicationAuthorName")
    @Expose
    private String publicationAuthorName;
    @SerializedName("publicationDescription")
    @Expose
    private String publicationDescription;
    @SerializedName("linkUrl")
    @Expose
    private String linkUrl;
    @SerializedName("publicationCountLike")
    @Expose
    private Integer publicationCountLike;
    @SerializedName("feed_status")
    @Expose
    private Integer feedStatus;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("author")
    @Expose
    private Author author;
    @SerializedName("community")
    @Expose
    private Community community;
    @SerializedName("authorName")
    @Expose
    private String authorName;
    @SerializedName("masterName")
    @Expose
    private String masterName;

    public String getPublicationTitle() {
        return publicationTitle;
    }

    public void setPublicationTitle(String publicationTitle) {
        this.publicationTitle = publicationTitle;
    }

    public String getPublicationAuthorName() {
        return publicationAuthorName;
    }

    public void setPublicationAuthorName(String publicationAuthorName) {
        this.publicationAuthorName = publicationAuthorName;
    }

    public String getPublicationDescription() {
        return publicationDescription;
    }

    public void setPublicationDescription(String publicationDescription) {
        this.publicationDescription = publicationDescription;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public Integer getPublicationCountLike() {
        return publicationCountLike;
    }

    public void setPublicationCountLike(Integer publicationCountLike) {
        this.publicationCountLike = publicationCountLike;
    }

    public Integer getFeedStatus() {
        return feedStatus;
    }

    public void setFeedStatus(Integer feedStatus) {
        this.feedStatus = feedStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

}