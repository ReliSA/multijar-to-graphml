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
 * Created by Viktor Vašina  on 19.6.16.
 *
 * Library class with with methods for parsing Jar, JClass, JMethod etc. to GraphML structure.
 */

public class Utils {
    private Utils(){}

    /**
     * Returns list of files recursively found in directory, filtered by filename filter.
     * @param directory starting directory
     * @param filter file name filter (for example *.jar)
     * @return list of all files recursively found in root directory
     */
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

    /**
     * Inserts new member to dictionary structure. Where key is entities short name and values is Set of HierarchyMembers
     * with this short name. This is because of possible existence of packages or class duplicities in structure.
     *
     * @param dict where to insert new HierarchyMember
     * @param member new HierarchyMember
     */
    public static void insertMember(HashMap<String, HashSet<HierarchyMember>> dict, HierarchyMember member) {
        if (dict.containsKey(member.getShortName()))
            dict.get(member.getShortName()).add(member);
        else {
            HashSet<HierarchyMember> newSet = new HashSet<HierarchyMember>();
            newSet.add(member);
            dict.put(member.getShortName(), newSet);
        }
    }


    /**
     * Insert whole hierarchy into structure (class and all parent packages).
     *
     * @param exportDict where to insert new hierarchy
     * @param jar insert hierarchy and add it to this jar
     * @param c class to by parsed and inserted
     * @param unknown if true, all node ids will start with jar set as: unknown
     */
    public static void insertHierarchy(HashMap<String, HashSet<HierarchyMember>> exportDict, Jar jar, JClass c, boolean unknown){

        HashSet<HierarchyMember> emptyHelper = new HashSet<HierarchyMember>();

        String jarName = c.getOrigin();
        if(unknown){
            jarName = "unknown";
        }

        String[] path = c.getName().split("\\.");
        Package p = null;


        //insert all nested packages on path of class
        for (int i = 0; i < path.length - 1; i++) {
            Package tmp = new Package();
            //if this is first package
            if (p == null) {
                //if there already exists this package in jar
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
                //if there already exists this package in jar
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
            //insert package to dictionary
            Utils.insertMember(exportDict, tmp);
            p = tmp;
        }


        //in the end insert class with methods and fields to structure
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
