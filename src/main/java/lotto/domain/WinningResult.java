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
    public long winningMoney() {
        return rank.getWinningMoney();
    }
}
