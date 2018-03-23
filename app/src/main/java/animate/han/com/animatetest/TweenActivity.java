package animate.han.com.animatetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class TweenActivity extends AppCompatActivity {


    @BindView(R.id.tween_rotate)
    Button rotate;
    @BindView(R.id.tween_translate)
    Button translate;
    @BindView(R.id.tween_scale)
    Button scale;
    @BindView(R.id.tween_alpha)
    Button alpha;
    @BindView(R.id.tween_all)
    Button tween_all;
    @BindView(R.id.tween_img)
    ImageView image;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);

        unbinder = ButterKnife.bind(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @OnClick({R.id.tween_rotate, R.id.tween_translate, R.id.tween_scale, R.id.tween_alpha, R.id.tween_all})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tween_rotate:
                //xml开启动画
                Animation rotate1 = AnimationUtils.loadAnimation(this, R.anim.rotate_anima);
                image.startAnimation(rotate1);
                //代码开启动画
               /* RotateAnimation rotateAnimation = new RotateAnimation(0f, 359f,  Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotateAnimation.setDuration(1000);
                rotateAnimation.setRepeatCount(10);
                image.startAnimation(rotateAnimation);*/
                break;
            case R.id.tween_translate:
                //xml开启动画
              /*  Animation rotate2 = AnimationUtils.loadAnimation(this, R.anim.translate_anima);
                image.startAnimation(rotate2);*/
                //代码启动动画
                TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, -1.0f,
                        Animation.RELATIVE_TO_PARENT, 1.0f, Animation.RELATIVE_TO_PARENT,
                        -1.0f, Animation.RELATIVE_TO_PARENT, 1.0f);
                translateAnimation.setDuration(2000);
                translateAnimation.setRepeatCount(-1);
                translateAnimation.setStartOffset(100);
                image.startAnimation(translateAnimation);

                break;
            case R.id.tween_scale:
                //xml实现
               /* Animation rotate2 = AnimationUtils.loadAnimation(this, R.anim.scale_anima);
                image.startAnimation(rotate2);*/

                //代码实现
                ScaleAnimation scaleAnimation = new ScaleAnimation(2.0f, 0.1f, 2.0f, 0.2f,
                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation.setDuration(2000);
                scaleAnimation.setRepeatCount(-1);
                scaleAnimation.setRepeatMode(Animation.RESTART);
                scaleAnimation.setStartOffset(1000);
//                scaleAnimation.setStartTime(20000);
                image.startAnimation(scaleAnimation);
                break;
            case R.id.tween_alpha:
                //xml开启动画
               /* Animation rotate2 = AnimationUtils.loadAnimation(this, R.anim.alpha_anima);
                image.startAnimation(rotate2);*/
                //代码实现
                AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1f);
                alphaAnimation.setDuration(1000);
                alphaAnimation.setRepeatCount(-1);
                alphaAnimation.setStartOffset(500);
                image.startAnimation(alphaAnimation);
                break;
            case R.id.tween_all:
                //xml开启动画
              /*  Animation rotate2 = AnimationUtils.loadAnimation(this, R.anim.all_anima);
                image.startAnimation(rotate2);*/

              //代码实现
                AnimationSet set = new AnimationSet(true);
                AlphaAnimation alphaAnimation1 = new AlphaAnimation(0f, 1f);
//                alphaAnimation1.setDuration(1000);
//                alphaAnimation1.setRepeatCount(-1);
//                alphaAnimation1.setStartOffset(500);
                set.addAnimation(alphaAnimation1);

                ScaleAnimation scaleAnimation1 = new ScaleAnimation(2.0f, 0.1f, 2.0f, 0.2f,
                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//                scaleAnimation1.setDuration(2000);
//                scaleAnimation1.setRepeatCount(-1);
//                scaleAnimation1.setRepeatMode(Animation.RESTART);
//                scaleAnimation1.setStartOffset(1000);
                set.addAnimation(scaleAnimation1);

                TranslateAnimation translateAnimation1 = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, -1.0f,
                        Animation.RELATIVE_TO_PARENT, 1.0f, Animation.RELATIVE_TO_PARENT,
                        -1.0f, Animation.RELATIVE_TO_PARENT, 1.0f);
//                translateAnimation1.setDuration(2000);
//                translateAnimation1.setRepeatCount(-1);
//                translateAnimation1.setStartOffset(100);
                set.addAnimation(translateAnimation1);

                RotateAnimation rotateAnimation = new RotateAnimation(0f, 359f,  Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//                rotateAnimation.setDuration(1000);
//                rotateAnimation.setRepeatCount(10);
                set.addAnimation(rotateAnimation);
                set.setDuration(10000);
                set.setStartOffset(1000);
                image.setAnimation(set);
                break;
        }

    }
}
