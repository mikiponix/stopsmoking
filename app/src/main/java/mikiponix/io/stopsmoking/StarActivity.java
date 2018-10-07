package mikiponix.io.stopsmoking;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StarActivity extends AppCompatActivity {

    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference reference=database.getReference();

    EditText aruaruText;
    LottieAnimationView aruaruanimationView;
    FloatingActionButton modoruButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star);

        aruaruanimationView=(LottieAnimationView)findViewById(R.id.aruaruanimation_view);
        aruaruanimationView.setAnimation(R.raw.guchiri2);
        aruaruanimationView.setRepeatCount(LottieDrawable.INFINITE);
        aruaruanimationView.playAnimation();

        aruaruText = (EditText)findViewById(R.id.aruaru_text);
        modoruButton = (FloatingActionButton) findViewById(R.id.modoru_button);

        modoruButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StarActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
