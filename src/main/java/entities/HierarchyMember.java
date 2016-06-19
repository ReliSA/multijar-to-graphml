package entities;

import javax.xml.bind.annotation.*;

/**
 * Created by Viktor Vašina on 14.5.2016.
 *
 * Default GraphML member. Contains id attribute for serialization.
 * Contains shortName attribute(package or class name without jar).
 * Provides default &lt;data&gt; field for node name.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class HierarchyMember {
    /**
     * GraphML node id.
     */
    @XmlAttribute(name="id")
    protected String id;

    /**
     * Not serialized - name of entity without jar part.
     */
    @XmlTransient
    protected String shortName;

    /**
     * Data element for any node, provides name attribute to node.
     */
    @XmlElement(name="data")
    protected Data name = new Data("nodeName", "");

    /**
     * Returns node id.
     * @return node id
     */
    public String getId() {
        return id;
    }

    /**
     * Set node id.
     * @param id node id
     */
    public void setId(String id) {
        this.id = id;
        if(this.name != null)
            this.name.setValue(id);
    }

    /**
     * Returns node id without jar part.
     * @return node id without jar part
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Set node short name - node id without jar part.
     * @param shortName node id without jar part
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * @param o other object
     * @return true if nodes have same id
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HierarchyMember)) return false;

        HierarchyMember that = (HierarchyMember) o;

        return getId().equals(that.getId());

    }

    /**
     * @return hash of node id
     */
    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
