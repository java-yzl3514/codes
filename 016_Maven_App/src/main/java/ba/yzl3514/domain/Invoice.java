package ba.yzl3514.domain;

import ba.yzl3514.data.AbstractEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Invoice extends AbstractEntity<Long> {
    private String invoiceNumber;
    private LocalDate invoiceDate;
    private BigDecimal invoiceTotal;
    private BigDecimal paymentTotal;
    private BigDecimal creditTotal;
    private LocalDate invoiceDueDate;
    private LocalDate paymentDate;
    private long termsId;
    private long vendorId;

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public BigDecimal getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setInvoiceTotal(BigDecimal invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }

    public BigDecimal getPaymentTotal() {
        return paymentTotal;
    }

    public void setPaymentTotal(BigDecimal paymentTotal) {
        this.paymentTotal = paymentTotal;
    }

    public BigDecimal getCreditTotal() {
        return creditTotal;
    }

    public void setCreditTotal(BigDecimal creditTotal) {
        this.creditTotal = creditTotal;
    }

    public LocalDate getInvoiceDueDate() {
        return invoiceDueDate;
    }

    public void setInvoiceDueDate(LocalDate invoiceDueDate) {
        this.invoiceDueDate = invoiceDueDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public long getTermsId() {
        return termsId;
    }

    public void setTermsId(long termsId) {
        this.termsId = termsId;
    }

    public long getVendorId() {
        return vendorId;
    }

    public void setVendorId(long vendorId) {
        this.vendorId = vendorId;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceNumber='" + invoiceNumber + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", invoiceTotal=" + invoiceTotal +
                ", paymentTotal=" + paymentTotal +
                ", creditTotal=" + creditTotal +
                ", invoiceDueDate=" + invoiceDueDate +
                ", paymentDate=" + paymentDate +
                ", termsId=" + termsId +
                ", vendorId=" + vendorId +
                '}';
    }
}
