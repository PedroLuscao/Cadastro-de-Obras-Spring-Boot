package com.desafio.desafioWeb.ObraPublica;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.desafio.desafioWeb.Obra.ObraRepository;
import com.desafio.desafioWeb.Obra.ObraService;
import com.desafio.desafioWeb.Responsavel.ResponsavelRepository;

import jakarta.transaction.Transactional;

@Service
public class ObraPublicaService extends ObraService{
    
    private final ObraPublicaRepository obraPublicaRepository;
    
    public ObraPublicaService(ObraRepository obraRepository, ResponsavelRepository responsavelRepository, ObraPublicaRepository obraPublicaRepository) {
        super(obraRepository, responsavelRepository);
        this.obraPublicaRepository = obraPublicaRepository;
    }

    @Transactional
    public List<ObraPublica> getObrasPublicas(){
		List<ObraPublica> obrasPublicas = obraPublicaRepository.findAll();
        obrasPublicas.forEach(obraPublica -> {
            obraPublica.getResponsaveis().size();
        });
        return obrasPublicas;
	}

    public void addNewObraPublica(ObraPublica obraPublica){
        Optional<ObraPublica> obraPublicaOptional =  obraPublicaRepository.findObraPublicaByNumero(obraPublica.getNumero());
        if (obraPublicaOptional.isPresent()){
            throw new IllegalStateException("numero ja existe");
        }
        if ( obraPublica.getDataFim().isBefore(obraPublica.getDataInicio())){
            throw new IllegalStateException("data fim não pode ser antes que data inicio");
        }
        
        obraPublicaRepository.save(obraPublica);
    }
}
