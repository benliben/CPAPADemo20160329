package com.example.mylibrary.simple;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.textservice.TextInfo;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

/**
 * Created by Administrator on 2016/3/29.
 * 这个adapter没有改变原来的adapter里面的内容
 * 只是在原来的基础之上加了一个头部和尾部
 */
public class HeaderAndFooterRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /*静态常量*/
    private static final int TYPE_HEADER_VIEW = Integer.MIN_VALUE;
    private static final int TYPE_FOOTER_VIEW = Integer.MIN_VALUE + 1;

    /**
     * RecyclerView使用的，真正的Adapter
     */
    private RecyclerView.Adapter<RecyclerView.ViewHolder> mInnerAdapter;

    //    装头部的view
    private ArrayList<View> mHeaderViews = new ArrayList<>();
    //    装尾部的view
    private ArrayList<View> mFooterViews = new ArrayList<>();

    /**
     * *******************************************************************************************
     * adapter的数据观察者
     */
    private RecyclerView.AdapterDataObserver mDataObserver = new RecyclerView.AdapterDataObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            notifyDataSetChanged();
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount) {
            super.onItemRangeChanged(positionStart, itemCount);
            onItemRangeChanged(positionStart + getHeaderViewsCount(), itemCount);
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            super.onItemRangeInserted(positionStart, itemCount);
            onItemRangeInserted(positionStart + getHeaderViewsCount(), itemCount);
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            super.onItemRangeRemoved(positionStart, itemCount);
            onItemRangeRemoved(positionStart + getHeaderViewsCount(), itemCount);
        }

        @Override
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            super.onItemRangeMoved(fromPosition, toPosition, itemCount);
            int headerViewsCountCount = getHeaderViewsCount();
            onItemRangeMoved(fromPosition + headerViewsCountCount, toPosition + headerViewsCountCount, itemCount);
        }
    };

    /**
     * *******************************************************************************************
     */
    private HeaderAndFooterRecyclerViewAdapter() {
    }

    public HeaderAndFooterRecyclerViewAdapter(RecyclerView.Adapter innerAdapter) {
        setAdapter(innerAdapter);
    }

    /**
     * 设置内部的Adapter
     */
    private void setAdapter(RecyclerView.Adapter adapter) {
        if (adapter != null) {
            if (!(adapter instanceof RecyclerView.Adapter)) {
                throw new RuntimeException("your adapter muster be RecyclerView.Adapter");
            }
        }
        if (mInnerAdapter != null) {
            notifyItemRangeRemoved(getHeaderViewsCount(), mInnerAdapter.getItemCount());
            mInnerAdapter.unregisterAdapterDataObserver(mDataObserver);
        }
        this.mInnerAdapter = adapter;
        mInnerAdapter.registerAdapterDataObserver(mDataObserver);
        notifyItemRangeInserted(getHeaderViewsCount(), mInnerAdapter.getItemCount());
    }


    /**
     * 获取内部的Adapter
     */
    public RecyclerView.Adapter getInnerAdapter() {
        return mInnerAdapter;
    }

    /**
     * 添加头部view
     */
    public void addHeaderView(View headView) {
        if (headView == null) {
            throw new NullPointerException("headerView is null");
        }
        mHeaderViews.add(headView);
        this.notifyDataSetChanged();
    }

    /**
     * 添加尾部View
     */
    public void addFooterView(View footerView) {
        if (footerView == null) {
            throw new NullPointerException("footerView is null");
        }
        mFooterViews.add(footerView);
        this.notifyDataSetChanged();
    }

    /**
     * 获取头部view的数量
     *
     * @return
     */
    public int getHeaderViewsCount() {
        return mHeaderViews.size();
    }

    /**
     * 获取尾部view的数量
     *
     * @return
     */
    public int getFooterViewsCount() {
        return mFooterViews.size();
    }

    /**
     * 获取头部View
     */
    public View getHeaderView() {
        return mHeaderViews.size() > 0 ? mHeaderViews.get(0) : null;
    }

    /**
     * 获取尾部View
     *
     * @return
     */
    public View getFooterView() {
        return mFooterViews.size() > 0 ? mFooterViews.get(0) : null;
    }

    /**
     * 移除头部View
     *
     * @param view
     */
    public void removeHeadView(View view) {
        mHeaderViews.remove(view);
        this.notifyDataSetChanged();
    }

    /**
     * 移除尾部View
     *
     * @param view
     */
    public void removeFooterView(View view) {
        mFooterViews.remove(view);
        this.notifyDataSetChanged();
    }

    public boolean isHeader(int position) {
        return getHeaderViewsCount() > 0 && position == 0;
    }

    public boolean isFooter(int position) {
        int lastPosition = getItemCount() - 1;
        return getFooterViewsCount() > 0 && position == lastPosition;
    }

    /**
     * 创建ViewHolder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int headerViewsCountCount = getHeaderViewsCount();
        if (viewType < TYPE_HEADER_VIEW + headerViewsCountCount) {
            return new ViewHolder(mHeaderViews.get(viewType - TYPE_HEADER_VIEW));
        } else if (viewType >= TYPE_FOOTER_VIEW && viewType < Integer.MAX_VALUE / 2) {
            return new ViewHolder(mFooterViews.get(viewType - TYPE_FOOTER_VIEW));
        } else {
            return mInnerAdapter.onCreateViewHolder(parent, viewType - Integer.MAX_VALUE / 2);
        }
    }

    /**
     * 绑定ViewHolder
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int headerViewsCountCount = getHeaderViewsCount();
        if (position >= headerViewsCountCount && position < headerViewsCountCount + mInnerAdapter.getItemCount()) {
            mInnerAdapter.onBindViewHolder(holder, position - headerViewsCountCount);
        } else {
            ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
            if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {

                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
            }
        }
    }

    /**
     * 获取View的最终数量
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return getFooterViewsCount() + getHeaderViewsCount() + mInnerAdapter.getItemCount();
    }




    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        int innerCount = mInnerAdapter.getItemCount();
        int headerViewsCountCount = getHeaderViewsCount();
        if (position < headerViewsCountCount) {
            return TYPE_HEADER_VIEW + position;
        } else if (headerViewsCountCount <= position && position < headerViewsCountCount + innerCount) {
            int innerItemViewType = mInnerAdapter.getItemViewType(position - headerViewsCountCount);
            if (innerItemViewType >= Integer.MAX_VALUE / 2) {
                throw new IllegalArgumentException("your adapter's return value of getViewTypeCount() must <integer.MAX_VALUE/2)");
            }
            return innerItemViewType + Integer.MAX_VALUE / 2;
        } else {
            return TYPE_FOOTER_VIEW + position - headerViewsCountCount - innerCount;
        }
    }
}
