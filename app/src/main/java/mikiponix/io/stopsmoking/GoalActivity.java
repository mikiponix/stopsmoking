package mikiponix.io.stopsmoking;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class GoalActivity extends AppCompatActivity {

    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference reference=database.getReference();

    TextView d1Text;
    TextView d1adText;
    TextView d2Text;
    TextView d2adText;
    TextView d3Text;
    TextView d3adText;
    TextView w1Text;
    TextView w1adText;
    TextView w2Text;
    TextView w2adText;
    TextView m9Text;
    TextView m9adText;
    TextView y1Text;
    TextView y1adText;
    TextView y4Text;
    TextView y4adText;
    TextView y9Text;
    TextView y9adText;
    FloatingActionButton modoru2Button;
    LottieAnimationView kirakiraanimationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);
        kirakiraanimationView=(LottieAnimationView)findViewById(R.id.kirakiraanimation_view);
        kirakiraanimationView.setAnimation(R.raw.kirakira2);
        kirakiraanimationView.setRepeatCount(LottieDrawable.INFINITE);
        kirakiraanimationView.playAnimation();

        d1Text=(TextView)findViewById(R.id.d1_text);
        d1adText=(TextView)findViewById(R.id.d1_ad_text);
        d2Text=(TextView)findViewById(R.id.d2_text);
        d2adText=(TextView)findViewById(R.id.d2_ad_text);
        d3Text=(TextView)findViewById(R.id.d2_text);
        d3adText=(TextView)findViewById(R.id.d3_ad_text);
        w1Text=(TextView)findViewById(R.id.w1_text);
        w1adText=(TextView)findViewById(R.id.w1_ad_text);
        w2Text=(TextView)findViewById(R.id.w2_text);
        w2adText=(TextView)findViewById(R.id.w2_ad_text);
        m9Text=(TextView)findViewById(R.id.m9_text);
        m9adText=(TextView)findViewById(R.id.m9_ad_text);
        y1Text=(TextView)findViewById(R.id.y1_text);
        y1adText=(TextView)findViewById(R.id.y1_ad_text);
        y4Text=(TextView)findViewById(R.id.y4_text);
        y4adText=(TextView)findViewById(R.id.y4_ad_text);
        y9Text=(TextView)findViewById(R.id.y9_text);
        y9adText=(TextView)findViewById(R.id.y9_ad_text);

        modoru2Button=(FloatingActionButton)findViewById(R.id.modoru2_button);

        modoru2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(GoalActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
