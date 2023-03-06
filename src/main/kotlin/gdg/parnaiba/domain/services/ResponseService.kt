package gdg.parnaiba.domain.services

import gdg.parnaiba.domain.clients.GoogleFormClient
import jakarta.inject.Singleton

@Singleton
class ResponseService(
    private val googleFormClient: GoogleFormClient
) {
    fun getResponses(formId: String) = googleFormClient.readResponses(formId)
}