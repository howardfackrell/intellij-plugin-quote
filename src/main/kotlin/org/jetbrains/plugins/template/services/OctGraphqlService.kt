package org.jetbrains.plugins.template.services

import com.google.gson.Gson
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage

@State(
    name = "OctGraphqlState",
    reloadable = true,
    storages = [Storage("octGraphqlState.xml")]
)
@Service
class OctGraphqlService : PersistentStateComponent<OctGraphqlService.State> {


//    val gson: Gson = Gson()

//    data class TokenRequestBody(
//        var grant_type: String = "client_credentials",
//        var client_id: String,
//        var client_secret: String
//    )
//
//    data class TokenResponse(
//        var token_type: String,
//        var expires_in: Long,
//        var access_token: String,
//        var aquiredAt: Instant
//    ) {
//        fun expired(): Boolean {
//            return Instant.now().isAfter(aquiredAt.plus(expires_in-10, ChronoUnit.SECONDS))
//        }
//    }

    data class State(var tokenUrl: String?, var graphUrl: String?, var clientId: String?, var clientSecret: String?)

    var persistentState: State? = null //State("https://tokenurl", "https://graphql", "id", "secret")

    override fun getState(): State? {
        return persistentState
    }

    override fun loadState(newState: State) {
        persistentState = newState
    }

//    fun retrieveServiceToken(): TokenResponse {
//        val authRequest = Request.Post(persistentState.tokenUrl)
//            .addHeader(BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString()))
//            .bodyString(
//                gson.toJson(
//                    TokenRequestBody(
//                        client_id = persistentState.clientId,
//                        client_secret = persistentState.clientSecret
//                    )
//                ), ContentType.APPLICATION_JSON
//            )
//
//        val responseString = authRequest.execute()
//            .returnContent()
//            .asString()
//        println("Token Response String is ${responseString}")
//
//        val tokenResponse: TokenResponse = gson.fromJson(
//            responseString, TokenResponse::class.java
//        )
//        return tokenResponse
//    }
}