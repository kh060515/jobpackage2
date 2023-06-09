package itachi.uchiha.service;

import java.util.List;

import itachi.uchiha.domain.MemberDTO;
import itachi.uchiha.domain.RegistrationDTO;
import itachi.uchiha.domain.SearchCriteria;
import itachi.uchiha.domain.SellDTO;

public interface BoardService {

	List<String> getAttach(String productNumber);
	
	void insertin(SellDTO dto);
	
	List<RegistrationDTO> search(SearchCriteria cri);
	
	int getSearchtAmount(SearchCriteria cri);
	
	void registration(RegistrationDTO dto2);

	MemberDTO readId(String id);
	
	List<RegistrationDTO> mainView();
	
	RegistrationDTO view(String productNumber);

	List<RegistrationDTO> category(String productNumber);
	
	int sellCount(String productNumber);

	List<SellDTO> auctionHistory(String productNumber);
	
	void umoney(RegistrationDTO rdto);
	
	RegistrationDTO Rupdateui(String id,String productNumber);

	void Rupdate(RegistrationDTO dto);
	
	List<RegistrationDTO> mylist(String id);
	
}
