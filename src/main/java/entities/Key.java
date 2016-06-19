package entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Viktor on 18.5.2016.
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

    public Key()
    {
        name = null;
    }

    public String getFor() {
        return _for;
    }

    public void setFor(String _for) {
        this._for = _for;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
