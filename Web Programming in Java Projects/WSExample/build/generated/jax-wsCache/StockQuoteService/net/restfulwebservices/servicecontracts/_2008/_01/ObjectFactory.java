
package net.restfulwebservices.servicecontracts._2008._01;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import net.restfulwebservices.datacontracts._2008._01.ArrayOfStockQuote;
import net.restfulwebservices.datacontracts._2008._01.StockQuote;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.restfulwebservices.servicecontracts._2008._01 package. 
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

    private final static QName _GetStockQuoteRequest_QNAME = new QName("http://www.restfulwebservices.net/ServiceContracts/2008/01", "request");
    private final static QName _GetWorldMajorIndicesResponseGetWorldMajorIndicesResult_QNAME = new QName("http://www.restfulwebservices.net/ServiceContracts/2008/01", "GetWorldMajorIndicesResult");
    private final static QName _GetStockQuoteResponseGetStockQuoteResult_QNAME = new QName("http://www.restfulwebservices.net/ServiceContracts/2008/01", "GetStockQuoteResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.restfulwebservices.servicecontracts._2008._01
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetStockQuote }
     * 
     */
    public GetStockQuote createGetStockQuote() {
        return new GetStockQuote();
    }

    /**
     * Create an instance of {@link GetWorldMajorIndices }
     * 
     */
    public GetWorldMajorIndices createGetWorldMajorIndices() {
        return new GetWorldMajorIndices();
    }

    /**
     * Create an instance of {@link GetWorldMajorIndicesResponse }
     * 
     */
    public GetWorldMajorIndicesResponse createGetWorldMajorIndicesResponse() {
        return new GetWorldMajorIndicesResponse();
    }

    /**
     * Create an instance of {@link GetStockQuoteResponse }
     * 
     */
    public GetStockQuoteResponse createGetStockQuoteResponse() {
        return new GetStockQuoteResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/ServiceContracts/2008/01", name = "request", scope = GetStockQuote.class)
    public JAXBElement<String> createGetStockQuoteRequest(String value) {
        return new JAXBElement<String>(_GetStockQuoteRequest_QNAME, String.class, GetStockQuote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfStockQuote }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/ServiceContracts/2008/01", name = "GetWorldMajorIndicesResult", scope = GetWorldMajorIndicesResponse.class)
    public JAXBElement<ArrayOfStockQuote> createGetWorldMajorIndicesResponseGetWorldMajorIndicesResult(ArrayOfStockQuote value) {
        return new JAXBElement<ArrayOfStockQuote>(_GetWorldMajorIndicesResponseGetWorldMajorIndicesResult_QNAME, ArrayOfStockQuote.class, GetWorldMajorIndicesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StockQuote }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/ServiceContracts/2008/01", name = "GetStockQuoteResult", scope = GetStockQuoteResponse.class)
    public JAXBElement<StockQuote> createGetStockQuoteResponseGetStockQuoteResult(StockQuote value) {
        return new JAXBElement<StockQuote>(_GetStockQuoteResponseGetStockQuoteResult_QNAME, StockQuote.class, GetStockQuoteResponse.class, value);
    }

}
