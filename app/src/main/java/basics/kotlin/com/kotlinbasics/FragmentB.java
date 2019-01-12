package basics.kotlin.com.kotlinbasics;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

@SuppressLint("ValidFragment")
public class FragmentB extends Fragment {
    private ClickListener mItemListener;
    private View view;

    public FragmentB(ClickListener mItemListener) {
        this.mItemListener = mItemListener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragmenttwo, parent, false);
        Button btnFragB = (Button)view.findViewById(R.id.btnFrag);
        btnFragB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"click",Toast.LENGTH_SHORT).show();
                mItemListener.itemSelClick(2);
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
