package be.khleuven.vanransbeeck.kevin;

import java.util.Map;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;
import com.memetix.mst.detect.Detect;


public class EquityLanguageActivity extends EquityActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.language);
	    TextView textView = (TextView) findViewById(R.id.textView7);
		
	    Translate.setKey("F201136C4151E60657AFB717096F87C70F45EF30");
	    try {
//			String translatedText = Translate.execute("Bonjour le monde", Language.FRENCH, Language.ENGLISH);
//			textView.setText(translatedText);
	    	Map<String,Language> localizedMap = Language.values(Language.FRENCH);
	    	for(String langName : localizedMap.keySet()) {
	            Log.i("Equity", langName + " : " + localizedMap.get(langName).toString());
	        }
		} catch (Exception e) {
			textView.setText("OEPS");
		}
	    
	}
}
