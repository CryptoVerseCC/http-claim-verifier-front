@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")
@file:JsModule("json-formatter-js")
package io.ghostbuster91.http.claim.verifier.front

import kotlin.js.*
import kotlin.js.Json
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*

external class JSONFormatter(json: Any) {
    var json: Any
    var open: Any
    var config: Any
    var key: Any
    var _isOpen: Any
    var element: Any
    fun constructor(json: Any, open: Number? = definedExternally /* null */, config: JSONFormatterConfiguration? = definedExternally /* null */, key: String? = definedExternally /* null */)
    var isOpen: Any
    var isDate: Any
    var isUrl: Any
    var isArray: Any
    var isObject: Any
    var isEmptyObject: Any
    var isEmpty: Any
    var useToJSON: Any
    var hasKey: Any
    var constructorName: Any
    var type: Any
    var keys: Any
    fun toggleOpen()
    fun openAtDepth(depth: Number? = definedExternally /* null */)
    fun getInlinepreview(): String
    fun render(): HTMLDivElement
    fun appendChildren(animated: Boolean? = definedExternally /* null */)
    fun removeChildren(animated: Boolean? = definedExternally /* null */)
}

external interface JSONFormatterConfiguration {
    var hoverPreviewEnabled: Boolean? get() = definedExternally; set(value) = definedExternally
    var hoverPreviewArrayCount: Number? get() = definedExternally; set(value) = definedExternally
    var hoverPreviewFieldCount: Number? get() = definedExternally; set(value) = definedExternally
    var animateOpen: Boolean? get() = definedExternally; set(value) = definedExternally
    var animateClose: Boolean? get() = definedExternally; set(value) = definedExternally
    var theme: String? get() = definedExternally; set(value) = definedExternally
    var useToJSON: Boolean? get() = definedExternally; set(value) = definedExternally
    var sortPropertiesBy: ((a: String, b: String) -> Number)? get() = definedExternally; set(value) = definedExternally
}