package org.example.structural_type;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 *
 * @author chocolate
 * 2024/4/3 15:00
 */
public class CompositePattern {

    public static void main(String[] args) {
        Folder folder = new Folder("文件夹1");
        folder.add(new File("fileA"));
        Folder folder1 = new Folder("folder1");
        folder1.add(new File("FileB"));
        folder.add(folder1);

        info(folder);
    }

    static void info(AbstractFile file){
        System.out.println(file.name);
        if (file.getChild() == null){
            return;
        }
        for (AbstractFile abstractFile : file.getChild()) {
            info(abstractFile);
        }
    }
}


abstract class AbstractFile{
    String name;

    abstract boolean add(AbstractFile file);
    abstract boolean remove(AbstractFile file);
    abstract List<AbstractFile> getChild();

}


class Folder extends AbstractFile{

    public List<AbstractFile> fileList = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    @Override
    boolean add(AbstractFile file) {
        return this.fileList.add(file);
    }

    @Override
    boolean remove(AbstractFile file) {
        return this.fileList.remove(file);
    }

    @Override
    List<AbstractFile> getChild() {
        return this.fileList;
    }
}

class File extends AbstractFile{

    public File(String name) {
        this.name = name;
    }

    @Override
    boolean add(AbstractFile file) {
        return false;
    }

    @Override
    boolean remove(AbstractFile file) {
        return false;
    }

    @Override
    List<AbstractFile> getChild() {
        return null;
    }
}