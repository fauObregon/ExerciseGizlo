/**
 * 
 */
package com.gizlo.ms.usuario.repository.ifc;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gizlo.ms.usuario.model.UsuarioExterno;

/**
 * @author fauob
 *
 */
@Repository
public interface IUsuarioExternoRepository extends MongoRepository<UsuarioExterno, UUID> {

}
