package com.portfolio.lastry.Controller;

import com.portfolio.lastry.Dto.dtoPersona;
import com.portfolio.lastry.Security.Controller.Mensaje;
import com.portfolio.lastry.Service.ImpPersonaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.portfolio.lastry.Entity.Persona;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://front-argprograma-finalproject.web.app/")
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
    ImpPersonaService impPersonaService;

    @GetMapping("/list")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = impPersonaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!impPersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe persona con ese ID❗"), HttpStatus.NOT_FOUND);
        }

        Persona persona = impPersonaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impPersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe persona con ese ID❗"), HttpStatus.NOT_FOUND);
        }

        impPersonaService.delete(id);
        return new ResponseEntity(new Mensaje("♻️ Persona eliminada ♻️"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtoPers) {
        if (StringUtils.isBlank(dtoPers.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio❗"), HttpStatus.BAD_REQUEST);
        }
        if (impPersonaService.existsByNombre(dtoPers.getNombre())) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe❗"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoPers.getDescripcion())) {
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria❗"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = new Persona(dtoPers.getNombre(), dtoPers.getApellido(), dtoPers.getDescripcion(), dtoPers.getImg());
        impPersonaService.save(persona);
        return new ResponseEntity(new Mensaje("🔥 Persona agregada 🔥"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtoPers) {
        if (!impPersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe persona con ese ID❗"), HttpStatus.NOT_FOUND);
        }
        if (impPersonaService.existsByNombre(dtoPers.getNombre()) && impPersonaService.getByNombre(dtoPers.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe❗"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoPers.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio❗"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoPers.getApellido())) {
            return new ResponseEntity(new Mensaje("El apellido es obligatorio❗"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoPers.getDescripcion())) {
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria❗"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoPers.getImg())) {
            return new ResponseEntity(new Mensaje("La imagen es obligatoria❗"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = impPersonaService.getOne(id).get();
        persona.setNombre(dtoPers.getNombre());
        persona.setApellido(dtoPers.getApellido());
        persona.setDescripcion(dtoPers.getDescripcion());
        persona.setImg(dtoPers.getImg());

        impPersonaService.save(persona);

        return new ResponseEntity(new Mensaje("🔮 Persona actualizada 🔮"), HttpStatus.OK);
    }

}
