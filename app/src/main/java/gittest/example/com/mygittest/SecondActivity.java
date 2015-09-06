package gittest.example.com.mygittest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by admin on 15/pic/28.
 */
public class SecondActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final ThreadPoolManager threadPoolManager = ThreadPoolManager.getInstance(0,3);
        threadPoolManager.start();

        Button btn = (Button) findViewById(R.id.btn_second);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                threadPoolManager.addAsyncTask(new ThreadPoolTask() {
                    @Override
                    public void run() {
                        super.run();
                    }
                });
            }
        });
    }

}
