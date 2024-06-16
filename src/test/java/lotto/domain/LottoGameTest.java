package lotto.domain;

import lotto.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoGameTest {

    @BeforeEach
    public void setUp() {
        // 테스트 입력을 모의하기 위해 System.in을 바꿉니다.
        String simulatedInput = "1, 2, 3, 4, 8, 7";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
    }

    @DisplayName("로또 번호 일치개수를 구한다.")
    @Test
    void calculateMatchNumber(){
        Lotto lotto = new Lotto(new ArrayList<>(List.of(1,2,3,4,5,6)));
        InputView lottoInputView = new InputView();
        List<Integer> winningNumber = lottoInputView.inputLottoNumber();
        LottoGame lottoGame = new LottoGame(lotto);
        int matchCount = lottoGame.getMatchCount(winningNumber);
        System.out.println(lottoGame.getLotto().getLottoNumber());
        System.out.println(winningNumber);
        assertThat(matchCount).isEqualTo(4);
    }
}