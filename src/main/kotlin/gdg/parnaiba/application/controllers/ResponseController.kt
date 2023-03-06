package gdg.parnaiba.application.controllers

import gdg.parnaiba.application.controllers.responses.ResponsesResponse
import gdg.parnaiba.domain.services.ResponseService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller
class ResponseController(private val responseService: ResponseService) {

    @Get("/responses/{formId}")
    fun getResponses(formId: String): MutableHttpResponse<ResponsesResponse>? {
        return HttpResponse.ok(responseService.listResponses(formId))
    }
}