package com.desafio.desafioWeb.ObraPublica;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "obrapublica")
public class ObraPublicaController {
    
    private final ObraPublicaService obraPublicaService;

    public ObraPublicaController(ObraPublicaService obraPublicaService) {
        this.obraPublicaService = obraPublicaService;
    }

    @GetMapping
	public List<ObraPublica> getObrasPublicas(){
		return obraPublicaService.getObrasPublicas();
	}

	@PostMapping
	public void registerNewObraPublica(@RequestBody ObraPublica obraPublica){
		obraPublicaService.addNewObraPublica(obraPublica);
	}

}
