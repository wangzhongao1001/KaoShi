package com.example.kaoshi;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kaoshi.adapter.RlvHomeAdapter;
import com.example.kaoshi.utils.MyHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements RlvHomeAdapter.onClick {
    private View view;
    private RecyclerView mRlv;
    ArrayList<DbBean>list=new ArrayList<>();
    private RlvHomeAdapter rlvHomeAdapter;
    private HomeFragment.onWeb onWeb;
    String str="https://www.baidu.com/";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_home, null);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mRlv = (RecyclerView) inflate.findViewById(R.id.rlv);
        mRlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rlvHomeAdapter = new RlvHomeAdapter(list, getActivity());
        mRlv.setAdapter(rlvHomeAdapter);
        List<DbBean> query = MyHelper.myHelper.query();
        list.addAll(query);
        rlvHomeAdapter.setDbBeans(list);
        rlvHomeAdapter.notifyDataSetChanged();
        rlvHomeAdapter.setOnClickListener(this);
    }

    @Override
    public void onClickListener(View v, int position) {
        Intent intent = new Intent(getActivity(),Main2Activity.class);
        startActivity(intent);
    }

    public interface onWeb{
        void setOnWeb(String str);
    }
    public void setOnWeb(onWeb onWeb){
        this.onWeb = onWeb;
    }
}
