package entities;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

/**
 * Created by Viktor Vašina on 14.5.2016.
 *
 * Java Package entity for GraphML serialization.
 */
@XmlRootElement(name = "node")
@XmlAccessorType(XmlAccessType.FIELD)
public class Package extends HierarchyMember {

    @XmlElement(name="graph")
    private PackageContent packageContent = new PackageContent();

    /**
     * Returns Set of package root classes
     * @return package root classes
     */
    public HashSet<Class> getClasses() {
        return packageContent.getClasses();
    }

    /**
     * Set new package root classes.
     * @param classes new package root classes
     */
    public void setClasses(HashSet<Class> classes) {
        packageContent.setClasses(classes);
    }

    /**
     * Returns nested packages.
     * @return nested packages
     */
    public HashSet<Package> getPackages() {
        return packageContent.getPackages();
    }

    /**
     * Set new nested packages.
     * @param packages new nested packages
     */
    public void setPackages(HashSet<Package> packages) {
        packageContent.setPackages(packages);
    }

    @Override
    public void setId(String id) {
        super.setId(id);
        packageContent.setId(id);
    }
}

