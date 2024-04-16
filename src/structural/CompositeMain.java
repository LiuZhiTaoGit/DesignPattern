package structural;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liuzt
 * @date: 2024/4/16 - 04 - 16 - 13:22
 * @description: structural  组合模式
 * @version: 1.0
 */
public class CompositeMain {
    public static void main(String[] args) {
        AbstractFile root = new Folder("root");

        AbstractFile file = new File("文件a");
        AbstractFile folder = new Folder("文件夹A");
        root.Add(file);
        root.Add(folder);

        print(root);

//        System.out.println();
    }
    static void print(AbstractFile abstractFile){
        abstractFile.printName();
        List<AbstractFile> children = abstractFile.getChildren();
        if(children == null) return;
        for (AbstractFile child : children) {
            print(child);
        }
    }
}


abstract class AbstractFile{
    protected String name;


    public void printName(){
        System.out.println(name);
    }
    public abstract void Add(AbstractFile abstractFile);
    public abstract void Remove(AbstractFile abstractFile);
    public abstract List<AbstractFile> getChildren();
}

class File extends AbstractFile{
    public File(String name) {
        this.name = name;
    }

    @Override
    public void Add(AbstractFile abstractFile) {
        return;
    }

    @Override
    public void Remove(AbstractFile abstractFile) {
        return;
    }

    @Override
    public List<AbstractFile> getChildren() {
        return null;
    }
}

class Folder extends AbstractFile{

    private List<AbstractFile> childrenList = new ArrayList<AbstractFile>();

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public void Add(AbstractFile abstractFile) {
        childrenList.add(abstractFile);
    }

    @Override
    public void Remove(AbstractFile abstractFile) {
        childrenList.remove(abstractFile);
    }

    @Override
    public List<AbstractFile> getChildren() {
        return childrenList;
    }
}

