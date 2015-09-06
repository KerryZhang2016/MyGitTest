package gittest.example.com.mygittest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by admin on 15/pic/25.
 */
public class Fragment1 extends Fragment implements View.OnClickListener{

    private OnFragmentButtonClickListener onFragmentButtonClickListener;
    private ThreadPoolManager threadPoolManager1;


    public Fragment1(OnFragmentButtonClickListener onFragmentButtonClickListener){
        super();
        this.onFragmentButtonClickListener = onFragmentButtonClickListener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        threadPoolManager1 = ThreadPoolManager.getInstance(0,3);
        threadPoolManager1.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1,container,false);

        initUI(view);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        threadPoolManager1.stop();
    }

    private void initUI(View view) {
        Button btn1 = (Button) view.findViewById(R.id.btn_fragment1_a);
        btn1.setOnClickListener(this);
        Button btn2 = (Button) view.findViewById(R.id.btn_fragment1_b);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_fragment1_a:
                threadPoolManager1.addAsyncTask(new ThreadPoolTask() {
                    @Override
                    public void run() {
                        super.run();
                    }
                });
                break;
            case R.id.btn_fragment1_b:
                    threadPoolManager1.stop();
//                startActivity(new Intent(getActivity(),SecondActivity.class));
                break;
        }
    }

    public interface OnFragmentButtonClickListener{
        public void click1(String s);

        public void click2(String s);
    }

}
