package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInputView {
    static Scanner scanner = new Scanner(System.in);

    public static List<Integer> inputLottoNumber(){
        return Arrays.stream(scanner.nextLine().split(",\\s*"))
                                           .map(Integer::parseInt)
                                           .collect(Collectors.toList());
    }
    public static Integer inputBonusNumber(){
        return scanner.nextInt();
    }



}
