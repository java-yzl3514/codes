package ba.yzl3514.framework.jdbc.repository;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public interface CrudRepository<T, ID> {

    T save(T entity); // Create, Update


    List<T> findAll(); // Read


    Optional<T> findById(ID id); // Read


    boolean deleteById(ID id); // Delete

}
