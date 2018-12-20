package net.liuzd.util.lambda;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import net.liuzd.util.collections.CollectionUtils;

public class LambdaUtils {

    public static <T, R> List<R> toList(List<T> beans, Function<? super T, ? extends R> mapper) {
        if (CollectionUtils.isNotEmpty(beans)) {
            return beans.stream().map(mapper).collect(Collectors.toList());
        }
        return null;
    }

    public static <T, K, V> Map<K, V> toSimpMap(List<T> beans, Function<? super T, ? extends K> keyMapper,
            Function<? super T, ? extends V> valMapper) {
        if (CollectionUtils.isNotEmpty(beans)) {
            return beans.stream().collect(Collectors.toMap(keyMapper, valMapper));
        }
        return null;
    }

    public static <T, R> Map<R, T> toMap(List<T> beans, Function<? super T, ? extends R> keyMapper) {
        if (CollectionUtils.isNotEmpty(beans)) {
            return beans.stream().collect(Collectors.toMap(keyMapper, Function.identity()));
        }
        return null;
    }

    public static <T, R> Map<R, List<T>> toGroupMap(List<T> beans, Function<? super T, ? extends R> keyMapper) {
        if (CollectionUtils.isNotEmpty(beans)) {
            return beans.stream().collect(Collectors.groupingBy(keyMapper));
        }
        return null;
    }
}
