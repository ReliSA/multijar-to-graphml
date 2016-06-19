package entities;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

/**
 * Created by Viktor on 14.5.2016.
 */
@XmlRootElement(name = "node")
@XmlAccessorType(XmlAccessType.FIELD)
public class Package extends HierarchyMember {

    @XmlElement(name="graph")
    private PackageContent packageContent = new PackageContent();

    public PackageContent getPackageContent() {
        return packageContent;
    }

    public void setPackageContent(PackageContent packageContent) {
        this.packageContent = packageContent;
    }

    public HashSet<Class> getClasses() {
        return packageContent.getClasses();
    }

    public void setClasses(HashSet<Class> classes) {
        packageContent.setClasses(classes);
    }

    public HashSet<Package> getPackages() {
        return packageContent.getPackages();
    }

    public void setPackages(HashSet<Package> packages) {
        packageContent.setPackages(packages);
    }

    @Override
    public void setId(String id) {
        super.setId(id);
        packageContent.setId(id);
    }
}

