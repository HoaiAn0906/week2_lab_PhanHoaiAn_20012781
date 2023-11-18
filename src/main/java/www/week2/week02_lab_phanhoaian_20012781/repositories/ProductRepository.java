package www.week2.week02_lab_phanhoaian_20012781.repositories;

import org.hibernate.Session;
import org.hibernate.Transaction;
import www.week2.week02_lab_phanhoaian_20012781.models.Employee;
import www.week2.week02_lab_phanhoaian_20012781.models.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository extends BaseRepository<Product> {
    public Map<String, List<Object>> getChartPriceByTime(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "SELECT\n" +
                "    DATE_FORMAT(pp.price_date_time, '%Y-%m') AS month,\n" +
                "    AVG(pp.price) AS average_price\n" +
                "    FROM\n" +
                "    product_prices pp\n" +
                "    WHERE\n" +
                "    pp.product_id = " + id + "\n" +
                "    AND DATE_FORMAT(pp.price_date_time, '%Y-%m') BETWEEN DATE_FORMAT(NOW(), '%Y-%m') AND DATE_FORMAT(NOW() + INTERVAL 12 MONTH, '%Y-%m')\n" +
                "    GROUP BY\n" +
                "    month;";
        List<Object[]> result = session.createNativeQuery(sql).getResultList();
        transaction.commit();
        session.close();

        Map<String, List<Object>> chartData = new HashMap<>();

        for (Object[] row : result) {
            String month = (String) row[0];
            Double price = (Double) row[1];

            if (!chartData.containsKey("month")) {
                chartData.put("month", new ArrayList<>());
            }
            chartData.get("month").add(month);

            if (!chartData.containsKey("price")) {
                chartData.put("price", new ArrayList<>());
            }
            chartData.get("price").add(price);
        }

        return chartData;
    }
}
