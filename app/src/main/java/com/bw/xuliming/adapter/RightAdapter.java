package com.bw.xuliming.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.xuliming.R;
import com.bw.xuliming.entity.RigthEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 时间：2020/1/6
 * 作者：徐黎明
 * 类的作用：
 */
public class RightAdapter extends RecyclerView.Adapter<RightAdapter.MyRightAdapter> {
    private final Context context;
    private final List<RigthEntity.DataBean> data;


    public RightAdapter(Context context, List<RigthEntity.DataBean> data) {

        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyRightAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.right, null);
        MyRightAdapter myRightAdapter = new MyRightAdapter(view);
        return myRightAdapter;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRightAdapter holder, int position) {
        Glide.with(context).load(data.get(position).getGoods_thumb())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.iv);
        holder.tv.setText(data.get(position).getGoods_english_name());
        holder.tv2.setText(data.get(position).getCurrency_price()+"");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyRightAdapter extends RecyclerView.ViewHolder {
        @BindView(R.id.iv)
        ImageView iv;
        @BindView(R.id.tv)
        TextView tv;
        @BindView(R.id.tv2)
        TextView tv2;
        public MyRightAdapter(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
