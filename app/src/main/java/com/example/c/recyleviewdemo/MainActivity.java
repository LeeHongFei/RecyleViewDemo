package com.example.c.recyleviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> datas=new ArrayList<>();
    private LayoutInflater mLayoutInflater;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();
        mRecyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        myAdapter=new MyAdapter(datas);
        mRecyclerView.setAdapter(myAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
       mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
       myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
           @Override
           public void onClick(View v, int position, String city) {
               Toast.makeText(MainActivity.this,"city:"+city+"position:"+position,Toast.LENGTH_SHORT).show();
           }
       });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.id_action_add:
                myAdapter.addData(0,"new city");
            break;
            case R.id.id_action_delete:
                myAdapter.removeData(1);
                break;
            case R.id.id_action_gridview:
                mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
                break;
            case R.id.id_action_listview:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.id_action_staview:
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
                break;
        }
        return true;
    }

    private void initDatas(){
        datas.add("罗纳尔多");
        datas.add("C罗");
        datas.add("小小罗");
        datas.add("New Yourkawesafasdf");
        datas.add("广州恒大");
        datas.add("北京国安asdfsdfsdf");
        datas.add("河南建业");
        datas.add("皇家马德里sdfsfsdfsf");
        datas.add("巴塞罗那");
        datas.add("曼彻斯特联");
        datas.add("米兰");
        datas.add("西班牙asdfs");
        datas.add("美国asdfasdf");
        datas.add("印度");
        datas.add("迪拜");
    }
}
