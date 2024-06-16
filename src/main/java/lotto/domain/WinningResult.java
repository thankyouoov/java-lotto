package lotto.domain;

public class WinningResult {

    private final Rank rank;

    public WinningResult(Rank rank) {
        this.rank = rank;
    }
    public Rank getRank() {
        return rank;
    }
}
