package web.aprendiendola.dictionaryweb.aprendiendola.dictionary.DiccionarioDeJava;

import java.util.List;
import net.java.html.boot.BrowserBuilder;
import web.aprendiendola.dictionaryweb.aprendiendola.dictionary.DiccionarioDeJava.js.Dialogs;

public final class Main {
    private Main() {
    }
    
    public static void main(String... args) throws Exception {
        BrowserBuilder.newBrowser().
            loadPage("pages/index.html").
            loadClass(Main.class).
            invoke("onPageLoad", args).
            showAndWait();
        System.exit(0);
    }

    /**
     * Called when the page is ready.
     */
    public static void onPageLoad() throws Exception {
    Dictionary model=new Dictionary("Hello World!","please click to search","","");
        List<String> termList = model.getTermList();
        termList.add("Hello World!");
        termList.add("Java");
        List<String> definitionList = model.getDefinitionList();
        definitionList.add("Hello world is a program that prints the \"Hello world!\" phrase.");
        definitionList.add("Java is an Object Oriented language that can run in both OO and procedural modes.");
        List<String> examplesList = model.getExampleCodeList();
        examplesList.add("<b>public class HelloWorld{<br>\tpublic static void <b>main</b>(String args...){<br>System.out.println(\"Hello World!\")}}");
        examplesList.add("");
    model.applyBindings();
    Dialogs.screenSize();
    }
    
}
