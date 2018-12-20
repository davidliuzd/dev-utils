package net.liuzd.util.kv;

import java.io.Serializable;

import net.liuzd.util.lang.StringUtils;

public class KV<K, V> implements Serializable, Comparable<KV<K, V>> {

    private static final long serialVersionUID = 1L;

    private K                 k;

    private V                 v;

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }

    public void set(K k, V v) {
        this.k = k;
        this.v = v;
    }

    public KV(K k, V v) {
        this(k);
        this.v = v;
    }

    public KV(K k) {
        super();
        this.k = k;
    }

    public boolean isEmptyK() {
        return null == k || StringUtils.isBlank(k.toString());
    }

    public boolean isEmptyV() {
        return null == v || StringUtils.isBlank(v.toString());
    }

    public boolean isAllEmpty() {
        return isEmptyK() && isEmptyV();
    }

    public KV() {
        super();
    }

    @Override
    public String toString() {
        return "KV [k=" + k + ", v=" + v + "]";
    }

    @Override
    public int compareTo(KV<K, V> o) {
        if (null == o) {
            return 0;
        }
        return o.toString().compareTo(toString());
    }

}
