package com.giphly.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;

/**
 * GiphyGif
 */
@javax.annotation.processing.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2020-02-10T13:00:18.898581-06:00[America/Chicago]"
)
public class GiphyGif {

    @JsonProperty("bitly_url")
    private String bitlyUrl;

    @JsonProperty("content_url")
    private String contentUrl;

    @JsonProperty("create_datetime")
    private String createDatetime;

    @JsonProperty("embded_url")
    private String embdedUrl;

    @JsonProperty("featured_tags")
    @Valid
    private List<String> featuredTags = null;

    @JsonProperty("id")
    private String id;

    @JsonProperty("images")
    private GiphyGifImages images;

    @JsonProperty("import_datetime")
    private String importDatetime;

    @JsonProperty("rating")
    private String rating;

    @JsonProperty("slug")
    private String slug;

    @JsonProperty("source")
    private String source;

    @JsonProperty("source_post_url")
    private String sourcePostUrl;

    @JsonProperty("source_tld")
    private String sourceTld;

    @JsonProperty("tags")
    @Valid
    private List<String> tags = null;

    @JsonProperty("trending_datetime")
    private String trendingDatetime;

    /**
     * Type of the gif. By default, this is almost always gif
     */
    public enum TypeEnum {
        GIF("gif");

        private String value;

        TypeEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static TypeEnum fromValue(String value) {
            for (TypeEnum b : TypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("type")
    private TypeEnum type = TypeEnum.GIF;

    @JsonProperty("update_datetime")
    private String updateDatetime;

    @JsonProperty("url")
    private String url;

    @JsonProperty("user")
    private GiphyUser user;

    @JsonProperty("username")
    private String username;

    public GiphyGif bitlyUrl(String bitlyUrl) {
        this.bitlyUrl = bitlyUrl;
        return this;
    }

    /**
     * The unique bit.ly URL for this GIF
     * @return bitlyUrl
     */
    @Schema(example = "https://gph.is/1gsWDcL", description = "The unique bit.ly URL for this GIF")
    public String getBitlyUrl() {
        return bitlyUrl;
    }

    public void setBitlyUrl(String bitlyUrl) {
        this.bitlyUrl = bitlyUrl;
    }

    public GiphyGif contentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
        return this;
    }

    /**
     * Currently unused
     * @return contentUrl
     */
    @Schema(description = "Currently unused")
    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public GiphyGif createDatetime(String createDatetime) {
        this.createDatetime = createDatetime;
        return this;
    }

    /**
     * The date this GIF was added to the GIPHY database.
     * @return createDatetime
     */
    @Schema(description = "The date this GIF was added to the GIPHY database.")
    @Valid
    public String getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime;
    }

    public GiphyGif embdedUrl(String embdedUrl) {
        this.embdedUrl = embdedUrl;
        return this;
    }

    /**
     * A URL used for embedding this GIF
     * @return embdedUrl
     */
    @Schema(example = "https://giphy.com/embed/YsTs5ltWtEhnq", description = "A URL used for embedding this GIF")
    public String getEmbdedUrl() {
        return embdedUrl;
    }

    public void setEmbdedUrl(String embdedUrl) {
        this.embdedUrl = embdedUrl;
    }

    public GiphyGif featuredTags(List<String> featuredTags) {
        this.featuredTags = featuredTags;
        return this;
    }

    public GiphyGif addFeaturedTagsItem(String featuredTagsItem) {
        if (this.featuredTags == null) {
            this.featuredTags = new ArrayList<>();
        }
        this.featuredTags.add(featuredTagsItem);
        return this;
    }

    /**
     * An array of featured tags for this GIF (Note: Not available when using the Public Beta Key)
     * @return featuredTags
     */
    @Schema(description = "An array of featured tags for this GIF (Note: Not available when using the Public Beta Key) ")
    public List<String> getFeaturedTags() {
        return featuredTags;
    }

    public void setFeaturedTags(List<String> featuredTags) {
        this.featuredTags = featuredTags;
    }

