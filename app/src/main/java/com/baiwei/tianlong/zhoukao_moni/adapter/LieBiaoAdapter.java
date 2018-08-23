package com.baiwei.tianlong.zhoukao_moni.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baiwei.tianlong.zhoukao_moni.R;
import com.baiwei.tianlong.zhoukao_moni.mvp.main.model.beans.LieBiaoBeans;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LieBiaoAdapter extends RecyclerView.Adapter<LieBiaoAdapter.LieBiaoHolder> {

    private List<LieBiaoBeans.DataBean> data;
    private Context context;

    public LieBiaoAdapter(List<LieBiaoBeans.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public LieBiaoHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.liebiao, viewGroup, false);
        return new LieBiaoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LieBiaoHolder lieBiaoHolder, final int i) {
        String name = data.get(i).getName();
        String createtime = data.get(i).getCreatetime();
        String icon = data.get(i).getIcon();

        lieBiaoHolder.frescoLiebiao.setImageURI(Uri.parse(icon));
        lieBiaoHolder.liebiaoText.setText(name);
        lieBiaoHolder.liebiaoText1.setText(createtime);

        lieBiaoHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemLieBiaoInstance!=null){
                   onItemLieBiaoInstance.onItemClick(view,i);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class LieBiaoHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.fresco_liebiao)
        SimpleDraweeView frescoLiebiao;
        @BindView(R.id.liebiao_text)
        TextView liebiaoText;
        @BindView(R.id.liebiao_text1)
        TextView liebiaoText1;
        public LieBiaoHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }



     OnItemLieBiaoInstance  onItemLieBiaoInstance;

    public interface OnItemLieBiaoInstance {
        void onItemClick(View view , int position);
    }

    public void setOnItemLieBiaoInstance(OnItemLieBiaoInstance onItemLieBiaoInstance) {
        this.onItemLieBiaoInstance = onItemLieBiaoInstance;
    }
}
