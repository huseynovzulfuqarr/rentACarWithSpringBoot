package kodlama.io.rentACar.webApi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.response.GetAllModelsResponse;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/models")
public class ModelsController {
private ModelService modelService;
@GetMapping
public List<GetAllModelsResponse> getAll(){
	return modelService.getAll();
}
@PostMapping()
@ResponseStatus(code=HttpStatus.CREATED)
public void add(@RequestBody   CreateModelRequest createModelRequest) {
	this.modelService.add(createModelRequest);
}

}
