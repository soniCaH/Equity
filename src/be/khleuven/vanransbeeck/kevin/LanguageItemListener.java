package be.khleuven.vanransbeeck.kevin;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class LanguageItemListener implements AdapterView.OnItemClickListener {
	ListView listView;
	String countryText;
	String flag;
	
	public LanguageItemListener(ListView list) {
		listView = list;
	}
	public void onItemClick(AdapterView<?> parent, 
							View itemClicked, int position, long id) {
		 countryText = listView.getItemAtPosition(position).toString();
		 String flagLabel = ((TextView) itemClicked.findViewById(R.id.language_label)).getText().toString();
		 String langCode  = ((TextView) itemClicked.findViewById(R.id.language_code)).getText().toString();
		 
		 int flagID = itemClicked.getResources().getIdentifier("be.khleuven.vanransbeeck.kevin:drawable/"+flagLabel.getText(), null, null);
		 
		 flag = getBingLangCode(flagID);
		 
		 Intent intent = new Intent(itemClicked.getContext(), EquityTranslateActivity.class);
		 intent.putExtra("langCode", flag);
		 //@TODO: save/preferences??
		 itemClicked.getContext().startActivity(intent);
	}
	
	private String getBingLangCode(int flagID) {
		String flag = "";
		switch(flagID) {
			 // EUROPE
			 case R.string.language_en_gb:
				 flag = "en-gb"; break;
			 case R.string.language_de_de:
				 flag = "de-de"; break;
			 case R.string.language_fr_fr:
				 flag = "fr-fr"; break;
			 case R.string.language_al:
				 flag = "al"; break;
			 case R.string.language_ca:
				 flag = "ca"; break;
			 case R.string.language_de_at:
				 flag = "de_at"; break;
			 case R.string.language_az:
				 flag = "az"; break;
			 case R.string.language_be:
				 flag = "be"; break;
			 case R.string.language_nl_be:
				 flag = "nl-be"; break;
			 case R.string.language_fr_be:
				 flag = "fr-be"; break;
			 case R.string.language_bg:
				 flag = "bg"; break;
			 case R.string.language_es_ca:
				 flag = "es-ca"; break;
			 case R.string.language_cs:
				 flag = "cs"; break;
			 case R.string.language_da_dk:
				 flag = "da-dk"; break;
			 case R.string.language_et:
				 flag = "et"; break;
			 case R.string.language_fi_fi:
				 flag = "fi-fi"; break;
			 case R.string.language_el:
				 flag = "el"; break;
			 case R.string.language_hu:
				 flag = "hu"; break;
			 case R.string.language_it_it:
				 flag = "it-it"; break;
			 case R.string.language_lv:
				 flag = "lv"; break;
			 case R.string.language_de_li:
				 flag = "de-li"; break;
			 case R.string.language_lt:
				 flag = "lt"; break;
			 case R.string.language_de_lu:
				 flag = "de-lu"; break;
			 case R.string.language_fr_lu:
				 flag = "fr-lu"; break;
			 case R.string.language_nl_nl:
				 flag = "nl-nl"; break;
			 case R.string.language_nb_no:
				 flag = "nb-no"; break;
			 case R.string.language_pl_pl:
				 flag = "pl-pl"; break;
			 case R.string.language_pt_pt:
				 flag = "pt-pt"; break;
			 case R.string.language_ro:
				 flag = "ro"; break;
			 case R.string.language_ru_ru:
				 flag = "ru-ru"; break;
			 case R.string.language_sk:
				 flag = "sk"; break;
			 case R.string.language_sl:
				 flag = "sl"; break;
			 case R.string.language_es_es:
				 flag = "es-es"; break;
			 case R.string.language_sv:
				 flag = "sv"; break;
			 case R.string.language_de_ch:
				 flag = "de-ch"; break;
			 case R.string.language_it_ch:
				 flag = "it-ch"; break;
			 case R.string.language_tr_tr:
				 flag = "tr-tr"; break;
			 case R.string.language_uk:
				 flag = "uk"; break;
				 
			 //NORTH AMERICA
			 case R.string.language_en_us:
				 flag = "en-us"; break;
			 case R.string.language_en_ca:
				 flag = "en-ca"; break;
			 case R.string.language_fr_ca:
				 flag = "fr-ca"; break;
				 
			 //SOUTH AMERICA
			 case R.string.language_es_ar:
				 flag = "es-ar"; break;
			 case R.string.language_es_bo:
				 flag = "es-bo"; break;
			 case R.string.language_pt_br:
				 flag = "pt-br"; break;
			 case R.string.language_es_co:
				 flag = "es-co"; break;
			 case R.string.language_ht:
				 flag = "ht"; break;
			 case R.string.language_es_ec:
				 flag = "es-ec"; break;
			 case R.string.language_es_mx:
				 flag = "es-mx"; break;
			 case R.string.language_es_py:
				 flag = "es-py"; break;
			 case R.string.language_es_pa:
				 flag = "es-pa"; break;
			 case R.string.language_es_pr:
				 flag = "es-pr"; break;
			 case R.string.language_es_pe:
				 flag = "es-pe"; break;
			 case R.string.language_es_uy:
				 flag = "es-uy"; break;
			 case R.string.language_es_ve:
				 flag = "es-ve"; break;
				 
			 // OCEANIA
			 case R.string.language_en_au:
				 flag = "en-au"; break;
				 
			 // AFRICA
			 case R.string.language_af:
				 flag = "af"; break;
			 case R.string.language_he:
				 flag = "he"; break;
			 case R.string.language_ar:
				 flag = "ar"; break;
			 case R.string.language_ar_eg:
				 flag = "ar_eg"; break;
			 case R.string.language_ar_ly:
				 flag = "ar_ly"; break;
			 case R.string.language_ar_ma:
				 flag = "ar_ma"; break;
			 case R.string.language_ar_tn:
				 flag = "ar_tn"; break;
				 
			 // ASIA
			 case R.string.language_ar_bh:
				 flag = "ar-bh"; break;
			 case R.string.language_zh_CHS:
				 flag = "zh-CHS"; break;
			 case R.string.language_zh_CHT:
				 flag = "zh-CHT"; break;
			 case R.string.language_zh_cn:
				 flag = "zh-cn"; break;
			 case R.string.language_zh_hk:
				 flag = "zh-hk"; break;
			 case R.string.language_zh_tw:
				 flag = "zh-tw"; break;
			 case R.string.language_ar_lb:
				 flag = "ar-lb"; break;
			 case R.string.language_id:
				 flag = "id"; break;
			 case R.string.language_hi:
				 flag = "hi"; break;
			 case R.string.language_en_in:
				 flag = "en-in"; break;
			 case R.string.language_ja_jp:
				 flag = "ja-jp"; break;
			 case R.string.language_ko_kr:
				 flag = "ko-kr"; break;
			 case R.string.language_ar_qa:
				 flag = "ar-qa"; break;
				 
			 default: flag = "";
			 }
		return flag;
	}

}
