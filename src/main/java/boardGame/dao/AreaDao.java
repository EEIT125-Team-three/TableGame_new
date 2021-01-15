package boardGame.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import boardGame.model.City;
import boardGame.model.District;

@Repository
public class AreaDao {
	@Autowired
	SessionFactory factory;
	
	public List<City> getAllCity() {
		return factory.getCurrentSession().createQuery("from City").getResultList();
	}

	public City getCity(Integer cityId) {
		return factory.getCurrentSession().get(City.class, cityId);
	}
	
	public District getDistrict(Integer districtId) {
		return factory.getCurrentSession().get(District.class, districtId);
	}
}
