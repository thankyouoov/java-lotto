package lotto.view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static List<Integer> inputLottoNumber(){
        return Arrays.stream(scanner.nextLine().split(",\\s*"))
                                    .filter(s -> !s.isEmpty())
                                    .map(Integer::parseInt)
                                    .collect(Collectors.toList());
    }
    public static Integer inputBonusNumber(){
        int bonusNumber = scanner.nextInt();
        scanner.nextLine();
        return bonusNumber;
    }
    public static int inputPurchasePrice(){
        int purchasePrice = scanner.nextInt();
        scanner.nextLine();
        return purchasePrice;
    }


}
