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
    DatabaseReference reference = database.getReference();



    //String PRIVATE_KEY;

    public ListView listView;
    public FloatingActionButton addButton;


    public CardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);

    listView = (ListView)findViewById(R.id.list_view);
    addButton = (FloatingActionButton)findViewById(R.id.add_button);


    adapter = new CardAdapter(this,0, new ArrayList<Card>());
    adapter.setOnLikeClickListener(this);
    listView.setAdapter(adapter);


    addButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, ToukouActivity.class);
            //intent.putExtra("key", PRIVATE_KEY);
            startActivity(intent);

        }
    });




    //reference.child("post").addChildEventListener(new ChildEventListener() {
        reference.addChildEventListener(new ChildEventListener() {
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
            item.setAdvice(result.getAdvice());

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
