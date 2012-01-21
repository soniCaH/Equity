package be.khleuven.vanransbeeck.kevin;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;


public class EquityLanguageActivity extends EquityActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.language);
		
//	    Translate.setKey("F201136C4151E60657AFB717096F87C70F45EF30");
		
		setupTabs();
		setupLanguages();
	}
	
	private void setupTabs() {
		TabHost tabHost = (TabHost) findViewById(R.id.TabHost1);
		tabHost.setup();
		
		TabSpec tabEurope = tabHost.newTabSpec("europe");
		tabEurope.setIndicator(
				getResources().getString(R.string.lang_continent_europe),
				getResources().getDrawable(R.drawable.cont_europe));
	    tabEurope.setContent(R.id.ListView_Europe);
	    
	    tabHost.addTab(tabEurope);
	    
	    TabSpec tabNorthAmerica = tabHost.newTabSpec("northAmerica");
	    tabNorthAmerica.setIndicator(
				getResources().getString(R.string.lang_continent_northamerica),
				getResources().getDrawable(R.drawable.cont_northamerica));
	    tabNorthAmerica.setContent(R.id.ListView_NorthAmerica);
	    
	    tabHost.addTab(tabNorthAmerica);
	    
	    TabSpec tabSouthAmerica = tabHost.newTabSpec("southAmerica");
	    tabSouthAmerica.setIndicator(
				getResources().getString(R.string.lang_continent_southamerica),
				getResources().getDrawable(R.drawable.cont_southamerica));
	    tabSouthAmerica.setContent(R.id.ListView_SouthAmerica);
	    
	    tabHost.addTab(tabSouthAmerica);
	    
	    TabSpec tabAsia = tabHost.newTabSpec("asi");
	    tabAsia.setIndicator(
				getResources().getString(R.string.lang_continent_asia),
				getResources().getDrawable(R.drawable.cont_asia));
	    tabAsia.setContent(R.id.ListView_Asia);
	    
	    tabHost.addTab(tabAsia);
	    
	    TabSpec tabAfrica = tabHost.newTabSpec("africa");
	    tabAfrica.setIndicator(
				getResources().getString(R.string.lang_continent_africa),
				getResources().getDrawable(R.drawable.cont_africa));
	    tabAfrica.setContent(R.id.ListView_Africa);
	    
	    tabHost.addTab(tabAfrica);
	    
	    TabSpec tabOceania = tabHost.newTabSpec("oceania");
	    tabOceania.setIndicator(
				getResources().getString(R.string.lang_continent_oceania),
				getResources().getDrawable(R.drawable.cont_oceania));
	    tabOceania.setContent(R.id.ListView_Oceania);
	    
	    tabHost.addTab(tabOceania);
	    
	    tabHost.setCurrentTabByTag("europe");
	    
	    for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
	        RelativeLayout rl = (RelativeLayout) tabHost.getTabWidget().getChildAt(i);
//	        ImageView imageView = (ImageView) rl.getChildAt(0);
	        TextView textView = (TextView) rl.getChildAt(1);        
	        textView.setTextColor(Color.parseColor("#9e3bc7"));
	    }
	}
	
	private void setupLanguages() {
		setupEurope();
		setupNorthAmerica();
		setupSouthAmerica();
		setupAsia();
		setupOceania();
		setupAfrica();
	}
	private void setupEurope() {
		final ListView europeList = (ListView) findViewById(R.id.ListView_Europe);
		String[] items = {
			getS(R.string.language_al)
		}; 
		Drawable[] flags = {
			getD(R.drawable.al)	
		};
		
		LanguageAdapter adapt = new LanguageAdapter(this, items, flags);
		europeList.setAdapter(adapt);
		
		// onclicklistener;
	}
	private void setupNorthAmerica() {
		
	}
	private void setupSouthAmerica() {
		
	}
	private void setupOceania() {
		
	}
	private void setupAfrica() {
		
	}
	private void setupAsia() {
		
	}
	private String getS(int i) {
		return getResources().getString(i);
	}
	private Drawable getD(int i) {
		return getResources().getDrawable(i);
	}
}
