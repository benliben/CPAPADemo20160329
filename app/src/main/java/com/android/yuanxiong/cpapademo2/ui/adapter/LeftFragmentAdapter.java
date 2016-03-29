package com.android.yuanxiong.cpapademo2.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.yuanxiong.cpapademo2.R;
import com.android.yuanxiong.cpapademo2.model.LeftTagModel;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by 李远雄 on 2016/3/18.
 */
public class LeftFragmentAdapter extends BaseAdapter {

    private List<LeftTagModel> models;
    private Context context;
    private int choosePosition = -1;

    public LeftFragmentAdapter(List<LeftTagModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int i) {
        return models.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void setChoosePosition(int position) {
        this.choosePosition = position;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        LeftTagModel model = models.get(i);
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_left, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        holder = (ViewHolder) view.getTag();
        initView(holder, model, i);
        return view;
    }

    private void initView(ViewHolder holder, LeftTagModel model, int position) {
        holder.text.setText(model.getName());
        if (position == choosePosition) {
            holder.text.setTextColor(Color.parseColor("#FFFFFF"));
            holder.content.setBackgroundColor(Color.parseColor("#000000"));
            holder.img.setBackgroundResource(R.mipmap.cllection_btn_slet);
        } else {
            holder.text.setTextColor(Color.parseColor("#000000"));
            holder.content.setBackgroundColor(Color.parseColor("#242424"));
            holder.img.setBackgroundResource(R.mipmap.cllection_btn_no);
        }
    }

    static class ViewHolder {
        @Bind(R.id.img)
        ImageView img;
        @Bind(R.id.text)
        TextView text;
        @Bind(R.id.content)
        RelativeLayout content;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
