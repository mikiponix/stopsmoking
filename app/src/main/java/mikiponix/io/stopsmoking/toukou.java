package mikiponix.io.stopsmoking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;

public class toukou extends AppCompatActivity{

    EditText goalText;
    EditText todayText;
    EditText dayText;
    EditText diaryText;
    TextView count1Text;
    TextView count2Text;
    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toukou);

        goalText = (EditText) findViewById(R.id.goal_card);
        todayText = (EditText) findViewById(R.id.today_card);
        dayText = (EditText) findViewById(R.id.day_card);
        diaryText = (EditText) findViewById(R.id.diary_card);
        count1Text = (TextView) findViewById(R.id.count1_card);
        count2Text = (TextView) findViewById(R.id.count2_card);
        sendButton = (Button) findViewById(R.id.send_button);

        sendButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(toukou.this,"追加！！", Toast.LENGTH_SHORT).show();
            }
        });
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
