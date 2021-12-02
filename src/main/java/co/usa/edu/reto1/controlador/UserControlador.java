/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.reto1.controlador;

import co.usa.edu.reto1.model.Usuario;
import co.usa.edu.reto1.service.UsuarioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Javier Gomez
 */

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserControlador {
     /**
     * Introducción  servicio de usuarios
     */
    @Autowired
    private UsuarioServicio userservice;
    
    /**
     * Solicitud de web Http  tipo GET obtener usuarios
     * @return retorna los usuarios creados
     */
    @GetMapping("/all")
    public List<Usuario> getUsuarios(){
        return userservice.getAllUsuarios();
    } 
    
    /**
     * Mapeado para registrar un nuevo usuario
     * @param usuario objeto de tipo usuario que se debe enviar para su creación
     * @return retorna el usuario creado 
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@RequestBody Usuario usuario){
        return userservice.saveUsuario(usuario);
    }

    /**
     * Mapeado verificación de email existente en la BD por medio de petición
     * web Http tipo GET
     * @param email correo electrónico a validar su existencia
     * @return una respuesta verdadero o falso al validar existencia
     */
    @GetMapping("/{email}")
    public boolean verificarEmail(@PathVariable String email){
        return userservice.verificador(email);
    }

    /**
     * Mapeado de petición web Http tipo GET para el login de usuario en la Webapp
     * @param email correo electrónico del usuario.
     * @param password password del usuario.
     * @return objeto de tipo usuario dependiendo de su existencia
     */
    @GetMapping("/{email}/{password}")
    public Usuario verificarSimilitud(@PathVariable String email,@PathVariable String password){
        return userservice.validarUsuario(email, password);
        }
    }
