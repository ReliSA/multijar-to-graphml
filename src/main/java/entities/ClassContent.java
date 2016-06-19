package entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.HashSet;

/**
 * Created by Viktor on 9.6.2016.
 */
class ClassContent extends HierarchyMember{
    @XmlAttribute(name = "edgeDefault")
    private final String edgeDefault = "directed";

    @XmlElement(name="node")
    private HashSet<Field> fields = new HashSet<Field>();

    @XmlElement(name="node")
    private HashSet<Method> methods = new HashSet<Method>();

    HashSet<Field> getFields() {
        return fields;
    }

    void setFields(HashSet<Field> fields) {
        this.fields = fields;
    }

    HashSet<Method> getMethods() {
        return methods;
    }

    void setMethods(HashSet<Method> methods) {
        this.methods = methods;
    }
}
