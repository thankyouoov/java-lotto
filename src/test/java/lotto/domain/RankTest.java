package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RankTest {


    @DisplayName("당첨등수가 5등이다.")
    @Test
    void RANK_FIFTH(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> winningNumber = new ArrayList<>(List.of(1,2,3,9,10,11));
        int bonusNumber = 45;
        LottoGame lottoGame = new LottoGame(lotto);
        lottoGame.getMatchCount(winningNumber);

        Rank rank = Rank.getRank(lottoGame.getMatchCount(winningNumber),lotto.isBonusNumberMatch(bonusNumber));

        assertThat(rank.getRank()).isEqualTo(5);
    }

    @DisplayName("당첨등수가 4등이다.")
    @Test
    void RANK_FOURTH(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> winningNumber = new ArrayList<>(List.of(1,2,3,4,10,11));
        int bonusNumber = 45;
        LottoGame lottoGame = new LottoGame(lotto);
        lottoGame.getMatchCount(winningNumber);

        Rank rank = Rank.getRank(lottoGame.getMatchCount(winningNumber),lotto.isBonusNumberMatch(bonusNumber));

        assertThat(rank.getRank()).isEqualTo(4);
    }

    @DisplayName("당첨등수가 3등이다.")
    @Test
    void RANK_THIRD(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> winningNumber = new ArrayList<>(List.of(1,2,3,4,5,11));
        int bonusNumber = 45;
        LottoGame lottoGame = new LottoGame(lotto);
        lottoGame.getMatchCount(winningNumber);

        Rank rank = Rank.getRank(lottoGame.getMatchCount(winningNumber),lotto.isBonusNumberMatch(bonusNumber));

        assertThat(rank.getRank()).isEqualTo(3);
    }

    @DisplayName("당첨등수가 2등이다.")
    @Test
    void RANK_SECOND(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,45));
        List<Integer> winningNumber = new ArrayList<>(List.of(1,2,3,4,5,11));
        int bonusNumber = 45;
        LottoGame lottoGame = new LottoGame(lotto);
        lottoGame.getMatchCount(winningNumber);

        Rank rank = Rank.getRank(lottoGame.getMatchCount(winningNumber),lotto.isBonusNumberMatch(bonusNumber));

        assertThat(rank.getRank()).isEqualTo(2);
    }

    @DisplayName("당첨등수가 1등이다.")
    @Test
    void RANK_FIRST(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,11));
        List<Integer> winningNumber = new ArrayList<>(List.of(1,2,3,4,5,11));
        int bonusNumber = 45;
        LottoGame lottoGame = new LottoGame(lotto);
        lottoGame.getMatchCount(winningNumber);

        Rank rank = Rank.getRank(lottoGame.getMatchCount(winningNumber),lotto.isBonusNumberMatch(bonusNumber));

        assertThat(rank.getRank()).isEqualTo(1);
    }

}