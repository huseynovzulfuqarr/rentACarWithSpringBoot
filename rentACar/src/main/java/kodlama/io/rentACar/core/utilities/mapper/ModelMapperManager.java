package kodlama.io.rentACar.core.utilities.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService {
private ModelMapper mapper;
	@Override
	public ModelMapper forResponse() {
		this.mapper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		return this.mapper;
	}

	@Override
	public ModelMapper forRequest() {
		this.mapper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.STANDARD);
		return this.mapper;
	}

}
