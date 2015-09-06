package gittest.example.com.mygittest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.greenrobot.event.EventBus;

/**
 * Created by admin on 15/pic/25.
 */
public class Fragment2 extends Fragment implements Fragment1.OnFragmentButtonClickListener{

    TextView tv_text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2,container,false);

        EventBus.getDefault().register(this);
        initUI(view);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    // Called in the same thread (default)
    public void onEvent(MessageEvent event) {
        tv_text.setText(event.message);
    }

    private void initUI(View view) {
        tv_text = (TextView) view.findViewById(R.id.tv_text);
    }

    @Override
    public void click1(String s) {
        tv_text.setText(s);
    }

    @Override
    public void click2(String s) {
        tv_text.setText(s);
    }
}
