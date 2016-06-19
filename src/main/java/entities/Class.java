package entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;

/**
 * Created by Viktor on 14.5.2016.
 */

@XmlRootElement(name = "node")
@XmlAccessorType(XmlAccessType.FIELD)
public class Class extends HierarchyMember {
    @XmlElement(name="graph")
    private ClassContent classContent = new ClassContent();

    public ClassContent getClassContent() {
        return classContent;
    }

    public void setClassContent(ClassContent classContent) {
        this.classContent = classContent;
    }

    public HashSet<Field> getFields() {
        return classContent.getFields();
    }

    public void setFields(HashSet<Field> fields) {
        classContent.setFields(fields);
    }

    public HashSet<Method> getMethods() {
        return classContent.getMethods();
    }

    public void setMethods(HashSet<Method> methods) {
        classContent.setMethods(methods);
    }

    @Override
    public void setId(String id) {
        super.setId(id);
        classContent.setId(id);
    }

}
