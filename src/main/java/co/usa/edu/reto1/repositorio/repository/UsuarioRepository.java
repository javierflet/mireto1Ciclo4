/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.reto1.repositorio.repository;

import co.usa.edu.reto1.repositorio.UsuarioInterface;
import co.usa.edu.reto1.model.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



/**
 * @author JAVIER GÓMEZ HURTADO
 */

@Repository
public class UsuarioRepository {
    @Autowired
    private UsuarioInterface usuarioCrudRepository;
    
    public List<Usuario> getAll(){
        return (List<Usuario>) usuarioCrudRepository.findAll();
    }
    
    public Usuario save(Usuario newUsuario){
        return usuarioCrudRepository.save(newUsuario);
    }
    
    public Optional<Usuario> getUsuario(int id){
        return usuarioCrudRepository.findById(id);
    }
    
    public boolean verificacion (String email){
        return usuarioCrudRepository.existsByEmail(email);
    }
    
    public Usuario verificaion2 (String email, String password){
        return usuarioCrudRepository.findByEmailAndPassword(email, password);
    }
    
}
