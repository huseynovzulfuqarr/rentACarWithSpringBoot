package kodlama.io.rentACar.webApi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.response.GetAllBrandsResponse;
import kodlama.io.rentACar.business.response.GetAllByIDBrandResponse;


@RestController
@RequestMapping("/api/brends")
public class BrandsController {
	private BrandService brandService;

	public BrandsController(BrandService brandService) {
		this.brandService = brandService;
	}

	@GetMapping()
	public List<GetAllBrandsResponse> getAll() {
		return brandService.getAll();
	}
@GetMapping("/{id}")
public GetAllByIDBrandResponse getbyid(@PathVariable("id") int id) {
	return this.brandService.allByIDBrandRequest(id);
}
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody()  CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);
	}
	@PutMapping("/update")
	public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
		this.brandService.update(updateBrandRequest);
	}
	
@DeleteMapping("/{id}")
public void delete(@PathVariable("id") int id) {
	this.brandService.delete(id);
}
}
