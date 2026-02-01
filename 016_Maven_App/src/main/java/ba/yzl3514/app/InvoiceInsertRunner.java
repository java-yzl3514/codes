package ba.yzl3514.app;

import ba.yzl3514.domain.Invoice;
import ba.yzl3514.framework.ApplicationRunner;
import ba.yzl3514.repository.InvoiceJdbcRepositoryImpl;
import ba.yzl3514.repository.InvoiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class InvoiceInsertRunner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(InvoiceRepository.class);
    private InvoiceRepository invoiceRepository;

    public InvoiceInsertRunner(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public void run() throws Exception {
        Invoice invoice = new Invoice();
        invoice.setVendorId(122L);
        invoice.setInvoiceNumber("989319-500");
        invoice.setInvoiceDate(LocalDate.of(2026, 1, 1));
        invoice.setInvoiceTotal(new BigDecimal("4000.33"));
        invoice.setPaymentTotal(new BigDecimal("4000.33"));
        invoice.setCreditTotal(new BigDecimal("0.00"));
        invoice.setTermsId(3L);
        invoice.setInvoiceDueDate(LocalDate.of(2026, 2, 1));
        invoice.setPaymentDate(LocalDate.of(2026, 1, 31));

        Invoice saved = invoiceRepository.save(invoice);
        logger.info("Invoice is inserted with id : {}", saved.getId());
    }
}
