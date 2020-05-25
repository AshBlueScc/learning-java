package jjwt;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

/**
 * @author chengzhen
 * @date 2020/4/17
 * @time 下午4:59
 */
@RunWith(Arquillian.class)
public class JWTDemoTest1 {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(JWTDemo.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }


}
