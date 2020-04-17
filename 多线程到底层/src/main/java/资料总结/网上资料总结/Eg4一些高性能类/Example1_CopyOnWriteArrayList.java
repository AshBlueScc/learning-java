package 资料总结.网上资料总结.Eg4一些高性能类;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created By ChengZhen on 2019/12/23.
 * Author: Ash
 * Date: 2019/12/23
 * Time: 18:03
 * Debug the codes and debug the world!
 */

//修改时先修改到copy的副本，最后再写到内存。典型的空间换时间
//本质上还是ArrayList底层实现不同
public class Example1_CopyOnWriteArrayList {
    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
}


/**
 *
 * 1.https://www.jianshu.com/p/9b6a4d0b94ac
 * 2.https://monkeysayhi.github.io/2017/10/24/%E6%BA%90%E7%A0%81%7C%E5%B9%B6%E5%8F%91%E4%B8%80%E6%9E%9D%E8%8A%B1%E4%B9%8BCopyOnWriteArrayList/
 */

