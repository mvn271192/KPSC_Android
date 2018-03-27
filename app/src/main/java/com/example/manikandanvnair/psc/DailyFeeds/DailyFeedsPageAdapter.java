package com.example.manikandanvnair.psc.DailyFeeds;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manikandanvnair.psc.Models.DailyFeed;
import com.example.manikandanvnair.psc.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by manikandanvnair on 24/03/18.
 */

public class DailyFeedsPageAdapter extends  RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mCtx;
    private List<DailyFeed> dailyFeedList;

    public DailyFeedsPageAdapter(Context mCtx, List<DailyFeed> dailyFeedList) {
        this.mCtx = mCtx;
        this.dailyFeedList = dailyFeedList;
    }

    @Override
    public int getItemViewType(int position) {
        DailyFeed dailyFeed = dailyFeedList.get(position);
        return dailyFeed.getType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        switch (viewType)
        {
            case 1: //text data
                View view = inflater.inflate(R.layout.dailyfeed_cardview,null);
                DailyFeedsViewHolder viewHolder = new DailyFeedsViewHolder(view);
                return  viewHolder;
            case 2:// image data
                View imageView = inflater.inflate(R.layout.daily_feed_image_card,null);
                DailyFeedsImageViewHolder imageViewHoldermageViewHolder = new DailyFeedsImageViewHolder(imageView);
                return  imageViewHoldermageViewHolder;
            case 3:
                View question = inflater.inflate(R.layout.dailyfeed_cardview,null);
                DailyFeedsViewHolder questioniVewHolder = new DailyFeedsViewHolder(question);
                return  questioniVewHolder;

        }


        return null;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        DailyFeed dailyFeed = dailyFeedList.get(position);

        switch (dailyFeed.getType())
        {
            case 1:

                DailyFeedsViewHolder dailyFeedsViewHolder = (DailyFeedsViewHolder) holder;
                dailyFeedsViewHolder.title.setText(dailyFeed.getTitle());
                dailyFeedsViewHolder.content.setText(dailyFeed.getTextData());

                break;
            case  2:
                DailyFeedsImageViewHolder dailyFeedsImageViewHolder = (DailyFeedsImageViewHolder) holder;
                Picasso.get().load(dailyFeed.getImageURL()).into(dailyFeedsImageViewHolder.imageView);

                break;
            case 3:
                DailyFeedsViewHolder questionDailyFeedsViewHolder = (DailyFeedsViewHolder) holder;
                questionDailyFeedsViewHolder.title.setText(dailyFeed.getTitle());
                questionDailyFeedsViewHolder.content.setText(dailyFeed.getAnswer());


        }
    }

    @Override
    public long getItemId(int position) {

        DailyFeed dailyFeed = dailyFeedList.get(position);
        Integer type = dailyFeed.getType();
        return type;
    }



//    @Override
//    public void onBindViewHolder( RecyclerView.ViewHolder holder, int position) {
//
//        DailyFeed dailyFeed = dailyFeedList.get(position);
//        holder.title.setText(dailyFeed.getTitle());
//        holder.content.setText(dailyFeed.getTextData());
//    }

    @Override
    public int getItemCount() {
        return dailyFeedList.size();
    }

    class DailyFeedsViewHolder extends RecyclerView.ViewHolder
    {

        TextView title, content;

        public DailyFeedsViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_text);
            content = itemView.findViewById(R.id.content_text);
        }
    }

    class  DailyFeedsImageViewHolder extends  RecyclerView.ViewHolder
    {
        ImageView imageView;

        public DailyFeedsImageViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.media_image);

        }
    }
}
