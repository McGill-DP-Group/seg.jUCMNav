//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.9-03/31/2009 04:14 PM(snajper)-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.07.19 at 07:21:12 PM EDT 
//


package seg.jUCMNav.importexport.z151.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ComponentKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ComponentKind">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Team"/>
 *     &lt;enumeration value="Object"/>
 *     &lt;enumeration value="Process"/>
 *     &lt;enumeration value="Agent"/>
 *     &lt;enumeration value="Actor"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ComponentKind")
@XmlEnum
public enum ComponentKind {

    @XmlEnumValue("Team")
    TEAM("Team"),
    @XmlEnumValue("Object")
    OBJECT("Object"),
    @XmlEnumValue("Process")
    PROCESS("Process"),
    @XmlEnumValue("Agent")
    AGENT("Agent"),
    @XmlEnumValue("Actor")
    ACTOR("Actor");
    private final String value;

    ComponentKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ComponentKind fromValue(String v) {
        for (ComponentKind c: ComponentKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
