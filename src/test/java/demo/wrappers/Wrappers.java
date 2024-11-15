package demo.wrappers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
    public static void searchMethod(WebElement element, String text) throws InterruptedException
    {
        element.click();
        Thread.sleep(1000);
        element.sendKeys(text);
        element.submit();


    }

    public static void sort(List<WebElement> element, String text)throws InterruptedException
    
    {
        for(WebElement e: element)
        {
            if(e.getText().contains(text))
            {
                e.click();
                Thread.sleep(1000);
            }
        }
       
    }

    public static void countRatings(List<WebElement> element)throws InterruptedException
    
    {
        int count=0;
        for(WebElement e: element)
        {
            String rating=e.getText();
            double num=Double.parseDouble(rating.trim());
            
            if(num==4 || num<4)
            {
                count=count+1;
            }
        }

        System.out.println("Total producs of rating less or equal to a are: "+count);
       
    }


    public static void countDiscounts(List<WebElement> element)throws InterruptedException
    
    {
        int count=0;
        for(WebElement e: element)
        {
            String longDiscount=e.getText();
            String discount=longDiscount.substring(0,2);
            int num=Integer.parseInt(discount.trim());
            
            if(num>17)
            {
                count=count+1;
            }
        }

        System.out.println("Total products of dicsount more than 17% are  "+count);
       
    }

    public static void printItems(List<WebElement> element)throws InterruptedException
    
    {
        for(int i=0;i<5;i++)
        {
            System.out.println(element.get(i).getText());
        }
    }

    public static void printItems2(List<WebElement> element)throws InterruptedException
    
    {
        for(int i=0;i<5;i++)
        {
            System.out.println(element.get(i).getAttribute("href"));
        }
    }

    
    
}

