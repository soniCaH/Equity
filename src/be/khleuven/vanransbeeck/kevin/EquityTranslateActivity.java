package be.khleuven.vanransbeeck.kevin;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.memetix.mst.translate.Translate;

public class EquityTranslateActivity extends EquityActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.translate);
		
		Intent callingIntent = getIntent();
		String langCode = callingIntent.getStringExtra("langCode");
		
		TextView tv = (TextView) findViewById(R.id.textView1);
		
	    Translate.setKey("F201136C4151E60657AFB717096F87C70F45EF30");

//		try {
//			String translatedText = Translate.execute("Hello World", "en-us", langCode);
//			tv.setText(translatedText);
//		} catch (Exception e) {
//			tv.setText("Unable to contact translation server");
//		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.eqoptions, menu);
		menu.findItem(R.id.help_menu_item).setIntent(new Intent(this, EquityHelpActivity.class));
		menu.findItem(R.id.settings_menu_item).setIntent(new Intent(this, EquitySettingsActivity.class));
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		startActivity(item.getIntent());
		return true;
	}
	
	
	
	
}
