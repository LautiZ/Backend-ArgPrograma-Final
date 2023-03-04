package com.portfolio.lastry.Controller;

import com.portfolio.lastry.Entity.Experiencia;
import com.portfolio.lastry.Entity.HyS;
import com.portfolio.lastry.Dto.dtoHyS;
import com.portfolio.lastry.Security.Controller.Mensaje;
import com.portfolio.lastry.Service.ImpHySService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://front-argprograma-finalproject.web.app/")
@RequestMapping("/hys")
public class HySController {
    @Autowired
    ImpHySService impHySService;

    @GetMapping("/list")  // Traer lista de skills
    public ResponseEntity<List<Experiencia>> list() {
        List<HyS> list = impHySService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}") // Mostrar detalles de skill buscando por id
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id) {
        if (!impHySService.existsById(id)) {
            return new ResponseEntity(new Mensaje("🚫 No existe usuario con ese id 🚫"), HttpStatus.NOT_FOUND);
        }

        HyS skill = impHySService.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }

    @PostMapping("/create")  // Crear una nueva skill
    public ResponseEntity<?> create(@RequestBody dtoHyS dtohys) {

        // Validar si ingreso nombre
        if (StringUtils.isBlank(dtohys.getName())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio❗"), HttpStatus.BAD_REQUEST);
        }

        // Vaslidar si ese nombre ya existe
        if (impHySService.existsByName(dtohys.getName())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe❗"), HttpStatus.BAD_REQUEST);
        }

        // Crear la nueva skill y guardarla
        HyS skill = new HyS(dtohys.getName(), dtohys.getTime());
        impHySService.save(skill);

        return new ResponseEntity(new Mensaje("🔥 Experiencia agregada 🔥"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}") // Editar una skill
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHyS dtohys) {
        // Validar si existe el ID ingresado
        if(!impHySService.existsById(id)) {
            return new ResponseEntity(new Mensaje("Ese ID no se encuentra❗"), HttpStatus.BAD_REQUEST);
        }

        // Comparar nombre de las skills
        if(impHySService.existsByName(dtohys.getName()) && impHySService.getByName(dtohys.getName()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa skill ya existe❗"), HttpStatus.BAD_REQUEST);
        }

        // No puede estar vacio el campo nombre
        if(StringUtils.isBlank(dtohys.getName())) {
            return new ResponseEntity(new Mensaje("El campo nombre es obligatorio❗"), HttpStatus.BAD_REQUEST);
        }

        // Cambiar los valores y guardarlos
        HyS skill = impHySService.getOne(id).get();
        skill.setName(dtohys.getName());
        skill.setTime(dtohys.getTime());
        impHySService.save(skill);

        return new ResponseEntity(new Mensaje("🔮 Skill actualizada 🔮"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        // Validar si existe el ID ingresado
        if(!impHySService.existsById(id)) {
            return new ResponseEntity(new Mensaje("Ese ID no se encuentra❗"), HttpStatus.BAD_REQUEST);
        }

        impHySService.delete(id);

        return new ResponseEntity(new Mensaje("♻️ Skill eliminada ♻️"), HttpStatus.OK);
    }
}
