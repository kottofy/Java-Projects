package sq;

import net.restfulwebservices.datacontracts._2008._01.StockQuote;

/**
 * @name StockQuoteDTO
 */
public class StockQuoteDTO {

    String date, high, low, last, mktCap;

    public StockQuoteDTO() {
        date = "";
        high = "";
        low = "";
        last = "";
        mktCap = "";
    }

    public StockQuoteDTO(StockQuote sq) {
        date = sq.getDate().getValue();
        high = sq.getHigh().getValue();
        low = sq.getLow().getValue();
        last = sq.getLast().getValue();
        mktCap = sq.getMktCap().getValue();
    }

    public String getDate() {
        return date;
    }

    public String getHigh() {
        return high;
    }

    public String getLast() {
        return last;
    }

    public String getLow() {
        return low;
    }

    public String getMktCap() {
        return mktCap;
    }
}
