package web.aprendiendola.dictionaryweb.aprendiendola.dictionary.DiccionarioDeJava;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import net.java.html.boot.BrowserBuilder;
import web.aprendiendola.dictionaryweb.aprendiendola.dictionary.DiccionarioDeJava.js.Dialogs;

public final class Main {
    private Main() {
    }
    
    public static void main(String... args) throws Exception {
        BrowserBuilder.newBrowser().
            loadPage("pages/index.html").
                locale(Locale.getDefault()).
               //                locale(new Locale("ES")). //uncomment to try certain locale
            loadClass(Main.class).
            invoke("onPageLoad", args).
            showAndWait();
        System.exit(0);
    }

    /**
     * Called when the page is ready.
     */
    public static void onPageLoad() throws Exception {
    Dictionary model=new Dictionary(java.util.ResourceBundle.getBundle("web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe").getString("HELLOWORLD"),java.util.ResourceBundle.getBundle("web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe").getString("CLICKTOSEARCH"),"","");
        List<String> termList = model.getTermList();
        termList.add(java.util.ResourceBundle.getBundle("web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe").getString("HELLOWORLD"));
        termList.add(java.util.ResourceBundle.getBundle("web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe").getString("JAVA"));
        List<String> definitionList = model.getDefinitionList();
        definitionList.addAll(Arrays.asList(java.util.ResourceBundle.getBundle("web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe").getString("HELLOWORLD_INFO"),java.util.ResourceBundle.getBundle("web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe").getString("JAVA_INFO")));
        List<String> examplesList = model.getExampleCodeList();
        examplesList.add(java.util.ResourceBundle.getBundle("web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe").getString("HELLOWORLD_CODE"));
        examplesList.add(java.util.ResourceBundle.getBundle("web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe").getString("JAVA_CODE"));
    model.applyBindings();
    Dialogs.screenSize();
    }
    
}
