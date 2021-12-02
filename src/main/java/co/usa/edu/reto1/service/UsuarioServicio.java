/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.reto1.service;

import co.usa.edu.reto1.repositorio.repository.UsuarioRepository;
import co.usa.edu.reto1.model.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author JAVIER GÓMEZ HURTADO
 */
@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public List<Usuario> getAllUsuarios(){
        return (List<Usuario>)usuarioRepository.getAll();
    }
    
    public Optional<Usuario> getUsuarioById(int id){
        return usuarioRepository.getUsuario(id);
    }
    
    public Usuario saveUsuario(Usuario usuario){
        if(usuario.getId()==null){
            return usuarioRepository.save(usuario);
        }else{
            Optional<Usuario> usuarioOpt = usuarioRepository.getUsuario(usuario.getId());
            if (usuarioOpt.isPresent()){
                return usuarioRepository.save(usuario);
            }else{
                return usuario;
            }
        }   
    }    
    
    public boolean verificador (String email){
        return usuarioRepository.verificacion(email);
    }
    
    public Usuario validarUsuario(String email,String pass){
            Usuario user = usuarioRepository.verificaion2(email, pass);
            if (user!=null){
                return user;
            }else{
                Usuario user2 = new Usuario();
                user2.setName("NO DEFINIDO");
                user2.setEmail(email);
                user2.setPassword(pass);
                return user2; 
            } 
        }
}
