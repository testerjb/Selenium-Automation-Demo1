
/* *****************************************
 * NOTE THIS TEST WAS COMMENTED OUT
 * IT GIVES ERROR WHEN MIGRATED TO SELENIUM 4,
 * IF THE TEST IS NOT COMMENTED THE REST OF THE SUITE
 * WOULD HAVE NOT RUN
 * THIS HAPPENS WHEN THERE ARE ERRORS IN ANY CLASS IN THE PROJECT
 * DatabaseManager error in SQLUtils class
 * *****************************************/

/******************************************
 * Purpose: This is a class that return dynamic values
 *
 * parameters: The methods return a list with product names,
 * and product description for a "x" product name passed as parameter
 **************************************************//*
package practiceYT.Utilities;
import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.ArrayList;

public class productSearchUtilities extends SQLUtils {

    public productSearchUtilities(WebDriver driver) {}

    //get all the keys for the searches
    public List<String> findproductName()  {
        List<String> productNameList = null;
        String query = "select distinct top 10 productname , max(ahc.descdisplay) as descdisplay "
                + "from product_1 (nolock) p Inner Join product_1 (nolock) df on p.id = df.id "
                + "inner join product_3 t1  on p.t1 = t1.id inner Join table2 ahc  (nolock) ON p.fieldId = ahc.field4 "
                + "where pri.price = 1 and pricetype = 2 GROUP BY productname order by 1 asc ";
        try {
            productNameList = SQLUtils.executeSqlAndReturnSingleColumnAsList(query, "productname");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productNameList;
    }

    //return description
    public ArrayList<String[]> getproductDescription(String productName)  {
        ArrayList<String[]> productNameAList = null;
        String query = "select p.data1, productname, ahc.describe "
                + "from product_1 (nolock) p Inner Join product_1 (nolock) df on p.id = df.id "
                + "inner join product_2  on p.id = t1.id inner Join table2 ahc  (nolock) ON p.field3 = ahc.field3 "
                + "inner join pri pri (nolock) ON p.id = pri.id inner join table3 r (nolock) on r.id = p.id "
                + "where pri.price = 1 and pricetype = 2 and productname = '" + productName
                + "' order by 1 asc";
        try {
            productNameAList = SQLUtils.executeSqlAndReturnResultsetAsArrayList(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return productNameAList;
    }

}
*/
