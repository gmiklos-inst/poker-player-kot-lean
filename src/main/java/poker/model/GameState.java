
package poker.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "tournament_id",
    "game_id",
    "round",
    "bet_index",
    "small_blind",
    "current_buy_in",
    "pot",
    "minimum_raise",
    "dealer",
    "orbits",
    "in_action",
    "players",
    "community_cards"
})
public class GameState {

    @JsonProperty("tournament_id")
    private String tournamentId;
    @JsonProperty("game_id")
    private String gameId;
    @JsonProperty("round")
    private Integer round;
    @JsonProperty("bet_index")
    private Integer betIndex;
    @JsonProperty("small_blind")
    private Integer smallBlind;
    @JsonProperty("current_buy_in")
    private Integer currentBuyIn;
    @JsonProperty("pot")
    private Integer pot;
    @JsonProperty("minimum_raise")
    private Integer minimumRaise;
    @JsonProperty("dealer")
    private Integer dealer;
    @JsonProperty("orbits")
    private Integer orbits;
    @JsonProperty("in_action")
    private Integer inAction;
    @JsonProperty("players")
    private List<Player> players = null;
    @JsonProperty("community_cards")
    private List<CommunityCard> communityCards = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("tournament_id")
    public String getTournamentId() {
        return tournamentId;
    }

    @JsonProperty("tournament_id")
    public void setTournamentId(String tournamentId) {
        this.tournamentId = tournamentId;
    }

    @JsonProperty("game_id")
    public String getGameId() {
        return gameId;
    }

    @JsonProperty("game_id")
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    @JsonProperty("round")
    public Integer getRound() {
        return round;
    }

    @JsonProperty("round")
    public void setRound(Integer round) {
        this.round = round;
    }

    @JsonProperty("bet_index")
    public Integer getBetIndex() {
        return betIndex;
    }

    @JsonProperty("bet_index")
    public void setBetIndex(Integer betIndex) {
        this.betIndex = betIndex;
    }

    @JsonProperty("small_blind")
    public Integer getSmallBlind() {
        return smallBlind;
    }

    @JsonProperty("small_blind")
    public void setSmallBlind(Integer smallBlind) {
        this.smallBlind = smallBlind;
    }

    @JsonProperty("current_buy_in")
    public Integer getCurrentBuyIn() {
        return currentBuyIn;
    }

    @JsonProperty("current_buy_in")
    public void setCurrentBuyIn(Integer currentBuyIn) {
        this.currentBuyIn = currentBuyIn;
    }

    @JsonProperty("pot")
    public Integer getPot() {
        return pot;
    }

    @JsonProperty("pot")
    public void setPot(Integer pot) {
        this.pot = pot;
    }

    @JsonProperty("minimum_raise")
    public Integer getMinimumRaise() {
        return minimumRaise;
    }

    @JsonProperty("minimum_raise")
    public void setMinimumRaise(Integer minimumRaise) {
        this.minimumRaise = minimumRaise;
    }

    @JsonProperty("dealer")
    public Integer getDealer() {
        return dealer;
    }

    @JsonProperty("dealer")
    public void setDealer(Integer dealer) {
        this.dealer = dealer;
    }

    @JsonProperty("orbits")
    public Integer getOrbits() {
        return orbits;
    }

    @JsonProperty("orbits")
    public void setOrbits(Integer orbits) {
        this.orbits = orbits;
    }

    @JsonProperty("in_action")
    public Integer getInAction() {
        return inAction;
    }

    @JsonProperty("in_action")
    public void setInAction(Integer inAction) {
        this.inAction = inAction;
    }

    @JsonProperty("players")
    public List<Player> getPlayers() {
        return players;
    }

    @JsonProperty("players")
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @JsonProperty("community_cards")
    public List<CommunityCard> getCommunityCards() {
        return communityCards;
    }

    @JsonProperty("community_cards")
    public void setCommunityCards(List<CommunityCard> communityCards) {
        this.communityCards = communityCards;
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
