
package net.restfulwebservices.datacontracts._2008._01;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.restfulwebservices.datacontracts._2008._01 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ArrayOfStockQuote_QNAME = new QName("http://www.restfulwebservices.net/DataContracts/2008/01", "ArrayOfStockQuote");
    private final static QName _StockQuote_QNAME = new QName("http://www.restfulwebservices.net/DataContracts/2008/01", "StockQuote");
    private final static QName _StockQuotePercentageChange_QNAME = new QName("http://www.restfulwebservices.net/DataContracts/2008/01", "PercentageChange");
    private final static QName _StockQuoteOpen_QNAME = new QName("http://www.restfulwebservices.net/DataContracts/2008/01", "Open");
    private final static QName _StockQuoteLow_QNAME = new QName("http://www.restfulwebservices.net/DataContracts/2008/01", "Low");
    private final static QName _StockQuoteMktCap_QNAME = new QName("http://www.restfulwebservices.net/DataContracts/2008/01", "MktCap");
    private final static QName _StockQuoteChange_QNAME = new QName("http://www.restfulwebservices.net/DataContracts/2008/01", "Change");
    private final static QName _StockQuoteVolume_QNAME = new QName("http://www.restfulwebservices.net/DataContracts/2008/01", "Volume");
    private final static QName _StockQuoteAnnRange_QNAME = new QName("http://www.restfulwebservices.net/DataContracts/2008/01", "AnnRange");
    private final static QName _StockQuotePE_QNAME = new QName("http://www.restfulwebservices.net/DataContracts/2008/01", "PE");
    private final static QName _StockQuoteEarns_QNAME = new QName("http://www.restfulwebservices.net/DataContracts/2008/01", "Earns");
    private final static QName _StockQuoteHigh_QNAME = new QName("http://www.restfulwebservices.net/DataContracts/2008/01", "High");
    private final static QName _StockQuoteName_QNAME = new QName("http://www.restfulwebservices.net/DataContracts/2008/01", "Name");
    private final static QName _StockQuoteLast_QNAME = new QName("http://www.restfulwebservices.net/DataContracts/2008/01", "Last");
    private final static QName _StockQuoteTime_QNAME = new QName("http://www.restfulwebservices.net/DataContracts/2008/01", "Time");
    private final static QName _StockQuoteDate_QNAME = new QName("http://www.restfulwebservices.net/DataContracts/2008/01", "Date");
    private final static QName _StockQuoteSymbol_QNAME = new QName("http://www.restfulwebservices.net/DataContracts/2008/01", "Symbol");
    private final static QName _StockQuotePreviousClose_QNAME = new QName("http://www.restfulwebservices.net/DataContracts/2008/01", "PreviousClose");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.restfulwebservices.datacontracts._2008._01
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ArrayOfStockQuote }
     * 
     */
    public ArrayOfStockQuote createArrayOfStockQuote() {
        return new ArrayOfStockQuote();
    }

    /**
     * Create an instance of {@link StockQuote }
     * 
     */
    public StockQuote createStockQuote() {
        return new StockQuote();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfStockQuote }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", name = "ArrayOfStockQuote")
    public JAXBElement<ArrayOfStockQuote> createArrayOfStockQuote(ArrayOfStockQuote value) {
        return new JAXBElement<ArrayOfStockQuote>(_ArrayOfStockQuote_QNAME, ArrayOfStockQuote.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StockQuote }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", name = "StockQuote")
    public JAXBElement<StockQuote> createStockQuote(StockQuote value) {
        return new JAXBElement<StockQuote>(_StockQuote_QNAME, StockQuote.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", name = "PercentageChange", scope = StockQuote.class)
    public JAXBElement<String> createStockQuotePercentageChange(String value) {
        return new JAXBElement<String>(_StockQuotePercentageChange_QNAME, String.class, StockQuote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", name = "Open", scope = StockQuote.class)
    public JAXBElement<String> createStockQuoteOpen(String value) {
        return new JAXBElement<String>(_StockQuoteOpen_QNAME, String.class, StockQuote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", name = "Low", scope = StockQuote.class)
    public JAXBElement<String> createStockQuoteLow(String value) {
        return new JAXBElement<String>(_StockQuoteLow_QNAME, String.class, StockQuote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", name = "MktCap", scope = StockQuote.class)
    public JAXBElement<String> createStockQuoteMktCap(String value) {
        return new JAXBElement<String>(_StockQuoteMktCap_QNAME, String.class, StockQuote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", name = "Change", scope = StockQuote.class)
    public JAXBElement<String> createStockQuoteChange(String value) {
        return new JAXBElement<String>(_StockQuoteChange_QNAME, String.class, StockQuote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", name = "Volume", scope = StockQuote.class)
    public JAXBElement<String> createStockQuoteVolume(String value) {
        return new JAXBElement<String>(_StockQuoteVolume_QNAME, String.class, StockQuote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", name = "AnnRange", scope = StockQuote.class)
    public JAXBElement<String> createStockQuoteAnnRange(String value) {
        return new JAXBElement<String>(_StockQuoteAnnRange_QNAME, String.class, StockQuote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", name = "PE", scope = StockQuote.class)
    public JAXBElement<String> createStockQuotePE(String value) {
        return new JAXBElement<String>(_StockQuotePE_QNAME, String.class, StockQuote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", name = "Earns", scope = StockQuote.class)
    public JAXBElement<String> createStockQuoteEarns(String value) {
        return new JAXBElement<String>(_StockQuoteEarns_QNAME, String.class, StockQuote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", name = "High", scope = StockQuote.class)
    public JAXBElement<String> createStockQuoteHigh(String value) {
        return new JAXBElement<String>(_StockQuoteHigh_QNAME, String.class, StockQuote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", name = "Name", scope = StockQuote.class)
    public JAXBElement<String> createStockQuoteName(String value) {
        return new JAXBElement<String>(_StockQuoteName_QNAME, String.class, StockQuote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", name = "Last", scope = StockQuote.class)
    public JAXBElement<String> createStockQuoteLast(String value) {
        return new JAXBElement<String>(_StockQuoteLast_QNAME, String.class, StockQuote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", name = "Time", scope = StockQuote.class)
    public JAXBElement<String> createStockQuoteTime(String value) {
        return new JAXBElement<String>(_StockQuoteTime_QNAME, String.class, StockQuote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", name = "Date", scope = StockQuote.class)
    public JAXBElement<String> createStockQuoteDate(String value) {
        return new JAXBElement<String>(_StockQuoteDate_QNAME, String.class, StockQuote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", name = "Symbol", scope = StockQuote.class)
    public JAXBElement<String> createStockQuoteSymbol(String value) {
        return new JAXBElement<String>(_StockQuoteSymbol_QNAME, String.class, StockQuote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", name = "PreviousClose", scope = StockQuote.class)
    public JAXBElement<String> createStockQuotePreviousClose(String value) {
        return new JAXBElement<String>(_StockQuotePreviousClose_QNAME, String.class, StockQuote.class, value);
    }

}
