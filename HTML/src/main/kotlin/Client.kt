import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.dom.append
import kotlinx.html.js.onClickFunction
import kotlinx.html.p
import org.w3c.dom.Node

fun main() {
    window.onload = { document.body?.sayHello() }
}

fun Node.sayHello() {
    append {
        div {
            div {
                onClickFunction = { event ->
                    window.alert("I was clicked - ${event.timeStamp}")
                }
                p {
                    +"This is a paragraph"
                }
            }
            a("https://github.com/kotlin/kotlinx.html") {
                +"This is a link"
            }
        }
    }
}
