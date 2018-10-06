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


public class ToukouActivity extends AppCompatActivity{


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference("User");

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
    int number;
    TextView adviceText;

    String PRIVATE_KEY;


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
        adviceText = (TextView)findViewById(R.id.advice_card);

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

                Card item = new Card(key, goal, today, day, 1, 2, diary,advice);

                reference.child("post").child(key).setValue(item).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {


                    }
                });

                reference.child("num").setValue("20").addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        finish();
                    }
                });





            }

        });


    }

    public void add(View v){
        count1 = count1 + 1;
        count1Text.setText(count1 + "本我慢しました！");

//        count2 = count2 + 20;
        count2Text.setText(count1 * 20 + "円貯まりました！！");

        Random randomAdvice = new Random();
        adviceText.setText(advice[randomAdvice.nextInt(31)]);


    }

    public void minus(View v){
        count1 = count1 - 1;
        count1Text.setText(count1 + "本我慢しました！");

//        count2 = count2 - 20;
        count2Text.setText(count1 * 20 + "円貯まりました!!");
    }

}







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