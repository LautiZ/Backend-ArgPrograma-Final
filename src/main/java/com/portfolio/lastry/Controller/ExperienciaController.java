package com.portfolio.lastry.Controller;

import com.portfolio.lastry.Entity.Experiencia;
import com.portfolio.lastry.Security.Controller.Mensaje;
import com.portfolio.lastry.Service.ImpExperienciaService;
import com.portfolio.lastry.Dto.dtoExperiencia;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("exp")
@CrossOrigin(origins = {"https://front-argprograma-finalproject.web.app/", "http://localhost:4200/"})
public class ExperienciaController {
    @Autowired
    ImpExperienciaService impExperienciaService;

    @GetMapping("/list")  // Traer lista de experiencias laborales
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = impExperienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id) {
        if (!impExperienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("🚫 No existe usuario con ese id 🚫"), HttpStatus.NOT_FOUND);
        }

        Experiencia experiencia = impExperienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @PostMapping("/create")  // Crear una experiencia laboral
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp) {

        // Validar si ingreso nombre
        if (StringUtils.isBlank(dtoexp.getTitleE())) {
            return new ResponseEntity(new Mensaje("El titulo es obligatorio❗"), HttpStatus.BAD_REQUEST);
        }

        // Vaslidar si ese nombre ya existe
        if (impExperienciaService.existsByTitleE(dtoexp.getTitleE())) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe❗"), HttpStatus.BAD_REQUEST);
        }

        // Validar si se ingreso descripcion
        if (StringUtils.isBlank(dtoexp.getDescriptionE())) {
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria❗"), HttpStatus.BAD_REQUEST);
        }

        // Crear la nueva experiencia y guardarla
        Experiencia exp = new Experiencia(dtoexp.getTitleE(), dtoexp.getDescriptionE());
        impExperienciaService.save(exp);

        return new ResponseEntity(new Mensaje("🔥 Experiencia agregada 🔥"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp) {
        // Validar si existe el ID ingresado
        if(!impExperienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("Ese ID no se encuentra❗"), HttpStatus.BAD_REQUEST);
        }

        // Comparar nombre de las experiencias
        if(impExperienciaService.existsByTitleE(dtoexp.getTitleE()) && impExperienciaService.getByTitleE(dtoexp.getTitleE()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe❗"), HttpStatus.BAD_REQUEST);
        }

        // No puede estar vacio el campo title
        if(StringUtils.isBlank(dtoexp.getTitleE())) {
            return new ResponseEntity(new Mensaje("El campo titulo es obligatorio❗"), HttpStatus.BAD_REQUEST);
        }

        // Cambiar los valores y guardarlos
        Experiencia exp = impExperienciaService.getOne(id).get();
        exp.setTitleE(dtoexp.getTitleE());
        exp.setDescriptionE(dtoexp.getDescriptionE());
        impExperienciaService.save(exp);

        return new ResponseEntity(new Mensaje("🔮 Experiencia actualizada 🔮"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        // Validar si existe el ID ingresado
        if(!impExperienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("Ese ID no se encuentra❗"), HttpStatus.BAD_REQUEST);
        }

        impExperienciaService.delete(id);

        return new ResponseEntity(new Mensaje("♻️ Experiencia eliminada ♻️"), HttpStatus.OK);
    }
}
