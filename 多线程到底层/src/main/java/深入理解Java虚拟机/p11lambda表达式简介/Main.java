package 深入理解Java虚拟机.p11lambda表达式简介;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author chengzhen
 * @date 2020/5/21
 * @time 上午10:21
 */
public class Main extends JFrame{
    private JButton jb;

    public Main(){
        this.setBounds(200, 200, 400, 200);
        this.setTitle("lambda测试");

        jb = new JButton("click");

        //匿名内部类
//        jb.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("clicked");
//            }
//        });

        //lambda表达式
        jb.addActionListener(event -> System.out.println("clicked"));

        this.add(jb);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new Main();
    }
}
