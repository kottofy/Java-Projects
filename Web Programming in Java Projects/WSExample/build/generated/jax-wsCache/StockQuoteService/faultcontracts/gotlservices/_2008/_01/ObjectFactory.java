
package faultcontracts.gotlservices._2008._01;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the faultcontracts.gotlservices._2008._01 package. 
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

    private final static QName _DefaultFaultContract_QNAME = new QName("http://GOTLServices.FaultContracts/2008/01", "DefaultFaultContract");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: faultcontracts.gotlservices._2008._01
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DefaultFaultContract }
     * 
     */
    public DefaultFaultContract createDefaultFaultContract() {
        return new DefaultFaultContract();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DefaultFaultContract }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://GOTLServices.FaultContracts/2008/01", name = "DefaultFaultContract")
    public JAXBElement<DefaultFaultContract> createDefaultFaultContract(DefaultFaultContract value) {
        return new JAXBElement<DefaultFaultContract>(_DefaultFaultContract_QNAME, DefaultFaultContract.class, null, value);
    }

}
