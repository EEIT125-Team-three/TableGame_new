package boardGame.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import boardGame.model.City;
import boardGame.model.District;
import boardGame.model.Region;
import boardGame.model.Road;

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
	
	public Road getRoad(Integer roadId) {
		return factory.getCurrentSession().get(Road.class, roadId);
	}
	
	public Region getRegionByRegionName(String regionName) {
		List<Region> list = factory.getCurrentSession().createQuery("From Region where region ='" + regionName + "'").getResultList();
		if(list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
