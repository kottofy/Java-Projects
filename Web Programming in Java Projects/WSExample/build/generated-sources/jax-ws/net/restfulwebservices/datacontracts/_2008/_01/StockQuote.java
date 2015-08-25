
package net.restfulwebservices.datacontracts._2008._01;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StockQuote complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StockQuote">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Symbol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Last" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Time" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Change" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Open" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="High" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Low" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Volume" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MktCap" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PreviousClose" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PercentageChange" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AnnRange" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Earns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StockQuote", propOrder = {
    "symbol",
    "last",
    "date",
    "time",
    "change",
    "open",
    "high",
    "low",
    "volume",
    "mktCap",
    "previousClose",
    "percentageChange",
    "annRange",
    "earns",
    "pe",
    "name"
})
public class StockQuote {

    @XmlElementRef(name = "Symbol", namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", type = JAXBElement.class)
    protected JAXBElement<String> symbol;
    @XmlElementRef(name = "Last", namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", type = JAXBElement.class)
    protected JAXBElement<String> last;
    @XmlElementRef(name = "Date", namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", type = JAXBElement.class)
    protected JAXBElement<String> date;
    @XmlElementRef(name = "Time", namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", type = JAXBElement.class)
    protected JAXBElement<String> time;
    @XmlElementRef(name = "Change", namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", type = JAXBElement.class)
    protected JAXBElement<String> change;
    @XmlElementRef(name = "Open", namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", type = JAXBElement.class)
    protected JAXBElement<String> open;
    @XmlElementRef(name = "High", namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", type = JAXBElement.class)
    protected JAXBElement<String> high;
    @XmlElementRef(name = "Low", namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", type = JAXBElement.class)
    protected JAXBElement<String> low;
    @XmlElementRef(name = "Volume", namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", type = JAXBElement.class)
    protected JAXBElement<String> volume;
    @XmlElementRef(name = "MktCap", namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", type = JAXBElement.class)
    protected JAXBElement<String> mktCap;
    @XmlElementRef(name = "PreviousClose", namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", type = JAXBElement.class)
    protected JAXBElement<String> previousClose;
    @XmlElementRef(name = "PercentageChange", namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", type = JAXBElement.class)
    protected JAXBElement<String> percentageChange;
    @XmlElementRef(name = "AnnRange", namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", type = JAXBElement.class)
    protected JAXBElement<String> annRange;
    @XmlElementRef(name = "Earns", namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", type = JAXBElement.class)
    protected JAXBElement<String> earns;
    @XmlElementRef(name = "PE", namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", type = JAXBElement.class)
    protected JAXBElement<String> pe;
    @XmlElementRef(name = "Name", namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", type = JAXBElement.class)
    protected JAXBElement<String> name;

    /**
     * Gets the value of the symbol property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSymbol() {
        return symbol;
    }

    /**
     * Sets the value of the symbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSymbol(JAXBElement<String> value) {
        this.symbol = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the last property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLast() {
        return last;
    }

    /**
     * Sets the value of the last property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLast(JAXBElement<String> value) {
        this.last = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDate(JAXBElement<String> value) {
        this.date = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTime(JAXBElement<String> value) {
        this.time = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the change property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getChange() {
        return change;
    }

    /**
     * Sets the value of the change property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setChange(JAXBElement<String> value) {
        this.change = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the open property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOpen() {
        return open;
    }

    /**
     * Sets the value of the open property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOpen(JAXBElement<String> value) {
        this.open = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the high property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHigh() {
        return high;
    }

    /**
     * Sets the value of the high property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHigh(JAXBElement<String> value) {
        this.high = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the low property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLow() {
        return low;
    }

    /**
     * Sets the value of the low property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLow(JAXBElement<String> value) {
        this.low = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the volume property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVolume() {
        return volume;
    }

    /**
     * Sets the value of the volume property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVolume(JAXBElement<String> value) {
        this.volume = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the mktCap property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMktCap() {
        return mktCap;
    }

    /**
     * Sets the value of the mktCap property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMktCap(JAXBElement<String> value) {
        this.mktCap = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the previousClose property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPreviousClose() {
        return previousClose;
    }

    /**
     * Sets the value of the previousClose property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPreviousClose(JAXBElement<String> value) {
        this.previousClose = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the percentageChange property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPercentageChange() {
        return percentageChange;
    }

    /**
     * Sets the value of the percentageChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPercentageChange(JAXBElement<String> value) {
        this.percentageChange = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the annRange property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAnnRange() {
        return annRange;
    }

    /**
     * Sets the value of the annRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAnnRange(JAXBElement<String> value) {
        this.annRange = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the earns property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEarns() {
        return earns;
    }

    /**
     * Sets the value of the earns property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEarns(JAXBElement<String> value) {
        this.earns = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the pe property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPE() {
        return pe;
    }

    /**
     * Sets the value of the pe property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPE(JAXBElement<String> value) {
        this.pe = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setName(JAXBElement<String> value) {
        this.name = ((JAXBElement<String> ) value);
    }

}
