package com.desafio.desafioWeb.Responsavel;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.caelum.stella.validation.CPFValidator;
import jakarta.transaction.Transactional;

@Service
public class ResponsavelService {

    private final ResponsavelRepository responsavelRepository;

    public ResponsavelService(ResponsavelRepository responsavelRepository) {
        this.responsavelRepository = responsavelRepository;
    }

	public List<Responsavel> getResponsaveis(){
		return responsavelRepository.findAll();
	}

    /*
     * Adiciona um responsavel no banco
     */
    @Transactional
    public void addNewResponsavel(Responsavel responsavel) {
        Optional<Responsavel> responsavelOptional =  responsavelRepository.findResponsavelByCodigo(responsavel.getCodigo());
        if (responsavelOptional.isPresent()){
            throw new IllegalStateException("codigo ja existe");
        }

        CPFValidator cpfValidator = new CPFValidator(); 
        boolean valido;
        try{ 
            cpfValidator.assertValid(responsavel.getCpf()); 
            valido = true; 
        } catch (Exception e) { 
            valido = false; 
        }
        if (!valido) {
            throw new IllegalStateException("cpf não é valido");
        }

        responsavelOptional =  responsavelRepository.findResponsavelByCpf(responsavel.getCpf());
        if (responsavelOptional.isPresent()){
            throw new IllegalStateException("ja possui um cadastro com o mesmo cpf");
        }
        responsavelRepository.save(responsavel);
    }

    /*
     * Deleta um responsavel do banco
     */
    public void deleteResponsavel(Long codigo) { 
        if (!responsavelRepository.existsById(codigo)){
            throw new IllegalStateException("responsavel com codigo " + codigo + " nao existe");
        }
        
        responsavelRepository.deleteById(codigo);
    }

    /*
     * Valida se o CPF é valido
     */
    public static boolean validaCpf(String cpf) { 
        CPFValidator cpfValidator = new CPFValidator(); 
        try{ 
            cpfValidator.assertValid(cpf); 
            return true; 
        } catch (Exception e) { 
            e.printStackTrace(); 
            return false; 
        } 
    }
}
