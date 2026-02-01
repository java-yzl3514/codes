package ba.yzl3514.spring_demo;

import ba.yzl3514.spring_demo.domain.Invoice;
import ba.yzl3514.spring_demo.repository.InvoiceRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }


    @Component
    public class AppRunner implements ApplicationRunner {

        private InvoiceRepository invoiceRepository;

        public AppRunner(InvoiceRepository invoiceRepository) {
            this.invoiceRepository = invoiceRepository;
        }

        @Override
        public void run(ApplicationArguments args) throws Exception {
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
            System.out.println(saved.getInvoiceId());
        }
    }
}
