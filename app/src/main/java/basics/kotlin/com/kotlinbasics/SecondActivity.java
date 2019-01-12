package basics.kotlin.com.kotlinbasics;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity implements ItemListener,ClickListener {

    private Button btnFrag;
    private FragmentA mFragmentA;
    private FragmentB mFragmentB;
    private FragmentManager mFragmentManager;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mFragmentA = new FragmentA(SecondActivity.this);
        //mFragmentA.setmItemListener(SecondActivity.class);
        mFragmentManager = getFragmentManager();
        ft = mFragmentManager.beginTransaction();
        ft.add(R.id.fragment, mFragmentA);
        ft.commit();
    }

    @Override
    public void clickCallBack(int type) {

        if (type == 1) {
            mFragmentB=new FragmentB(SecondActivity.this);
           // mFragmentManager = getFragmentManager();
            ft = mFragmentManager.beginTransaction();
            ft.replace(R.id.fragment, mFragmentB);
            ft.addToBackStack("FragmentOne");
            ft.commit();
            Log.i("SecondActivity", "FragmentOne");
        } else if (type == 2) {

            }


    }

    @Override
    public void itemSelClick(int type) {
        mFragmentManager.popBackStack();
    }
}
