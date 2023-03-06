package gdg.parnaiba.domain.objects

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.JsonNode

data class ResponseObject(
    @JsonProperty("answers")
    val answers: JsonNode,
    val createTime: String,
    val lastSubmittedTime: String,
    val respondentEmail: String,
    val responseId: String
)