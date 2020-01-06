package com.bw.xuliming.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.xuliming.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 时间：2020/1/6
 * 作者：徐黎明
 * 类的作用：
 */
public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.MyLeftAdapter> {

    private final Context context;
    private final List<String> category;


    public LeftAdapter(Context context, List<String> category) {
        this.context = context;
        this.category = category;
    }

    @NonNull
    @Override
    public MyLeftAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.left, null);
        MyLeftAdapter myLeftAdapter = new MyLeftAdapter(view);
        return myLeftAdapter;
    }

    @Override
    public void onBindViewHolder(@NonNull MyLeftAdapter holder, int position) {
            holder.tv.setText(category.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    leftClick.onclick(category.get(position));
                }
            });
    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    class MyLeftAdapter extends RecyclerView.ViewHolder {
        @BindView(R.id.tv)
        TextView tv;
        public MyLeftAdapter(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    private LeftClick leftClick;

    public void setLeftClick(LeftClick leftClick) {
        this.leftClick = leftClick;
    }

    public interface LeftClick{
        void onclick(String id);
    }
}
