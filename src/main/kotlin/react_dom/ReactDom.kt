package react_dom

import org.w3c.dom.Element
import react.ReactElement

@JsModule("react-dom")
@JsNonModule
external object ReactDom {
    fun render(element: ReactElement<*>, container: Element?, callback: () -> Unit): Element
    fun render(element: ReactElement<*>, container: Element?): Element
}
