package web.aprendiendola.dictionaryweb.aprendiendola.dictionary.DiccionarioDeJava;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class DataModelTest {
    @Test public void areHelloWorldTwoWords() {
        Dictionary model=new Dictionary();
        model.setSearchPhrase("Hello World!");
    }
}
