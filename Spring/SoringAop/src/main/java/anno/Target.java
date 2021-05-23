package anno;


import org.springframework.stereotype.Component;

@Component("target")
public class Target implements TargetInterface {

    public void save() {

        System.out.println("正在进行..............");
        //int i=1/0;
    }


}
