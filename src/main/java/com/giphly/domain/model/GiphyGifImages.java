package com.giphly.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.Objects;

/**
 * An object containing data for various available formats and sizes of this GIF.
 */
@ApiModel(description = "An object containing data for various available formats and sizes of this GIF.")
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-02-10T13:00:18.898581-06:00[America/Chicago]")

public class GiphyGifImages   {
  @JsonProperty("downsized")
  private Image downsized;

  @JsonProperty("downsized_large")
  private Image downsizedLarge;

  @JsonProperty("downsized_medium")
  private Image downsizedMedium;

  @JsonProperty("downsized_small")
  private Image downsizedSmall;

  @JsonProperty("downsized_still")
  private Image downsizedStill;

  @JsonProperty("fixed_height")
  private Image fixedHeight;

  @JsonProperty("fixed_height_downsampled")
  private Image fixedHeightDownsampled;

  @JsonProperty("fixed_height_small")
  private Image fixedHeightSmall;

  @JsonProperty("fixed_height_small_still")
  private Image fixedHeightSmallStill;

  @JsonProperty("fixed_height_still")
  private Image fixedHeightStill;

  @JsonProperty("fixed_width")
  private Image fixedWidth;

  @JsonProperty("fixed_width_downsampled")
  private Image fixedWidthDownsampled;

  @JsonProperty("fixed_width_small")
  private Image fixedWidthSmall;

  @JsonProperty("fixed_width_small_still")
  private Image fixedWidthSmallStill;

  @JsonProperty("fixed_width_still")
  private Image fixedWidthStill;

  @JsonProperty("looping")
  private Image looping;

  @JsonProperty("original")
  private Image original;

  @JsonProperty("original_still")
  private Image originalStill;

  @JsonProperty("preview")
  private Image preview;

  @JsonProperty("preview_gif")
  private Image previewGif;

  public GiphyGifImages downsized(Image downsized) {
    this.downsized = downsized;
    return this;
  }

  /**
   * Get downsized
   * @return downsized
  */
  @ApiModelProperty(value = "")

  @Valid

  public Image getDownsized() {
    return downsized;
  }

  public void setDownsized(Image downsized) {
    this.downsized = downsized;
  }

  public GiphyGifImages downsizedLarge(Image downsizedLarge) {
    this.downsizedLarge = downsizedLarge;
    return this;
  }

  /**
   * Get downsizedLarge
   * @return downsizedLarge
  */
  @ApiModelProperty(value = "")

  @Valid

  public Image getDownsizedLarge() {
    return downsizedLarge;
  }

  public void setDownsizedLarge(Image downsizedLarge) {
    this.downsizedLarge = downsizedLarge;
  }

  public GiphyGifImages downsizedMedium(Image downsizedMedium) {
    this.downsizedMedium = downsizedMedium;
    return this;
  }

  /**
   * Get downsizedMedium
   * @return downsizedMedium
  */
  @ApiModelProperty(value = "")

  @Valid

  public Image getDownsizedMedium() {
    return downsizedMedium;
  }

  public void setDownsizedMedium(Image downsizedMedium) {
    this.downsizedMedium = downsizedMedium;
  }

  public GiphyGifImages downsizedSmall(Image downsizedSmall) {
    this.downsizedSmall = downsizedSmall;
    return this;
  }

  /**
   * Get downsizedSmall
   * @return downsizedSmall
  */
  @ApiModelProperty(value = "")

  @Valid

  public Image getDownsizedSmall() {
    return downsizedSmall;
  }

  public void setDownsizedSmall(Image downsizedSmall) {
    this.downsizedSmall = downsizedSmall;
  }

  public GiphyGifImages downsizedStill(Image downsizedStill) {
    this.downsizedStill = downsizedStill;
    return this;
  }

  /**
   * Get downsizedStill
   * @return downsizedStill
  */
  @ApiModelProperty(value = "")