    public GiphyGif id(String id) {
        this.id = id;
        return this;
    }

    /**
     * This GIF's unique ID
     * @return id
     */
    @Schema(example = "YsTs5ltWtEhnq", description = "This GIF's unique ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GiphyGif images(GiphyGifImages images) {
        this.images = images;
        return this;
    }

    /**
     * Get images
     * @return images
     */
    @Schema
    @Valid
    public GiphyGifImages getImages() {
        return images;
    }

    public void setImages(GiphyGifImages images) {
        this.images = images;
    }

    public GiphyGif importDatetime(String importDatetime) {
        this.importDatetime = importDatetime;
        return this;
    }

    /**
     * The creation or upload date from this GIF's source.
     * @return importDatetime
     */
    @Schema(description = "The creation or upload date from this GIF's source.")
    @Valid
    public String getImportDatetime() {
        return importDatetime;
    }

    public void setImportDatetime(String importDatetime) {
        this.importDatetime = importDatetime;
    }

    public GiphyGif rating(String rating) {
        this.rating = rating;
        return this;
    }

    /**
     * The MPAA-style rating for this content. Examples include Y, G, PG, PG-13 and R
     * @return rating
     */
    @Schema(example = "g", description = "The MPAA-style rating for this content. Examples include Y, G, PG, PG-13 and R")
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public GiphyGif slug(String slug) {
        this.slug = slug;
        return this;
    }

    /**
     * The unique slug used in this GIF's URL
     * @return slug
     */
    @Schema(example = "confused-flying-YsTs5ltWtEhnq", description = "The unique slug used in this GIF's URL")
    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public GiphyGif source(String source) {
        this.source = source;
        return this;
    }

    /**
     * The page on which this GIF was found
     * @return source
     */
    @Schema(
        example = "https://www.reddit.com/r/reactiongifs/comments/1xpyaa/superman_goes_to_hollywood/",
        description = "The page on which this GIF was found"
    )
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public GiphyGif sourcePostUrl(String sourcePostUrl) {
        this.sourcePostUrl = sourcePostUrl;
        return this;
    }

    /**
     * The URL of the webpage on which this GIF was found.
     * @return sourcePostUrl
     */
    @Schema(example = "https://cheezburger.com/5282328320", description = "The URL of the webpage on which this GIF was found.")
    public String getSourcePostUrl() {
        return sourcePostUrl;
    }

    public void setSourcePostUrl(String sourcePostUrl) {
        this.sourcePostUrl = sourcePostUrl;
    }

    public GiphyGif sourceTld(String sourceTld) {
        this.sourceTld = sourceTld;
        return this;
    }

    /**
     * The top level domain of the source URL.
     * @return sourceTld
     */
    @Schema(example = "cheezburger.com", description = "The top level domain of the source URL.")
    public String getSourceTld() {
        return sourceTld;
    }

    public void setSourceTld(String sourceTld) {
        this.sourceTld = sourceTld;
    }

    public GiphyGif tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public GiphyGif addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * An array of tags for this GIF (Note: Not available when using the Public Beta Key)
     * @return tags
     */
    @Schema(description = "An array of tags for this GIF (Note: Not available when using the Public Beta Key) ")
    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public GiphyGif trendingDatetime(String trendingDatetime) {
        this.trendingDatetime = trendingDatetime;
        return this;
    }

    /**
     * The date on which this gif was marked trending, if applicable.
     * @return trendingDatetime
     */
    @Schema(description = "The date on which this gif was marked trending, if applicable.")
    @Valid
    public String getTrendingDatetime() {
        return trendingDatetime;
    }

    public void setTrendingDatetime(String trendingDatetime) {
        this.trendingDatetime = trendingDatetime;
    }

    public GiphyGif type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * Type of the gif. By default, this is almost always gif
     * @return type
     */
    @Schema(description = "Type of the gif. By default, this is almost always gif")
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public GiphyGif updateDatetime(String updateDatetime) {
        this.updateDatetime = updateDatetime;
        return this;
    }

