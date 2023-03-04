package com.portfolio.lastry.Controller;

import com.portfolio.lastry.Entity.Education;
import com.portfolio.lastry.Security.Controller.Mensaje;
import com.portfolio.lastry.Service.ImpEducationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.portfolio.lastry.Dto.dtoEducation;

import java.util.List;

@RestController
@RequestMapping("/education")
@CrossOrigin(origins = "https://front-argprograma-finalproject.web.app/")
public class EducationController {
    @Autowired
    ImpEducationService impEducationService;

    @GetMapping("/list")
    public ResponseEntity<List<Education>> list() {
        List<Education> list = impEducationService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") int id) {
        if (!impEducationService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe educacion con ese ID❗"), HttpStatus.NOT_FOUND);
        }

        Education edu = impEducationService.getOne(id).get();
        return new ResponseEntity(edu, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impEducationService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe educacion con ese ID❗"), HttpStatus.NOT_FOUND);
        }

        impEducationService.delete(id);
        return new ResponseEntity(new Mensaje("♻️ Educacion eliminada ♻️"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducation dtoEdu) {
        if (StringUtils.isBlank(dtoEdu.getTitleEd())) {
            return new ResponseEntity(new Mensaje("El titulo es obligatorio❗"), HttpStatus.BAD_REQUEST);
        }
        if (impEducationService.existsByTitleEd(dtoEdu.getTitleEd())) {
            return new ResponseEntity(new Mensaje("Ese titulo ya existe❗"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoEdu.getDescriptionEd())) {
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria❗"), HttpStatus.BAD_REQUEST);
        }

        Education edu = new Education(dtoEdu.getTitleEd(), dtoEdu.getDescriptionEd());
        impEducationService.save(edu);
        return new ResponseEntity(new Mensaje("🔥 Educacion agregada 🔥"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducation dtoEdu) {
        if (!impEducationService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe educacion con ese ID❗"), HttpStatus.NOT_FOUND);
        }
        if (impEducationService.existsByTitleEd(dtoEdu.getTitleEd()) && impEducationService.getByTitleEdu(dtoEdu.getTitleEd()).get().getedId() != id) {
            return new ResponseEntity(new Mensaje("Ese titulo ya existe❗"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoEdu.getTitleEd())) {
            return new ResponseEntity(new Mensaje("El titulo es obligatorio❗"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoEdu.getDescriptionEd())) {
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria❗"), HttpStatus.BAD_REQUEST);
        }

        Education edu = impEducationService.getOne(id).get();
        edu.setTitleEd(dtoEdu.getTitleEd());
        edu.setDescriptionEd(dtoEdu.getDescriptionEd());

        impEducationService.save(edu);

        return new ResponseEntity(new Mensaje("🔮 Educacion actualizada 🔮"), HttpStatus.OK);
    }
}
