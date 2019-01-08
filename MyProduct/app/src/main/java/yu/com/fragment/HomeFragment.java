package yu.com.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yu.com.Onclick.MyHomeOnClick;
import yu.com.databinding.FragmentHomeBinding;
import yu.com.R;

/**
 * OkHttp 学习篇
 */

public class HomeFragment extends Fragment {

    private FragmentHomeBinding fragmentHomeBinding;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentHomeBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false);
        fragmentHomeBinding.setMyHomeOnClick(new MyHomeOnClick());
        return fragmentHomeBinding.getRoot();
    }


    @Override
    public void onDetach() {
        super.onDetach();

    }

}
