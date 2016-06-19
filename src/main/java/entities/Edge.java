package entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Viktor on 18.5.2016.
 */
@XmlRootElement(name = "edge")
@XmlAccessorType(XmlAccessType.FIELD)
public class Edge extends HierarchyMember{

    @XmlAttribute(name = "source")
    private String source;

    @XmlAttribute(name = "target")
    private String target;

    public Edge()
    {
        name = null;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
