package com.portfolio.lastry.Interface;

import com.portfolio.lastry.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    // Traer una lista de personas
    public List<Persona> getPersona();

    // Guardar un objeto de tipo Persona
    public void savePersona(Persona persona);

    // Eliminar un objeto persona, buscado por id
    public void deletePersona(Long id);

    // Buscar un objeto Persona por id
    public Persona findPersona(Long id);
}
