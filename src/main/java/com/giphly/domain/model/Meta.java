package com.giphly.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 * The Meta Object contains basic information regarding the request, whether it was successful, and the response given by the API.  Check &#x60;responses&#x60; to see a description of types of response codes the API might give you under different cirumstances.
 */
@Schema(
    description = "The Meta Object contains basic information regarding the request, whether it was successful, and the response given by the API.  Check `responses` to see a description of types of response codes the API might give you under different cirumstances. "
)
@javax.annotation.processing.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2020-02-10T13:00:18.898581-06:00[America/Chicago]"
)
public class Meta {

    @JsonProperty("msg")
    private String msg;

    @JsonProperty("response_id")
    private String responseId;

    @JsonProperty("status")
    private Integer status;

    public Meta msg(String msg) {
        this.msg = msg;
        return this;
    }

    /**
     * HTTP Response Message
     * @return msg
     */
    @Schema(example = "OK", description = "HTTP Response Message")
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
     */
    @Schema(example = "57eea03c72381f86e05c35d2", description = "A unique ID paired with this response from the API.")
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
     */
    @Schema(example = "200", description = "HTTP Response Code")
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
        return (
            Objects.equals(this.msg, meta.msg) &&
            Objects.equals(this.responseId, meta.responseId) &&
            Objects.equals(this.status, meta.status)
        );
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
