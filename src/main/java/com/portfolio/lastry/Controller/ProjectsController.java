package com.portfolio.lastry.Controller;

import com.portfolio.lastry.Dto.dtoProjects;
import com.portfolio.lastry.Entity.Projects;
import com.portfolio.lastry.Security.Controller.Mensaje;
import com.portfolio.lastry.Service.ImpProjectsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@CrossOrigin(origins = {"https://front-argprograma-finalproject.web.app/", "http://localhost:4200/"})
public class ProjectsController {
    @Autowired
    ImpProjectsService impProjectsService;

    @GetMapping("/list")
    public ResponseEntity<List<Projects>> list() {
        List<Projects> list =  impProjectsService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Projects> detail(@PathVariable("id") int id) {
        if (!impProjectsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el id❗"), HttpStatus.NOT_FOUND);
        }

        Projects project = impProjectsService.getOne(id).get();
        return new ResponseEntity(project, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impProjectsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el id❗"), HttpStatus.NOT_FOUND);
        }
        impProjectsService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProjects dtoprojects) {
        // Verificar que se ingresen todos los datos
        if (StringUtils.isBlank(dtoprojects.getTitle())) {
            return new ResponseEntity(new Mensaje("El titulo es obligatorio❗"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoprojects.getSubtitle())) {
            return new ResponseEntity(new Mensaje("El subtitulo es obligatorio❗"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoprojects.getDescription())) {
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria❗"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoprojects.getImgProject())) {
            return new ResponseEntity(new Mensaje("La imagen es obligatoria❗"), HttpStatus.BAD_REQUEST);
        }
        // Validar que no exista otro proyecto con el mismo nombre
        if (impProjectsService.existsByTitleP(dtoprojects.getTitle())) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe❗"), HttpStatus.BAD_REQUEST);
        }

        // Si pasa las validaciones
        Projects project = new Projects(
                dtoprojects.getTitle(),
                dtoprojects.getSubtitle(),
                dtoprojects.getDescription(),
                dtoprojects.getImgProject(),
                dtoprojects.getLinkProject()
        );
        impProjectsService.save(project);
        return new ResponseEntity(new Mensaje("Proyecto creado🔥"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProjects dtoprojects) {
        // Validar si existe el id para modificar el proyecto
        if (!impProjectsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe ese id❗"), HttpStatus.NOT_FOUND);
        }

        // Validar que el titulo no se repita
        if(impProjectsService.existsByTitleP(dtoprojects.getTitle()) && impProjectsService.getByTitleP(dtoprojects.getTitle()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe❗"), HttpStatus.BAD_REQUEST);
        }

        // Validar si alguno de los campos estan vacios
        if(StringUtils.isBlank(dtoprojects.getTitle())) {
            return new ResponseEntity(new Mensaje("El titulo no puede estar vacio❗"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoprojects.getSubtitle())) {
            return new ResponseEntity(new Mensaje("El subtitulo no puede estar vacio❗"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoprojects.getDescription())) {
            return new ResponseEntity(new Mensaje("La descripcion no puede estar vacia❗"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoprojects.getImgProject())) {
            return new ResponseEntity(new Mensaje("La imagen no puede estar vacia❗"), HttpStatus.BAD_REQUEST);
        }

        Projects project = impProjectsService.getOne(id).get();

        project.setTitle(dtoprojects.getTitle());
        project.setSubtitle(dtoprojects.getSubtitle());
        project.setDescription(dtoprojects.getDescription());
        project.setImgProject(dtoprojects.getImgProject());
        project.setLinkProject(dtoprojects.getLinkProject());

        impProjectsService.save(project);
        return new ResponseEntity(new Mensaje("Proyecto actualizado🔥"), HttpStatus.OK);
    }
}
