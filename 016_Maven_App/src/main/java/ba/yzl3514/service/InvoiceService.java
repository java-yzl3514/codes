package ba.yzl3514.service;

import ba.yzl3514.domain.Invoice;
import ba.yzl3514.repository.InvoiceRepository;

import java.util.List;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class InvoiceService {

    private InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository){
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice saveInvoice(Invoice invoice){
        // Business Logic
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> findAllInvoices(){
        return invoiceRepository.findAll();
    }

    //....

}
