package lotto.view;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoInputViewTest {

    @BeforeEach
    public void setUp() {
        // 테스트 입력을 모의하기 위해 System.in을 바꿉니다.
        String simulatedInput = "1, 2, 3, 4, 5, 6";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
    }

    @DisplayName("수동 로또 번호를 입력받는다.")
    @Test
    void inputManualLottoNumber(){
        LottoInputView lottoInputView = new LottoInputView();
        List<Integer> lottoNumber = new ArrayList<>(List.of(1,2,3,4,5,6));
        List<Integer> inputLottoNumber = lottoInputView.inputManualLottoNumber();
        assertThat(inputLottoNumber).isEqualTo(inputLottoNumber);

    }

}