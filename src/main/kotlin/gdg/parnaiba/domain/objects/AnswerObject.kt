package gdg.parnaiba.domain.objects

import com.fasterxml.jackson.annotation.JsonProperty
import gdg.parnaiba.domain.models.Answer

data class AnswerObject(
    @JsonProperty("060bb147")
    val socialMediaLinks: AnswerDataObject,

    @JsonProperty("1055dba4")
    val genderIdentity: AnswerDataObject,

    @JsonProperty("1202d002")
    val race: AnswerDataObject,

    @JsonProperty("18565a31")
    val lectureObjective: AnswerDataObject,

    @JsonProperty("18c34cd9")
    val email: AnswerDataObject,

    @JsonProperty("1a0005fc")
    val speakerBio: AnswerDataObject,

    @JsonProperty("2576568b")
    val lectureDescription: AnswerDataObject,

    @JsonProperty("413124d5")
    val speakerName: AnswerDataObject,

    @JsonProperty("2c04e49b")
    val speakerPronouns: AnswerDataObject,

    @JsonProperty("6f8a40ca")
    val speakerPhoto: AnswerDataObject,

    @JsonProperty("704244e9")
    val lectureTitle: AnswerDataObject,

    @JsonProperty("6d355025")
    val lectureTargetAudience: AnswerDataObject,

    @JsonProperty("2c5281d7")
    val lectureLength: AnswerDataObject,

    @JsonProperty("07033d47")
    val firstTimeLecturing: AnswerDataObject,

    @JsonProperty("48de1591")
    val canBeInPerson: AnswerDataObject,

    @JsonProperty("4913e716")
    val subjectToTalk: AnswerDataObject,

    @JsonProperty("2eee8cd0")
    val needAccessibility: AnswerDataObject? = null,

    @JsonProperty("6acaf57b")
    val doubts: AnswerDataObject? = null,

    @JsonProperty("6561b9f5")
    val acceptedTermsOfUse: AnswerDataObject,
) {
    fun toDomain(): Answer = Answer(
        email = email.textAnswers.answers.first().value,
        speakerName = speakerName.textAnswers.answers.first().value,
        speakerPronouns = speakerPronouns.textAnswers.answers.first().value,
        genderIdentity = genderIdentity.textAnswers.answers.first().value,
        race = race.textAnswers.answers.first().value,
        speakerBio = speakerBio.textAnswers.answers.first().value,
        speakerPhoto = speakerPhoto.textAnswers.answers.first().value,
        lectureTitle = lectureTitle.textAnswers.answers.first().value,
        lectureDescription = lectureDescription.textAnswers.answers.first().value,
        lectureObjective = lectureObjective.textAnswers.answers.first().value,
        lectureTargetAudience = lectureTargetAudience.textAnswers.answers.first().value,
        lectureLength = lectureLength.textAnswers.answers.first().value,
        firstTimeLecturing = firstTimeLecturing.textAnswers.answers.first().value,
        canBeInPerson = canBeInPerson.textAnswers.answers.first().value,
        subjectToTalk = subjectToTalk.textAnswers.answers.map { it.value },
        needAccessibility = needAccessibility?.textAnswers?.answers?.first()?.value,
        doubts = doubts?.textAnswers?.answers?.first()?.value,
        acceptedTermsOfUse = acceptedTermsOfUse.textAnswers.answers.first().value,
    )
}