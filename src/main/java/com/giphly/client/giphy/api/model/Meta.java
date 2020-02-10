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
 * The Meta Object contains basic information regarding the request, whether it was successful, and the response given by the API.  Check &#x60;responses&#x60; to see a description of types of response codes the API might give you under different cirumstances.
 */
@ApiModel(description = "The Meta Object contains basic information regarding the request, whether it was successful, and the response given by the API.  Check `responses` to see a description of types of response codes the API might give you under different cirumstances. ")
@JsonPropertyOrder({
  Meta.JSON_PROPERTY_MSG,
  Meta.JSON_PROPERTY_RESPONSE_ID,
  Meta.JSON_PROPERTY_STATUS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-02-10T13:51:22.963150-06:00[America/Chicago]")
public class Meta {
  public static final String JSON_PROPERTY_MSG = "msg";
  private String msg;

  public static final String JSON_PROPERTY_RESPONSE_ID = "response_id";
  private String responseId;

  public static final String JSON_PROPERTY_STATUS = "status";
  private Integer status;


  public Meta msg(String msg) {

    this.msg = msg;
    return this;
  }

   /**
   * HTTP Response Message
   * @return msg
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "OK", value = "HTTP Response Message")
  @JsonProperty(JSON_PROPERTY_MSG)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMsg() {
    return msg;
  }


  public void setMsg(String msg) {
    this.msg = msg;
  }


  public Meta responseId(String responseId) {

    this.responseId = responseId;
    return this;
  }

   /**
   * A unique ID paired with this response from the API.
   * @return responseId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "57eea03c72381f86e05c35d2", value = "A unique ID paired with this response from the API.")
  @JsonProperty(JSON_PROPERTY_RESPONSE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getResponseId() {
    return responseId;
  }


  public void setResponseId(String responseId) {
    this.responseId = responseId;
  }


  public Meta status(Integer status) {

    this.status = status;
    return this;
  }

   /**
   * HTTP Response Code
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "200", value = "HTTP Response Code")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getStatus() {
    return status;
  }


  public void setStatus(Integer status) {
    this.status = status;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Meta meta = (Meta) o;
    return Objects.equals(this.msg, meta.msg) &&
        Objects.equals(this.responseId, meta.responseId) &&
        Objects.equals(this.status, meta.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(msg, responseId, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Meta {\n");
    sb.append("    msg: ").append(toIndentedString(msg)).append("\n");
    sb.append("    responseId: ").append(toIndentedString(responseId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
