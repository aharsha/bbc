package eshop;
import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.harsha.daoimpl.CategoryDaoImpl;
import com.harsha.model.Category;

public class BasicTest {
	private static AnnotationConfigApplicationContext context;
	private static CategoryDaoImpl catDao;
	//Run once, e.g. Database connection, connection pool
    @BeforeClass
    public static void runOnceBeforeClass() {
        System.out.println("@BeforeClass - runOnceBeforeClass");
        context=new AnnotationConfigApplicationContext();
        context.scan("com.harsha.daoimpl.CategoryDaoImpl");
		context.refresh();
		System.out.println("---1"+catDao);
      catDao =(CategoryDaoImpl) context.getBean("categoryDaoImpl");
      System.out.println("---2"+catDao);
    }

    // Run once, e.g close connection, cleanup
    @AfterClass
    public static void runOnceAfterClass() {
        System.out.println("@AfterClass - runOnceAfterClass");
    }

    // Should rename to @BeforeTestMethod
    // e.g. Creating an similar object and share for all @Test
    @Before
    public void runBeforeTestMethod() {
        System.out.println("@Before - runBeforeTestMethod");
    }

    // Should rename to @AfterTestMethod
    @After
    public void runAfterTestMethod() {
        System.out.println("@After - runAfterTestMethod");
    }

    @Test
    public void test_method_1() {
        System.out.println("@Test - test_method_1");
        Category  category=new Category();
        category.setCategoryId(1023);
        category.setCategoryName("abc");
        category.setCategoryDiscription("-------");
        
        
        assertEquals("success", true, catDao.saveCategory(category));
    }

    @Test
    public void test_method_2() {
        System.out.println("@Test - test_method_2");
    }
}
