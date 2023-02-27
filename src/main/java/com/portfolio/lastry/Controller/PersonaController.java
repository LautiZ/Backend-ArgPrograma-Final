package com.portfolio.lastry.Controller;

import com.portfolio.lastry.Entity.Persona;
import com.portfolio.lastry.Interface.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService iPersonaService;

    // Ruta de prueba
    @GetMapping("personas/yo")
    public Persona getPersonaYo() { return iPersonaService.findPersona((long)1); }

    // Traer una lista de personas
    @GetMapping("personas/show")
    public List<Persona> getPersona() {
        return iPersonaService.getPersona();
    }

    // Crear una nueva persona
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("personas/create")
    public String createPersona(@RequestBody Persona persona) {
        iPersonaService.savePersona(persona);

        return "🔥 La persona fue creada 🔥";
    }

    // Eliminar una persona por su id
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("personas/delete/{id}")
    public String deletePersona(@PathVariable Long id) {
        iPersonaService.deletePersona(id);

        return "La persona fue eliminada❗";
    }

    // Editar persona buscando por su id
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("personas/edit/{id}")
    public Persona editPersona(@PathVariable Long id, @RequestParam("nombre") String nuevoNombre, @RequestParam("apellido") String nuevoApellido, @RequestParam("img") String nuevaImg) {
        Persona persona = iPersonaService.findPersona(id);

        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevaImg);

        iPersonaService.savePersona(persona);

        return persona;
    }

}
