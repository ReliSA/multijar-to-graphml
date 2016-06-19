package entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;

/**
 * Created by Viktor Vašina on 14.5.2016.
 *
 * Java Class entity for Graphml serialization.
 */

@XmlRootElement(name = "node")
@XmlAccessorType(XmlAccessType.FIELD)
public class Class extends HierarchyMember {
    @XmlElement(name="graph")
    private ClassContent classContent = new ClassContent();

    /**
     * Returns Set of class fields.
     * @return class fields
     */
    public HashSet<Field> getFields() {
        return classContent.getFields();
    }

    /**
     * Set class fields.
     * @param fields new class fields
     */
    public void setFields(HashSet<Field> fields) {
        classContent.setFields(fields);
    }

    /**
     * Returns Set of class methods.
     * @return class methods
     */
    public HashSet<Method> getMethods() {
        return classContent.getMethods();
    }

    /**
     * Set new class methods.
     * @param methods new class methods
     */
    public void setMethods(HashSet<Method> methods) {
        classContent.setMethods(methods);
    }

    @Override
    public void setId(String id) {
        super.setId(id);
        classContent.setId(id);
    }

}
