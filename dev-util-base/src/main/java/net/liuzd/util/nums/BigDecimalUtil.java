package net.liuzd.util.nums;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import net.liuzd.util.lang.StringUtils;

public class BigDecimalUtil {

    private static final String DECIMAL_FORMAT_TWO = "#,##0.00";

    /**
     * 向下取整用
     * @param value
     * @return
     */
    public static Double floor(Double value) {
        if (null == value) {
            return 0.00;
        }
        return Math.floor(value);
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
     * @param v1 被除数
     * @param v2 除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */

    public static Double divide(Double v1, Double v2, int scale) {
        if (null == v1) {
            v1 = 0d;
        }
        if (null == v2) {
            v2 = 0d;
        }
        if (v1 == 0d && v2 == 0d) {
            return 0d;
        }
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 由scale参数指 定精度，对double进行四舍五入的格式化
     * @param value
     * @param scale
     * @return
     */
    public static double formatRound(Double value, int scale) {
        if (null == value) {
            return 0d;
        }
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        if (Double.isInfinite(value) || Double.isNaN(value)) {
            value = 0d;
        }
        BigDecimal bigDecimal = new BigDecimal(value);
        return bigDecimal.setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * 由scale参数指 定精度，对double进行0,0.5,1范围的精确
     * @param value
     * @param scale
     * @return
     */
    public static Double cleverRound(double value, int scale) {
        Double _h = Math.floor(value);
        Double spot = value - _h;
        Double remain = 0d;
        if (spot >= 0 && spot < 0.35) {
            remain = 0d;
        } else if (spot >= 0.35 && spot < 0.7) {
            remain = 0.5d;
        } else {
            remain = 1d;
        }
        BigDecimal bigDecimal = new BigDecimal(_h + remain);

        return bigDecimal.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * @description: 将数字转换成对应的百分比
     * @return:String
     * @param value : 需要格式化成百分比的数字
     * @param scale: 设置百分比的小数位后保留的位数
     */
    public static String formatToPercentage(double value, int scale) {
        NumberFormat defaultFormat = NumberFormat.getPercentInstance();
        defaultFormat.setMinimumFractionDigits(scale);
        return defaultFormat.format(value);
    }

    /**
     * 不用科学计数法表示
     * @param money
     * @param isGroupingUsed 为空默认为：true:三位数作分隔
     * @return
     */
    public static String doubleToString(Double money, Boolean isGroupingUsed) {
        String retVal = null;
        if (null != money) {
            java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
            nf.setGroupingUsed(null == isGroupingUsed ? true : isGroupingUsed);
            retVal = nf.format(money);
        }
        return StringUtils.defaultString(retVal);
    }

    public static String doubleToString(Double money) {
        return doubleToString(money, true);
    }

    /**
     * 不使用科学计数法，保留小数点后二位
     * @param value
     * @return
     */
    public static String decimalFormat(Number value) {
        String result = null;
        if (null != value) {
            DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_FORMAT_TWO);// 格式化设置
            result = decimalFormat.format(value);
        }
        return result;
    }

    /**
     * double 相加
     * @param d1
     * @param d2
     * @return
     */
    public static double sum(Double d1, Double d2) {
        if (null == d1) {
            d1 = 0d;
        }
        if (null == d2) {
            d2 = 0d;
        }
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.add(bd2).doubleValue();
    }

    /**
     * double 相减
     * @param d1
     * @param d2
     * @return
     */
    public static double positiveSub(Double d1, Double d2) {
        if (null == d1) {
            d1 = 0d;
        }
        if (null == d2) {
            d2 = 0d;
        }
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.subtract(bd2).doubleValue() > 0d ? bd1.subtract(bd2).doubleValue() : 0d;
    }

    /**
     * @Title: sub
     * @Description: 相减
     * @param d1
     * @param d2
     * @return double
     */
    public static double sub(Double d1, Double d2) {
        if (null == d1) {
            d1 = 0d;
        }
        if (null == d2) {
            d2 = 0d;
        }
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.subtract(bd2).doubleValue();
    }

    /**
     * @Title: multiply
     * @Description: 乘法
     * @param d1
     * @param d2
     * @return double
     */
    public static double multiply(Double d1, Double d2) {
        if (null == d1) {
            d1 = 0d;
        }
        if (null == d2) {
            d2 = 0d;
        }
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.multiply(bd2).doubleValue();
    }

    /**
     * @Title: compareTo
     * @Description: 比较大小
     * @param d1
     * @param d2
     * @return int -1,表示d1小于d2，0,表示d1等于d2，1,表示d1大于d2
     */
    public static int compareTo(BigDecimal d1, BigDecimal d2) {
        if (null == d1) {
            d1 = new BigDecimal(0);
        }
        if (null == d2) {
            d2 = new BigDecimal(0);
        }
        return d1.compareTo(d2);
    }

    public static boolean eq(BigDecimal d1, BigDecimal d2) {
        return compareTo(d1, d2) == 0;
    }

    /**
     * @Title: gt
     * @Description: 判断d1是否大于d2
     * @param d1
     * @param d2
     * @return boolean
     */
    public static boolean gt(BigDecimal d1, BigDecimal d2) {
        return compareTo(d1, d2) == 1;
    }

    /**
     * @Title: gtOrEq
     * @Description: 判断d1是否大于或者等于d2
     * @param d1
     * @param d2
     * @return boolean
     */
    public static boolean gtOrEq(BigDecimal d1, BigDecimal d2) {
        return compareTo(d1, d2) != -1;
    }

    /**
     * @Title: gtOfDef
     * @Description: 判断d1是否大于0
     * @param d1
     * @return boolean
     */
    public static boolean gtOfDef(BigDecimal d1) {
        return compareTo(d1, null) == 1;
    }

    /**
     * @Title: ltOfDef
     * @Description: 判断d1是否小于0
     * @param d1
     * @return boolean
     */
    public static boolean ltOfDef(BigDecimal d1) {
        return compareTo(d1, null) == -1;
    }

    /**
     * @Title: gt
     * @Description: 判断d1是否小于d2
     * @param d1
     * @param d2
     * @return boolean
     */
    public static boolean lt(BigDecimal d1, BigDecimal d2) {
        return compareTo(d1, d2) == -1;
    }

}
