package mikiponix.io.stopsmoking;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CardAdapter extends ArrayAdapter<Card>{

    private List<Card> cards;

    private View.OnClickListener likeClickListener =null;

    public CardAdapter(Context context, int resource,List<Card> cards){
        super(context,resource,cards);

        this.cards = cards;
    }

    @Override
    public int getCount(){
        return cards.size();
    }

    @Override
    public Card getItem(int position){
        return cards.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        final ViewHolder viewHolder;

        if (convertView != null){
            viewHolder = (ViewHolder) convertView.getTag();
        }else{
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card,parent,false);
            viewHolder = new ViewHolder();

            viewHolder.goalText=(TextView) convertView.findViewById(R.id.goal_card);
            viewHolder.todayText=(TextView)convertView.findViewById(R.id.today_card);
            viewHolder.dayText=(TextView)convertView.findViewById(R.id.day_card);
            viewHolder.likeImage=(ImageView)convertView.findViewById(R.id.like_image);
            viewHolder.count1Text(TextView)convertView.findViewById(R.id.count1_card);
            viewHolder.count2text(TextView)convertView.findViewById(R.id.count2_card);
            viewHolder.diaryText(TextView)convertView.findViewById(R.id.diary_card);
            viewHolder.likecountText=(TextView)convertView.findViewById(R.id.like_count_text);

            convertView.setTag(viewHolder);
        }

        Card card =cards.get(position);

        viewHolder.goalText.setText(card.getGoal());
        viewHolder.todayText.setText(card.getToday());
        viewHolder.dayText.setText(card.getDay());
        viewHolder.diaryText.setText(card.getDiary());
        viewHolder.count1Text.setText(card.getCount1());
        viewHolder.count2text.setText(card.getCount2());
        viewHolder.likecountText.setText(card.setLikecount());
        viewHolder.likeImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (likeClickListener != null){
                    likeClickListener.onLikeClick(position);
                }
            }

        });

        return convertView;
    }

    public void setOnClickListener(View.OnClickListener likeClickListener){
        this.likeClickListener = likeClickListener;
    }

    static  class ViewHolder{
        TextView goalText;
        TextView todayText;
        TextView dayText;
        ImageView likeImage;
        TextView count1Text;
        TextView count2text;
        TextView diaryText;
        TextView likecountText;
    }

    interface OnLikeClickListener{
        void onLikeClick(int position);
    }
}
