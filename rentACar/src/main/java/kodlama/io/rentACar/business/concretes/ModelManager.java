package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.response.GetAllBrandsResponse;
import kodlama.io.rentACar.business.response.GetAllModelsResponse;
import kodlama.io.rentACar.core.utilities.mapper.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
private ModelRepository modelRepository;
private ModelMapperService mapperService;
	@Override
	public List<GetAllModelsResponse> getAll() {
List<Model> models = modelRepository.findAll();
		
		List<GetAllModelsResponse> response=models.stream().
				map(model->this.mapperService.forResponse()
						.map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
		return response;
		
	}
	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model=this.mapperService.forRequest().map(createModelRequest, Model.class);
		this.modelRepository.save(model);
		
	}

}
