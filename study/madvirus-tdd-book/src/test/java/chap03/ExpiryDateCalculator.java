package chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(PayData data) {
        return data.getBillingDate().plusMonths(1);
    }
}
