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
import com.baiwei.tianlong.zhoukao_moni.mvp.main.model.beans.SheJiBeans;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SheJiShiAdapter extends RecyclerView.Adapter<SheJiShiAdapter.SheJiHolder> {

    private List<SheJiBeans.DataBean.DisplayBean> display;
    private Context context;

    public SheJiShiAdapter(List<SheJiBeans.DataBean.DisplayBean> display, Context context) {
        this.display = display;
        this.context = context;
    }

    @NonNull
    @Override
    public SheJiHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.shejiitem, viewGroup, false);
        return new SheJiHolder(view);
    }

    @Override
        public void onBindViewHolder(@NonNull SheJiHolder sheJiHolder, int i) {
        String avatar = display.get(i).getAvatar();
        String nick_name = display.get(i).getNick_name();
        sheJiHolder.frescoSheji.setImageURI(Uri.parse(avatar));
        sheJiHolder.shejiText.setText(nick_name);

    }

    @Override
    public int getItemCount() {
        return display == null ? 0 : display.size();
    }

    public class SheJiHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.fresco_sheji)
        SimpleDraweeView frescoSheji;
        @BindView(R.id.sheji_text)
        TextView shejiText;

        public SheJiHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
