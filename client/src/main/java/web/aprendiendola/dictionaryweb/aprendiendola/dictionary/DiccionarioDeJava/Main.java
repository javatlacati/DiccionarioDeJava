package web.aprendiendola.dictionaryweb.aprendiendola.dictionary.DiccionarioDeJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.java.html.boot.BrowserBuilder;
import java.util.ResourceBundle;
import web.aprendiendola.dictionaryweb.aprendiendola.dictionary.DiccionarioDeJava.js.Dialogs;

/**
 * Class that configures the model and binds the HTML view with the data.
 *
 * @author javatlacati
 */
public final class Main {

    private static final String BUNDLE_PATH
            = "web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe";

    private static void addTermsToTermList(List<String> termList, final String... terms) {
        for (String term : terms) {
            termList.add(ResourceBundle.getBundle(BUNDLE_PATH).getString(term));
        }
        //termList.addAll(Arrays.asList(terms));
    }

    private static void addTermsToDefinitionsList(List<String> definitionsList,
            final String... terms) {
        for (String term : terms) {
            definitionsList.add(ResourceBundle.getBundle(BUNDLE_PATH).getString(term + "_INFO"));
        }
    }

    private static void addTermsToExamplesList(List<String> definitionsList,
            final String... terms) {
        for (String term : terms) {
            definitionsList.add(ResourceBundle.getBundle(BUNDLE_PATH).getString(term + "_CODE"));
        }
    }

    private static void addTerms(List<String> termList,
            List<String> definitionList,
            List<String> examplesList, final String... terms) {
        addTermsToTermList(termList, terms);
        addTermsToDefinitionsList(definitionList, terms);
        addTermsToExamplesList(examplesList, terms);
    }

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
        Dictionary model = new Dictionary(
                ResourceBundle.getBundle(BUNDLE_PATH)
                .getString("HELLOWORLD"),
                ResourceBundle.getBundle(BUNDLE_PATH)
                .getString("CLICKTOSEARCH"),
                "", "");
        List<String> termList = model.getTermList();
        List<String> definitionsList = model.getDefinitionList();
        List<String> examplesList = model.getExampleCodeList();
        addTerms(termList, definitionsList, examplesList,
                "HELLOWORLD", "JAVA", "CLASS", "VARIABLE", "PACKAGE_INFO");
        model.applyBindings();
        Dialogs.screenSize();
    }

}
