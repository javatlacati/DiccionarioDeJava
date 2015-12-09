package web.aprendiendola.dictionaryweb.aprendiendola.dictionary.DiccionarioDeJava;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.java.html.boot.BrowserBuilder;
import web.aprendiendola.dictionaryweb.aprendiendola.dictionary.DiccionarioDeJava.js.Dialogs;

/**
 * Class that configures the model and binds the HTML view with the data.
 *
 * @author javatlacati
 */
public final class Main {

    /**
     * Empty constructor, since no prerequisites are needed.
     */
    private Main() {
    }

    /**
     * Configuration entry point.
     *
     * @param args arguments
     */
    public static void main(final String... args) {
        try {
            BrowserBuilder.newBrowser().
                    loadPage("pages/index.html").
                    locale(Locale.getDefault()).
                    //locale(new Locale("ES")).//uncomment to try certain locale
                    loadClass(Main.class).
                    invoke("onPageLoad", args).
                    showAndWait();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, e.getMessage());
        }
        System.exit(0);
    }

    /**
     * Called when the page is ready.
     *
     * @throws java.lang.Exception
     */
    public static void onPageLoad() throws Exception {
        Dictionary model = new Dictionary(java.util.ResourceBundle.getBundle("web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe").getString("HELLOWORLD"), java.util.ResourceBundle.getBundle("web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe").getString("CLICKTOSEARCH"), "", "");
        List<String> termList = model.getTermList();
        termList.add(java.util.ResourceBundle.getBundle("web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe").getString("HELLOWORLD"));
        termList.add(java.util.ResourceBundle.getBundle("web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe").getString("JAVA"));
        termList.add(java.util.ResourceBundle.getBundle("web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe").getString("CLASS"));
        termList.add(java.util.ResourceBundle.getBundle("web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe").getString("VARIABLE"));
        termList.add(java.util.ResourceBundle.getBundle("web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe").getString("PACKAGE_INFO"));

        List<String> definitionList = model.getDefinitionList();
        definitionList.addAll(Arrays.asList(
                java.util.ResourceBundle.getBundle("web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe").
                        getString("HELLOWORLD_INFO"),
                java.util.ResourceBundle.getBundle("web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe").
                        getString("JAVA_INFO"),
                java.util.ResourceBundle.getBundle("web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe").
                        getString("CLASS_INFO"),
                java.util.ResourceBundle.getBundle("web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe").
                        getString("VARIABLE_INFO"),
                java.util.ResourceBundle.getBundle("web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe").
                        getString("PACKAGE_INFO_INFO"))
        );

        List<String> examplesList = model.getExampleCodeList();
        examplesList.add(java.util.ResourceBundle.getBundle("web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe").getString("HELLOWORLD_CODE"));
        examplesList.add(java.util.ResourceBundle.getBundle("web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe").getString("JAVA_CODE"));
        examplesList.add(java.util.ResourceBundle.getBundle("web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe").getString("CLASS_CODE"));
        examplesList.add(java.util.ResourceBundle.getBundle("web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe").getString("VARIABLE_CODE"));
        examplesList.add(java.util.ResourceBundle.getBundle("web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe").getString("PACKAGE_INFO_CODE"));
        model.applyBindings();
        Dialogs.screenSize();
    }

}
