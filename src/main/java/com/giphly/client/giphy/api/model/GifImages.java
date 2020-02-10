/*
 * Giphy
 * Giphy API
 *
 * The version of the OpenAPI document: 1.0
 * Contact: support@giphy.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.giphly.client.giphy.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * An object containing data for various available formats and sizes of this GIF.
 */
@ApiModel(description = "An object containing data for various available formats and sizes of this GIF.")
@JsonPropertyOrder({
  GifImages.JSON_PROPERTY_DOWNSIZED,
  GifImages.JSON_PROPERTY_DOWNSIZED_LARGE,
  GifImages.JSON_PROPERTY_DOWNSIZED_MEDIUM,
  GifImages.JSON_PROPERTY_DOWNSIZED_SMALL,
  GifImages.JSON_PROPERTY_DOWNSIZED_STILL,
  GifImages.JSON_PROPERTY_FIXED_HEIGHT,
  GifImages.JSON_PROPERTY_FIXED_HEIGHT_DOWNSAMPLED,
  GifImages.JSON_PROPERTY_FIXED_HEIGHT_SMALL,
  GifImages.JSON_PROPERTY_FIXED_HEIGHT_SMALL_STILL,
  GifImages.JSON_PROPERTY_FIXED_HEIGHT_STILL,
  GifImages.JSON_PROPERTY_FIXED_WIDTH,
  GifImages.JSON_PROPERTY_FIXED_WIDTH_DOWNSAMPLED,
  GifImages.JSON_PROPERTY_FIXED_WIDTH_SMALL,
  GifImages.JSON_PROPERTY_FIXED_WIDTH_SMALL_STILL,
  GifImages.JSON_PROPERTY_FIXED_WIDTH_STILL,
  GifImages.JSON_PROPERTY_LOOPING,
  GifImages.JSON_PROPERTY_ORIGINAL,
  GifImages.JSON_PROPERTY_ORIGINAL_STILL,
  GifImages.JSON_PROPERTY_PREVIEW,
  GifImages.JSON_PROPERTY_PREVIEW_GIF
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-02-10T13:51:22.963150-06:00[America/Chicago]")
public class GifImages {
  public static final String JSON_PROPERTY_DOWNSIZED = "downsized";
  private Image downsized;

  public static final String JSON_PROPERTY_DOWNSIZED_LARGE = "downsized_large";
  private Image downsizedLarge;

  public static final String JSON_PROPERTY_DOWNSIZED_MEDIUM = "downsized_medium";
  private Image downsizedMedium;

  public static final String JSON_PROPERTY_DOWNSIZED_SMALL = "downsized_small";
  private Image downsizedSmall;

  public static final String JSON_PROPERTY_DOWNSIZED_STILL = "downsized_still";
  private Image downsizedStill;

  public static final String JSON_PROPERTY_FIXED_HEIGHT = "fixed_height";
  private Image fixedHeight;

  public static final String JSON_PROPERTY_FIXED_HEIGHT_DOWNSAMPLED = "fixed_height_downsampled";
  private Image fixedHeightDownsampled;

  public static final String JSON_PROPERTY_FIXED_HEIGHT_SMALL = "fixed_height_small";
  private Image fixedHeightSmall;

  public static final String JSON_PROPERTY_FIXED_HEIGHT_SMALL_STILL = "fixed_height_small_still";
  private Image fixedHeightSmallStill;

  public static final String JSON_PROPERTY_FIXED_HEIGHT_STILL = "fixed_height_still";
  private Image fixedHeightStill;

  public static final String JSON_PROPERTY_FIXED_WIDTH = "fixed_width";
  private Image fixedWidth;

  public static final String JSON_PROPERTY_FIXED_WIDTH_DOWNSAMPLED = "fixed_width_downsampled";
  private Image fixedWidthDownsampled;

  public static final String JSON_PROPERTY_FIXED_WIDTH_SMALL = "fixed_width_small";
  private Image fixedWidthSmall;

  public static final String JSON_PROPERTY_FIXED_WIDTH_SMALL_STILL = "fixed_width_small_still";
  private Image fixedWidthSmallStill;

  public static final String JSON_PROPERTY_FIXED_WIDTH_STILL = "fixed_width_still";
  private Image fixedWidthStill;

  public static final String JSON_PROPERTY_LOOPING = "looping";
  private Image looping;

  public static final String JSON_PROPERTY_ORIGINAL = "original";
  private Image original;

  public static final String JSON_PROPERTY_ORIGINAL_STILL = "original_still";
  private Image originalStill;

  public static final String JSON_PROPERTY_PREVIEW = "preview";
  private Image preview;

  public static final String JSON_PROPERTY_PREVIEW_GIF = "preview_gif";
  private Image previewGif;


  public GifImages downsized(Image downsized) {

    this.downsized = downsized;
    return this;
  }

   /**
   * Get downsized
   * @return downsized
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DOWNSIZED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Image getDownsized() {
    return downsized;
  }


  public void setDownsized(Image downsized) {
    this.downsized = downsized;
  }


  public GifImages downsizedLarge(Image downsizedLarge) {

    this.downsizedLarge = downsizedLarge;
    return this;
  }

   /**
   * Get downsizedLarge
   * @return downsizedLarge
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DOWNSIZED_LARGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Image getDownsizedLarge() {
    return downsizedLarge;
  }


  public void setDownsizedLarge(Image downsizedLarge) {
    this.downsizedLarge = downsizedLarge;
  }


  public GifImages downsizedMedium(Image downsizedMedium) {

    this.downsizedMedium = downsizedMedium;
    return this;
  }

   /**
   * Get downsizedMedium
   * @return downsizedMedium
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DOWNSIZED_MEDIUM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Image getDownsizedMedium() {
    return downsizedMedium;
  }


  public void setDownsizedMedium(Image downsizedMedium) {
    this.downsizedMedium = downsizedMedium;
  }


  public GifImages downsizedSmall(Image downsizedSmall) {

    this.downsizedSmall = downsizedSmall;
    return this;
  }

   /**
   * Get downsizedSmall
   * @return downsizedSmall
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DOWNSIZED_SMALL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Image getDownsizedSmall() {
    return downsizedSmall;
  }


  public void setDownsizedSmall(Image downsizedSmall) {
    this.downsizedSmall = downsizedSmall;
  }


  public GifImages downsizedStill(Image downsizedStill) {

    this.downsizedStill = downsizedStill;
    return this;
  }

   /**
   * Get downsizedStill
   * @return downsizedStill
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DOWNSIZED_STILL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Image getDownsizedStill() {
    return downsizedStill;
  }


  public void setDownsizedStill(Image downsizedStill) {
    this.downsizedStill = downsizedStill;
  }


  public GifImages fixedHeight(Image fixedHeight) {

    this.fixedHeight = fixedHeight;
    return this;
  }

   /**
   * Get fixedHeight
   * @return fixedHeight
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FIXED_HEIGHT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Image getFixedHeight() {
    return fixedHeight;
  }


  public void setFixedHeight(Image fixedHeight) {
    this.fixedHeight = fixedHeight;
  }


  public GifImages fixedHeightDownsampled(Image fixedHeightDownsampled) {

    this.fixedHeightDownsampled = fixedHeightDownsampled;
    return this;
  }

   /**
   * Get fixedHeightDownsampled
   * @return fixedHeightDownsampled
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FIXED_HEIGHT_DOWNSAMPLED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Image getFixedHeightDownsampled() {
    return fixedHeightDownsampled;
  }


  public void setFixedHeightDownsampled(Image fixedHeightDownsampled) {
    this.fixedHeightDownsampled = fixedHeightDownsampled;
  }


  public GifImages fixedHeightSmall(Image fixedHeightSmall) {

    this.fixedHeightSmall = fixedHeightSmall;
    return this;
  }

   /**
   * Get fixedHeightSmall
   * @return fixedHeightSmall
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FIXED_HEIGHT_SMALL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Image getFixedHeightSmall() {
    return fixedHeightSmall;
  }


  public void setFixedHeightSmall(Image fixedHeightSmall) {
    this.fixedHeightSmall = fixedHeightSmall;
  }


  public GifImages fixedHeightSmallStill(Image fixedHeightSmallStill) {

    this.fixedHeightSmallStill = fixedHeightSmallStill;
    return this;
  }

   /**
   * Get fixedHeightSmallStill
   * @return fixedHeightSmallStill
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FIXED_HEIGHT_SMALL_STILL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Image getFixedHeightSmallStill() {
    return fixedHeightSmallStill;
  }


  public void setFixedHeightSmallStill(Image fixedHeightSmallStill) {
    this.fixedHeightSmallStill = fixedHeightSmallStill;
  }


  public GifImages fixedHeightStill(Image fixedHeightStill) {

    this.fixedHeightStill = fixedHeightStill;
    return this;
  }

   /**
   * Get fixedHeightStill
   * @return fixedHeightStill
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FIXED_HEIGHT_STILL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Image getFixedHeightStill() {
    return fixedHeightStill;
  }


  public void setFixedHeightStill(Image fixedHeightStill) {
    this.fixedHeightStill = fixedHeightStill;
  }


  public GifImages fixedWidth(Image fixedWidth) {

    this.fixedWidth = fixedWidth;
    return this;
  }

   /**
   * Get fixedWidth
   * @return fixedWidth
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FIXED_WIDTH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Image getFixedWidth() {
    return fixedWidth;
  }


  public void setFixedWidth(Image fixedWidth) {
    this.fixedWidth = fixedWidth;
  }


  public GifImages fixedWidthDownsampled(Image fixedWidthDownsampled) {

    this.fixedWidthDownsampled = fixedWidthDownsampled;
    return this;
  }

   /**
   * Get fixedWidthDownsampled
   * @return fixedWidthDownsampled
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FIXED_WIDTH_DOWNSAMPLED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Image getFixedWidthDownsampled() {
    return fixedWidthDownsampled;
  }


  public void setFixedWidthDownsampled(Image fixedWidthDownsampled) {
    this.fixedWidthDownsampled = fixedWidthDownsampled;
  }


  public GifImages fixedWidthSmall(Image fixedWidthSmall) {

    this.fixedWidthSmall = fixedWidthSmall;
    return this;
  }

   /**
   * Get fixedWidthSmall
   * @return fixedWidthSmall
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FIXED_WIDTH_SMALL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Image getFixedWidthSmall() {
    return fixedWidthSmall;
  }


  public void setFixedWidthSmall(Image fixedWidthSmall) {
    this.fixedWidthSmall = fixedWidthSmall;
  }


  public GifImages fixedWidthSmallStill(Image fixedWidthSmallStill) {

    this.fixedWidthSmallStill = fixedWidthSmallStill;
    return this;
  }

   /**
   * Get fixedWidthSmallStill
   * @return fixedWidthSmallStill
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FIXED_WIDTH_SMALL_STILL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Image getFixedWidthSmallStill() {
    return fixedWidthSmallStill;
  }


  public void setFixedWidthSmallStill(Image fixedWidthSmallStill) {
    this.fixedWidthSmallStill = fixedWidthSmallStill;
  }


  public GifImages fixedWidthStill(Image fixedWidthStill) {

    this.fixedWidthStill = fixedWidthStill;
    return this;
  }

   /**
   * Get fixedWidthStill
   * @return fixedWidthStill
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FIXED_WIDTH_STILL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Image getFixedWidthStill() {
    return fixedWidthStill;
  }


  public void setFixedWidthStill(Image fixedWidthStill) {
    this.fixedWidthStill = fixedWidthStill;
  }


  public GifImages looping(Image looping) {

    this.looping = looping;
    return this;
  }

   /**
   * Get looping
   * @return looping
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_LOOPING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Image getLooping() {
    return looping;
  }


  public void setLooping(Image looping) {
    this.looping = looping;
  }


  public GifImages original(Image original) {

    this.original = original;
    return this;
  }

   /**
   * Get original
   * @return original
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ORIGINAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Image getOriginal() {
    return original;
  }


  public void setOriginal(Image original) {
    this.original = original;
  }


  public GifImages originalStill(Image originalStill) {

    this.originalStill = originalStill;
    return this;
  }

   /**
   * Get originalStill
   * @return originalStill
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ORIGINAL_STILL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Image getOriginalStill() {
    return originalStill;
  }


  public void setOriginalStill(Image originalStill) {
    this.originalStill = originalStill;
  }


  public GifImages preview(Image preview) {

    this.preview = preview;
    return this;
  }

   /**
   * Get preview
   * @return preview
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PREVIEW)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Image getPreview() {
    return preview;
  }


  public void setPreview(Image preview) {
    this.preview = preview;
  }


  public GifImages previewGif(Image previewGif) {

    this.previewGif = previewGif;
    return this;
  }

   /**
   * Get previewGif
   * @return previewGif
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PREVIEW_GIF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

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
    GifImages gifImages = (GifImages) o;
    return Objects.equals(this.downsized, gifImages.downsized) &&
        Objects.equals(this.downsizedLarge, gifImages.downsizedLarge) &&
        Objects.equals(this.downsizedMedium, gifImages.downsizedMedium) &&
        Objects.equals(this.downsizedSmall, gifImages.downsizedSmall) &&
        Objects.equals(this.downsizedStill, gifImages.downsizedStill) &&
        Objects.equals(this.fixedHeight, gifImages.fixedHeight) &&
        Objects.equals(this.fixedHeightDownsampled, gifImages.fixedHeightDownsampled) &&
        Objects.equals(this.fixedHeightSmall, gifImages.fixedHeightSmall) &&
        Objects.equals(this.fixedHeightSmallStill, gifImages.fixedHeightSmallStill) &&
        Objects.equals(this.fixedHeightStill, gifImages.fixedHeightStill) &&
        Objects.equals(this.fixedWidth, gifImages.fixedWidth) &&
        Objects.equals(this.fixedWidthDownsampled, gifImages.fixedWidthDownsampled) &&
        Objects.equals(this.fixedWidthSmall, gifImages.fixedWidthSmall) &&
        Objects.equals(this.fixedWidthSmallStill, gifImages.fixedWidthSmallStill) &&
        Objects.equals(this.fixedWidthStill, gifImages.fixedWidthStill) &&
        Objects.equals(this.looping, gifImages.looping) &&
        Objects.equals(this.original, gifImages.original) &&
        Objects.equals(this.originalStill, gifImages.originalStill) &&
        Objects.equals(this.preview, gifImages.preview) &&
        Objects.equals(this.previewGif, gifImages.previewGif);
  }

  @Override
  public int hashCode() {
    return Objects.hash(downsized, downsizedLarge, downsizedMedium, downsizedSmall, downsizedStill, fixedHeight, fixedHeightDownsampled, fixedHeightSmall, fixedHeightSmallStill, fixedHeightStill, fixedWidth, fixedWidthDownsampled, fixedWidthSmall, fixedWidthSmallStill, fixedWidthStill, looping, original, originalStill, preview, previewGif);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GifImages {\n");
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
