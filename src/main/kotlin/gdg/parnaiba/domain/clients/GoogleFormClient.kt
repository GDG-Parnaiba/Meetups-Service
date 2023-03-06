package gdg.parnaiba.domain.clients

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.forms.v1.Forms
import com.google.api.client.json.JsonFactory
import com.google.api.services.forms.v1.FormsScopes
import com.google.api.services.forms.v1.model.ListFormResponsesResponse
import com.google.auth.oauth2.GoogleCredentials
import jakarta.inject.Singleton
import java.io.FileInputStream
import java.io.IOException
import java.security.GeneralSecurityException

@Singleton
class GoogleFormClient {
    private val APPLICATION_NAME = "meetups-services"

    private var formsService: Forms? = null

    init {
        try {
            val jsonFactory: JsonFactory = JacksonFactory.getDefaultInstance()

            formsService = Forms.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                jsonFactory, null
            )
                .setApplicationName(APPLICATION_NAME).build()
        } catch (e: GeneralSecurityException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun readResponses(formId: String): ListFormResponsesResponse? {
        val token = getAccessToken()
        return readResponses(formId, token)
    }

    private fun readResponses(formId: String, token: String): ListFormResponsesResponse? {
        return formsService!!.forms().responses().list(formId).setOauthToken(token).execute()
    }

    private fun getAccessToken(): String {
        val credentialFile = FileInputStream("src/main/resources/cred.json")
        val credential = GoogleCredentials.fromStream(credentialFile).createScoped(FormsScopes.all())
        return if (credential.accessToken != null) credential.accessToken.tokenValue else credential.refreshAccessToken().tokenValue
    }
}