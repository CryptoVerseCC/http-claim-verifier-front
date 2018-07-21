package io.ghostbuster91.http.claim.verifier.front

import kotlinx.html.*
import kotlinx.html.dom.append
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLDivElement
import kotlin.browser.document
import kotlin.browser.window
import kotlin.js.Json

fun main(args: Array<String>) {
    document.addEventListener("DOMContentLoaded", {
        document.body!!.append.div {
            div {
                input(name = "signatureInput") {
                    placeholder = "Paste claim signature to verify"
                    size = "50"
                }
                button {
                    +"verify"
                    onClickFunction = {
                        window.fetch("http://api.userfeeds.io/api/verify-claim?signatureValue=0x0047eee0bf0fad4fc13fcb5d1ba78b2559ec598d747e1b8f0b66518f3ee2752f1892e5bb621355702db4074d80690e0ccef385ce44a8790d901173da35619c011b")
                                .then { res -> res.text() }
                                .then { displayResults(JSON.parse(it)) }
                    }
                }
            }
            div {
                id = "result"
            }
        }
    })
}

fun displayResults(data: Json) {
    val resultView = document.getElementById("result") as HTMLDivElement
    if (resultView.hasChildNodes()) {
        resultView.removeChild(resultView.firstChild!!)
    }

    resultView.append.div {
        p {
            +(data["signatureValue"] as String)
        }
    }
}
