package lotto.view;

import lotto.domain.WinningResult;

public class OutputView {
    private static final int SECOND = 2;

    public static void printLottoResult(WinningResult winningResult){
        System.out.println("당첨통계");
        System.out.println("-------");
        String secondMessage = "";
        if(SECOND == winningResult.getRank().getRank())
            secondMessage = ", 보너스 볼 일치";

        System.out.println(String.format("%d개 일치%s (%d원)",winningResult.getRank().getMatchCount(),secondMessage, winningResult.getRank().getWinningMoney()));
    }

}
