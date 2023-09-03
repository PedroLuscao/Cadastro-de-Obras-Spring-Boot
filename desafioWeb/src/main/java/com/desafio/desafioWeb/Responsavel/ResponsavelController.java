package com.desafio.desafioWeb.Responsavel;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "responsavel")
public class ResponsavelController {
    
    private final ResponsavelService responsavelService;

    public ResponsavelController(ResponsavelService responsavelService) {
        this.responsavelService = responsavelService;
    }

    @GetMapping
	public List<Responsavel> getResponsaveis(){
		return responsavelService.getResponsaveis();
	}

	@PostMapping
	public void registerNewResponsavel(@RequestBody Responsavel responsavel){
		responsavelService.addNewResponsavel(responsavel);
	}

	@DeleteMapping(path = "{responsavelCodigo}")
	public void deleteResponsavel(@PathVariable("responsavelCodigo") Long codigo){
		responsavelService.deleteResponsavel(codigo);
	}
}
