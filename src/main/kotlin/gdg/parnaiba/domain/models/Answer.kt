package gdg.parnaiba.domain.models

data class Answer(
    val email: String,
    val speakerName: String,
    val speakerPronouns: String,
    val genderIdentity: String,
    val race: String,
    val speakerBio: String,
    val speakerPhoto: String,
    val lectureTitle: String,
    val lectureDescription: String,
    val lectureObjective: String,
    val lectureTargetAudience: String,
    val lectureLength: String,
    val firstTimeLecturing: String,
    val canBeInPerson: String,
    val subjectToTalk: List<String>,
    val needAccessibility: String?,
    val doubts: String?,
    val acceptedTermsOfUse: String,
)