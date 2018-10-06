package mikiponix.io.stopsmoking;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


//import com.airbnb.lottie.LottieAnimationView;
//import com.airbnb.lottie.LottieDrawable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements CardAdapter.OnLikeClickListener{

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference("User");


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

    String PRIVATE_KEY;

    public ListView listView;
    public FloatingActionButton addButton;
   //public Button addButtonall;
   // public TextView tabaccoaddButton;
   // public TextView moneyaddButton;

    public CardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);

    listView = (ListView)findViewById(R.id.list_view);
    addButton = (FloatingActionButton)findViewById(R.id.add_button);
    //addButtonall =(Button)findViewById(R.id.addbutton_all);
    //tabaccoaddButton =(TextView)findViewById(R.id.all_tabacco);
    //moneyaddButton =(TextView)findViewById(R.id.all_money);

    adapter = new CardAdapter(this,0, new ArrayList<Card>());
    adapter.setOnLikeClickListener(this);

    listView.setAdapter(adapter);


    addButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, ToukouActivity.class);
            intent.putExtra("key", PRIVATE_KEY);
            startActivity(intent);

        }
    });

    //addButtonall.setOnClickListener(new View.OnClickListener() {
        //@Override
        //public void onClick(View v) {


        //}
    //});


    reference.child("post").addChildEventListener(new ChildEventListener() {
        @Override
        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            Card item = dataSnapshot.getValue(Card.class);
            adapter.add(item);
            adapter.notifyDataSetChanged();
        }

        @Override
        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            Card result = dataSnapshot.getValue(Card.class);
            if (result == null) return;

            Card item = adapter.getItemByKey(result.getKey());
            item.setGoal(result.getGoal());
            item.setToday(result.getToday());
            item.setDay(result.getDay());
            item.setCount1(result.getCount1());
            item.setCount2(result.getCount2());
            item.setDiary(result.getDiary());
            item.setLikecount(result.getLikecount());
//            item.setAdvice(result.getAdvice());

            adapter.notifyDataSetChanged();
        }

        @Override
        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
    }

    reference.child("num").addChildEventListner(new ChildEventListener()){
        @Override
        public  void onTotalClick(int position){

        }
    }

    @Override
    public void onLikeClick(int position) {
        Card item = adapter.getItem(position);
        if (item == null) return;

        int likeCount = item.getLikecount();
        likeCount = likeCount + 1;

        // いいね数を更新
        item.setLikecount(likeCount);

        // 更新
        Map<String, Object> postValues = new HashMap<>();
        postValues.put("/" + item.getKey() + "/", item);

        // 送信
        reference.updateChildren(postValues);
    }




}

  //  LottieAnimationView animationView;

  //  @Override
 //  protected void onCreate(Bundle savedInstanceState) {//      super.onCreate(savedInstanceState);
 //       setContentView(R.layout.activity_main);
  //      animationView = (LottieAnimationView) findViewById(R.id.animation_view);

  //      animationView.setAnimation(R.raw.recharge_completed);
  //      animationView.setRepeatCount(LottieDrawable.INFINITE);
  //      animationView.playAnimation();

//}
