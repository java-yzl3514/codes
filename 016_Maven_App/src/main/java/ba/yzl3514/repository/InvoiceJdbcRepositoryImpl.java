package ba.yzl3514.repository;

import ba.yzl3514.domain.Invoice;
import ba.yzl3514.framework.JDBCUtil;
import ba.yzl3514.jdbc.core.JdbcTemplate;
import ba.yzl3514.jdbc.core.ResultSetExtractor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
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

    private JdbcTemplate jdbcTemplate;
    private Logger logger = LoggerFactory.getLogger(InvoiceJdbcRepositoryImpl.class);

    public InvoiceJdbcRepositoryImpl(JdbcTemplate jdbcTemplate) {
        Objects.requireNonNull(jdbcTemplate);
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Invoice save(Invoice entity) {
        logger.info("save method ");
        return jdbcTemplate.execute(connection -> connection.prepareStatement(SQL_INSERT,
                Statement.RETURN_GENERATED_KEYS), statement -> {
            statement.setLong(1, entity.getVendorId());
            statement.setString(2, entity.getInvoiceNumber());
            statement.setObject(3, entity.getInvoiceDate(), Types.DATE);
            statement.setBigDecimal(4, entity.getInvoiceTotal());
            statement.setBigDecimal(5, entity.getPaymentTotal());
            statement.setBigDecimal(6, entity.getCreditTotal());
            statement.setLong(7, entity.getTermsId());
            statement.setObject(8, entity.getInvoiceDueDate());
            statement.setObject(9, entity.getPaymentDate());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                long generatedId = generatedKeys.getLong(1);
                entity.setId(generatedId);
            }
            return entity;
        });
    }

    @Override
    public List<Invoice> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, new InvoiceResultSetExtractor());
    }

    @Override
    public Optional<Invoice> findById(Long id) {
        return Optional.empty();
    }


    @Override
    public boolean deleteById(Long id) {
        return false;
    }


    private static class InvoiceResultSetExtractor implements ResultSetExtractor<List<Invoice>> {

        @Override
        public List<Invoice> extract(ResultSet resultSet) throws SQLException {
            List<Invoice> invoices = new ArrayList<>();
            while (resultSet.next()) {
                Invoice invoice = new Invoice();
                invoice.setId(resultSet.getLong("invoice_id"));
                invoice.setInvoiceNumber(resultSet.getString("invoice_number"));
                invoice.setInvoiceTotal(resultSet.getBigDecimal("invoice_total"));
                invoice.setInvoiceDate(resultSet.getObject("invoice_date", LocalDate.class));
                invoice.setPaymentDate(resultSet.getObject("payment_date",LocalDate.class));
                invoice.setCreditTotal(resultSet.getBigDecimal("credit_total"));
                invoice.setVendorId(resultSet.getLong("vendor_id"));
                invoice.setInvoiceDueDate(resultSet.getObject("invoice_due_date",LocalDate.class));
                invoice.setTermsId(resultSet.getLong("terms_id"));
                invoices.add(invoice);
            }
            return invoices;
        }
    }
}
