package be.khleuven.vanransbeeck.kevin;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class EquitySplashActivity extends EquityActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		Animation fadeTitle = AnimationUtils.loadAnimation(this, R.anim.fade_in);

		ImageView imageView = (ImageView)findViewById(R.id.imageView1);
		imageView.startAnimation(fadeTitle);
		
		TextView titleLogo = (TextView)findViewById(R.id.textView1);
		TextView versionText = (TextView)findViewById(R.id.textView1);
	}
}
