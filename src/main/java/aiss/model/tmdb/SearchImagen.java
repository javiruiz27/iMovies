
package aiss.model.tmdb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "backdrops",
    "posters"
})
public class SearchImagen {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("backdrops")
    private List<Backdrop> backdrops = null;
    @JsonProperty("posters")
    private List<Poster> posters = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("backdrops")
    public List<Backdrop> getBackdrops() {
        return backdrops;
    }

    @JsonProperty("backdrops")
    public void setBackdrops(List<Backdrop> backdrops) {
        this.backdrops = backdrops;
    }

    @JsonProperty("posters")
    public List<Poster> getPosters() {
        return posters;
    }

    @JsonProperty("posters")
    public void setPosters(List<Poster> posters) {
        this.posters = posters;
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
