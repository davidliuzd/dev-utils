package net.liuzd.util.collections;

import java.util.Collection;

public class CollectionUtils {

    public static <T> boolean isNotEmpty(Collection<T> beans) {
        return null != beans && !beans.isEmpty();
    }

}
