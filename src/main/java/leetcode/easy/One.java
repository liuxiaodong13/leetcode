package leetcode.easy;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

public class One {
    public static void main(String[] args) {
//        System.out.println(romanToInt("III"));
//        System.out.println(romanToInt("IV"));
//        System.out.println(romanToInt("IX"));
//        System.out.println(romanToInt("LVIII"));
//        System.out.println(romanToInt("MCMXCIV"));

        //System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"c", "acc", "ccc"}));

    }

    public static int romanToInt(String s) {
        // 构建罗马数字序列
        char[] romanNums = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] nums = new int[]{1, 5, 10, 50, 100, 500, 1000};
        int sum = 0;
        char[] chars = s.toCharArray();
        int romanNum = 0;
        int lastNum = 0;
        for (int i = 0; i < chars.length; i++) {
            // 查找罗马数字
            for (int j = 0; j < romanNums.length; j++) {
                if (romanNums[j] == chars[i]) {
                    romanNum = nums[j];
                    break;
                }
            }
            // 和上次的值比较大小
            if (i == 0 || romanNum <= lastNum) {
                sum += romanNum;
            } else {
                // 相减
                sum += Math.abs(lastNum - romanNum);
                // 减去多加的值
                sum -= lastNum;
            }
            lastNum = romanNum;
        }
        return sum;
    }

    /**
     * 14. Longest Common Prefix
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        // 以第一个为样本
        if (strs == null || strs.length == 0)
            return "";
        String sample = strs[0];
        for (String str : strs) {
            while (!str.startsWith(sample)) {
                if (sample.length() == 1) {
                    return "";
                }
                sample = sample.substring(0, sample.length() - 1);
            }
        }
        return sample;
    }
}
