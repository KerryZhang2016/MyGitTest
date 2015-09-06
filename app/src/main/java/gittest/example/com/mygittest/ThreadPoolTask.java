package gittest.example.com.mygittest;

import android.util.Log;

/**
 * Created by Kerry on 15/pic/28.
 */
public abstract class ThreadPoolTask implements Runnable {


    public ThreadPoolTask() {
    }

    @Override
    public void run() {
        Log.d("ThreadPoolTest", "任务开始执行。当前线程ID" + Thread.currentThread().getId());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d("ThreadPoolTest","任务执行结束");
    }

}