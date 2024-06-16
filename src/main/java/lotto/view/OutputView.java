package lotto.view;

import lotto.domain.*;

import java.util.stream.Collectors;

public class OutputView {
    private static final int SECOND = 2;

    public static String makeWinningStatistics(WinningResults winningResults){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("당첨 통계\n---------\n")
                     .append(winningResults.winningRanks().stream()
                                                          .map(rank -> formatRank(rank, winningResults))
                                                          .collect(Collectors.joining("\n")));
        double winningRate = winningResults.getWinningRate();
        stringBuilder.append("\n")
                     .append(String.format("총 수익률을 %.2f입니다.",winningRate));
        if (winningRate < 1) {
            stringBuilder.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        return stringBuilder.toString();

    }
    private static String formatRank(Rank rank, WinningResults winningResults){
        String secondMessage = "";
        if(SECOND == rank.getRank())
            secondMessage = ", 보너스 볼 일치";
        return String.format("%d개 일치%s (%d원)- %d개",rank.getMatchCount(),secondMessage, rank.getWinningMoney(),winningResults.countRank(rank));
    }
    public static void printLottoResults(WinningResults winningResults){
        System.out.println(makeWinningStatistics(winningResults));

    }
    public static void printLottoGameMessage(String lottoGameMessage){
        System.out.println(lottoGameMessage);

    }

    public static void printLottoNumber(Lottos lottos){
        StringBuilder lottoNumber = new StringBuilder();
        lottos.getLottos()
               .forEach(lotto -> lottoNumber.append(formatLotto(lotto))
                                            .append("\n"));
        System.out.println(lottoNumber);

    }
    private static String formatLotto(Lotto lotto) {
        return "[" + lotto.getLottoNumber().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]";
    }



}
