package com.igor.test.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.igor.test.R;
import com.igor.test.model.data.ArticlesList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    OnArticleClickListener mOnArticleClickListener;
    Context mContext;

    public RecyclerViewAdapter withClickListener(OnArticleClickListener onArticleClickListener) {
        mOnArticleClickListener = onArticleClickListener;
        return this;
    }

    public interface OnArticleClickListener {
        void onArticleClick(View v, int position, ArticlesList articlesList);
    }

    private List<ArticlesList> mArticlesLists = new ArrayList<>();

    public void setArticleList(List<ArticlesList> articleList) {
        this.mArticlesLists = articleList;
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_articles_list, viewGroup, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        final ArticlesList articlesList = mArticlesLists.get(position);
        String imageLink;
        mContext = viewHolder.mImageView.getContext();
//        Log.d("MYLOG", "getThumb = " +articlesList.getThumb().getLink());
        if (articlesList.getThumb().getLink() != null && !articlesList.getThumb().getLink().equals("")) {
            imageLink = articlesList.getThumb().getLink().replace("%dx%d", "300x300");
            Picasso.with(viewHolder.mImageView.getContext())
                    .load(imageLink)
                    .resize(300, 300)
                    .into(viewHolder.mImageView);
        } else {
            Picasso.with(viewHolder.mImageView.getContext())
                    .load(R.drawable.image_preview)
                    .resize(300, 300)
                    .into(viewHolder.mImageView);
        }
        viewHolder.title.setText(articlesList.getTitle());
        viewHolder.subtitle.setText(articlesList.getSubtitle());
        viewHolder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnArticleClickListener.onArticleClick(v, position, articlesList);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mArticlesLists.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.title)
        TextView title;
        @Bind(R.id.subtitle)
        TextView subtitle;
        @Bind(R.id.image)
        ImageView mImageView;
        @Bind(R.id.layout_article)
        LinearLayout mLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}