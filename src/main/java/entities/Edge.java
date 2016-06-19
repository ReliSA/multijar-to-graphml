package entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Viktor Vašina on 18.5.2016.
 */
@XmlRootElement(name = "edge")
@XmlAccessorType(XmlAccessType.FIELD)
public class Edge extends HierarchyMember{

    @XmlAttribute(name = "source")
    private String source;

    @XmlAttribute(name = "target")
    private String target;

    /**
     * Default constructor.
     */
    public Edge()
    {
        name = null;
    }

    /**
     * Returns source node id.
     * @return source node id
     */
    public String getSource() {
        return source;
    }

    /**
     * Set source node id.
     * @param source node id
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Target node id.
     * @return target node id
     */
    public String getTarget() {
        return target;
    }

    /**
     * Set target node id.
     * @param target node id
     */
    public void setTarget(String target) {
        this.target = target;
    }
}
