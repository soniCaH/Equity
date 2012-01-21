package be.khleuven.vanransbeeck.kevin;

import android.os.Bundle;
import android.widget.TextView;

import com.memetix.mst.translate.Translate;


public class EquityLanguageActivity extends EquityActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.language);
	    TextView textView = (TextView) findViewById(R.id.textView7);
		
	    Translate.setKey("F201136C4151E60657AFB717096F87C70F45EF30");
	    
	}
}
