package itachi.uchiha.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import itachi.uchiha.domain.MemberDTO;
import itachi.uchiha.domain.RegistrationDTO;
import itachi.uchiha.domain.SearchCriteria;
import itachi.uchiha.domain.SellDTO;
import kr.co.function.CheckNumberGenerator2;



@Repository
public class BoardDAOImpl implements BoardDAO {
	
	
	
	@Inject
	private SqlSession sqlSession;
	
	private String NS="itachi.uchiha.mapper.board";
	
	@Override
	public List<RegistrationDTO> mylist(String id) {
		return sqlSession.selectList(NS+".mylist", id);
	}
	
	@Override
	public RegistrationDTO Rupdateui(String id,String productNumber) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mb_Id", id);
		map.put("productNumber", productNumber);
		return sqlSession.selectOne(NS+".Rupdateui", map);
	}

	@Override
	public void Rupdate(RegistrationDTO dto) {
		sqlSession.update(NS+".Rupdate", dto);
	}
	
	@Override
	   public void usellCount(int usellCount,String productNumber) {
	      // TODO Auto-generated method stub
	      Map<String, Object> map = new HashMap<String, Object>();
	      map.put("usellCount", usellCount);
	      map.put("productNumber", productNumber);      
	      sqlSession.update(NS+".usellCount", map);
	      
	   }
	
	@Override
	public List<RegistrationDTO> category(String productNumber) {
		
		return sqlSession.selectList(NS+".category", productNumber);
	}
	
	@Override
	public void addAttach(String fullName, String productNumber) {
		int id=getAt_id();
		Map<String , Object> map=new HashMap<String, Object>();
		map.put("at_id", id);
		map.put("fullName",fullName);
		map.put("productNumber", productNumber);
		sqlSession.insert(NS+".addAttach", map);
		
	}
	
	private int getAt_id() {
		Integer at_id= sqlSession.selectOne(NS+".getAt_id");
		if(at_id==null) {
			at_id=0;
		}
		return ++at_id;
	}



	@Override
	public List<String> getAttach(String productNumber) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS+".getAttach",productNumber);
	}
	
	
	@Override
	public void registration(RegistrationDTO dto2) {
		
		switch (dto2.getCategory()) {
		case "clothing":
			dto2.setProductNumber("A"+CheckNumberGenerator2.checknumber());
			break;
		case "beauty":
			dto2.setProductNumber("B"+CheckNumberGenerator2.checknumber());
			break;
		case "merchandise":
			dto2.setProductNumber("C"+CheckNumberGenerator2.checknumber());
			break;
		case "appliances":
			dto2.setProductNumber("D"+CheckNumberGenerator2.checknumber());
			break;
		case "bookorticket":
			dto2.setProductNumber("E"+CheckNumberGenerator2.checknumber());
			break;
			
		default:
			dto2.setProductNumber("F"+CheckNumberGenerator2.checknumber());
			break;
		}
		
		sqlSession.insert(NS+".registration",dto2);
		sqlSession.update(NS+".registration2", dto2);
	}
	
	@Override
	public int getSearchAmount(SearchCriteria cri) {
		return sqlSession.selectOne(NS+".getSearchAmount",cri);
	}
	
	@Override
	public List<RegistrationDTO> search(SearchCriteria cri) {
		return sqlSession.selectList(NS+".search", cri);
	}

	@Override
	public MemberDTO readId(String id) {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne(NS+".readid", id);
	}
	
	@Override
	public void insertin(SellDTO dto) {		
		sqlSession.insert(NS + ".sellin", dto);
	}

	@Override
	public List<RegistrationDTO> mainView() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS+".mainView");
	}
	
	@Override
	public RegistrationDTO view(String productNumber) {
		return sqlSession.selectOne(NS + ".select_view", productNumber);
	}

	@Override
	public int sellCount(String productNumber) {
		Integer sellcount= sqlSession.selectOne(NS + ".sellCount", productNumber);
		if(sellcount==null) {
			sellcount=0;
		}
		return sellcount;
	}
	

	@Override
	public void umoney(RegistrationDTO rdto) {
		sqlSession.update(NS+".umoney", rdto);
		
	}
  

	@Override
	public List<SellDTO> auctionHistory(String productNumber) {
		return sqlSession.selectList(NS + ".selectSellBySellId", productNumber);
	}

	
}
