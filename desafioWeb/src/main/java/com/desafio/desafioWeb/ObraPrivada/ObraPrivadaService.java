package com.desafio.desafioWeb.ObraPrivada;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.desafio.desafioWeb.Obra.ObraRepository;
import com.desafio.desafioWeb.Obra.ObraService;
import com.desafio.desafioWeb.Responsavel.ResponsavelRepository;

import jakarta.transaction.Transactional;

@Service
public class ObraPrivadaService extends ObraService{

    private final ObraPrivadaRepository obraPrivadaRepository;
    
    public ObraPrivadaService(ObraRepository obraRepository, ResponsavelRepository responsavelRepository, ObraPrivadaRepository obraPrivadaRepository) {
        super(obraRepository, responsavelRepository);
        this.obraPrivadaRepository = obraPrivadaRepository;
    }
    

    @Transactional
    public List<ObraPrivada> getObrasPrivadas(){
		List<ObraPrivada> obrasPrivadas = obraPrivadaRepository.findAll();
        obrasPrivadas.forEach(obraPrivada -> {
            obraPrivada.getResponsaveis().size();
        });
        return obrasPrivadas;
	}

    public void addNewObraPrivada(ObraPrivada obraPrivada){
        Optional<ObraPrivada> obraPrivadaOptional =  obraPrivadaRepository.findObraPrivadaByNumero(obraPrivada.getNumero());
        if (obraPrivadaOptional.isPresent()){
            throw new IllegalStateException("numero ja existe");
        }
        obraPrivadaRepository.save(obraPrivada);
    }
}
