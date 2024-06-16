package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningResult {

    private final Rank rank;

    public WinningResult(Rank rank) {
        this.rank = rank;
    }
    public Rank getRank() {
        return rank;
    }
    public List<Rank> winningRanks() {
        return Arrays.stream(Rank.values())
                .filter(i -> i.getMatchCount() >= Rank.FIFTH.getMatchCount())
                .collect(Collectors.toList());
    }
    public long winningMoney() {
        return rank.getWinningMoney();
    }
}
