package com.example.c.recyleviewdemo;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by C罗 on 2016/9/12.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHoder> {

    private List<String> mDatas;
    private LayoutInflater mLayoutInflater;
    private MyAdapter myAdapter;
    private RecyclerView mRecyclerView;
    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener=listener;
    }

    public MyAdapter(List<String> datas) {
         this.mDatas=datas;
    }

    @Override
    public ViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        mLayoutInflater=LayoutInflater.from(parent.getContext());
        View view=mLayoutInflater.inflate(R.layout.item,parent,false);

        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(ViewHoder holder, int position) {
            holder.textView.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    //局部更新
    public void addData(int position,String city){
        mDatas.add(position,city);
        notifyItemChanged(position);
    }

    //删除
    public void removeData(int position){
        mDatas.remove(position);
        notifyItemRemoved(position);
    }

    class ViewHoder extends RecyclerView.ViewHolder{

        private TextView textView;

        public ViewHoder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        listener.onClick(v,getLayoutPosition(),mDatas.get(getLayoutPosition()));
                    }
                }
            });
        }
    }

    interface OnItemClickListener{
        void onClick(View v,int position,String city);
    }
}
