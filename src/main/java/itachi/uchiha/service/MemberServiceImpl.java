package itachi.uchiha.service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import itachi.uchiha.dao.MemberDAO;
import itachi.uchiha.domain.LoginDTO;
import itachi.uchiha.domain.MemberDTO;
import itachi.uchiha.domain.ReceiptDTO;
import itachi.uchiha.domain.SellDTO;

import itachi.uchiha.domain.RegistrationDTO;
import itachi.uchiha.domain.SearchCriteria;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO dao;
	
	@Override
	public void cashget(ReceiptDTO dto) {
		dao.cashget(dto);
	}
	
	@Override
	public ReceiptDTO cashgetui(int nowMoney, String productNumber) {
		return dao.cashgetui(nowMoney,productNumber);
	}
	
	@Override
	public void cashback(MemberDTO dto) {
		dao.cashback(dto);
	}
	
	@Override
	public MemberDTO readId(String id) {
		// TODO Auto-generated method stub
		return dao.readId(id);
	}
	
	@Override
	public void cash(MemberDTO dto) {
		dao.cash(dto);
	}

	@Override
	public void selectpw(MemberDTO dto) {
		System.out.println("MemberServiceImpl selectpw: " + dto);
		dao.selectpw(dto);

	}

	@Override
	public MemberDTO login(LoginDTO dto) {

		return dao.login(dto);
	}

	@Override
	public MemberDTO updateui(String id) {

		return dao.updateUI(id);
	}

	@Override
	public void update(MemberDTO dto) {
		dao.update(dto);
	}

	@Override
	public void insert(MemberDTO dto) {
		dao.insert(dto);
	}

	@Override
	public String idCheck(String id) {
		return dao.idCheck(id);
	}

	@Override
	public String findId(String mb_Email, String mb_Name, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = dao.findId(mb_Email, mb_Name);

		if (id == null) {
			out.println("<script>");
			out.println("alert('가입된 아이디가 없습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return null;
		} else {
			return id;
		}
	}

	@Override
	public String emailCheck(String email) {
		// TODO Auto-generated method stub
		return dao.emailCheck(email);
	}

}
