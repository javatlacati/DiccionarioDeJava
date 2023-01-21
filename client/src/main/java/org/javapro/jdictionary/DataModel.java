package org.javapro.jdictionary;

import java.io.Closeable;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import net.java.html.json.ComputedProperty;
import net.java.html.json.Function;
import net.java.html.json.Model;
import net.java.html.json.Property;
import net.java.html.json.Models;
import org.javapro.jdictionary.js.Dialogs;
import org.javapro.jdictionary.js.TemplateRegistration;
/** Model annotation generates class Data with
 * one message property, boolean property and read only words property
 */
@Model(className = "Dictionary", targetId = "", properties
        = {
            @Property(name = "template", type = String.class),
            @Property(name = "searchPhrase", type = String.class),
            @Property(name = "foundPhrase", type = String.class),
            @Property(name = "description", type = String.class),
            @Property(name = "code", type = String.class),
            @Property(name = "termList", type = String.class, array = true),
            @Property(name = "definitionList", type = String.class,
                    array = true),
            @Property(name = "exampleCodeList", type = String.class,
                    array = true)
        })
final class DataModel {
    
    private static final String BUNDLE_PATH
            = "TranslateMe";
    
    private static Dictionary ui;
    
//    private static Closeable wordIndex;
//    private static Closeable definition;
    /**
     * Determines if a word search can be performed.
     *
     * @param searchPhrase the user entered search phrase. Must not be null.
     * @return true if the phrase exists and is not empty
     * @see #changeSP(Dictionary, String)
     */
    @ComputedProperty
    public static boolean canSearch(final String searchPhrase) {
        return searchPhrase != null && searchPhrase.length() > 0;
    }

    /**
     * Changes the found phrase in the model.
     *
     * @param model data model
     */
    @Function
    public static void changeFP(final Dictionary model) {
        final String searchP = model.getSearchPhrase();
        if (!"".equals(searchP)) {
            final List<String> listOfTerms = model.getTermList();
            for (int i = 0; i < listOfTerms.size(); i++) {
                final String term = listOfTerms.get(i);
                if (stringsAreEqual(term, searchP)) {
                    model.setFoundPhrase(term);
                    model.setDescription(model.getDefinitionList().get(i));
                    model.setCode(model.getExampleCodeList().get(i));
                    if (Dialogs.idExists("dynamic")) {
                        Models.applyBindings(model, "dynamic");
                    }
                    return;
                }
            }
        }
        model.setDescription("");
        model.setCode("");
        model.setFoundPhrase(
                ResourceBundle.getBundle(
                        "TranslateMe"
                //        , Locale.getDefault()
                //  ,new Locale("ES")
                ).getString("NOTFOUND"));
    }

    /**
     * Changes the value of the search phrase in the model.
     *
     * @param data The search phrase
     * @param model data model
     */
    @Function
    public static void changeSP(Dictionary model, final String data) {
        if (!"".equals(data)) {
            model.setSearchPhrase(data);
            changeFP(model);
        }
    }

    /**
     * Determines if search phrase is contained into the term. This method
     * matches any kind of letter from any language to compare.
     *
     * @param term dictionary term
     * @param searchP Search phrase
     * @return If the search phrase is contained into the given term
     */
    private static boolean stringsAreEqual(final String term,
            final String searchP) {
        return term.trim().replaceAll(
                "[^\\p{L}]",
                "").toLowerCase().contains(
                        searchP.trim().toLowerCase().replaceAll(
                                "[^\\p{L}]", "")
                );
    }
    
    //i18n
    
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

    @Function
    public static void navigateWordIndex(Dictionary model) {
        model.setTemplate("wordindex");
    }

    @Function
    public static void navigateDefinition(Dictionary model) {
        model.setTemplate("definition");
    }
 /**
     * Called when the page is ready.
     */
    static void onPageLoad() throws Exception {
        ui = new Dictionary("wordindex", getStringFromBundle("HELLOWORLD"), getStringFromBundle("CLICKTOSEARCH"),
                "", "");
        List<String> termList = ui.getTermList();
        List<String> definitionsList = ui.getDefinitionList();
        List<String> examplesList = ui.getExampleCodeList();
        addTerms(termList, definitionsList, examplesList,
                "HELLOWORLD", "JAVA", "CLASS", "VARIABLE", "PACKAGE", "PACKAGE-INFO",
                "CYCLOMATIC_COMPLEXITY", "CONSTRUCTOR", "METHOD", "EXCEPTION",
                "ATTRIBUTE", "JVM");
        Models.toRaw(ui);
//        wordIndex = TemplateRegistration.register("wordindex", "templates/wordindex.html");
//        definition = TemplateRegistration.register("definition", "templates/definition.html");
        ui.setTemplate("wordindex");
        ui.applyBindings();
    }
    
    
}
