
package net.restfulwebservices.servicecontracts._2008._01;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import net.restfulwebservices.datacontracts._2008._01.ArrayOfStockQuote;
import net.restfulwebservices.datacontracts._2008._01.StockQuote;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2-hudson-740-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "IStockQuoteService", targetNamespace = "http://www.restfulwebservices.net/ServiceContracts/2008/01")
@XmlSeeAlso({
    faultcontracts.gotlservices._2008._01.ObjectFactory.class,
    net.restfulwebservices.datacontracts._2008._01.ObjectFactory.class,
    net.restfulwebservices.servicecontracts._2008._01.ObjectFactory.class,
    com.microsoft.schemas._2003._10.serialization.ObjectFactory.class
})
public interface IStockQuoteService {


    /**
     * 
     * @param request
     * @return
     *     returns net.restfulwebservices.datacontracts._2008._01.StockQuote
     * @throws IStockQuoteServiceGetStockQuoteDefaultFaultContractFaultFaultMessage
     */
    @WebMethod(operationName = "GetStockQuote", action = "GetStockQuote")
    @WebResult(name = "GetStockQuoteResult", targetNamespace = "http://www.restfulwebservices.net/ServiceContracts/2008/01")
    @RequestWrapper(localName = "GetStockQuote", targetNamespace = "http://www.restfulwebservices.net/ServiceContracts/2008/01", className = "net.restfulwebservices.servicecontracts._2008._01.GetStockQuote")
    @ResponseWrapper(localName = "GetStockQuoteResponse", targetNamespace = "http://www.restfulwebservices.net/ServiceContracts/2008/01", className = "net.restfulwebservices.servicecontracts._2008._01.GetStockQuoteResponse")
    public StockQuote getStockQuote(
        @WebParam(name = "request", targetNamespace = "http://www.restfulwebservices.net/ServiceContracts/2008/01")
        String request)
        throws IStockQuoteServiceGetStockQuoteDefaultFaultContractFaultFaultMessage
    ;

    /**
     * 
     * @return
     *     returns net.restfulwebservices.datacontracts._2008._01.ArrayOfStockQuote
     * @throws IStockQuoteServiceGetWorldMajorIndicesDefaultFaultContractFaultFaultMessage
     */
    @WebMethod(operationName = "GetWorldMajorIndices", action = "GetWorldMajorIndices")
    @WebResult(name = "GetWorldMajorIndicesResult", targetNamespace = "http://www.restfulwebservices.net/ServiceContracts/2008/01")
    @RequestWrapper(localName = "GetWorldMajorIndices", targetNamespace = "http://www.restfulwebservices.net/ServiceContracts/2008/01", className = "net.restfulwebservices.servicecontracts._2008._01.GetWorldMajorIndices")
    @ResponseWrapper(localName = "GetWorldMajorIndicesResponse", targetNamespace = "http://www.restfulwebservices.net/ServiceContracts/2008/01", className = "net.restfulwebservices.servicecontracts._2008._01.GetWorldMajorIndicesResponse")
    public ArrayOfStockQuote getWorldMajorIndices()
        throws IStockQuoteServiceGetWorldMajorIndicesDefaultFaultContractFaultFaultMessage
    ;

}
