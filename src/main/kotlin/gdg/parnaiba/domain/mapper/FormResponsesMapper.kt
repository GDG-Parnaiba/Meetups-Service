package gdg.parnaiba.domain.mapper

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import gdg.parnaiba.domain.models.Response
import gdg.parnaiba.domain.objects.AnswerObject
import gdg.parnaiba.domain.objects.ResponseObject
import jakarta.inject.Singleton

object ResponseMapper {
    fun mapToResponse(response: ResponseObject): Response {
        val jacksonMapper: ObjectMapper = jacksonObjectMapper()

        val answer = jacksonMapper.readValue<AnswerObject>(response.answers.toString()).toDomain()
        return Response(
            answer,
            response.createTime,
            response.lastSubmittedTime,
            response.respondentEmail,
            response.responseId
        )
    }
}