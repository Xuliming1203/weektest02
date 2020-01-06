package com.bw.xuliming.view.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.xuliming.R;
import com.bw.xuliming.adapter.LeftAdapter;
import com.bw.xuliming.adapter.RightAdapter;
import com.bw.xuliming.contracl.IContracl;
import com.bw.xuliming.entity.LeftEntity;
import com.bw.xuliming.entity.RigthEntity;
import com.bw.xuliming.presenter.Presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MainActivity extends AppCompatActivity implements IContracl.IView {
    @BindView(R.id.rv_left)
    RecyclerView rvLeft;
    @BindView(R.id.rv_right)
    RecyclerView rvRight;
     Presenter presenter;
     Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind = ButterKnife.bind(this);
        presenter = new Presenter(this);
        presenter.getLeft();
        EventBus.getDefault().register(this);
        rvLeft.setLayoutManager(new LinearLayoutManager(this));
        rvRight.setLayoutManager(new GridLayoutManager(this, 2));
        presenter.getLeft();
    }

    @Override
    public void success(Object o) {
        if (o instanceof LeftEntity) {
            LeftEntity leftEntity = (LeftEntity) o;
            List<String> category = leftEntity.getCategory();
            LeftAdapter leftAdapter = new LeftAdapter(MainActivity.this, category);
            leftAdapter.notifyDataSetChanged();
            leftAdapter.setLeftClick(new LeftAdapter.LeftClick() {
                @Override
                public void onclick(String id) {
                    EventBus.getDefault().post(id);
                }
            });
            rvLeft.setAdapter(leftAdapter);
        } else if (o instanceof RigthEntity) {
            RigthEntity rigthEntity = (RigthEntity) o;
            RightAdapter rightAdapter=new RightAdapter(MainActivity.this,rigthEntity.getData());
            rvRight.setAdapter(rightAdapter);
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getId(String id){
        HashMap<String,String> params=new HashMap<>();
        params.put("category",id);
        presenter.getRight(params);
    }
    @Override
    public void fshibai(Throwable throwable) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null) {
            bind.unbind();
        }
        EventBus.getDefault().unregister(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
