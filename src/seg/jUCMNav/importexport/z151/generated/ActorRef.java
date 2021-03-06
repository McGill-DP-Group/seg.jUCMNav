//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.9-03/31/2009 04:14 PM(snajper)-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.07.19 at 07:21:12 PM EDT 
//


package seg.jUCMNav.importexport.z151.generated;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActorRef complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActorRef">
 *   &lt;complexContent>
 *     &lt;extension base="{}GRLmodelElement">
 *       &lt;sequence>
 *         &lt;element name="label" type="{}Label"/>
 *         &lt;element name="actorDef" type="{http://www.w3.org/2001/XMLSchema}IDREF"/>
 *         &lt;element name="nodes" type="{http://www.w3.org/2001/XMLSchema}IDREF" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="pos" type="{}Position"/>
 *         &lt;element name="size" type="{}Size"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActorRef", propOrder = {
    "label",
    "actorDef",
    "nodes",
    "pos",
    "size"
})
public class ActorRef
    extends GRLmodelElement
{

    @XmlElement(required = true)
    protected Label label;
    @XmlElement(required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object actorDef;
    @XmlElementRef(name = "nodes", type = JAXBElement.class)
    protected List<JAXBElement<Object>> nodes;
    @XmlElement(required = true)
    protected Position pos;
    @XmlElement(required = true)
    protected Size size;

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link Label }
     *     
     */
    public Label getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link Label }
     *     
     */
    public void setLabel(Label value) {
        this.label = value;
    }

    /**
     * Gets the value of the actorDef property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getActorDef() {
        return actorDef;
    }

    /**
     * Sets the value of the actorDef property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setActorDef(Object value) {
        this.actorDef = value;
    }

    /**
     * Gets the value of the nodes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nodes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNodes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<Object>> getNodes() {
        if (nodes == null) {
            nodes = new ArrayList<JAXBElement<Object>>();
        }
        return this.nodes;
    }

    /**
     * Gets the value of the pos property.
     * 
     * @return
     *     possible object is
     *     {@link Position }
     *     
     */
    public Position getPos() {
        return pos;
    }

    /**
     * Sets the value of the pos property.
     * 
     * @param value
     *     allowed object is
     *     {@link Position }
     *     
     */
    public void setPos(Position value) {
        this.pos = value;
    }

    /**
     * Gets the value of the size property.
     * 
     * @return
     *     possible object is
     *     {@link Size }
     *     
     */
    public Size getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     * @param value
     *     allowed object is
     *     {@link Size }
     *     
     */
    public void setSize(Size value) {
        this.size = value;
    }

}
