package mikiponix.io.stopsmoking;

import android.content.ClipData;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

//import com.airbnb.lottie.LottieAnimationView;
//import com.airbnb.lottie.LottieDrawable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CardAdapter.OnLikeClickListener{

    public ListView listView;
    public FloatingActionButton addButton;

    public CardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
     super.onCreate(savedInstanceState);
     setContentView(R.layoit.activity_main);

    listView = (ListView)findViewById(R.id.list_view);
    addButton = (FloatingActionButton)findViewById(R.id.add_button);

    adapter = new CardAdapter(this,0,new ArrayList<Card>());
    adapter.setOnLikeClickListener(this);
    listView.setAdapter(adapter);

    addButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, toukou.class);
            startActivity(intent);
        }
    });

        adapter.addAll(getSampleData());
}

    @Override
    public void onLikeClick(int position) {
        Toast.makeText(MainActivity.this, "いいねが押されたよ", Toast.LENGTH_SHORT).show();
    }

    public List<Card> getSampleData() {
        return Arrays.asList(
                new Item("title", "content", 3),
                new Item("title", "content", 3),
                new Item("title", "content", 3),
                new Item("title", "content", 3),
                new Item("title", "content", 3),
                new Item("title", "content", 3),
                new Item("title", "content", 3),
                new Item("title", "content", 3),
                new Item("title", "content", 3));
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
