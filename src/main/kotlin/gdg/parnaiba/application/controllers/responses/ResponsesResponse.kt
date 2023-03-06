package gdg.parnaiba.application.controllers.responses

import gdg.parnaiba.domain.models.Response

data class ResponsesResponse(
    val formId: String,
    val responses: List<Response>
)