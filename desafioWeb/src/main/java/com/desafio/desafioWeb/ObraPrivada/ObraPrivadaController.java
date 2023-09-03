package com.desafio.desafioWeb.ObraPrivada;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "obraprivada")
public class ObraPrivadaController {

    private final ObraPrivadaService obraPrivadaService;

    public ObraPrivadaController(ObraPrivadaService obraPrivadaService) {
        this.obraPrivadaService = obraPrivadaService;
    }

    @GetMapping
	public List<ObraPrivada> getObrasPrivadas(){
		return obraPrivadaService.getObrasPrivadas();
	}

	@PostMapping
	public void registerNewObraPrivada(@RequestBody ObraPrivada obraPrivada){
		obraPrivadaService.addNewObraPrivada(obraPrivada);
	}
}
