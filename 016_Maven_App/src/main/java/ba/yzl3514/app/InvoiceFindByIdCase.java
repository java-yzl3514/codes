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
public class InvoiceFindByIdCase implements ApplicationRunner {
    private InvoiceService invoiceService;

    public InvoiceFindByIdCase(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Override
    public void run() throws Exception {
        System.out.println(invoiceService.findInvoiceById(110L));
    }
}