  @Valid

  public Image getDownsizedStill() {
    return downsizedStill;
  }

  public void setDownsizedStill(Image downsizedStill) {
    this.downsizedStill = downsizedStill;
  }

  public GiphyGifImages fixedHeight(Image fixedHeight) {
    this.fixedHeight = fixedHeight;
    return this;
  }

  /**
   * Get fixedHeight
   * @return fixedHeight
  */
  @ApiModelProperty(value = "")

  @Valid

  public Image getFixedHeight() {
    return fixedHeight;
  }

  public void setFixedHeight(Image fixedHeight) {
    this.fixedHeight = fixedHeight;
  }

  public GiphyGifImages fixedHeightDownsampled(Image fixedHeightDownsampled) {
    this.fixedHeightDownsampled = fixedHeightDownsampled;
    return this;
  }

  /**
   * Get fixedHeightDownsampled
   * @return fixedHeightDownsampled
  */
  @ApiModelProperty(value = "")

  @Valid

  public Image getFixedHeightDownsampled() {
    return fixedHeightDownsampled;
  }

  public void setFixedHeightDownsampled(Image fixedHeightDownsampled) {
    this.fixedHeightDownsampled = fixedHeightDownsampled;
  }

  public GiphyGifImages fixedHeightSmall(Image fixedHeightSmall) {
    this.fixedHeightSmall = fixedHeightSmall;
    return this;
  }

  /**
   * Get fixedHeightSmall
   * @return fixedHeightSmall
  */
  @ApiModelProperty(value = "")

  @Valid

  public Image getFixedHeightSmall() {
    return fixedHeightSmall;
  }

  public void setFixedHeightSmall(Image fixedHeightSmall) {
    this.fixedHeightSmall = fixedHeightSmall;
  }

  public GiphyGifImages fixedHeightSmallStill(Image fixedHeightSmallStill) {
    this.fixedHeightSmallStill = fixedHeightSmallStill;
    return this;
  }

  /**
   * Get fixedHeightSmallStill
   * @return fixedHeightSmallStill
  */
  @ApiModelProperty(value = "")

  @Valid

  public Image getFixedHeightSmallStill() {
    return fixedHeightSmallStill;
  }

  public void setFixedHeightSmallStill(Image fixedHeightSmallStill) {
    this.fixedHeightSmallStill = fixedHeightSmallStill;
  }

  public GiphyGifImages fixedHeightStill(Image fixedHeightStill) {
    this.fixedHeightStill = fixedHeightStill;
    return this;
  }

  /**
   * Get fixedHeightStill
   * @return fixedHeightStill
  */
  @ApiModelProperty(value = "")

  @Valid

  public Image getFixedHeightStill() {
    return fixedHeightStill;
  }

  public void setFixedHeightStill(Image fixedHeightStill) {
    this.fixedHeightStill = fixedHeightStill;
  }

  public GiphyGifImages fixedWidth(Image fixedWidth) {
    this.fixedWidth = fixedWidth;
    return this;
  }

  /**
   * Get fixedWidth
   * @return fixedWidth
  */
  @ApiModelProperty(value = "")

  @Valid

  public Image getFixedWidth() {
    return fixedWidth;
  }

  public void setFixedWidth(Image fixedWidth) {
    this.fixedWidth = fixedWidth;
  }

  public GiphyGifImages fixedWidthDownsampled(Image fixedWidthDownsampled) {
    this.fixedWidthDownsampled = fixedWidthDownsampled;
    return this;
  }

  /**
   * Get fixedWidthDownsampled
   * @return fixedWidthDownsampled
  */
  @ApiModelProperty(value = "")

  @Valid

  public Image getFixedWidthDownsampled() {
    return fixedWidthDownsampled;
  }

  public void setFixedWidthDownsampled(Image fixedWidthDownsampled) {
    this.fixedWidthDownsampled = fixedWidthDownsampled;
  }

