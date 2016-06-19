package entities;

import javax.xml.bind.annotation.*;

/**
 * Created by Viktor on 14.5.2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class HierarchyMember {
    @XmlAttribute(name="id")
    protected String id;

    @XmlTransient
    protected String shortName;

    @XmlElement(name="data")
    protected Data name = new Data("nodeName", "");

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        if(this.name != null)
            this.name.setValue(id);
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HierarchyMember)) return false;

        HierarchyMember that = (HierarchyMember) o;

        return getId().equals(that.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
