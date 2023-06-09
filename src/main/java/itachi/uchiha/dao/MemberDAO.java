package itachi.uchiha.dao;

import itachi.uchiha.domain.LoginDTO;
import itachi.uchiha.domain.MemberDTO;
import itachi.uchiha.domain.ReceiptDTO;

public interface MemberDAO {
	MemberDTO login(LoginDTO dto);

	MemberDTO updateUI(String id);

	void update(MemberDTO dto);

	void insert(MemberDTO dto);

	String idCheck(String id);

	String findId(String mb_Email, String mb_Name);

	void selectpw(MemberDTO dto);

	String emailCheck(String email);


	void cash(MemberDTO dto);

	MemberDTO readId(String id);
	
	void cashback(MemberDTO dto);
	
	ReceiptDTO cashgetui(int nowMoney, String productNumber);

	void cashget(ReceiptDTO dto);
}
