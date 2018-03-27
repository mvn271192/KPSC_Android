package com.example.manikandanvnair.psc.Notification;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manikandanvnair.psc.Models.NotificationData;
import com.example.manikandanvnair.psc.R;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by manikandanvnair on 26/03/18.
 */

public class NotificationPageAdapter extends RecyclerView.Adapter<NotificationPageAdapter.NotificationCardView> {
    private Context mCtx;
    private List<NotificationData> notificationsList;

    public NotificationPageAdapter(Context mContext, List<NotificationData> notificationDataList) {
        this.mCtx = mContext;
        this.notificationsList = notificationDataList;
    }

    @Override
    public NotificationCardView onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view =  inflater.inflate(R.layout.notification_card_view, null);
        NotificationCardView notificationCardView = new NotificationCardView(view);

        return notificationCardView;
    }

    @Override
    public void onBindViewHolder(NotificationCardView holder, int position) {

        NotificationData notification = notificationsList.get(position);
        SimpleDateFormat sfd = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        //sfd.format(new Date(notification.getDateStamp()));
        holder.date.setText("txt");
        holder.title.setText(notification.getTitle());
        Picasso.get().load(notification.getImageUrl()).into(holder.imageView);



    }



    @Override
    public int getItemCount() {
        return notificationsList.size();
    }

    class  NotificationCardView extends  RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView title, date;

        public NotificationCardView(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.media_image);
            title = itemView.findViewById(R.id.primary_text);
            date = itemView.findViewById(R.id.sub_text);

        }
    }
}
