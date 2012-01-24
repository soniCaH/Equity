package be.khleuven.vanransbeeck.kevin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class EquityHelpActivity extends EquityActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);
		
		WebView webView = (WebView) findViewById(R.id.webView1);
		
		String data = "";
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.help)));
			String line;
			while ((line = br.readLine()) != null) {
				data += line;
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			data = "Failed loading help page!";
		}
		webView.setBackgroundColor(R.color.black);
		webView.loadData(data, "text/html", "UTF-8");
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
