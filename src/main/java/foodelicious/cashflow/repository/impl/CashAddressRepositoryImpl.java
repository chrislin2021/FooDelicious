package foodelicious.cashflow.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import foodelicious.article.container.ShareAreaRowMapper;
import foodelicious.article.model.ShareArea;
import foodelicious.cashflow.container.CashflowAddressRowMapper;
import foodelicious.cashflow.model.CashflowAddressBean;
import foodelicious.cashflow.repository.CashAddressRepository;
import foodelicious.member.model.Member;

@Repository
public class CashAddressRepositoryImpl implements CashAddressRepository {
	@PersistenceContext
	EntityManager em;

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public CashAddressRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}


	@Override
	public List<CashflowAddressBean> useIdfindAddress(int id) {
		String hql = "SELECT * FROM cashflow_address WHERE member_id = :id";
		Map<String, Object> AllData = new HashMap<>();
		AllData.put("id", id);
		List<CashflowAddressBean> list = namedParameterJdbcTemplate.query(hql, AllData, new CashflowAddressRowMapper());
		return list;
	}


	@Override
	public List<CashflowAddressBean> deleteById(Long addressId) {
		String hql = "DELETE * FROM cashflow_address WHERE member_id = :id";
		Map<String, Object> AllData = new HashMap<>();
		AllData.put("id", addressId);
		List<CashflowAddressBean> list = namedParameterJdbcTemplate.query(hql, AllData, new CashflowAddressRowMapper());
		return list;
	}

	@Override
	public List<CashflowAddressBean> insertAndUpdateAddress(Member members) {
		String hql = "UPDATE cashflow_address SET common_address=?, WHERE member_id = :id";
		Map<String, Object> AllData = new HashMap<>();
		AllData.put("id", members);
		List<CashflowAddressBean> list = namedParameterJdbcTemplate.query(hql, AllData, new CashflowAddressRowMapper());
		return list;
	}


	@Override
	public List<CashflowAddressBean> findAll() {
		String hql = "SELECT * FROM cashflow_address";
		Map<String, Object> AllData = new HashMap<>();
		List<CashflowAddressBean> list = namedParameterJdbcTemplate.query(hql, AllData, new CashflowAddressRowMapper());
		return list;
	}


	@Override
	public void useAddressIdDelete(Long id) {
		CashflowAddressBean cashflowAddressBean = em.find(CashflowAddressBean.class, id);
		em.remove(cashflowAddressBean);
	}


	@Override
	public void UpdateAddress(Map<String, String> params, Long addressId) {
		CashflowAddressBean cashflowAddressBean = em.find(CashflowAddressBean.class, addressId);
		cashflowAddressBean.setCommonAddress(params.get("commonAddress"));
		em.merge(cashflowAddressBean);
	}


	@Override
	public void pushAddress(Map<String, String> params, Long id) {
		Member member = em.find(Member.class, id);
		CashflowAddressBean cashflowAddressBean = new CashflowAddressBean();
		cashflowAddressBean.setCommonAddress(params.get("commonAddress"));
		
		cashflowAddressBean.setMember(member);
		em.persist(cashflowAddressBean);
		em.close();
	}



}
