package ma.fiscacostra.services;

import ma.fiscacostra.dtos.MetierResponse;
import ma.fiscacostra.entities.Metier;
import ma.fiscacostra.mappers.MetierMapper;
import ma.fiscacostra.repositories.MetierRpository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class MetierServiceImpl implements MetierService {


    private final MetierRpository metierRpository;
    private final MetierMapper metierMapper;

    public MetierServiceImpl(MetierRpository metierRpository, MetierMapper metierMapper) {
        this.metierRpository = metierRpository;
        this.metierMapper = metierMapper;
    }


    @Override
    public List<MetierResponse> getAll(Pageable pageable) {

        Page<Metier> metiers = metierRpository.findAll(pageable);

        List<MetierResponse> metierRespoonses = metiers
                .stream()
                .map(metier -> this.metierMapper.metierToMetierResponse(metier))
                .collect(Collectors.toList());

        return  metierRespoonses;
    }


}
