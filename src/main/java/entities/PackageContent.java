package entities;

import javax.xml.bind.annotation.*;
import java.lang.*;
import java.util.HashSet;

/**
 * Created by Viktor on 17.5.2016.
 */
@XmlRootElement(name = "graph")
@XmlAccessorType(XmlAccessType.FIELD)
class PackageContent extends HierarchyMember {

    @XmlAttribute(name = "edgeDefault")
    private final String edgeDefault = "directed";

    @XmlElement(name="node")
    private HashSet<Class> classes = new HashSet<Class>();

    @XmlElement(name="node")
    private HashSet<Package> packages = new HashSet<Package>();

    HashSet<Class> getClasses() {
        return classes;
    }

    void setClasses(HashSet<Class> classes) {
        this.classes = classes;
    }

    HashSet<Package> getPackages() {
        return packages;
    }

    void setPackages(HashSet<Package> packages) {
        this.packages = packages;
    }
}
