package web.aprendiendola.dictionaryweb.aprendiendola.dictionary.DiccionarioDeJava;

import org.netbeans.api.nbrwsr.OpenHTMLRegistration;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;

public class NbMain {
    private NbMain() {
    }
    
    @ActionID(
        category = "Games",
        id = "web.aprendiendola.dictionaryweb.aprendiendola.dictionary.DiccionarioDeJava.OpenPage"
    )
    @OpenHTMLRegistration(
        url="index.html",
        displayName = "Open Your Page",
        iconBase = "web/aprendiendola/dictionaryweb/aprendiendola/dictionary/DiccionarioDeJava/icon.png"
    )
    @ActionReferences({
        @ActionReference(path = "Menu/Window"),
        @ActionReference(path = "Toolbars/Games")
    })
    public static void onPageLoad() throws Exception {
        Main.onPageLoad();
    }
}
