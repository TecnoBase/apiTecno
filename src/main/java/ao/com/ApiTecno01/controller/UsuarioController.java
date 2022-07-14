package ao.com.ApiTecno01.controller;

import ao.com.ApiTecno01.models.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin("*")
@AllArgsConstructor
public class UsuarioController {

    public String entrar(Usuario usuario) {
        if (usuario.getEmail().equals("tecnobase@gmail.com")
                && usuario.getSenha().equals("tecnobase")) {
            return "redirect:/";
        } else {
//            return "redirect:/";
            return null;
        }
    }
}
