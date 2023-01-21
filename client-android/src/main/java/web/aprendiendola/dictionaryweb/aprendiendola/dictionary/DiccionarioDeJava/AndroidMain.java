package web.aprendiendola.dictionaryweb.aprendiendola.dictionary.DiccionarioDeJava;

import android.app.Activity;
import android.os.Bundle;

/**
 *
 * @author javatlacati, monacotoni
 */
public class AndroidMain 
        extends Activity 
{

//    private InterstitialAd mInterstitialAd;
//    private Handler mHandler;       // Handler to display the ad on the UI thread
//    private Runnable displayAd;     // Code to execute to perform this operation

    public AndroidMain() {

    }

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        mInterstitialAd = new InterstitialAd(this);
//        mInterstitialAd.setAdUnitId("ca-app-pub-4207300711287771/3403503227");
//        AdView adView = new AdView(getBaseContext());//(AdView) this.findViewById(R.id.adView);
//        adView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//        adView.setAdSize(AdSize.BANNER);
//        adView.setAdUnitId("ca-app-pub-4207300711287771/3403503227");
//        //adView.setId(50);
//        AdRequest adRequest = new AdRequest.Builder()
//                // Add a test device to show Test Ads
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
//                .addTestDevice("jhkjh")
//                .build();
//
//        // Load ads into Banner Ads
//        adView.loadAd(adRequest);
//
//        // Load ads into Interstitial Ads
//        mInterstitialAd.loadAd(adRequest);
//
//        // Prepare an Interstitial Ad Listener
//        mInterstitialAd.setAdListener(new AdListener() {
//            @Override
//            public void onAdLoaded() {
//                // Call displayInterstitial() function
//                displayInterstitial();
//            }
//        });
//        // delegate to original activity
//        startActivity(new Intent(getApplicationContext(),
//                com.dukescript.presenters.Android.class));
//
//        finish();
    }

    /**
     *
     */
    public void displayInterstitial() {
        // If Ads are loaded, show Interstitial else show nothing.
//        if (mInterstitialAd.isLoaded()) {
//            mInterstitialAd.show();
//        }
    }

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(final String... args) throws Exception {
//        Main.onPageLoad();
    }

}
