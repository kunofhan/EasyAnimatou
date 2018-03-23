package animate.han.com.animatetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_frame_animation)
    Button frameAnimation;
    @BindView(R.id.main_tweened_animation)
    Button tweenedAnimation;
    @BindView(R.id.main_object_animation)
    Button objectAnimation;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUnbinder = ButterKnife.bind(this);
    }

    @OnClick({R.id.main_frame_animation, R.id.main_tweened_animation, R.id.main_object_animation})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_frame_animation:
                Intent intent = new Intent(MainActivity.this, FrameActivity.class);
                startActivity(intent);
                break;
            case R.id.main_tweened_animation:
                Intent tweenIntent = new Intent(MainActivity.this, TweenActivity.class);
                startActivity(tweenIntent);
                break;
            case R.id.main_object_animation:
                Intent objectIntent = new Intent(MainActivity.this, ObjectActiity.class);
                startActivity(objectIntent);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
