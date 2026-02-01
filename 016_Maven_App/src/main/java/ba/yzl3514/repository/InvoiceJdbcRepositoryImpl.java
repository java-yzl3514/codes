package ba.yzl3514.repository;

import ba.yzl3514.domain.Invoice;
import ba.yzl3514.jdbc.JDBCUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class InvoiceJdbcRepositoryImpl implements InvoiceRepository {

    private static final String SQL_INSERT = "INSERT INTO ap.invoices " +
            "(vendor_id, invoice_number, invoice_date, invoice_total, payment_total, credit_total, terms_id, invoice_due_date, payment_date) " +
            "VALUES (?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPDATE = """
            UPDATE ap.invoices SET
                       vendor_id = ?,
                       invoice_number = ?,
                       invoice_date = ?,
                       invoice_total = ?,
                       payment_total = ?,
                       credit_total = ?, 
                       terms_id = ?, 
                       invoice_due_date = ?, 
                       payment_date = ? 
                       WHERE invoice_id = ?;
            """;

    private static final String SQL_DELETE_BY_ID = "DELETE FROM ap.invoices WHERE invoice_id = ?";
    private static final String SQL_FIND_BY_ID = """
            SELECT 
              invoice_id,
              vendor_id,
              invoice_number,
              invoice_date,
              invoice_total,
              payment_total,
              credit_total,
              terms_id,
              invoice_due_date,
              payment_date
            FROM ap.invoices 
            WHERE invoice_id = ?
            """;

    private static final String SQL_FIND_ALL = """
            SELECT 
              invoice_id,
              vendor_id,
              invoice_number,
              invoice_date,
              invoice_total,
              payment_total,
              credit_total,
              terms_id,
              invoice_due_date,
              payment_date
            FROM ap.invoices
            """;

    private DataSource dataSource;
    private Logger logger = LoggerFactory.getLogger(InvoiceJdbcRepositoryImpl.class);

    public InvoiceJdbcRepositoryImpl(DataSource dataSource) {
        Objects.requireNonNull(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public Invoice save(Invoice entity) {

        try (Connection connection = dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(SQL_INSERT,
                Statement.RETURN_GENERATED_KEYS)) {
            connection.setAutoCommit(false);
            statement.setLong(1, entity.getVendorId());
            statement.setString(2, entity.getInvoiceNumber());
            statement.setObject(3, entity.getInvoiceDate(), Types.DATE);
            statement.setBigDecimal(4, entity.getInvoiceTotal());
            statement.setBigDecimal(5, entity.getPaymentTotal());
            statement.setBigDecimal(6, entity.getCreditTotal());
            statement.setLong(7, entity.getTermsId());
            statement.setObject(8, entity.getInvoiceDueDate());
            statement.setObject(9, entity.getPaymentDate());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Insert is unsuccessful");
            }
            JDBCUtil.commit(connection);

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()){
                    long generatedId = generatedKeys.getLong(1);
                    entity.setId(generatedId);
                }
            }catch (SQLException e){
                throw new SQLException("The record id could not be handled!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    @Override
    public List<Invoice> findAll() {
        return List.of();
    }

    @Override
    public Optional<Invoice> findById() {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long aLong) {
        return false;
    }
}
