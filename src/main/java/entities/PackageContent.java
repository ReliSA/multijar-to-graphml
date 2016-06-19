package entities;

import javax.xml.bind.annotation.*;
import java.lang.*;
import java.util.HashSet;

/**
 * Created by Viktor on 17.5.2016.
 *
 * Helper Class for serializing Package entity as nested graph in Graphml.
 */
@XmlRootElement(name = "graph")
@XmlAccessorType(XmlAccessType.FIELD)
class PackageContent extends HierarchyMember {

    /**
     * Sets edges in GraphML as directed.
     */
    @XmlAttribute(name = "edgeDefault")
    private final String edgeDefault = "directed";

    @XmlElement(name="node")
    private HashSet<Class> classes = new HashSet<Class>();

    @XmlElement(name="node")
    private HashSet<Package> packages = new HashSet<Package>();

    /**
     * Returns Set of package root classes.
     * @return package root classes
     */
    HashSet<Class> getClasses() {
        return classes;
    }

    /**
     * Set new package root classes.
     * @param classes new package root classes
     */
    void setClasses(HashSet<Class> classes) {
        this.classes = classes;
    }

    /**
     * Returns Set of nested packages.
     * @return nested packages
     */
    HashSet<Package> getPackages() {
        return packages;
    }

    /**
     * Set new nested packages.
     * @param packages new nested packages
     */
    void setPackages(HashSet<Package> packages) {
        this.packages = packages;
    }
}
