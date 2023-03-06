package gdg.parnaiba.domain.models

data class Response (
    val answers: Answer,
    val createTime: String,
    val lastSubmittedTime: String,
    val respondentEmail: String,
    val responseId: String
)