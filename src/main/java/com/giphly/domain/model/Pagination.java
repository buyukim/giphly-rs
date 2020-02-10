package com.giphly.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * The Pagination Object contains information relating to the number of total results available as well as the number of results fetched and their relative positions.
 */
@ApiModel(description = "The Pagination Object contains information relating to the number of total results available as well as the number of results fetched and their relative positions. ")
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-02-10T13:00:18.898581-06:00[America/Chicago]")

public class Pagination   {
  @JsonProperty("count")
  private Integer count;

  @JsonProperty("offset")
  private Integer offset;

  @JsonProperty("total_count")
  private Integer totalCount;

  public Pagination count(Integer count) {
    this.count = count;
    return this;
  }

  /**
   * Total number of items returned.
   * @return count
  */
  @ApiModelProperty(example = "25", value = "Total number of items returned.")


  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public Pagination offset(Integer offset) {
    this.offset = offset;
    return this;
  }

  /**
   * Position in pagination.
   * @return offset
  */
  @ApiModelProperty(example = "75", value = "Position in pagination.")


  public Integer getOffset() {
    return offset;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  public Pagination totalCount(Integer totalCount) {
    this.totalCount = totalCount;
    return this;
  }

  /**
   * Total number of items available.
   * @return totalCount
  */
  @ApiModelProperty(example = "250", value = "Total number of items available.")


  public Integer getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pagination pagination = (Pagination) o;
    return Objects.equals(this.count, pagination.count) &&
        Objects.equals(this.offset, pagination.offset) &&
        Objects.equals(this.totalCount, pagination.totalCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, offset, totalCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pagination {\n");

    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
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

