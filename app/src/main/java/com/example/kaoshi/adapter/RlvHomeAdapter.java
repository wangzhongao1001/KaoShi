package com.example.kaoshi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kaoshi.DbBean;
import com.example.kaoshi.R;

import java.util.ArrayList;

public class RlvHomeAdapter extends RecyclerView.Adapter {
    ArrayList<DbBean>dbBeans;
    Context context;
    private onClick onClickListener;

    public RlvHomeAdapter(ArrayList<DbBean> dbBeans, Context context) {
        this.dbBeans = dbBeans;
        this.context = context;
    }

    public void setDbBeans(ArrayList<DbBean> dbBeans) {
        this.dbBeans = dbBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if (i==0){
            View inflate = inflater.inflate(R.layout.item_a, null);
            return new ViewHodler_a(inflate);
        }else{
            if (i==1){
                View inflate = inflater.inflate(R.layout.item_b, null);
                return new ViewHolder_b(inflate);
            }else{
                View inflate = inflater.inflate(R.layout.item_c, null);
                return new ViewHolder_c(inflate);
            }
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        int viewType = getItemViewType(i);
        if (viewType==0){
            ViewHodler_a vh_a= (ViewHodler_a) viewHolder;
            vh_a.tv_aa1.setText(dbBeans.get(i).getTitle());
            vh_a.tv_aa2.setText(dbBeans.get(i).getNews());
        }else{
            if (viewType==1){
                ViewHolder_b vh_b= (ViewHolder_b) viewHolder;
                vh_b.tv_bb.setText(dbBeans.get(i).getTitle());
            }else{
                ViewHolder_c vh_c= (ViewHolder_c) viewHolder;
                vh_c.tv_cc.setText(dbBeans.get(i).getTitle());
            }
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener!=null){
                    onClickListener.onClickListener(v,i);
                }
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 0;
        }else{
            if (position%2==0){
                return 2;
            }else{
                return 1;
            }
        }

    }

    @Override
    public int getItemCount() {
        return dbBeans.size();
    }
    class ViewHodler_a extends RecyclerView.ViewHolder{

        private  TextView tv_aa1;
        private  TextView tv_aa2;

        public ViewHodler_a(@NonNull View itemView) {
            super(itemView);
            tv_aa1 = itemView.findViewById(R.id.tv_aa1);
            tv_aa2 = itemView.findViewById(R.id.tv_aa2);
        }
    }
    class ViewHolder_b extends RecyclerView.ViewHolder{

        private  TextView tv_bb;

        public ViewHolder_b(@NonNull View itemView) {
            super(itemView);
            tv_bb = itemView.findViewById(R.id.tv_bb);
        }
    }
    class ViewHolder_c extends RecyclerView.ViewHolder{

        private TextView tv_cc;

        public ViewHolder_c(@NonNull View itemView) {
            super(itemView);
            tv_cc = itemView.findViewById(R.id.tv_cc);
        }
    }
    public interface onClick {
        void onClickListener(View v,int position);
    }
    public void setOnClickListener(onClick onClickListener){
        this.onClickListener = onClickListener;
    }
}