  public GiphyGifImages fixedWidthSmall(Image fixedWidthSmall) {
    this.fixedWidthSmall = fixedWidthSmall;
    return this;
  }

  /**
   * Get fixedWidthSmall
   * @return fixedWidthSmall
  */
  @ApiModelProperty(value = "")

  @Valid

  public Image getFixedWidthSmall() {
    return fixedWidthSmall;
  }

  public void setFixedWidthSmall(Image fixedWidthSmall) {
    this.fixedWidthSmall = fixedWidthSmall;
  }

  public GiphyGifImages fixedWidthSmallStill(Image fixedWidthSmallStill) {
    this.fixedWidthSmallStill = fixedWidthSmallStill;
    return this;
  }

  /**
   * Get fixedWidthSmallStill
   * @return fixedWidthSmallStill
  */
  @ApiModelProperty(value = "")

  @Valid

  public Image getFixedWidthSmallStill() {
    return fixedWidthSmallStill;
  }

  public void setFixedWidthSmallStill(Image fixedWidthSmallStill) {
    this.fixedWidthSmallStill = fixedWidthSmallStill;
  }

  public GiphyGifImages fixedWidthStill(Image fixedWidthStill) {
    this.fixedWidthStill = fixedWidthStill;
    return this;
  }

  /**
   * Get fixedWidthStill
   * @return fixedWidthStill
  */
  @ApiModelProperty(value = "")

  @Valid

  public Image getFixedWidthStill() {
    return fixedWidthStill;
  }

  public void setFixedWidthStill(Image fixedWidthStill) {
    this.fixedWidthStill = fixedWidthStill;
  }

  public GiphyGifImages looping(Image looping) {
    this.looping = looping;
    return this;
  }

  /**
   * Get looping
   * @return looping
  */
  @ApiModelProperty(value = "")

  @Valid

  public Image getLooping() {
    return looping;
  }

  public void setLooping(Image looping) {
    this.looping = looping;
  }

  public GiphyGifImages original(Image original) {
    this.original = original;
    return this;
  }

  /**
   * Get original
   * @return original
  */
  @ApiModelProperty(value = "")

  @Valid

  public Image getOriginal() {
    return original;
  }

  public void setOriginal(Image original) {
    this.original = original;
  }

  public GiphyGifImages originalStill(Image originalStill) {
    this.originalStill = originalStill;
    return this;
  }

  /**
   * Get originalStill
   * @return originalStill
  */
  @ApiModelProperty(value = "")

  @Valid

  public Image getOriginalStill() {
    return originalStill;
  }

  public void setOriginalStill(Image originalStill) {
    this.originalStill = originalStill;
  }

  public GiphyGifImages preview(Image preview) {
    this.preview = preview;
    return this;
  }

  /**
   * Get preview
   * @return preview
  */
  @ApiModelProperty(value = "")

  @Valid

  public Image getPreview() {
    return preview;
  }

  public void setPreview(Image preview) {
    this.preview = preview;
  }

  public GiphyGifImages previewGif(Image previewGif) {
    this.previewGif = previewGif;
    return this;
  }

  /**
   * Get previewGif
   * @return previewGif
  */
  @ApiModelProperty(value = "")

  @Valid

  public Image getPreviewGif() {
    return previewGif;
  }

