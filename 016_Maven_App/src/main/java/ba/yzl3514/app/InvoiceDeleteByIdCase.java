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
public class InvoiceDeleteByIdCase implements ApplicationRunner {

    private InvoiceService invoiceService;

    public InvoiceDeleteByIdCase(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Override
    public void run() throws Exception {
        System.out.println("Invoice deleted : " + invoiceService.deleteInvoiceById(136L));
    }
}
