package repository;

import model.Invoice;
import common.DateUtils;

public class InvoiceRepository extends CsvRepository<Invoice> {
    public InvoiceRepository() {
        super("BTL/src/main/resources/data/invoices.csv");
    }

    @Override
    protected Invoice fromCsv(String line) {
        String[] d = line.split(",");
        return new Invoice(d[0], d[1], Double.parseDouble(d[2]), DateUtils.fromString(d[3]));
    }

    @Override
    protected String toCsv(Invoice inv) {
        return inv.toCsv();
    }
}