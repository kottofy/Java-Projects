package beans;

import net.restfulwebservices.datacontracts._2008._01.StockQuote;
import net.restfulwebservices.servicecontracts._2008._01.IStockQuoteServiceGetStockQuoteDefaultFaultContractFaultFaultMessage;
import sq.StockQuoteDTO;

/**
 * @name StockQuoteBean
 */
public class StockQuoteBean {

    String stockSymbol;
    String status;
    StockQuoteDTO quote;

    public StockQuoteBean() {
        quote = new StockQuoteDTO();
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
        StockQuote stockQuote = null;
        try {
            status = "Calling web service";
            stockQuote = getStockQuote(stockSymbol);
            quote = new StockQuoteDTO(stockQuote);
        } catch (Exception e) {
            status = e.getMessage();
        }
    }

    private static StockQuote getStockQuote(java.lang.String request) throws IStockQuoteServiceGetStockQuoteDefaultFaultContractFaultFaultMessage {
        net.restfulwebservices.servicecontracts._2008._01.StockQuoteService service = new net.restfulwebservices.servicecontracts._2008._01.StockQuoteService();
        net.restfulwebservices.servicecontracts._2008._01.IStockQuoteService port = service.getBasicHttpBindingIStockQuoteService();
        return port.getStockQuote(request);
    }

    public StockQuoteDTO getQuote() {
        return quote;
    }
}
