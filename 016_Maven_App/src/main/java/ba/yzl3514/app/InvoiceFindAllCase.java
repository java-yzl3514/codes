package ba.yzl3514.app;

import ba.yzl3514.framework.ApplicationRunner;
import ba.yzl3514.service.InvoiceService;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class InvoiceFindAllCase implements ApplicationRunner {

    private InvoiceService invoiceService;

    public InvoiceFindAllCase(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Override
    public void run() throws Exception {
        invoiceService.findAllInvoices().forEach(System.out::println);
    }
}
