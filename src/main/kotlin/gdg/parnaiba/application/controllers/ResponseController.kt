package gdg.parnaiba.application.controllers

import gdg.parnaiba.domain.services.ResponseService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller
class ResponseController(private val responseService: ResponseService) {

    @Get("/responses/{formId}")
    fun getResponses(formId: String) = responseService.getResponses(formId)
}