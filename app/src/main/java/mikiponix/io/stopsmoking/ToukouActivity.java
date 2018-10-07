package mikiponix.io.stopsmoking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;


public class ToukouActivity extends AppCompatActivity {


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference();

    EditText goalText;
    EditText todayText;
    EditText dayText;
    EditText diaryText;
    TextView count1Text;
    TextView count2Text;
    Button sendButton;
    LottieAnimationView animationView;
    int count1;
    //int count2;
    int number;
    TextView adviceText;

    //String PRIVATE_KEY;

    String[] advice = {"たまには紅茶にしてみよう",
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
            "最近ごはん美味しくない？！",
            "味覚や嗅覚、胃の調子が良くなってきてる！",
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toukou);



        animationView = (LottieAnimationView) findViewById(R.id.animation_view);
        animationView.setAnimation(R.raw.recharge_completed);
        animationView.setRepeatCount(LottieDrawable.INFINITE);
        animationView.playAnimation();

        goalText = (EditText) findViewById(R.id.goal_card);
        todayText = (EditText) findViewById(R.id.today_card);
        dayText = (EditText) findViewById(R.id.day_card);
        diaryText = (EditText) findViewById(R.id.diary_card);
        count1Text = (TextView) findViewById(R.id.count1_card);
        count1 = 0;
        count2Text = (TextView) findViewById(R.id.count2_card);
        sendButton = (Button) findViewById(R.id.send_button);
        adviceText = (TextView) findViewById(R.id.advice_card);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String goal = goalText.getText().toString();
                String today = todayText.getText().toString();
                String day = dayText.getText().toString();
                String count1 = count1Text.getText().toString();
                String count2 = count2Text.getText().toString();
                String diary = diaryText.getText().toString();
                String advice = adviceText.getText().toString();
                String key = reference.push().getKey();

                Card item = new Card(key, goal, today, day, 1, 2, diary, advice);

                reference.child(key).setValue(item).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        finish();

                        //reference.child("post").child(key).setValue(item).addOnSuccessListener(new OnSuccessListener<Void>() {
                        //@Override
                        //public void onSuccess(Void aVoid) {


                        //}
                        //});

                        //reference.child("num").setValue("20").addOnSuccessListener(new OnSuccessListener<Void>() {
                        //@Override
                        //public void onSuccess(Void aVoid) {
                        //finish();
                        //}
                        // });


                    }

                });


            }




        });
        return;
    }

    public void add(View v){
        count1 = count1 + 1;
        count1Text.setText(count1 + "本我慢しました！");

        count2Text.setText(count1 * 20 + "円貯まりました！！");

        Random randomName = new Random ();
        int index= randomName.nextInt(32);
        //String advicename = advice[index];
        //adviceText.setText(advicename);
        adviceText.setText(advice[index]);

    }

    public void minus(View v){
        count1 = count1 - 1;
        count1Text.setText(count1 + "本我慢しました！");

        count2Text.setText(count1 * 20 + "円貯まりました");
    }










}