    /**
     * The date on which this GIF was last updated.
     * @return updateDatetime
     */
    @Schema(description = "The date on which this GIF was last updated.")
    @Valid
    public String getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(String updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public GiphyGif url(String url) {
        this.url = url;
        return this;
    }

    /**
     * The unique URL for this GIF
     * @return url
     */
    @Schema(example = "https://giphy.com/gifs/confused-flying-YsTs5ltWtEhnq", description = "The unique URL for this GIF")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public GiphyGif user(GiphyUser user) {
        this.user = user;
        return this;
    }

    /**
     * Get user
     * @return user
     */
    @Schema
    @Valid
    public GiphyUser getUser() {
        return user;
    }

    public void setUser(GiphyUser user) {
        this.user = user;
    }

    public GiphyGif username(String username) {
        this.username = username;
        return this;
    }

    /**
     * The username this GIF is attached to, if applicable
     * @return username
     */
    @Schema(example = "JoeCool4000", description = "The username this GIF is attached to, if applicable")
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
        GiphyGif giphyGif = (GiphyGif) o;
        return (
            Objects.equals(this.bitlyUrl, giphyGif.bitlyUrl) &&
            Objects.equals(this.contentUrl, giphyGif.contentUrl) &&
            Objects.equals(this.createDatetime, giphyGif.createDatetime) &&
            Objects.equals(this.embdedUrl, giphyGif.embdedUrl) &&
            Objects.equals(this.featuredTags, giphyGif.featuredTags) &&
            Objects.equals(this.id, giphyGif.id) &&
            Objects.equals(this.images, giphyGif.images) &&
            Objects.equals(this.importDatetime, giphyGif.importDatetime) &&
            Objects.equals(this.rating, giphyGif.rating) &&
            Objects.equals(this.slug, giphyGif.slug) &&
            Objects.equals(this.source, giphyGif.source) &&
            Objects.equals(this.sourcePostUrl, giphyGif.sourcePostUrl) &&
            Objects.equals(this.sourceTld, giphyGif.sourceTld) &&
            Objects.equals(this.tags, giphyGif.tags) &&
            Objects.equals(this.trendingDatetime, giphyGif.trendingDatetime) &&
            Objects.equals(this.type, giphyGif.type) &&
            Objects.equals(this.updateDatetime, giphyGif.updateDatetime) &&
            Objects.equals(this.url, giphyGif.url) &&
            Objects.equals(this.user, giphyGif.user) &&
            Objects.equals(this.username, giphyGif.username)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            bitlyUrl,
            contentUrl,
            createDatetime,
            embdedUrl,
            featuredTags,
            id,
            images,
            importDatetime,
            rating,
            slug,
            source,
            sourcePostUrl,
            sourceTld,
            tags,
            trendingDatetime,
            type,
            updateDatetime,
            url,
            user,
            username
        );
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GiphyGif {\n");

        sb.append("    bitlyUrl: ").append(toIndentedString(bitlyUrl)).append("\n");
        sb.append("    contentUrl: ").append(toIndentedString(contentUrl)).append("\n");
        sb.append("    createDatetime: ").append(toIndentedString(createDatetime)).append("\n");
        sb.append("    embdedUrl: ").append(toIndentedString(embdedUrl)).append("\n");
        sb.append("    featuredTags: ").append(toIndentedString(featuredTags)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    images: ").append(toIndentedString(images)).append("\n");
        sb.append("    importDatetime: ").append(toIndentedString(importDatetime)).append("\n");
        sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
        sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
        sb.append("    source: ").append(toIndentedString(source)).append("\n");
        sb.append("    sourcePostUrl: ").append(toIndentedString(sourcePostUrl)).append("\n");
        sb.append("    sourceTld: ").append(toIndentedString(sourceTld)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    trendingDatetime: ").append(toIndentedString(trendingDatetime)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    updateDatetime: ").append(toIndentedString(updateDatetime)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    user: ").append(toIndentedString(user)).append("\n");
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
