package Day06;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C01JavaFakerClass {


    @Test
    public void testFaker(){

        Faker faker = new Faker();
        String fulname1= faker.name().fullName();
        String fulname2= faker.name().fullName();

        System.out.println("fulname1 = " + fulname1);
        System.out.println("fulname2 = " + fulname2);

        System.out.println("faker.number() = " + faker.number().numberBetween(100,999));
        System.out.println(fulname1+" "+fulname2);

        System.out.println("faker.address().fullAddress() = " + faker.address().fullAddress());
        System.out.println("faker.internet().emailAddress() = " + faker.internet().emailAddress());
        System.out.println("faker.internet().password(6,8,true,true,false) = " + faker.internet().password(6, 8, true, true, false));
    }
}