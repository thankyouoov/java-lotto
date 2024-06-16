package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningResults {

    private static final int PRICE = 1000;
    private List<WinningResult> winningResults;
    public WinningResults(List<WinningResult> winningResultLists) {
        this.winningResults = winningResultLists;
    }
    public List<WinningResult> getWinningResults() {
        return winningResults;
    }
    public WinningResults(WinningResult... winningResultLists) {
        this.winningResults = Arrays.stream(winningResultLists).collect(Collectors.toList());
    }
    public void addWinningResult(WinningResult winningResult){
        this.winningResults.add(winningResult);
    }
    public int countRank(Rank rank){
        return (int) winningResults.stream()
                .filter( winningResultList-> winningResultList.getRank().equals(rank))
                .count();
    }
    public List<Rank> winningRanks() {
        return Arrays.stream(Rank.values())
                .filter(i -> i.getMatchCount() >= Rank.FIFTH.getMatchCount())
                .collect(Collectors.toList());
    }
    public double getWinningRate(){
        Long winningMoney = winningResults.stream()
                .map(WinningResult::winningMoney)
                .reduce(Long::sum)
                .orElse(0L);

        return (double) winningMoney / (winningResults.size() * PRICE);
    }


}
