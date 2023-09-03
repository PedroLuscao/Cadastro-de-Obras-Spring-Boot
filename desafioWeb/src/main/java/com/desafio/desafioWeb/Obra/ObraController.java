package com.desafio.desafioWeb.Obra;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "obra")
public class ObraController {
    
    private final ObraService obraService;

    public ObraController(ObraService obraService) {
        this.obraService = obraService;
    }

    @GetMapping
	public List<Obra> getObras(){
		return obraService.getObras();
	}

	@GetMapping("/responsaveis/{responsavelId}")
	public List<Obra> getObrasOfResponsavel(@PathVariable Long responsavelId){
		return obraService.getObrasOfResponsavel(responsavelId);
	}

	@DeleteMapping(path = "{obraNumero}")
	public void deleteObra(@PathVariable("obraNumero") Long numero){
		obraService.deleteObra(numero);
	}

	@PutMapping("/{obraId}/responsaveis/{responsavlId}")
	public Obra addResponsavel(@PathVariable Long obraId, @PathVariable Long responsavlId){
		return obraService.addResponsavelToObra(obraId, responsavlId);
	}
}
