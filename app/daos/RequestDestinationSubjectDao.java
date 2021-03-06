package daos;

import models.RequestDestinationSubject;
import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RequestDestinationSubjectDao extends BaseDao {

    public static String tableName = "request_destination_subject";

    public List<Map<String, Object>> requestDestinations(Long requestId) {
        String sql = "SELECT " +
                "rds.subject_id, rds.uri, " +
                "s.name AS subject_name, s.credits AS subject_credits, " +
                "s.code AS subject_code, d.name AS degree, " +
                "c.name AS centre, u.name AS university, ct.name AS city, " +
                "cnt.name AS country " +
                "FROM " + tableName + " rds " +
                "JOIN " + SubjectDao.tableName + " s ON rds.subject_id = s.id " +
                "JOIN " + DegreeDao.tableName + " d ON s.degree_id = d.id " +
                "JOIN " + CentreDao.tableName + " c ON d.centre_id = c.id " +
                "JOIN " + UniversityDao.tableName + " u ON c.university_id = u.id " +
                "JOIN " + CityDao.tableName + " ct ON u.city_id = ct.id " +
                "JOIN " + CountryDao.tableName + " cnt ON ct.country_id = cnt.id " +
                "WHERE rds.request_id = :requestId";

        List<Map<String, Object>> requestDestinationSubjects;
        try(Connection con = this.db.open()) {
            requestDestinationSubjects = toMapList(con.createQuery(sql)
                    .addParameter("requestId", requestId)
                    .executeAndFetchTable());
        }

        return requestDestinationSubjects;
    }

    public List<Long> create(List<RequestDestinationSubject> rdss) {
        List<Long> ids = new ArrayList<>();
        String sql = "INSERT INTO " + tableName + " " +
                "(request_id, subject_id, uri) " +
                "VALUES (:requestId, :subjectId, :uri)";

        ids.addAll(rdss.stream().map(rds -> insertModel(sql, rds)).collect(Collectors.toList()));

        return ids;
    }
}
