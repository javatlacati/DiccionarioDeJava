package web.aprendiendola.dictionaryweb.aprendiendola.dictionary.DiccionarioDeJava;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class AndroidMain extends Activity {

    public AndroidMain() {
//        try {
//            Main.onPageLoad();
//        } catch (Exception ex) {
//            Logger.getLogger(AndroidMain.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    //private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // obtain information you need
        //
        //SharedPreferences prefs = getApplicationContext().getSharedPreferences("karel.prefs", 0);
        //new AndroidStorage(prefs);
        //mInterstitialAd = new InterstitialAd(this,
        //        "ca-app-pub-4207300711287771/3403503227");
    //    AdView mAdView = new AdView(this, AdSize.BANNER, "");
        //    AdRequest adRequest = new AdRequest();
        //adRequest.Builder().build();
        //   mAdView.loadAd(adRequest);
         //mInterstitialAd.setAdUnitId("ca-app-pub-99999999999999999/9999999999");
        // delegate to original activity
        startActivity(new Intent(getApplicationContext(),
                com.dukescript.presenters.Android.class));

        finish();
    }

    public static void main(String... args) throws Exception {
        Main.onPageLoad();
    }
}
