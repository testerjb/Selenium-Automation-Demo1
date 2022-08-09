/* *****************************************
 * NOTE THIS TEST WAS COMMENTED OUT
 * IT GIVES ERROR WHEN MIGRATED TO SELENIUM 4,
 * IF THE TEST IS NOT COMMENTED THE REST OF THE SUITE
 * WOULD HAS NOT RUN
 * THIS HAPPENS WHEN THERE ARE ERRORS IN ANY CLASS IN THE PROJECT
 * DatabaseManager error in SQLUtils class
 * *****************************************/

/*****************Class description****************
 * Description: This class is intended to setup data for tests
 * parameters: receives customer id, returns state
 *
 **************************************************//*

package practiceYT.Utilities;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
public class setupData extends SQLUtils {

        *//* ***************************************
         * First method
         * ***************************************
         * Description: *** Gets a blocked state for a customer received as parameter
         * it returns the blocked state to be used in the second method getbillFromBlocked*//*

        public String getState(String customerId)   {
            String blocked = null;
            String Query = "Select top 1 state FROM client_state "
                    + "WHERE service_id = '1' AND exparte_rule = 'never' and  customer_id = '" + customerId + "'" ;
            try {
                blocked = SQLUtils.executeSqlAndReturnSingleColumnValue(Query,"state");
            } catch (Exception e) {
                //SQL exception is captured from SQLUtils
                e.printStackTrace();
            }
            if (blocked != null ) {
                System.out.println("Found state: " + blocked + " is blocked state for customer " + customerId);
            } else {
                System.out.println("No blocked state found for this customer");
            }
            return blocked;
        }


        *//* ***************************************
         * Second method
         * ***************************************
         * Description: *** Gets a bill *** from blocked state
         * and then it's returned to the test *//*
        public String getbillFromBlocked(String customerId) {
            String billNum = null;
            String blocked = getState(customerId);

            *//* Method to select a bill based on customer and blocked state *//*
            String Query = "Select top 1 bill_num FROM bill_master CM (nolock) "
                    + "WHERE CM.customer_id = '" + customerId + "' AND state = '" + blocked + "'" ;

            //Validates that the query returns values to execute next step
            if (blocked!= null ) {
                try {
                    billNum = SQLUtils.executeSqlAndReturnSingleColumnValue(Query,"bill_num");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (billNum != null ) {
                System.out.println("Found bill: " + billNum.trim() + " is blocked state " + blocked + " for customer " + customerId);
            } else {
                System.out.println("No bill found for this customer, getting more bills");
                // >> calls the second method to edit any state to a blocked
                billNum = changeState(customerId);
            }
            System.out.println("bill: " + billNum );
            return billNum.trim();
        }


        *//* ***************************************
         * Third method
         * ***************************************
         * Description: *** Get data from another state and update ***  If a customer does not have bills for a specific blocked
         * state, then it changes state for a bill belongs to another state with enough data and change to the needed one. *//*
        public String changeState(String customerId) {
            String stateToLook = null;
            String stateToChange = null;
            String billNum = null;

            switch (customerId) {
                case "client1":
                    stateToLook = "FL";
                    stateToChange = "AK";
                    break;
                case "client2":
                    stateToLook = "FL";
                    stateToChange = "AK";
                    break;
                case "client3":
                    stateToLook = "FL";
                    stateToChange = "AK";
                    break;
            }

            String query = "Select top 1 bill_num,state FROM bills CM (nolock) "
                    + "WHERE CM.customer_id = '" + customerId + "' AND state = '" + stateToLook + "'  AND "
                    + "ID is not null AND term_date is null ";

            String updateQuery = "UPDATE TOP(1) bills "
                    + "SET state = '" + stateToChange +"' , term_date = null	"
                    + "WHERE bill_Num in (Select top 1 bill_num "
                    + " FROM bill_master CM (nolock) "

                    + "WHERE ID is not null AND term_date is null  AND "
                    + "state = '" + stateToLook +"' AND CM.customer_id = '" + customerId +"' )";
            try {
                billNum = SQLUtils.executeSqlAndReturnSingleColumnValue(query,"bill_num");
                if (billNum != null) {
                    SQLUtils.executeSql(updateQuery);
                }
            } catch (Exception e) {e.printStackTrace();}
            return billNum;
        }

        public static class UtilityTestDeleteid  {
            private String userName;
            public UtilityTestDeleteid (String userName) {
                this.userName = userName;
            }
            @Parameterized.Parameters
            public static Collection<Object[]> parameters()  {
                Object[][] runParameter = new Object[1][1];
                runParameter[0][0] = "user1";
                return Arrays.asList(runParameter);
            }
        }
}*/







