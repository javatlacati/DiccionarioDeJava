package org.javapro.jdictionary;

import java.util.Locale;
import net.java.html.boot.BrowserBuilder;

public final class Main {
    
   
    
    private Main() {
    }

    public static void main(String... args) throws Exception {
        BrowserBuilder.newBrowser().
            loadPage("pages/index.html").
            locale(Locale.getDefault()).
            loadClass(Main.class).
            invoke("onPageLoad", args).
            showAndWait();
        System.exit(0);
    }
    
    


    public static void onPageLoad() throws Exception {
        // don't put "common" initialization stuff here, other platforms (iOS, Android, Bck2Brwsr) may not call this method. They rather call DataModel.onPageLoad
        DataModel.onPageLoad();
        
    }

}
