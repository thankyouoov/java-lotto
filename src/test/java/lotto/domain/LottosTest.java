package lotto.domain;

import lotto.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {
    @DisplayName("여러의 로또에 대해 당첨 결과를 구한다.")
    @Test
    void many_lotto_game(){
        /*Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,10));
        Lotto lotto2 = new Lotto(List.of(1,2,3,7,8,9));*/
        List<Integer> winningNumber = new ArrayList<>(List.of(1,2,3,4,5,6));
        int bonusNumber = 10;
        /*LottoGame lottoGame1 = new LottoGame(lotto1);
        LottoGame lottoGame2 = new LottoGame(lotto2);
        Rank rank1 = Rank.getRank(lottoGame1.getMatchCount(winningNumber),lottoGame1.isBonusNumberMatch(bonusNumber));
        Rank rank2 = Rank.getRank(lottoGame2.getMatchCount(winningNumber),lottoGame2.isBonusNumberMatch(bonusNumber));
        WinningResult winningResult1 = new WinningResult(rank1);
        WinningResult winningResult2 = new WinningResult(rank2);
        WinningResults winningResults = new WinningResults(winningResult1, winningResult2);
        */
        WinningResults winningResults = new WinningResults();
        for(int i = 6; i<16; ++i){
            Lotto lotto = new Lotto(List.of(1,2,i,14,15,i+15));
            LottoGame lottoGame = new LottoGame(lotto);
            Rank rank = Rank.getRank(lottoGame.getMatchCount(winningNumber),lottoGame.isBonusNumberMatch(bonusNumber));
            WinningResult winningResult = new WinningResult(rank);
            winningResults.addWinningResult(winningResult);
        }

        OutputView.printLottoResults(winningResults);
        /*for(WinningResult winningResult: winningResults.getWinningResultLists()){
            OutputView.printLottoResult(winningResult);
        }*/
        assertThat(winningResults.countRank(Rank.FIFTH)).isEqualTo(1);





    }
}