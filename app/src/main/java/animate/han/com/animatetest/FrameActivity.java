package animate.han.com.animatetest;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

//帧动画类似于gif动图，多张图片实现，图片过多会导致OOM
public class FrameActivity extends AppCompatActivity {
    @BindView(R.id.frame_img)
    ImageView mTweenImg;
    private Unbinder unbinder;
    private AnimationDrawable anima;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        unbinder = ButterKnife.bind(this);
        mTweenImg.setImageResource(R.drawable.animalist);
        anima = (AnimationDrawable) mTweenImg.getDrawable();
        anima.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @OnClick({R.id.frame_start, R.id.frame_stop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.frame_start:
                anima.start();

                break;
            case R.id.frame_stop:
                anima.stop();

                break;
        }
    }
}
