
package faultcontracts.gotlservices._2008._01;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DefaultFaultContract complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DefaultFaultContract">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ErrorId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CorrelationId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DefaultFaultContract", propOrder = {
    "errorId",
    "errorMessage",
    "correlationId"
})
public class DefaultFaultContract {

    @XmlElement(name = "ErrorId")
    protected int errorId;
    @XmlElement(name = "ErrorMessage", required = true, nillable = true)
    protected String errorMessage;
    @XmlElement(name = "CorrelationId", required = true)
    protected String correlationId;

    /**
     * Gets the value of the errorId property.
     * 
     */
    public int getErrorId() {
        return errorId;
    }

    /**
     * Sets the value of the errorId property.
     * 
     */
    public void setErrorId(int value) {
        this.errorId = value;
    }

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the correlationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrelationId() {
        return correlationId;
    }

    /**
     * Sets the value of the correlationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrelationId(String value) {
        this.correlationId = value;
    }

}
