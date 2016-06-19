package entities;

import javax.xml.bind.annotation.*;
import java.lang.*;
import java.util.HashSet;

/**
 * Created by Viktor on 18.5.2016.
 */

@XmlRootElement(name = "graph")
@XmlAccessorType(XmlAccessType.FIELD)
class JarContent extends HierarchyMember {

    @XmlAttribute(name = "edgeDefault")
    private final String edgeDefault = "directed";

    @XmlElement(name="node")
    private HashSet<java.lang.Class> classes = new HashSet<java.lang.Class>();

    @XmlElement(name="node")
    private HashSet<Package> packages = new HashSet<Package>();

    HashSet<java.lang.Class> getClasses() {
        return classes;
    }

    void setClasses(HashSet<java.lang.Class> classes) {
        this.classes = classes;
    }

    HashSet<Package> getPackages() {
        return packages;
    }

    void setPackages(HashSet<Package> packages) {
        this.packages = packages;
    }
}
