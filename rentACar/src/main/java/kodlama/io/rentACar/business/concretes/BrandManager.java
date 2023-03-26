package kodlama.io.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.response.GetAllBrandsResponse;
import kodlama.io.rentACar.business.response.GetAllByIDBrandResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.core.utilities.mapper.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrendRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
	private BrendRepository brendRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;

	

	@Override
	public List<GetAllBrandsResponse> getAll() {
		List<Brand> brands = brendRepository.findAll();
		
		List<GetAllBrandsResponse> response=brands.stream().
				map(brand->this.modelMapperService.forResponse()
						.map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
		return response;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		this.brandBusinessRules.checkIfBrandExists(createBrandRequest.getName());
		
		Brand brand=this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		this.brendRepository.save(brand);
	}

	@Override
	public GetAllByIDBrandResponse allByIDBrandRequest(int id) {
		Optional<Brand> brand=this.brendRepository.findById(id);
		GetAllByIDBrandResponse response=this.modelMapperService.forResponse()
				.map(brand, GetAllByIDBrandResponse.class);
		return response;
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand=this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brendRepository.save(brand);
		
	}

	@Override
	public void delete(int id) {
		this.brendRepository.deleteById(id);
		
	}

}
