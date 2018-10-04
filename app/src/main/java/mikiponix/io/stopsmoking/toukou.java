package mikiponix.io.stopsmoking;

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




public class toukou extends AppCompatActivity{


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
    int count2;


    @Override
    protected void onCreate(Bundle savedInstanceState){
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
        count1 =0;
        count2Text = (TextView) findViewById(R.id.count2_card);
        count2 =0;
        sendButton = (Button) findViewById(R.id.send_button);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String goal = goalText.getText().toString();
                String today = todayText.getText().toString();
                String day = dayText.getText().toString();
                String count1 = count1Text.getText().toString();
                String count2 = count2Text.getText().toString();
                String diary = diaryText.getText().toString();
                String key = reference.push().getKey();

                Card item = new Card(key, goal, today, day, 1, 2, diary);

                reference.child(key).setValue(item).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        finish();


                    }
                });

                @Override
                public void add (View v){
                    count1 = count1 + 1;
                    count1Text.setText(count1 + "本我慢しました！");

                    count2 = count2 + 20;
                    count2Text.setText(count2 + "円貯まりました！！");
                }

                public void minus (View v){
                    count1 = count1 - 1;
                    count1Text.setText(count1 - "本我慢しました！");

                    count2 = count2 - 20;
                    count2Text.setText(count2 - "円貯まりました!!");
                }


            }

        });}}







                ///public class MainActivity extends AppCompatActivity {

//LottieAnimationView animationView;

//@Override
// protected void onCreate(Bundle savedInstanceState) {
//super.onCreate(savedInstanceState);
//setContentView(R.layout.activity_main);

//animationView = (LottieAnimationView) findViewById(R.id.animation_view);

//animationView.setAnimation(R.raw.recharge_completed);
//animationView.setRepeatCount(LottieDrawable.INFINITE);
//animationView.playAnimation();
// }
//}