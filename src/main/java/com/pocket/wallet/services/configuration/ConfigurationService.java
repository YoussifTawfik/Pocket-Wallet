package com.pocket.wallet.services.configuration;

import com.pocket.wallet.entity.Configuration;
import com.pocket.wallet.repository.ConfigurationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfigurationService {

    private final ConfigurationRepository configurationRepository;

    public Optional<Configuration> getConfigByCode(String code){
        return Optional.of(configurationRepository.getByCode(code));
    }
}
