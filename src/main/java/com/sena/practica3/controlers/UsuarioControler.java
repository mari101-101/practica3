package com.sena.practica3.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.sena.practica3.models.Usuario;
import com.sena.practica3.respositoryes.UsuarioRepository;

import java.util.List;

@RestController
public class UsuarioControler {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("")
    public String inicio() {
        return "Saludo desde el controlador del usuario ";
    }

    @GetMapping("/todos")
    public List<Usuario> allUsers() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{numDoc}")
    public ResponseEntity<Usuario> usuarioid(@PathVariable Integer numDoc) {
                return usuarioRepository.findById(numDoc)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    
    }

    @PostMapping("/user")
    public ResponseEntity<Usuario> UsuarioporID(@RequestBody Usuario usuario) {
        return usuarioRepository.findById(usuario.getNumDoc())
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }
    
    //Crear usuario
    @PostMapping("/crear")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    //Actualizacion de datos

    @PutMapping ("/{numDoc}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Integer numDoc, @RequestBody Usuario opdateUser) {
        return usuarioRepository.findById(numDoc)
                .map(usuario -> {
                    usuario.setNombre(opdateUser.getNombre());
                    usuario.setApellido(opdateUser.getApellido());
                    usuario.setFechaNacimiento(opdateUser.getFechaNacimiento());
                    Usuario updatedUsuario = usuarioRepository.save(usuario);
                    return ResponseEntity.ok(updatedUsuario);
                })
                .orElse(ResponseEntity.notFound().build());
                    
    }

    //actualizae por post sin exponer numero de documento
    @PostMapping ("/actualizar")
    public ResponseEntity<Usuario> actualizarPost(@RequestBody Usuario usuario2) {
        //Obetenemos el numero de documento desde el Json Recibido
        Integer numDoc = usuario2.getNumDoc();
        return usuarioRepository.findById(numDoc)
                .map(usuario -> {
                    usuario.setNombre(usuario2.getNombre());
                    usuario.setApellido(usuario2.getApellido());
                    usuario.setFechaNacimiento(usuario2.getFechaNacimiento());
                    return ResponseEntity.ok(usuarioRepository.save(usuario));
                })
                .orElse(ResponseEntity.notFound().build());

}

    // Eliminar usuario mediante DELETE
    @DeleteMapping("/eliminar")
    private ResponseEntity<String> eliminarPost(@RequestBody Usuario usuario) {

    Integer numDoc = usuario.getNumDoc();

    if (usuarioRepository.existsById(numDoc)) {
        usuarioRepository.deleteById(numDoc);

        return ResponseEntity.ok(
            "Usuario con documento " + numDoc + " eliminado."
        );
    } else {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body("Usuario con documento " + numDoc + " NO EXISTE.");
    }
}
}
