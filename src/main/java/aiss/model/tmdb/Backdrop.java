
package aiss.model.tmdb;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aspect_ratio",
    "file_path",
    "height",
    "iso_639_1",
    "vote_average",
    "vote_count",
    "width"
})
public class Backdrop {

    @JsonProperty("aspect_ratio")
    private Double aspectRatio;
    @JsonProperty("file_path")
    private String filePath;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("iso_639_1")
    private Object iso6391;
    @JsonProperty("vote_average")
    private Integer voteAverage;
    @JsonProperty("vote_count")
    private Integer voteCount;
    @JsonProperty("width")
    private Integer width;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("aspect_ratio")
    public Double getAspectRatio() {
        return aspectRatio;
    }

    @JsonProperty("aspect_ratio")
    public void setAspectRatio(Double aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    @JsonProperty("file_path")
    public String getFilePath() {
        return filePath;
    }

    @JsonProperty("file_path")
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @JsonProperty("height")
    public Integer getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Integer height) {
        this.height = height;
    }

    @JsonProperty("iso_639_1")
    public Object getIso6391() {
        return iso6391;
    }

    @JsonProperty("iso_639_1")
    public void setIso6391(Object iso6391) {
        this.iso6391 = iso6391;
    }

    @JsonProperty("vote_average")
    public Integer getVoteAverage() {
        return voteAverage;
    }

    @JsonProperty("vote_average")
    public void setVoteAverage(Integer voteAverage) {
        this.voteAverage = voteAverage;
    }

    @JsonProperty("vote_count")
    public Integer getVoteCount() {
        return voteCount;
    }

    @JsonProperty("vote_count")
    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    @JsonProperty("width")
    public Integer getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(Integer width) {
        this.width = width;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
