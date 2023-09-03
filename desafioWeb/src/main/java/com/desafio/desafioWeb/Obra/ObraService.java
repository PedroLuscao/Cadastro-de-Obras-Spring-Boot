package com.desafio.desafioWeb.Obra;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.desafio.desafioWeb.Responsavel.Responsavel;
import com.desafio.desafioWeb.Responsavel.ResponsavelRepository;

import jakarta.transaction.Transactional;

@Service
public class ObraService {

    private final ObraRepository obraRepository;
    private final ResponsavelRepository responsavelRepository;

    public ObraService(ObraRepository obraRepository, ResponsavelRepository responsavelRepository) {
        this.obraRepository = obraRepository;
        this.responsavelRepository = responsavelRepository;
    }

    @Transactional
    public List<Obra> getObras(){
		List<Obra> obras = obraRepository.findAll();
        obras.forEach(obra -> {
            obra.getResponsaveis().size(); // This line triggers the lazy loading of responsaveis
        });
        return obras;
	}

    public void deleteObra(Long numero) { 
        if (!obraRepository.existsById(numero)){
            throw new IllegalStateException("obra com numero " + numero + " nao existe");
        }
        
        obraRepository.deleteById(numero);
    }

    public Obra addResponsavelToObra(Long obraId, Long responsavlId) {
        Set<Responsavel> responsavelSet = null;
        Responsavel responsavel = responsavelRepository.findById(responsavlId).get();
        Obra obra = obraRepository.findById(obraId).get();
        responsavelSet = obra.getResponsaveis();
        responsavelSet.add(responsavel);
        obra.setResponsaveis(responsavelSet);
        return obraRepository.save(obra);
    }

    public List<Obra> getObrasOfResponsavel(Long responsavelId) {
        return obraRepository.getObrasOfResponsavel(responsavelId);
    }
}