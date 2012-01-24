package be.khleuven.vanransbeeck.kevin;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

public class EquityTranslateActivity extends EquityActivity {
	String langCode;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.translate);
		
		
		Intent callingIntent = getIntent();
		langCode = callingIntent.getStringExtra("langCode");
	}
	
	public void startTextTranslation(final View clickedView) {
		int id = clickedView.getId();
		String baseURL = "http://kevin.van-ransbeeck.be/equity/";
		String file = "";
		
		if(id == R.id.translate_food1)
			file = "food_1.html";
		else if(id == R.id.translate_food2)
			file = "food_2.html";
		else if(id == R.id.translate_physical1)
			file = "phy_1.html";
		else if(id == R.id.translate_physical2)
			file = "phy_2.html";
		else if(id == R.id.translate_physical3)
			file = "phy_3.html";
		
		Intent intent = new Intent(EquityTranslateActivity.this, EquityTranslateTextActivity.class);
		intent.putExtra("langCode", langCode);
		intent.putExtra("textFile", baseURL + file);
		
		startActivity(intent);
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
