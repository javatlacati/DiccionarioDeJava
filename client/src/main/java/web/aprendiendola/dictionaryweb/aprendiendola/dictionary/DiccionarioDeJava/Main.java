package web.aprendiendola.dictionaryweb.aprendiendola.dictionary.DiccionarioDeJava;

import java.util.Arrays;
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

    private static void addTermsToTermList(List<String> termList,
            final String... terms) {
        for (String term : terms) {
            termList.add(ResourceBundle.getBundle(BUNDLE_PATH).getString(term));
        }
        //termList.addAll(Arrays.asList(terms));
    }

    private static void addTermsToDefinitionsList(List<String> definitionsList,
            final String... terms) {
        for (String term : terms) {
            definitionsList.add(getStringFromBundle(term + "_INFO")
            );
        }
    }

    private static void addTermsToExamplesList(List<String> definitionsList,
            final String... terms) {
        for (String term : terms) {
            definitionsList.add(getStringFromBundle(term + "_CODE"));
        }
    }

    private static void addTerms(final List<String> termList,
            final List<String> definitionList,
            final List<String> examplesList, final String... terms) {
        Arrays.sort(terms);
        addTermsToTermList(termList, terms);
        addTermsToDefinitionsList(definitionList, terms);
        addTermsToExamplesList(examplesList, terms);
    }

    private static String getStringFromBundle(final String nombre) {
//        String internacionalizado = nombre;
//        try {
//            internacionalizado = new String(
//                    ResourceBundle.getBundle(BUNDLE_PATH)
//                    .getString(nombre).getBytes(),
//                    "UTF-8"
//            );
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return internacionalizado;
        return ResourceBundle.getBundle(BUNDLE_PATH).getString(nombre);
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
     */
    public static void onPageLoad() {
        Dictionary model;
        model = new Dictionary(getStringFromBundle("HELLOWORLD"),
                getStringFromBundle("CLICKTOSEARCH"),
                "", "");
        List<String> termList = model.getTermList();
        List<String> definitionsList = model.getDefinitionList();
        List<String> examplesList = model.getExampleCodeList();
        addTerms(termList, definitionsList, examplesList,
                "HELLOWORLD", "JAVA", "CLASS", "VARIABLE", "PACKAGE_INFO",
                "CYCLOMATIC_COMPLEXITY", "CONSTRUCTOR", "METHOD",
                "ATTRIBUTE");
        try {
            model.applyBindings();
        } catch (Exception e) {
        }
        Dialogs.screenSize();
    }

}
