package web.aprendiendola.dictionaryweb.aprendiendola.dictionary.DiccionarioDeJava.js;

import java.io.Closeable;
import net.java.html.boot.script.Scripts;
import org.netbeans.html.boot.spi.Fn;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Tests for behavior of @JavaScriptBody methods. Set your JavaScript
 * environment up (for example define <code>alert</code> or use some emulation
 * library like <em>env.js</em>), register script presenter and then you can
 * call methods that deal with JavaScript in your tests.
 */
public class JsInteractionTest {

    private Closeable jsEngine;

    @BeforeMethod
    public final void initializeJSEngine() throws Exception {
        jsEngine = Fn.activate(Scripts.createPresenter());
    }

    @AfterMethod
    public final void shutdownJSEngine() throws Exception {
        jsEngine.close();
    }

    @Test
    public final void testCallbackFromJavaScript() throws Exception {
        class R implements Runnable {

            int called;

            @Override
            public void run() {
                called++;
            }
        }
        R callback = new R();

        Dialogs.confirmByUser("Hello", callback);

        assertEquals(callback.called, 1, "One immediate callback");
    }
}
