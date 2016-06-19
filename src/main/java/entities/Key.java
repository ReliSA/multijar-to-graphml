package entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Viktor Vašina on 18.5.2016.
 *
 * Entity for serializing key element in GraphML.
 * Key element is definition of custom node fields in GraphML.
 */

@XmlRootElement(name = "key")
@XmlAccessorType(XmlAccessType.FIELD)
public class Key extends HierarchyMember{

    @XmlAttribute(name = "for")
    private String _for;
    @XmlAttribute(name = "attr.name")
    private String _name;
    @XmlAttribute(name = "attr.type")
    private String type;

    /**
     * Default constructor.
     */
    public Key()
    {
        name = null;
    }

    /**
     * Returns for which element in GraphML is key provided.
     * @return GraphML element fo key
     */
    public String getFor() {
        return _for;
    }

    /** Set for which element is key element provided.
     * @param _for GraphML element for key
     */
    public void setFor(String _for) {
        this._for = _for;
    }

    /**
     * Returns name of this GraphML key.
     * @return name of GraphML key
     */
    public String getName() {
        return _name;
    }

    /**
     * Set name of GraphML key.
     * @param name GraphML key name
     */
    public void setName(String name) {
        this._name = name;
    }

    /**
     * Returns type of GraphML key.
     * @return type of key
     */
    public String getType() {
        return type;
    }

    /**
     * Set type of GraphML key.
     * @param type type of key
     */
    public void setType(String type) {
        this.type = type;
    }
}
