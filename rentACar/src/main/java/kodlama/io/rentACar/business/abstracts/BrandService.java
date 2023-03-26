package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.response.GetAllBrandsResponse;
import kodlama.io.rentACar.business.response.GetAllByIDBrandResponse;
import kodlama.io.rentACar.entities.concretes.Brand;

public interface BrandService {
	List<GetAllBrandsResponse> getAll();
GetAllByIDBrandResponse allByIDBrandRequest(int id);
	void add(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete(int id);
}
