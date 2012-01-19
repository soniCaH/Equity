package be.khleuven.vanransbeeck.kevin;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class EquitySplashActivity extends EquityActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		Animation fade_in = AnimationUtils.loadAnimation(this, R.anim.fade_in);
		Animation fade_in2 = AnimationUtils.loadAnimation(this, R.anim.fade_in2);
		Animation fade_in3 = AnimationUtils.loadAnimation(this, R.anim.fade_in3);


		ImageView imageView = (ImageView)findViewById(R.id.imageView1);
		imageView.startAnimation(fade_in2);
		
		TextView titleText = (TextView)findViewById(R.id.textView1);
		titleText.startAnimation(fade_in);
		
		TextView versionText = (TextView)findViewById(R.id.textView2);
		versionText.startAnimation(fade_in3);
		
		fade_in3.setAnimationListener(new AnimationListener() {
			public void onAnimationEnd(Animation animation) {
				startActivity(new Intent(EquitySplashActivity.this, EquityMenuActivity.class));
				EquitySplashActivity.this.finish();
			}

			public void onAnimationRepeat(Animation animation) { }
			public void onAnimationStart(Animation animation)  { }
		});
	}

	@Override
	protected void onDestroy() {
		ImageView imageView = (ImageView)findViewById(R.id.imageView1);
		TextView titleText = (TextView)findViewById(R.id.textView1);
		TextView versionText = (TextView)findViewById(R.id.textView2);
		imageView.clearAnimation(); titleText.clearAnimation(); versionText.clearAnimation();
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		ImageView imageView = (ImageView)findViewById(R.id.imageView1);
		TextView titleText = (TextView)findViewById(R.id.textView1);
		TextView versionText = (TextView)findViewById(R.id.textView2);
		imageView.clearAnimation(); titleText.clearAnimation(); versionText.clearAnimation();
		super.onPause();
	}

	@Override
	protected void onStop() {
		ImageView imageView = (ImageView)findViewById(R.id.imageView1);
		TextView titleText = (TextView)findViewById(R.id.textView1);
		TextView versionText = (TextView)findViewById(R.id.textView2);
		imageView.clearAnimation(); titleText.clearAnimation(); versionText.clearAnimation();
		super.onStop();
	}
	
	
}
