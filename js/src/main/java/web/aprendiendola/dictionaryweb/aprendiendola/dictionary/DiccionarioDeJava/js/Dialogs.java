package web.aprendiendola.dictionaryweb.aprendiendola.dictionary.DiccionarioDeJava.js;

import net.java.html.js.JavaScriptBody;

public final class Dialogs {

    private Dialogs() {
    }

    /**
     * Shows confirmation dialog to the user.
     *
     * @param msg the message
     * @param callback called back when the use accepts (can be null)
     * @return true or false
     */
    /**
     * Shows direct interaction with JavaScript
     */
    @JavaScriptBody(
            args = {
                "msg", "callback"
            },
            javacall = true,
            body = "if (confirm(msg)) {\n"
            + "  callback.@java.lang.Runnable::run()();\n"
            + "}\n"
    )
    public static native void confirmByUser(String msg, Runnable callback);

    @JavaScriptBody(
            args = {},
            body = "var w = window,\n"
            + "    d = document,\n"
            + "    e = d.documentElement,\n"
            + "    g = d.getElementsByTagName('body')[0],\n"
            + "    x = w.innerWidth || e.clientWidth || g.clientWidth,\n"
            + "    y = w.innerHeight|| e.clientHeight|| g.clientHeight;\n"
            + "\n"
            + "return 'Screen size is ' + x + ' times ' + y;\n"
    )
    public static native String screenSize();

    /**
     * Checks if the given id can be binded.
     *
     * @param identifyer the id to search
     * @return if the specified id exists and is not duplicated
     */
    @JavaScriptBody(
            args
            = {
                "identifyer"
            },
            body = "return document.getElementById(identifyer)!==null;"
    //body = "return document.querySelectorAll(\"[id=identifyer]\").length === 1; "
    )
    public static native boolean idExists(final String identifyer);
}
