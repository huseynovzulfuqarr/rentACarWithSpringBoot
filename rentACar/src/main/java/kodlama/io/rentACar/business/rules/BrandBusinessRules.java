package kodlama.io.rentACar.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.BrendRepository;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class BrandBusinessRules {
	private BrendRepository brendRepository;
	
public void checkIfBrandExists(String name) {
	if(this.brendRepository.existsByName(name)) {
		throw new BusinessException("Brend name already exists");
	}
}
}
