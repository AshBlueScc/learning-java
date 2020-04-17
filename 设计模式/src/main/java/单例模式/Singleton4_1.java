package 单例模式;

/**
 * Created By ChengZhen on 2019/12/5.
 * Author: Ash
 * Date: 2019/12/5
 * Time: 14:26
 * Debug the codes and debug the world!
 */
//枚举
//ThreadSafr
public enum Singleton4_1 {
    SINGLETON("enum is the easiest singleton pattern, but not the most readable"){
        public void testAbsMethod() {
            print();
            System.out.println("enum is ugly, but so flexible to make lots of trick");
        }
    };

    private String comment = null;

    Singleton4_1(String comment){
        this.comment = comment;
    }

    public void print(){
        System.out.println("comment=" + comment);
    }

    abstract public void testAbsMethod();

    public static Singleton4_1 getInstance(){
        return SINGLETON;
    }
}
