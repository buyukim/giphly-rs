package com.giphly.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 * Image
 */
@javax.annotation.processing.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2020-02-10T13:00:18.898581-06:00[America/Chicago]"
)
public class Image {

    @JsonProperty("frames")
    private String frames;

    @JsonProperty("height")
    private String height;

    @JsonProperty("mp4")
    private String mp4;

    @JsonProperty("mp4_size")
    private String mp4Size;

    @JsonProperty("size")
    private String size;

    @JsonProperty("url")
    private String url;

    @JsonProperty("webp")
    private String webp;

    @JsonProperty("webp_size")
    private String webpSize;

    @JsonProperty("width")
    private String width;

    public Image frames(String frames) {
        this.frames = frames;
        return this;
    }

    /**
     * The number of frames in this GIF.
     * @return frames
     */
    @Schema(example = "15", description = "The number of frames in this GIF.")
    public String getFrames() {
        return frames;
    }

    public void setFrames(String frames) {
        this.frames = frames;
    }

    public Image height(String height) {
        this.height = height;
        return this;
    }

    /**
     * The height of this GIF in pixels.
     * @return height
     */
    @Schema(example = "200", description = "The height of this GIF in pixels.")
    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Image mp4(String mp4) {
        this.mp4 = mp4;
        return this;
    }

    /**
     * The URL for this GIF in .MP4 format.
     * @return mp4
     */
    @Schema(example = "https://media1.giphy.com/media/cZ7rmKfFYOvYI/giphy.mp4", description = "The URL for this GIF in .MP4 format.")
    public String getMp4() {
        return mp4;
    }

    public void setMp4(String mp4) {
        this.mp4 = mp4;
    }

    public Image mp4Size(String mp4Size) {
        this.mp4Size = mp4Size;
        return this;
    }

    /**
     * The size in bytes of the .MP4 file corresponding to this GIF.
     * @return mp4Size
     */
    @Schema(example = "25123", description = "The size in bytes of the .MP4 file corresponding to this GIF.")
    public String getMp4Size() {
        return mp4Size;
    }

    public void setMp4Size(String mp4Size) {
        this.mp4Size = mp4Size;
    }

    public Image size(String size) {
        this.size = size;
        return this;
    }

    /**
     * The size of this GIF in bytes.
     * @return size
     */
    @Schema(example = "32381", description = "The size of this GIF in bytes.")
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Image url(String url) {
        this.url = url;
        return this;
    }

    /**
     * The publicly-accessible direct URL for this GIF.
     * @return url
     */
    @Schema(
        example = "https://media1.giphy.com/media/cZ7rmKfFYOvYI/200.gif",
        description = "The publicly-accessible direct URL for this GIF."
    )
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Image webp(String webp) {
        this.webp = webp;
        return this;
    }

    /**
     * The URL for this GIF in .webp format.
     * @return webp
     */
    @Schema(example = "https://media1.giphy.com/media/cZ7rmKfFYOvYI/giphy.webp", description = "The URL for this GIF in .webp format.")
    public String getWebp() {
        return webp;
    }

    public void setWebp(String webp) {
        this.webp = webp;
    }

    public Image webpSize(String webpSize) {
        this.webpSize = webpSize;
        return this;
    }

    /**
     * The size in bytes of the .webp file corresponding to this GIF.
     * @return webpSize
     */
    @Schema(example = "12321", description = "The size in bytes of the .webp file corresponding to this GIF.")
    public String getWebpSize() {
        return webpSize;
    }

    public void setWebpSize(String webpSize) {
        this.webpSize = webpSize;
    }

    public Image width(String width) {
        this.width = width;
        return this;
    }

    /**
     * The width of this GIF in pixels.
     * @return width
     */
    @Schema(example = "320", description = "The width of this GIF in pixels.")
    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Image image = (Image) o;
        return (
            Objects.equals(this.frames, image.frames) &&
            Objects.equals(this.height, image.height) &&
            Objects.equals(this.mp4, image.mp4) &&
            Objects.equals(this.mp4Size, image.mp4Size) &&
            Objects.equals(this.size, image.size) &&
            Objects.equals(this.url, image.url) &&
            Objects.equals(this.webp, image.webp) &&
            Objects.equals(this.webpSize, image.webpSize) &&
            Objects.equals(this.width, image.width)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(frames, height, mp4, mp4Size, size, url, webp, webpSize, width);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Image {\n");

        sb.append("    frames: ").append(toIndentedString(frames)).append("\n");
        sb.append("    height: ").append(toIndentedString(height)).append("\n");
        sb.append("    mp4: ").append(toIndentedString(mp4)).append("\n");
        sb.append("    mp4Size: ").append(toIndentedString(mp4Size)).append("\n");
        sb.append("    size: ").append(toIndentedString(size)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    webp: ").append(toIndentedString(webp)).append("\n");
        sb.append("    webpSize: ").append(toIndentedString(webpSize)).append("\n");
        sb.append("    width: ").append(toIndentedString(width)).append("\n");
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
