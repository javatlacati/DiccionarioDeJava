package web.aprendiendola.dictionaryweb.aprendiendola.dictionary.DiccionarioDeJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.java.html.json.ComputedProperty;
import net.java.html.json.Function;
import net.java.html.json.Model;
import net.java.html.json.Property;

/**
 * Model annotation generates class Data with one message property, boolean
 * property and read only words property
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

    @ComputedProperty
    static boolean canSearch(String searchPhrase) {
        return searchPhrase != null && searchPhrase.length() > 0;
    }

    @Function
    static void changeFP(Dictionary model) {
        String searchP = model.getSearchPhrase();
        List<String> listOfTerms = model.getTermList();
        for (int i = 0; i < listOfTerms.size(); i++) {
            final String term = listOfTerms.get(i);
            if (stringsAreEqual(term, searchP)) {
                model.setFoundPhrase(term);
                model.setDescription(model.getDefinitionList().get(i));
                model.setCode(model.getExampleCodeList().get(i));
                return;
            }
        }
        model.setDescription("");
        model.setCode("");
        model.setFoundPhrase(ResourceBundle.getBundle("web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/TranslateMe"
        //        , Locale.getDefault()
              //  ,new Locale("ES")
        ).getString("NOTFOUND"));
    }

    @Function
    static void changeSP(Dictionary model, String data
    ) {
        if (data != "") {
            model.setSearchPhrase(data);
            changeFP(model);
        }
    }

    private static boolean stringsAreEqual(final String term, final String searchP) {
        return term.trim().replaceAll("[^\\x00-\\x7F]", "").toLowerCase().contains(searchP.trim().toLowerCase().replaceAll("[^\\x00-\\x7F\\s]", ""));
    }

}
