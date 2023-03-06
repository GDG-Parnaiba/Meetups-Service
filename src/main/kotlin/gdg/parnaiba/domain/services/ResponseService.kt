package gdg.parnaiba.domain.services

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import gdg.parnaiba.application.controllers.responses.ResponsesResponse
import gdg.parnaiba.domain.clients.GoogleFormClient
import gdg.parnaiba.domain.mapper.ResponseMapper
import gdg.parnaiba.domain.models.Response
import gdg.parnaiba.domain.objects.ApiResponseObject
import jakarta.inject.Singleton

@Singleton
class ResponseService(
    private val googleFormClient: GoogleFormClient,
    private val jacksonMapper: ObjectMapper = jacksonObjectMapper()
) {
    fun listResponses(formId: String): ResponsesResponse {
        val formResponses = googleFormClient.getResponses(formId)
        val apiResponse = jacksonMapper.readValue<ApiResponseObject>(formResponses.toString())
        val responseList = mutableListOf<Response>()

        apiResponse.responses.forEach {
            val response = ResponseMapper.mapToResponse(it)
            responseList.add(response)
        }

        return ResponsesResponse(formId, responseList)
    }
}