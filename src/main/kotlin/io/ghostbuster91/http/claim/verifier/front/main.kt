package io.ghostbuster91.http.claim.verifier.front

import kotlinx.html.ButtonType
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.dom.append
import kotlinx.html.input
import kotlinx.html.js.onClickFunction
import org.w3c.dom.get
import org.w3c.dom.url.URL
import org.w3c.fetch.*
import org.w3c.xhr.XMLHttpRequest
import kotlin.browser.document
import kotlin.browser.window

fun main(args: Array<String>) {
    document.addEventListener("DOMContentLoaded", {
        document.body!!.append.div {
            div {
                input(name = "signatureInput") {
                    placeholder = "Paste claims signature to verify"
                    size = "50"
                }
                button(name = "CALL") {
                    value = "123"
                    onClickFunction = {
                        window.fetch("http://api.userfeeds.io/api/verify-claim?signatureValue=0x0047eee0bf0fad4fc13fcb5d1ba78b2559ec598d747e1b8f0b66518f3ee2752f1892e5bb621355702db4074d80690e0ccef385ce44a8790d901173da35619c011b",init = RequestInit(
                                mode = RequestMode.NO_CORS,
                                cache = RequestCache.DEFAULT,
                                redirect = RequestRedirect.FOLLOW,
                                integrity = ""
                        )).then {
                            console.log(it.body)
                        }
//                        oReq.setRequestHeader("Access-Control-Allow-Origin", "*");
                    }
                    this.type= ButtonType.submit
                }
            }
        div(classes = "result") {

        }
        }
    })
}