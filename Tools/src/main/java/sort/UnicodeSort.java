package sort;

import com.ibm.icu.text.Collator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

/**
 * @author chengzhen
 * @date 2021/1/8
 * @time 1:37 下午
 */
public class UnicodeSort {

    public static void main(String[] args) {
        String[] arr = {
                "@1-测试",
                "#1-编辑",
                "$1-营销",
                "%1结束",
                "^2-测试",
                "&1-qt"
        };
        Comparator<String> c = (o1, o2) -> Collator.getInstance(Locale.CHINESE).compare(o1, o2);
        Arrays.sort(arr, c);
        System.out.println(Arrays.toString(arr));
    }
}
