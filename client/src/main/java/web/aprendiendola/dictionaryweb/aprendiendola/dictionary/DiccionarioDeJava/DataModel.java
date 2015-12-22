package web.aprendiendola.dictionaryweb.aprendiendola.dictionary.DiccionarioDeJava;

import java.util.List;
import java.util.ResourceBundle;
import net.java.html.json.ComputedProperty;
import net.java.html.json.Function;
import net.java.html.json.Model;
import net.java.html.json.Models;
import net.java.html.json.Property;

/**
 * Model annotation generates class Data.
 */
@Model(className = "Dictionary", targetId = "", properties = {
    @Property(name = "searchPhrase", type = String.class),
    @Property(name = "foundPhrase", type = String.class),
    @Property(name = "description", type = String.class),
    @Property(name = "code", type = String.class),
    @Property(name = "termList", type = String.class, array = true),
    @Property(name = "definitionList", type = String.class, array = true),
    @Property(name = "exampleCodeList", type = String.class, array = true)
})

final class DataModel {

    /**
     * Determines if a word search can be performed.
     *
     * @param searchPhrase thse user entered search phrase. Must not be null.
     * @see #changeSP(Dictionary, String)
     */
    @ComputedProperty
    static boolean canSearch(final String searchPhrase) {
        return searchPhrase != null && searchPhrase.length() > 0;
    }

    @Function
    static void changeFP(final Dictionary model) {
        String searchP = model.getSearchPhrase();
        final List<String> listOfTerms = model.getTermList();
        for (int i = 0; i < listOfTerms.size(); i++) {
            final String term = listOfTerms.get(i);
            if (stringsAreEqual(term, searchP)) {
                model.setFoundPhrase(term);
                model.setDescription(model.getDefinitionList().get(i));
                model.setCode(model.getExampleCodeList().get(i));
                try {
                    Models.applyBindings(model, "dynamic");
                } catch (Exception exc) {

                }
                return;
            }
        }
        model.setDescription("");
        model.setCode("");
        model.setFoundPhrase(
                ResourceBundle.getBundle(
                        "web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe"
                //        , Locale.getDefault()
                //  ,new Locale("ES")
                ).getString("NOTFOUND"));
    }

    /**
     * Changes the value of the search phrase in the model.
     * @param data The search phrase
     * @param model data model
     */
    @Function
    static void changeSP(Dictionary model, final String data) {
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

}
