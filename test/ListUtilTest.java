import com.sun.jdi.connect.Connector;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class ListUtilTest {

    @Test
    public void 二つのリストをzipできる() {
        List<?> actual = ListUtil.zip(Arrays.asList(1, 2, 3), Arrays.asList("a", "b", "c"));
        assertIterableEquals(Arrays.asList(new Pair<Integer, String>(1, "a"), new Pair<Integer, String>(2, "b"), new Pair<Integer, String>(3, "c")), actual);
    }

    @Test
    public void 空のリスト同士をzipすると結果は空のリストとなる() {
        List<?> actual = ListUtil.zip(Collections.emptyList(), Collections.emptyList());
        assertIterableEquals(Collections.emptyList(), actual);
    }

    @Test
    public void いずれか一方のリストが空の場合にzipすると結果は空のリストとなる() {
        List<?> actual1 = ListUtil.zip(Collections.emptyList(), Arrays.asList(1, 2));
        assertIterableEquals(Collections.emptyList(), actual1);

        List<?> actual2 = ListUtil.zip(Arrays.asList(1, 2), Collections.emptyList());
        assertIterableEquals(Collections.emptyList(), actual2);
    }

    @Test
    public void ゼロの約数はゼロのみ() {
        List<Integer> actual = ListUtil.factors(0);

        assertIterableEquals(Collections.singletonList(0), actual);
    }

    @ParameterizedTest
    @MethodSource("factorsProvider")
    public void 与えた数の約数のリストを取得できる(int n, List<Integer> expected) {
        List<Integer> actual = ListUtil.factors(n);

        assertIterableEquals(expected, actual);
    }

    private static Stream<Arguments> factorsProvider() {
        return Stream.of(
                Arguments.arguments(1, Collections.singletonList(1)),
                Arguments.arguments(2, Arrays.asList(1, 2)),
                Arguments.arguments(3, Arrays.asList(1, 3)),
                Arguments.arguments(10, Arrays.asList(1, 2, 5, 10)),
                Arguments.arguments(-10, Arrays.asList(-1, -2, -5, -10))
        );
    }

    @ParameterizedTest
    @MethodSource("perfectsProvider")
    public void 完全数を計算できる(int n, List<Integer> expected) {
        List<Integer> actual = ListUtil.perfects(n);

        assertIterableEquals(expected, actual);
    }

    private static Stream<Arguments> perfectsProvider() {
        return Stream.of(
                Arguments.arguments(10, Collections.singletonList(6)),
                Arguments.arguments(30, Arrays.asList(6, 28)),
                Arguments.arguments(500, Arrays.asList(6, 28, 496))
        );
    }
}