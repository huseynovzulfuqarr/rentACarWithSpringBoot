package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.response.GetAllModelsResponse;

public interface ModelService {
List<GetAllModelsResponse> getAll();
void add(CreateModelRequest createModelRequest);
}
