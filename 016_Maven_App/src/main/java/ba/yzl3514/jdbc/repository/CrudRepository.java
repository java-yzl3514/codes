package ba.yzl3514.jdbc.repository;

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


    Optional<T> findById(); // Read


    boolean deleteById(ID id); // Delete

}
