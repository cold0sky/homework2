package chapter.android.aweme.ss.com.homework;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import chapter.android.aweme.ss.com.homework.widget.CircleImageView;

/**
 * 适配器
 */
public class GreenAdapter extends RecyclerView.Adapter<GreenAdapter.NumberViewHolder> {

    private static final String TAG = "GreenAdapter";

    private int mNumberItems;

    private final ListItemClickListener mOnClickListener;

    private static int viewHolderCount;

    //解析的数据存入数组
    private ArrayList<String> title;
    private ArrayList<String> hashtag;
    private ArrayList<String> time;
    private ArrayList<String> icon;
    private ArrayList<Boolean> isOfficial;

    public GreenAdapter(int numListItems, ListItemClickListener listener, ArrayList<String> title1, ArrayList<String> hashtag1, ArrayList<String> time1, ArrayList<String> icon1, ArrayList<Boolean> isOfficial1) {
        mNumberItems = numListItems;
        mOnClickListener = listener;
        viewHolderCount = 0;
        title = title1;
        hashtag = hashtag1;
        time = time1;
        icon = icon1;
        isOfficial = isOfficial1;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.im_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder(view);

        Log.d(TAG, "onCreateViewHolder: number of ViewHolders created: " + viewHolderCount);
        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder numberViewHolder, int position) {
        Log.d(TAG, "onBindViewHolder: #" + position);
        numberViewHolder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    public class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView viewTitle;
        private final TextView viewDescription;
        private final TextView viewTime;
        private final CircleImageView viewIcon;
        private final ImageView viewNotice;

        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            viewTitle = (TextView) itemView.findViewById(R.id.tv_title);
            viewDescription = (TextView) itemView.findViewById(R.id.tv_description);
            viewTime = (TextView) itemView.findViewById(R.id.tv_time);
            viewIcon = (CircleImageView) itemView.findViewById(R.id.iv_avatar);
            viewNotice = (ImageView) itemView.findViewById(R.id.robot_notice);
            itemView.setOnClickListener(this);
        }

        public void bind(int position) {
            //设置标题，描述，文字信息
            if (title != null && title.size() > 0)
                viewTitle.setText(title.get(position));
            if (hashtag != null && hashtag.size() > 0)
                viewDescription.setText(hashtag.get(position));
            if (time != null && time.size() > 0)
                viewTime.setText(time.get(position));

            //设置图标
            if (icon != null && icon.size() > 0) {
                switch (icon.get(position)) {
                    case "TYPE_ROBOT":
                        viewIcon.setImageResource(R.drawable.session_robot);
                        break;
                    case "TYPE_GAME":
                        viewIcon.setImageResource(R.drawable.icon_micro_game_comment);
                        break;
                    case "TYPE_SYSTEM":
                        viewIcon.setImageResource(R.drawable.session_system_notice);
                        break;
                    case "TYPE_STRANGER":
                        viewIcon.setImageResource(R.drawable.session_stranger);
                        break;
                    case "TYPE_USER":
                        viewIcon.setImageResource(R.drawable.icon_girl);
                        break;
                }

            }
            if(isOfficial != null && isOfficial.size() > 0) {
                if(isOfficial.get(position)){
                    viewNotice.setImageResource(R.drawable.im_icon_notice_official);
                    viewNotice.setVisibility(View.VISIBLE);
                }
                else
                    viewNotice.setVisibility(View.INVISIBLE);
            }


        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            if (mOnClickListener != null) {
                mOnClickListener.onListItemClick(clickedPosition);
            }
        }
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }
}
