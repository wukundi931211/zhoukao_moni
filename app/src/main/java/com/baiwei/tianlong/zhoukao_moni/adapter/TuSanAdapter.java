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
import com.baiwei.tianlong.zhoukao_moni.mvp.tusan.model.beans.TuSanBeans;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TuSanAdapter extends RecyclerView.Adapter<TuSanAdapter.TuSanHodel> {

    private List<TuSanBeans.DataBean> data;
    private Context context;

    public TuSanAdapter(List<TuSanBeans.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }


    @NonNull
    @Override
    public TuSanHodel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.tusan_item, viewGroup, false);
        return new TuSanHodel(view);
    }



    @Override
    public void onBindViewHolder(@NonNull TuSanHodel tuSanHodel, int i) {
        String image_url = data.get(i).getImages().split("\\|")[0];
        String title = data.get(i).getTitle();
        String subhead = data.get(i).getSubhead();


        tuSanHodel.frescoTusan.setImageURI(Uri.parse(image_url));
        tuSanHodel.tusanText.setText(title);
        tuSanHodel.tusanText1.setText(subhead);

    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class TuSanHodel extends RecyclerView.ViewHolder {
        @BindView(R.id.fresco_tusan)
        SimpleDraweeView frescoTusan;
        @BindView(R.id.tusan_text)
        TextView tusanText;
        @BindView(R.id.tusan_text1)
        TextView tusanText1;

        public TuSanHodel(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
