package io.ghostbuster91.http.claim.verifier.front

import kotlinx.html.*
import kotlinx.html.dom.append
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.url.URL
import kotlin.browser.document
import kotlin.browser.window
import kotlin.js.Json

fun main(args: Array<String>) {
    window.onload = {
        val signatureValueParam = URL(window.location.href).searchParams.get("signatureValue")
        document.body!!.append.div {
            div {
                input {
                    id = "signatureInput"
                    placeholder = "Paste claim signature"
                    size = "80"
                    value = signatureValueParam.orEmpty()
                }
                button {
                    +"show"
                    onClickFunction = {
                        val signatureValue = (document.getElementById("signatureInput") as HTMLInputElement).value
                        callApi(signatureValue)
                                .then { displayResults(JSON.parse(it)) }
                    }
                }
            }
            div {
                id = "result"
            }
        }
        if (signatureValueParam != null) {
            callApi(signatureValueParam)
                    .then { displayResults(JSON.parse(it)) }
        }
    }
}

private fun callApi(signatureValueParam: String?) =
        window.fetch("https://api.userfeeds.io/api/verify-claim?signatureValue=$signatureValueParam")
                .then { res -> res.text() }

private fun displayResults(data: Json) {
    val resultView = document.getElementById("result") as HTMLDivElement
    if (resultView.hasChildNodes()) {
        resultView.removeChild(resultView.firstChild!!)
    }

    resultView.append.div {
        p {
            +("Address used to sign this message: " + (data["creator"] as String))
        }
        p {
            +("Message signature hash: " + (data["signatureValue"] as String))
        }
        p {
            +("Message that was signed: " + (data["data"] as String))
        }
        div {
            p {
                +"Copy above values to "
                a(href = " http://etherscan.io/verifySig") { +"etherscan" }
                +" in order to verify"
            }
        }
    }
}
