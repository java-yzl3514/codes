package ba.yzl3514.repository.impl;

import ba.yzl3514.domain.Invoice;
import ba.yzl3514.framework.jdbc.core.JdbcTemplate;
import ba.yzl3514.framework.jdbc.core.ResultSetRowMapper;
import ba.yzl3514.repository.InvoiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDate;
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
        return jdbcTemplate.query(SQL_FIND_ALL, rowMapper);
    }

    @Override
    public Optional<Invoice> findById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, rowMapper, id);
    }

    @Override
    public boolean deleteById(Long id) {
        return jdbcTemplate.update(SQL_DELETE_BY_ID, id) > 0;
    }

    private final ResultSetRowMapper<Invoice> rowMapper = (resultSet, rowNumber) -> {
        Invoice invoice = new Invoice();
        invoice.setId(resultSet.getLong("invoice_id"));
        invoice.setInvoiceNumber(resultSet.getString("invoice_number"));
        invoice.setInvoiceTotal(resultSet.getBigDecimal("invoice_total"));
        //invoice.setInvoiceDate(resultSet.getDate("invoice_date").toLocalDate());
        invoice.setInvoiceDate(resultSet.getObject("invoice_date", LocalDate.class));
        invoice.setPaymentDate(resultSet.getObject("payment_date", LocalDate.class));
        invoice.setCreditTotal(resultSet.getBigDecimal("credit_total"));
        invoice.setVendorId(resultSet.getLong("vendor_id"));
        invoice.setPaymentTotal(resultSet.getBigDecimal("payment_total"));
        invoice.setInvoiceDueDate(resultSet.getObject("invoice_due_date", LocalDate.class));
        invoice.setTermsId(resultSet.getLong("terms_id"));
        return invoice;
    };
}
