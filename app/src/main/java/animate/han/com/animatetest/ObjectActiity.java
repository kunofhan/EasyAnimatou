package animate.han.com.animatetest;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ObjectActiity extends AppCompatActivity {

    @BindView(R.id.object_translate_scale)
    Button translatetcale;
    @BindView(R.id.object_img)
    ImageView image;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_actiity);

        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @OnClick({R.id.object_translate_scale, R.id.object_img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.object_translate_scale:
               float currentX = image.getTranslationX();
                float currentY = image.getTranslationY();
                /* System.out.println("currentX" + currentX);
                ObjectAnimator translateX = ObjectAnimator.ofFloat(image, "translationX", currentX, currentX + 100);
                translateX.setDuration(1000);
                translateX.start();*/

               /* ObjectAnimator rotate = ObjectAnimator.ofFloat(image, "rotation", 0f, 359f);
                rotate.setDuration(5000);
                rotate.setRepeatCount(-1);
                rotate.start();*/

               //动画集合
//                startMultAnima(currentY,currentX);
               startXmlAnima();
                break;
            case R.id.object_img:
                float x = image.getTranslationX();
                float y = image.getTranslationY();
                Toast.makeText(this, "x:" + x + "  y:" + y, Toast.LENGTH_LONG).show();
                break;
        }
    }

    private void startXmlAnima() {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.anim_file);
        animator.setTarget(image);
        animator.start();
    }

    private void startMultAnima(float currentY, float currentX) {
        ObjectAnimator moveInx = ObjectAnimator.ofFloat(image, "translationX", currentX, currentX+200);
        ObjectAnimator moveIny = ObjectAnimator.ofFloat(image, "translationY", currentY, currentY+50);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(image, "rotation", 0f, 360f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(image, "alpha", 1f, 0f, 1f);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(moveInx,moveIny,rotate,fadeInOut);
        set.setDuration(5000);
        set.start();
    }
}
