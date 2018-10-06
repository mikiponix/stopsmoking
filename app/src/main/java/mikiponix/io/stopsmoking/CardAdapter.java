package mikiponix.io.stopsmoking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;
import java.util.Random;

public class CardAdapter extends ArrayAdapter<Card>{

    String[] advice={"たまには紅茶にしてみよう",
            "いいよ、その調子です",
            "継続は力なり",
            "大きく深呼吸",
            "禁煙後20分で血圧や脈が正常化するよ",
            "１本だけの誘惑に負けないで",
            "体にいいことしかない！",
            "辛くなったら頼ってみよう！",
            "浮いたお金で家族旅行に行こう！",
            "いつもありがとう！",
            "今日も元気？一緒に頑張ろう！！",
            "最初の一週間はつらいけど死なないから大丈夫！",
            "最近ごはん美味しくない？！味覚や嗅覚、胃の調子が良くなってきてる！",
            "映画でも観に行こう！",
            "１本だけお化けにご注意。水の泡に",
            "5年後肺がんになる確率が半分になるよ",
            "７２時間後ニコチンが完全に消えるんだよ！続けよう！",
            "そろそろお金もいい感じじゃない",
            "吸いたくなったら家族と遊ぼう！",
            "タバコ臭いが消えた！！！",
            "ひたすら耐えるのみ！",
            "味方はたくさんいるよ",
            "一人じゃないからね",
            "お金と命があればもう！！",
            "一緒に長生きしませんか？",
            "今日のお昼は少し贅沢しよう",
            "あなたの健康が一番",
            "２４時間で心臓発作の確率が下がるんだよ！",
            "２〜３週間で肺活量が３０％回復",
            "頑張っている人はいつもかっこいい",
            "つらくなったら相談しよう！甘えじゃない！"};

    private List<Card> cards;

    private OnLikeClickListener likeClickListener =null;

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
            viewHolder.count1Text=(TextView)convertView.findViewById(R.id.count1_card);
            viewHolder.count2text=(TextView)convertView.findViewById(R.id.count2_card);
            viewHolder.diaryText=(TextView)convertView.findViewById(R.id.diary_card);
            viewHolder.likecountText=(TextView)convertView.findViewById(R.id.like_count_text);
            viewHolder.adviceText=(TextView)convertView.findViewById(R.id.advice_card);

            convertView.setTag(viewHolder);
        }

        Card card =cards.get(position);

        viewHolder.goalText.setText(card.getGoal());
        viewHolder.todayText.setText(card.getToday());
        viewHolder.dayText.setText(card.getDay());
        viewHolder.diaryText.setText(card.getDiary());
        viewHolder.count1Text.setText(card.getCount1());
        viewHolder.count2text.setText(card.getCount2());
        viewHolder.adviceText.setText(card.getAdvice()[0]); // 後々ランダム
        viewHolder.likecountText.setText(String.valueOf(card.getLikecount()));
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

    public void advice(View v){

        Random randomAdvice = new Random();
        int index = randomAdvice.nextInt(31);

    }

    public Card getItemByKey(String key) {
        for (Card item : cards) {
            if (item.getKey().equals(key)) {
                return item;
            }
        }

        return null;
    }

    public void setOnLikeClickListener(OnLikeClickListener onClickListener){
        this.likeClickListener = onClickListener;
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
        TextView adviceText;
    }

    interface OnLikeClickListener{
        void onLikeClick(int position);
    }
}
