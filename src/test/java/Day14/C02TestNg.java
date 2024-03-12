package Day14;

import org.testng.annotations.Test;

public class C02TestNg {

    @Test(priority = 1)// if it is smaller it will be executed first
    public void b() {
        System.out.println("Test01 is executed");

    }
     @Test(priority = 1)
        public void a(){// can be executed in alphabetic order if the priority is same
         System.out.println("Test02 is executed");


    }
}
