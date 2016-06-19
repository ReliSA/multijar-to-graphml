import cz.zcu.kiv.jacc.javatypes.JClass;
import cz.zcu.kiv.jacc.javatypes.JField;
import cz.zcu.kiv.jacc.javatypes.JMethod;
import entities.*;
import entities.Class;
import entities.Package;

import java.io.File;
import java.io.FilenameFilter;
import java.util.*;

/**
 * Created by root on 19.6.16.
 */
public class Utils {
    private Utils(){}

    public static Collection listFiles(File directory, FilenameFilter filter) {
        Vector files = new Vector();

        if (!directory.isDirectory())
            return files;

        File[] entries = directory.listFiles();

        for (File entry : entries) {
            if (filter == null || filter.accept(directory, entry.getName())) {
                files.add(entry);
            }

            if (entry.isDirectory()) {
                files.addAll(listFiles(entry, filter));
            }
        }

        return files;
    }

    public static void insertMember(HashMap<String, HashSet<HierarchyMember>> dict, HierarchyMember member) {
        if (dict.containsKey(member.getShortName()))
            dict.get(member.getShortName()).add(member);
        else {
            HashSet<HierarchyMember> newSet = new HashSet<HierarchyMember>();
            newSet.add(member);
            dict.put(member.getShortName(), newSet);
        }
    }

    public static void insertHierarchy(HashMap<String, HashSet<HierarchyMember>> exportDict, Jar jar, JClass c, boolean unknown){
        HashSet<HierarchyMember> emptyHelper = new HashSet<HierarchyMember>();
        String jarName = c.getOrigin();
        if(unknown){
            jarName = "unknown";
        }

        String[] path = c.getName().split("\\.");
        Package p = null;

        for (int i = 0; i < path.length - 1; i++) {
            Package tmp = new Package();
            if (p == null) {
                for(HierarchyMember x : exportDict.getOrDefault(path[0], emptyHelper)){
                    if(x.getId().equals(jarName + ":" + path[0])){
                        tmp = (Package)x;
                        break;
                    }
                }
                if(tmp.getShortName() == null){
                    tmp.setId(jarName + ":" + path[0]);
                    tmp.setShortName(path[0]);
                    jar.getPackages().add(tmp);
                }
            } else {
                for(HierarchyMember x : exportDict.getOrDefault(p.getShortName() + "." + path[i], emptyHelper)){
                    if(x.getId().equals(p.getId() + "." + path[i])){
                        tmp = (Package)x;
                        break;
                    }
                }
                tmp.setId(p.getId() + "." + path[i]);
                tmp.setShortName(p.getShortName() + "." + path[i]);
                p.getPackages().add(tmp);
            }
            Utils.insertMember(exportDict, tmp);
            p = tmp;
        }

        Class cl = new Class();
        cl.setId(p.getId() + "." + path[path.length - 1]);
        cl.setShortName(p.getShortName() + "." + path[path.length - 1]);

        for (JField f : c.getFields()) {
            Field newField = new Field();
            newField.setId(cl.getId() + "." + f.getName());
            newField.setShortName(cl.getShortName() + "." + f.getName());
            cl.getFields().add(newField);
            Utils.insertMember(exportDict, newField);
        }
        for (JMethod m : c.getMethods()) {
            Method newMethod = new Method();
            newMethod.setId(cl.getId() + "." + m.getName());
            newMethod.setShortName(cl.getShortName() + "." + m.getName());
            cl.getMethods().add(newMethod);
            Utils.insertMember(exportDict, newMethod);
        }
        p.getClasses().add(cl);
        Utils.insertMember(exportDict, cl);
    }
}
