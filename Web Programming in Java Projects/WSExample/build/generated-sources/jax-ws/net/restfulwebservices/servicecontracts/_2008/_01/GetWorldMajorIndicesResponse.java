
package net.restfulwebservices.servicecontracts._2008._01;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import net.restfulwebservices.datacontracts._2008._01.ArrayOfStockQuote;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetWorldMajorIndicesResult" type="{http://www.restfulwebservices.net/DataContracts/2008/01}ArrayOfStockQuote" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getWorldMajorIndicesResult"
})
@XmlRootElement(name = "GetWorldMajorIndicesResponse")
public class GetWorldMajorIndicesResponse {

    @XmlElementRef(name = "GetWorldMajorIndicesResult", namespace = "http://www.restfulwebservices.net/ServiceContracts/2008/01", type = JAXBElement.class)
    protected JAXBElement<ArrayOfStockQuote> getWorldMajorIndicesResult;

    /**
     * Gets the value of the getWorldMajorIndicesResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfStockQuote }{@code >}
     *     
     */
    public JAXBElement<ArrayOfStockQuote> getGetWorldMajorIndicesResult() {
        return getWorldMajorIndicesResult;
    }

    /**
     * Sets the value of the getWorldMajorIndicesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfStockQuote }{@code >}
     *     
     */
    public void setGetWorldMajorIndicesResult(JAXBElement<ArrayOfStockQuote> value) {
        this.getWorldMajorIndicesResult = ((JAXBElement<ArrayOfStockQuote> ) value);
    }

}
