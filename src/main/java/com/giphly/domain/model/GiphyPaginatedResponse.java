package com.giphly.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;

/**
 * InlineResponse200
 */
@javax.annotation.processing.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2020-02-10T13:00:18.898581-06:00[America/Chicago]"
)
public class GiphyPaginatedResponse {

    @JsonProperty("data")
    @Valid
    private List<GiphyGif> data = null;

    @JsonProperty("meta")
    private Meta meta;

    @JsonProperty("pagination")
    private Pagination pagination;

    public GiphyPaginatedResponse data(List<GiphyGif> data) {
        this.data = data;
        return this;
    }

    public GiphyPaginatedResponse addDataItem(GiphyGif dataItem) {
        if (this.data == null) {
            this.data = new ArrayList<>();
        }
        this.data.add(dataItem);
        return this;
    }

    /**
     * Get data
     * @return data
     */
    @Schema
    @Valid
    public List<GiphyGif> getData() {
        return data;
    }

    public void setData(List<GiphyGif> data) {
        this.data = data;
    }

    public GiphyPaginatedResponse meta(Meta meta) {
        this.meta = meta;
        return this;
    }

    /**
     * Get meta
     * @return meta
     */
    @Schema
    @Valid
    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public GiphyPaginatedResponse pagination(Pagination pagination) {
        this.pagination = pagination;
        return this;
    }

    /**
     * Get pagination
     * @return pagination
     */
    @Schema
    @Valid
    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GiphyPaginatedResponse giphyPaginatedResponse = (GiphyPaginatedResponse) o;
        return (
            Objects.equals(this.data, giphyPaginatedResponse.data) &&
            Objects.equals(this.meta, giphyPaginatedResponse.meta) &&
            Objects.equals(this.pagination, giphyPaginatedResponse.pagination)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, meta, pagination);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InlineResponse200 {\n");

        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
        sb.append("    pagination: ").append(toIndentedString(pagination)).append("\n");
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
