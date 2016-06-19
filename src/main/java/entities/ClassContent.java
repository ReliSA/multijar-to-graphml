package entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.HashSet;

/**
 * Created by Viktor Vašina on 9.6.2016.
 *
 * Helper Class for serializing Class entity as nested graph in Graphml.
 */
class ClassContent extends HierarchyMember{
    /**
     * Sets edges in GraphML as directed.
     */
    @XmlAttribute(name = "edgeDefault")
    private final String edgeDefault = "directed";

    @XmlElement(name="node")
    private HashSet<Field> fields = new HashSet<Field>();

    @XmlElement(name="node")
    private HashSet<Method> methods = new HashSet<Method>();

    /**
     * Returns Set of class fields.
     * @return class fields
     */
    HashSet<Field> getFields() {
        return fields;
    }

    /**
     * Set new class fields.
     * @param fields new class fields.
     */
    void setFields(HashSet<Field> fields) {
        this.fields = fields;
    }

    /**
     * Returns class methods.
     * @return class methods
     */
    HashSet<Method> getMethods() {
        return methods;
    }

    /**
     * Set new class methods.
     * @param methods new class methods
     */
    void setMethods(HashSet<Method> methods) {
        this.methods = methods;
    }
}