  public void setPreviewGif(Image previewGif) {
    this.previewGif = previewGif;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GiphyGifImages giphyGifImages = (GiphyGifImages) o;
    return Objects.equals(this.downsized, giphyGifImages.downsized) &&
        Objects.equals(this.downsizedLarge, giphyGifImages.downsizedLarge) &&
        Objects.equals(this.downsizedMedium, giphyGifImages.downsizedMedium) &&
        Objects.equals(this.downsizedSmall, giphyGifImages.downsizedSmall) &&
        Objects.equals(this.downsizedStill, giphyGifImages.downsizedStill) &&
        Objects.equals(this.fixedHeight, giphyGifImages.fixedHeight) &&
        Objects.equals(this.fixedHeightDownsampled, giphyGifImages.fixedHeightDownsampled) &&
        Objects.equals(this.fixedHeightSmall, giphyGifImages.fixedHeightSmall) &&
        Objects.equals(this.fixedHeightSmallStill, giphyGifImages.fixedHeightSmallStill) &&
        Objects.equals(this.fixedHeightStill, giphyGifImages.fixedHeightStill) &&
        Objects.equals(this.fixedWidth, giphyGifImages.fixedWidth) &&
        Objects.equals(this.fixedWidthDownsampled, giphyGifImages.fixedWidthDownsampled) &&
        Objects.equals(this.fixedWidthSmall, giphyGifImages.fixedWidthSmall) &&
        Objects.equals(this.fixedWidthSmallStill, giphyGifImages.fixedWidthSmallStill) &&
        Objects.equals(this.fixedWidthStill, giphyGifImages.fixedWidthStill) &&
        Objects.equals(this.looping, giphyGifImages.looping) &&
        Objects.equals(this.original, giphyGifImages.original) &&
        Objects.equals(this.originalStill, giphyGifImages.originalStill) &&
        Objects.equals(this.preview, giphyGifImages.preview) &&
        Objects.equals(this.previewGif, giphyGifImages.previewGif);
  }

  @Override
  public int hashCode() {
    return Objects.hash(downsized, downsizedLarge, downsizedMedium, downsizedSmall, downsizedStill, fixedHeight, fixedHeightDownsampled, fixedHeightSmall, fixedHeightSmallStill, fixedHeightStill, fixedWidth, fixedWidthDownsampled, fixedWidthSmall, fixedWidthSmallStill, fixedWidthStill, looping, original, originalStill, preview, previewGif);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GiphyGifImages {\n");

    sb.append("    downsized: ").append(toIndentedString(downsized)).append("\n");
    sb.append("    downsizedLarge: ").append(toIndentedString(downsizedLarge)).append("\n");
    sb.append("    downsizedMedium: ").append(toIndentedString(downsizedMedium)).append("\n");
    sb.append("    downsizedSmall: ").append(toIndentedString(downsizedSmall)).append("\n");
    sb.append("    downsizedStill: ").append(toIndentedString(downsizedStill)).append("\n");
    sb.append("    fixedHeight: ").append(toIndentedString(fixedHeight)).append("\n");
    sb.append("    fixedHeightDownsampled: ").append(toIndentedString(fixedHeightDownsampled)).append("\n");
    sb.append("    fixedHeightSmall: ").append(toIndentedString(fixedHeightSmall)).append("\n");
    sb.append("    fixedHeightSmallStill: ").append(toIndentedString(fixedHeightSmallStill)).append("\n");
    sb.append("    fixedHeightStill: ").append(toIndentedString(fixedHeightStill)).append("\n");
    sb.append("    fixedWidth: ").append(toIndentedString(fixedWidth)).append("\n");
    sb.append("    fixedWidthDownsampled: ").append(toIndentedString(fixedWidthDownsampled)).append("\n");
    sb.append("    fixedWidthSmall: ").append(toIndentedString(fixedWidthSmall)).append("\n");
    sb.append("    fixedWidthSmallStill: ").append(toIndentedString(fixedWidthSmallStill)).append("\n");
    sb.append("    fixedWidthStill: ").append(toIndentedString(fixedWidthStill)).append("\n");
    sb.append("    looping: ").append(toIndentedString(looping)).append("\n");
    sb.append("    original: ").append(toIndentedString(original)).append("\n");
    sb.append("    originalStill: ").append(toIndentedString(originalStill)).append("\n");
    sb.append("    preview: ").append(toIndentedString(preview)).append("\n");
    sb.append("    previewGif: ").append(toIndentedString(previewGif)).append("\n");
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

