package be.khleuven.vanransbeeck.kevin;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
	    
	    TabSpec tabAsia = tabHost.newTabSpec("asia");
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
			getS(R.string.language_en_gb),
			getS(R.string.language_fr_fr),
			getS(R.string.language_de_de),
			getS(R.string.language_ca),
			getS(R.string.language_de_at),
			getS(R.string.language_nl_be),
			getS(R.string.language_fr_be),
			getS(R.string.language_bg),
			getS(R.string.language_es_ca),
			getS(R.string.language_cs),
			getS(R.string.language_da_dk),
			getS(R.string.language_et),
			getS(R.string.language_fi_fi),
			getS(R.string.language_el),
			getS(R.string.language_hu),
			getS(R.string.language_it_it),
			getS(R.string.language_lv),
			getS(R.string.language_de_li),
			getS(R.string.language_lt),
			getS(R.string.language_de_lu),
			getS(R.string.language_fr_lu),
			getS(R.string.language_nl_nl),
			getS(R.string.language_nb_no),
			getS(R.string.language_pl_pl),
			getS(R.string.language_pt_pt),
			getS(R.string.language_ro),
			getS(R.string.language_ru_ru),
			getS(R.string.language_sk),
			getS(R.string.language_sl),
			getS(R.string.language_es_es),
			getS(R.string.language_sv),
			getS(R.string.language_de_ch),
			getS(R.string.language_it_ch),
			getS(R.string.language_tr_tr),
			getS(R.string.language_uk),
		}; 
		String[] langCodes = {
				"en-gb", "fr-fr", "de-de", "ca", "de-at", "nl-be", "fr-be", "bg", "es-ca", "cs", "da-dk", "et", "fi-fi",
				"el", "hu", "it-it", "lv", "de-li", "lt", "de-lu", "fr-lu", "nl-nl", "nb-no", "pl-pl", "pt-pt",
				"ro", "ru-ru", "sk", "sl", "es-es", "sv", "de-ch", "it-ch", "tr-tr", "uk",
		};
		Drawable[] flags = {
			getD(R.drawable.gb),
			getD(R.drawable.fr),
			getD(R.drawable.de),
			getD(R.drawable.ad),
			getD(R.drawable.at),
			getD(R.drawable.be),
			getD(R.drawable.be),
			getD(R.drawable.bg),
			getD(R.drawable.catalonia),
			getD(R.drawable.cz),
			getD(R.drawable.dk),
			getD(R.drawable.ee),
			getD(R.drawable.fi),
			getD(R.drawable.gr),
			getD(R.drawable.hu),
			getD(R.drawable.it),
			getD(R.drawable.lv),
			getD(R.drawable.li),
			getD(R.drawable.lt),
			getD(R.drawable.lu),
			getD(R.drawable.lu),
			getD(R.drawable.nl),
			getD(R.drawable.no),
			getD(R.drawable.pl),
			getD(R.drawable.pt),
			getD(R.drawable.ro),
			getD(R.drawable.ru),
			getD(R.drawable.sk),
			getD(R.drawable.si),
			getD(R.drawable.es),
			getD(R.drawable.se),
			getD(R.drawable.ch),
			getD(R.drawable.ch),
			getD(R.drawable.tr),
			getD(R.drawable.ua),
		};
		
		LanguageAdapter adapt = new LanguageAdapter(this, items, flags, langCodes);
		europeList.setAdapter(adapt);
		
		// onclicklistener;
		europeList.setOnItemClickListener(new LanguageItemListener(europeList));
	}
	private void setupNorthAmerica() {
		final ListView northamericaList = (ListView) findViewById(R.id.ListView_NorthAmerica);
		String[] items = {
			getS(R.string.language_en_us),
			getS(R.string.language_en_ca),
			getS(R.string.language_fr_ca),
		}; 
		String[] langCode = {
			"en-us", "en-ca", "fr-ca",
		};
		Drawable[] flags = {
			getD(R.drawable.us),
			getD(R.drawable.ca),
			getD(R.drawable.ca),
		};
		
		LanguageAdapter adapt = new LanguageAdapter(this, items, flags, langCode);
		northamericaList.setAdapter(adapt);
		
		// onclicklistener
		northamericaList.setOnItemClickListener(new LanguageItemListener(northamericaList));
	}
	private void setupSouthAmerica() {
		final ListView southamericaList = (ListView) findViewById(R.id.ListView_SouthAmerica);
		String[] items = {
			getS(R.string.language_es_ar),
			getS(R.string.language_es_bo),
			getS(R.string.language_pt_br),
			getS(R.string.language_es_co),
			getS(R.string.language_ht),
			getS(R.string.language_es_ec),
			getS(R.string.language_es_mx),
			getS(R.string.language_es_py),
			getS(R.string.language_es_pa),
			getS(R.string.language_es_pr),
			getS(R.string.language_es_pe),
			getS(R.string.language_es_uy),
			getS(R.string.language_es_ve),
		}; 
		String[] langCode = {
			"es-ar", "es-bo", "pt-br", "es-co", "ht", "es-ec", "es-mx", "ex-py", "es-pa", "es-pr", "es-pe", 
			"es-uy", "es-ve",
		};
		Drawable[] flags = {
			getD(R.drawable.ar),
			getD(R.drawable.bo),
			getD(R.drawable.br),
			getD(R.drawable.co),
			getD(R.drawable.ht),
			getD(R.drawable.ec),
			getD(R.drawable.mx),
			getD(R.drawable.py),
			getD(R.drawable.pa),
			getD(R.drawable.pr),
			getD(R.drawable.pe),
			getD(R.drawable.uy),
			getD(R.drawable.ve),
		};
		
		LanguageAdapter adapt = new LanguageAdapter(this, items, flags, langCode);
		southamericaList.setAdapter(adapt);
		
		// onclicklistener		
		southamericaList.setOnItemClickListener(new LanguageItemListener(southamericaList));
	}
	private void setupOceania() {
		final ListView oceaniaList = (ListView) findViewById(R.id.ListView_Oceania);
		String[] items = {
			getS(R.string.language_en_au),
		}; 
		String[] langCode = {
			"en-au",	
		};
		Drawable[] flags = {
			getD(R.drawable.au),
		};
		
		LanguageAdapter adapt = new LanguageAdapter(this, items, flags, langCode);
		oceaniaList.setAdapter(adapt);
		
		// onclicklistener
		oceaniaList.setOnItemClickListener(new LanguageItemListener(oceaniaList));
	}
	private void setupAfrica() {
		final ListView africaList = (ListView) findViewById(R.id.ListView_Africa);
		String[] items = {
			getS(R.string.language_he),
			getS(R.string.language_ar),
			getS(R.string.language_ar_eg),
			getS(R.string.language_ar_ly),
			getS(R.string.language_ar_ma),
			getS(R.string.language_ar_tn),
		}; 
		String[] langCode = {
				"he", "ar", "ar-eg", "ar-ly", "ar-ma", "ar-tn",
		};
		Drawable[] flags = {
			getD(R.drawable.al),
			getD(R.drawable.al),
			getD(R.drawable.eg),
			getD(R.drawable.ly),
			getD(R.drawable.ma),
			getD(R.drawable.tn),
		};
		
		LanguageAdapter adapt = new LanguageAdapter(this, items, flags, langCode);
		africaList.setAdapter(adapt);
		
		// onclicklistener
		africaList.setOnItemClickListener(new LanguageItemListener(africaList));
	}
	private void setupAsia() {
		final ListView asiaList = (ListView) findViewById(R.id.ListView_Asia);
		String[] items = {
			getS(R.string.language_ar_bh),
			getS(R.string.language_zh_CHS),
			getS(R.string.language_zh_CHT),
			getS(R.string.language_zh_cn),
			getS(R.string.language_zh_hk),
			getS(R.string.language_ar_lb),
			getS(R.string.language_id),
			getS(R.string.language_hi),
			getS(R.string.language_en_in),
			getS(R.string.language_ar),
			getS(R.string.language_he),
			getS(R.string.language_ja_jp),
			getS(R.string.language_ko_kr),
			getS(R.string.language_ko_kr),
			getS(R.string.language_hi),
			getS(R.string.language_ar_qa),
		}; 
		String[] langCode = {
			"ar-bh", "zh-CHS", "zh-CHT", "zh-cn", "zh-hk", "ar-lb", "id", "hi", "en-in",
			"ar", "he", "ja-jp", "ko-kr", "ko-kr", "hi", "ar-qa",
		};
		Drawable[] flags = {
			getD(R.drawable.bh),
			getD(R.drawable.cn),
			getD(R.drawable.cn),
			getD(R.drawable.cn),
			getD(R.drawable.hk),
			getD(R.drawable.lb),
			getD(R.drawable.id),
			getD(R.drawable.in),
			getD(R.drawable.in),
			getD(R.drawable.il),
			getD(R.drawable.il),
			getD(R.drawable.jp),
			getD(R.drawable.kr),
			getD(R.drawable.kp),
			getD(R.drawable.pk),
			getD(R.drawable.qa),
		};
		
		LanguageAdapter adapt = new LanguageAdapter(this, items, flags, langCode);
		asiaList.setAdapter(adapt);
		
		// onclicklistener
		asiaList.setOnItemClickListener(new LanguageItemListener(asiaList));
	}
	private String getS(int i) {
		return getResources().getString(i);
	}
	private Drawable getD(int i) {
		return getResources().getDrawable(i);
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
