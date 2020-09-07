package 深入理解Java虚拟机.读书版.Chapter3垃圾收集器与内存分配策略;

/**
 * @author chengzhen
 * @date 2020/9/3
 * @time 4:29 PM
 */
public class Chapter324Finalize方法演示 {

    public static Chapter324Finalize方法演示 SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("yse, i am still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        Chapter324Finalize方法演示.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new Chapter324Finalize方法演示();

        //对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        //因为Finalizer方法优先级很低，暂停0.5秒，以等待它
        Thread.sleep(500);
        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no, i am dead :(");
        }

        //下面这段代码与上面的完全相同，但是这次自救却失败了
        SAVE_HOOK = null;
        System.gc();
        //因为Finalizer方法优先级很低，暂停0.5秒，以等待它
        Thread.sleep(500);
        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no, i am dead :(");
        }
    }



}
