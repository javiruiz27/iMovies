
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
    "results",
    "page",
    "total_results",
    "dates",
    "total_pages"
})
public class NowPlaying {

    @JsonProperty("results")
    private List<Result> results = null;
    @JsonProperty("page")
    private int page;
    @JsonProperty("total_results")
    private int totalResults;
    @JsonProperty("dates")
    private Dates dates;
    @JsonProperty("total_pages")
    private int totalPages;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("results")
    public List<Result> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<Result> results) {
        this.results = results;
    }

    @JsonProperty("page")
    public int getPage() {
        return page;
    }

    @JsonProperty("page")
    public void setPage(int page) {
        this.page = page;
    }

    @JsonProperty("total_results")
    public int getTotalResults() {
        return totalResults;
    }

    @JsonProperty("total_results")
    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    @JsonProperty("dates")
    public Dates getDates() {
        return dates;
    }

    @JsonProperty("dates")
    public void setDates(Dates dates) {
        this.dates = dates;
    }

    @JsonProperty("total_pages")
    public int getTotalPages() {
        return totalPages;
    }

    @JsonProperty("total_pages")
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
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
