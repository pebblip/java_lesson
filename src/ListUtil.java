import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListUtil {

    /**
     * ２つのリストからそれぞれの要素を組とする新しいリストを生成します。
     *
     * @param firsts  　１つ目のリスト
     * @param seconds ２つ目のリスト
     * @param <S>     　１つ目のリストの要素の型
     * @param <T>     　２つ目のリストの要素の型
     * @return Pairのリスト
     */
    public static <S, T> List<Pair<S, T>> zip(List<S> firsts, List<T> seconds) {
        int count = Math.min(firsts.size(), seconds.size());

        List<Pair<S, T>> pairs = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            pairs.add(new Pair<>(firsts.get(i), seconds.get(i)));
        }

        return pairs;
    }

    /**
     * 与えられた数の全ての約数のリストを返します。
     *
     * @param n 　対象の整数
     * @return 約数のリスト
     */
    public static List<Integer> factors(int n) {
        if (n == 0) {
            return Collections.singletonList(0);
        }

        List<Integer> factors = new ArrayList<>();

        int absN = Math.abs(n);
        boolean isPositive = n > 0;
        for (int i = 1; i <= absN; i++) {
            if (n % i == 0) {
                factors.add(isPositive ? i : -i);
            }
        }
        return factors;
    }

    /**
     * 与えられた数以下の完全数を全てリストとして返します。
     *
     * @param n 0以上の数
     * @return n以下の全ての完全数の
     */
    public static List<Integer> perfects(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("number must be positive.");
        }
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        List<Pair<Integer, List<Integer>>> numAndFactors = new ArrayList<>();
        for (Integer each : numbers) {
            numAndFactors.add(new Pair<>(each, factors(each)));
        }

        List<Pair<Integer, Integer>> numAndFactorSums = new ArrayList<>();
        for (Pair<Integer, List<Integer>> pair : numAndFactors) {
            int totalOfFactors = total(pair.second());
            numAndFactorSums.add(new Pair<>(pair.first(), totalOfFactors - pair.first()));
        }

        List<Integer> perfects = new ArrayList<>();
        for (Pair<Integer, Integer> pair : numAndFactorSums) {
            int totalOfFactors = pair.second();
            if (totalOfFactors == pair.first()) {
                perfects.add(pair.first());
            }
        }

        return perfects;
    }

    private static int total(List<Integer> nums) {
        int total = 0;
        for (Integer n : nums) {
            total = total + n;
        }
        return total;
    }

}
