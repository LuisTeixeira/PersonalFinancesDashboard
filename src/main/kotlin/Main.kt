import kotlinx.browser.document
import models.TransactionImpl
import react.dom.h3
import react.dom.p
import react.dom.render
import styled.styledDiv

fun main() {
    render(document.getElementById("root")) {
        child(App::class){}
    }
}