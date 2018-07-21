package io.ghostbuster91.http.claim.verifier.front

import kotlinx.html.*
import kotlinx.html.dom.append
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLInputElement
import kotlin.browser.document
import kotlin.browser.window
import kotlin.js.Json

fun main(args: Array<String>) {
    document.addEventListener("DOMContentLoaded", {
        document.body!!.append.div {
            div {
                input {
                    id = "signatureInput"
                    placeholder = "Paste claim signature to verify"
                    size = "50"
                }
                button {
                    +"verify"
                    onClickFunction = {
                        val signatureValue = (document.getElementById("signatureInput") as HTMLInputElement).value
                        window.fetch("http://api.userfeeds.io/api/verify-claim?signatureValue=$signatureValue")
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
