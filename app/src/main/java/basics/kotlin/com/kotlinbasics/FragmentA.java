package basics.kotlin.com.kotlinbasics;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

@SuppressLint("ValidFragment")
public class FragmentA extends Fragment {
    private ItemListener mItemListener;
    private View view;

    public FragmentA(ItemListener mItemListener) {
        this.mItemListener = mItemListener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragmentone, parent, false);
        Button btnFragOne = (Button) view.findViewById(R.id.btnFrag);
        btnFragOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mItemListener.clickCallBack(1);
            }
        });
        Button btnTwo=(Button)view.findViewById(R.id.btnFinsh);
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent=getActivity().getIntent();
                mIntent.putExtra("welcome","Welcome");
                getActivity().setResult(Activity.RESULT_OK,mIntent);
                getActivity().finish();

            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
}
