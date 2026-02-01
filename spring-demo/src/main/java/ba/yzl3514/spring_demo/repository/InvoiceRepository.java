package ba.yzl3514.spring_demo.repository;

import ba.yzl3514.spring_demo.domain.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
}
