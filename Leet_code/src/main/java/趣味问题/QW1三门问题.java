package 趣味问题;

import org.apache.commons.lang3.RandomUtils;


/**
 * @author chengzhen
 * @date 2020/5/23
 * @time 下午2:06
 */
public class QW1三门问题 {

    public static void main(String[] args) {
        //模拟一万次看看概率
        solution(10000);
    }


    public static void solution(int n){
        int noRechooseCarsNum = 0;
        int rechooseCarsNum = 0;

        for(int i = 0; i < n; i++) {
            boolean[] doors = new boolean[]{false, false, false};   //三门，false表示羊，true表示车
            doors[RandomUtils.nextInt(0,4)] = true;   //0, 1, 2其中一扇门后面有一辆车

            //参与者随机选择一扇门
            int players = RandomUtils.nextInt(0,4);

            //主持人打开一扇门，去掉一个有羊的门
            //参与者不换选到车的次数加1
            if(doors[players]){
                noRechooseCarsNum ++;
            }

            //参与者换选到车的次数加1
            if(!doors[players]){
                rechooseCarsNum ++;
            }

        }

        double ratioA = (double) noRechooseCarsNum * 100 / n;
        double ratioB = (double) rechooseCarsNum * 100 / n;
        System.out.println("参与者不换选择得到车的概率:"+ratioA+"%");
        System.out.println("参与者换选择得到车的概率:"+ratioB+"%");

    }
}
