package com.giphly.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 * The Giphy User Object contains information about the user associated with a GIF and URLs to assets such as that user&#39;s avatar image, profile, and more.
 */
@Schema(
    description = "The Giphy User Object contains information about the user associated with a GIF and URLs to assets such as that user's avatar image, profile, and more."
)
@javax.annotation.processing.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2020-02-10T13:00:18.898581-06:00[America/Chicago]"
)
public class GiphyUser {

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("banner_url")
    private String bannerUrl;

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("profile_url")
    private String profileUrl;

    @JsonProperty("twitter")
    private String twitter;

    @JsonProperty("username")
    private String username;

    public GiphyUser avatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

    /**
     * The URL for this user's avatar image.
     * @return avatarUrl
     */
    @Schema(
        example = "https://media1.giphy.com/avatars/election2016/XwYrZi5H87o6.gif",
        description = "The URL for this user's avatar image."
    )
    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public GiphyUser bannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
        return this;
    }

    /**
     * The URL for the banner image that appears atop this user's profile page.
     * @return bannerUrl
     */
    @Schema(
        example = "https://media4.giphy.com/avatars/cheezburger/XkuejOhoGLE6.jpg",
        description = "The URL for the banner image that appears atop this user's profile page."
    )
    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public GiphyUser displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The display name associated with this user (contains formatting the base username might not).
     * @return displayName
     */
    @Schema(
        example = "JoeCool4000",
        description = "The display name associated with this user (contains formatting the base username might not)."
    )
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public GiphyUser profileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
        return this;
    }

    /**
     * The URL for this user's profile.
     * @return profileUrl
     */
    @Schema(example = "https://giphy.com/cheezburger/", description = "The URL for this user's profile.")
    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public GiphyUser twitter(String twitter) {
        this.twitter = twitter;
        return this;
    }

    /**
     * The Twitter username associated with this user, if applicable.
     * @return twitter
     */
    @Schema(example = "@joecool4000", description = "The Twitter username associated with this user, if applicable.")
    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public GiphyUser username(String username) {
        this.username = username;
        return this;
    }

    /**
     * The username associated with this user.
     * @return username
     */
    @Schema(example = "joecool4000", description = "The username associated with this user.")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GiphyUser giphyUser = (GiphyUser) o;
        return (
            Objects.equals(this.avatarUrl, giphyUser.avatarUrl) &&
            Objects.equals(this.bannerUrl, giphyUser.bannerUrl) &&
            Objects.equals(this.displayName, giphyUser.displayName) &&
            Objects.equals(this.profileUrl, giphyUser.profileUrl) &&
            Objects.equals(this.twitter, giphyUser.twitter) &&
            Objects.equals(this.username, giphyUser.username)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(avatarUrl, bannerUrl, displayName, profileUrl, twitter, username);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GiphyUser {\n");

        sb.append("    avatarUrl: ").append(toIndentedString(avatarUrl)).append("\n");
        sb.append("    bannerUrl: ").append(toIndentedString(bannerUrl)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    profileUrl: ").append(toIndentedString(profileUrl)).append("\n");
        sb.append("    twitter: ").append(toIndentedString(twitter)).append("\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
