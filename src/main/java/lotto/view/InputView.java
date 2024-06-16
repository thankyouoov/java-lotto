package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static Scanner scanner = new Scanner(System.in);

    public static List<Integer> inputLottoNumber(){

        List<Integer> lottoNumber = Arrays.stream(scanner.nextLine().split(",\\s*"))
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return lottoNumber;
    }
    public static Integer inputInteger(){
        int value = scanner.nextInt();
        clearInputBuffer();
        return value;
    }

    public static void clearInputBuffer() {
        scanner.nextLine();
    }



}
