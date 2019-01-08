package yu.com.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import yu.com.R;
import yu.com.adapter.MyFragmentAdapter;
import yu.com.fragment.BlankFragment;
import yu.com.fragment.HomeFragment;
import yu.com.fragment.MyFragment;

public class HomeActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private BottomNavigationView navigation;
    private MyFragmentAdapter myFragmentAdapter;
    private List<Fragment> fragmentList;
    private MenuItem menuItem;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewPager = findViewById(R.id.viewPager);
        navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if(menuItem!=null){
                    menuItem.setChecked(false);
                }else{
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                menuItem=navigation.getMenu().getItem(i);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        setFragment();
    }

    private void setFragment(){
        fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new BlankFragment());
        fragmentList.add(new MyFragment());
        myFragmentAdapter=new MyFragmentAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(myFragmentAdapter);

    }

}
