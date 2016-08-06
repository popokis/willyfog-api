package daos;

import models.City;
import org.sql2o.Connection;

import java.util.List;

public class CityDao extends BaseDao {

    public static String tableName = "city";

    public List<City> countryCities(Integer countryId) {
        String sql = "SELECT " +
                "id, name, code " +
                "FROM " + tableName + " " +
                "WHERE country_id = :countryId";

        List<City> cities;
        try(Connection con = this.db.open()) {
            cities = con.createQuery(sql)
                    .addParameter("countryId", countryId)
                    .executeAndFetch(City.class);
        }

        return cities;
    }
}
