
package poker.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "status",
    "version",
    "stack",
    "bet",
    "hole_cards"
})
public class Player {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("status")
    private String status;
    @JsonProperty("version")
    private String version;
    @JsonProperty("stack")
    private Integer stack;
    @JsonProperty("bet")
    private Integer bet;
    @JsonProperty("hole_cards")
    private List<HoleCard> holeCards = null;
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

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("stack")
    public Integer getStack() {
        return stack;
    }

    @JsonProperty("stack")
    public void setStack(Integer stack) {
        this.stack = stack;
    }

    @JsonProperty("bet")
    public Integer getBet() {
        return bet;
    }

    @JsonProperty("bet")
    public void setBet(Integer bet) {
        this.bet = bet;
    }

    @JsonProperty("hole_cards")
    public List<HoleCard> getHoleCards() {
        return holeCards;
    }

    @JsonProperty("hole_cards")
    public void setHoleCards(List<HoleCard> holeCards) {
        this.holeCards = holeCards;
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
