package Demo;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;
import com.mysql.jdbc.Connection;
import dao.CustomerDao;
import domain.Customer;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.DriverManager;

import static com.oracle.jrockit.jfr.DataType.UTF8;

/**
 * Created by codingBoy on 16/10/23.
 * This is a test from Joy Ann. 2017/04/05
 */
public class Demo
{
    QueryRunner qr=new TxQueryRunner();
    public static void main(String[] args)
    {
        CustomerDao customerDao=new CustomerDao();

        for (int i=0;i<1000;i++)
        {
            Customer customer=new Customer();
            customer.setId(CommonUtils.uuid());
            customer.setName("customer"+i);
            customer.setGender(i%2==0?"male":"female");
            customer.setPhone("13476"+i);
            customer.setEmail("customer"+i+"@163.com");
            customer.setDescription("helle world");

            customerDao.add(customer);
        }
    }
}
