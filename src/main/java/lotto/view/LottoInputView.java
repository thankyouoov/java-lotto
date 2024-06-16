package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInputView {
    static Scanner scanner = new Scanner(System.in);

    public List<Integer> inputLottoNumber(){
        return Arrays.stream(scanner.nextLine().split(",\\s*"))
                                           .map(Integer::parseInt)
                                           .collect(Collectors.toList());
    }
    public Integer inputBonusNumber(){
        return scanner.nextInt();
    }



}
